package com.shop.of.accounting.repository.jdbc;

import com.shop.of.accounting.model.Alcohol;
import com.shop.of.accounting.repository.AlcoholRepository;
import com.shop.of.accounting.repository.jdbc.row_mapper.AlcoholRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Repository
public class JdbcAlcoholRepositoryImpl implements AlcoholRepository {
    //Статический метод фабрики для создания нового BeanPropertyRowMapper (с отображенным классом, указанным только один раз).
    private static final RowMapper<Alcohol> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Alcohol.class);

    /*
    *  JdbcTemplate - это мощный механизм для подключения к базе данных и выполнения SQL-запросов.
    *  Мы можем выполнять все операции с базой данных с помощью класса JdbcTemplate, такие как вставка,
    *  обновление, удаление и извлечение данных из базы данных.*/
    private final JdbcTemplate jdbcTemplate;
    //способ вставки данных по именованному параметру. Таким образом мы используем имена вместо? (Знак вопроса)
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    /*многопоточный, многоразовый объект, обеспечивающий удобные возможности вставки для таблицы.
    Он обеспечивает обработку метаданных, чтобы упростить код, необходимый для построения
     основного оператора insertAlcohol. Фактическая вставка обрабатывается с помощью Spring JdbcTemplate*/
    private final SimpleJdbcInsert insertAlcohol;

    @Autowired
    public JdbcAlcoholRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertAlcohol = new SimpleJdbcInsert(dataSource)
                //Укажите имя таблицы, которое будет использоваться для вставки.
                .withTableName("alcohol")
                //Укажите имена любых столбцов, в которых есть автоматически сгенерированные ключи.
                .usingGeneratedKeyColumns("id");
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Alcohol save(Alcohol alcohol, int userId) {
        //Этот класс предназначен для передачи в простой Map значений параметров методам NamedParameterJdbcTemplateкласса.
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id",alcohol.getId()) //Добавьте параметр к этому источнику параметра.
                .addValue("goodsReceiptDate",alcohol.getGoodsReceiptDate())
                .addValue("category",alcohol.getCategory())
                .addValue("productName",alcohol.getProductName())
                .addValue("liter",alcohol.getLiter())
                .addValue("balanceOnTheFirstDayOfTheMonth",alcohol.getBalanceOnTheFirstDayOfTheMonth())
                .addValue("receivedForMonth",alcohol.getReceivedForMonth())
                .addValue("soldForMonth",alcohol.getSoldForMonth())
                .addValue("balanceOnTheLastDayOfTheMonth",alcohol.getBalanceOnTheLastDayOfTheMonth())
                .addValue("user_id",userId);
        if(alcohol.isNew()){
            //Выполните вставку, используя значения, переданные и возвращающие сгенерированный ключ.
            Number newId = insertAlcohol.executeAndReturnKey(map);
            alcohol.setId(newId.intValue());
        }else {
            if(namedParameterJdbcTemplate.update("UPDATE alcohol SET category=:category, productName=:productName," +
                    "liter=:liter, balanceOnTheFirstDayOfTheMonth=:balanceOnTheFirstDayOfTheMonth, receivedForMonth=:receivedForMonth," +
                    "soldForMonth=:soldForMonth, balanceOnTheLastDayOfTheMonth=:balanceOnTheLastDayOfTheMonth"+
            " WHERE id=:id AND user_id=:user_id", map)==0){
                return null;
            }
        }
        return alcohol;
    }

    @Override
    public boolean delete(int id, int userId) {
        return jdbcTemplate.update("DELETE FROM alcohol WHERE id=? AND user_id=?",id,userId) !=0;
    }

    @Override
    public Alcohol get(int id, int userId) {
        List<Alcohol> alcohols = jdbcTemplate.query("SELECT * FROM alcohol WHERE id=? AND user_id=?",
                new AlcoholRowMapper(),id,userId);
        return (Alcohol) DataAccessUtils.singleResult(alcohols); //Верните один объект результата из данной коллекции.
    }

    @Override
    public List<Alcohol> getAll(int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM alcohol WHERE user_id=? ORDER BY goodsReceiptDate DESC",
                new AlcoholRowMapper(),userId);
    }

    @Override
    public List<Alcohol> getCategory(String category, int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM alcohol WHERE category=? AND user_id=? ORDER BY goodsReceiptDate",
                new AlcoholRowMapper(),category,userId);
    }

    @Override
    public List<Alcohol> getBetween(LocalDate startDate, LocalDate endDate, int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM alcohol WHERE user_id=?  AND goodsReceiptDate BETWEEN  ? AND ? ORDER BY goodsReceiptDate DESC",
                new AlcoholRowMapper(), userId, startDate, endDate);
    }
}
