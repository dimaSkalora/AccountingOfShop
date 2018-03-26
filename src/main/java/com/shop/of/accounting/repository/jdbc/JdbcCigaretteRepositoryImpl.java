package com.shop.of.accounting.repository.jdbc;

import com.shop.of.accounting.model.Cigarette;
import com.shop.of.accounting.repository.CigaretteRepository;
import com.shop.of.accounting.repository.jdbc.row_mapper.CigaretteRowMapper;
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
public class JdbcCigaretteRepositoryImpl implements CigaretteRepository {
    //Статический метод фабрики для создания нового BeanPropertyRowMapper (с отображенным классом,
    // указанным только один раз).
    private static final RowMapper<Cigarette> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Cigarette.class);

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
    public JdbcCigaretteRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate
            namedParameterJdbcTemplate) {
        this.insertAlcohol = new SimpleJdbcInsert(dataSource)
                //Укажите имя таблицы, которое будет использоваться для вставки.
                .withTableName("cigarette")
                //Укажите имена любых столбцов, в которых есть автоматически сгенерированные ключи.
                .usingGeneratedKeyColumns("id");
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Cigarette save(Cigarette cigarette, int userId) {
        //Этот класс предназначен для передачи в простой Map значений параметров методам NamedParameterJdbcTemplate класса.
                MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id",cigarette.getId()) //Добавьте параметр к этому источнику параметра.
                .addValue("goodsReceiptDate",cigarette.getGoodsReceiptDate())
                .addValue("category",cigarette.getCategory())
                .addValue("productName",cigarette.getProductName())
                .addValue("amount",cigarette.getAmount())
                .addValue("balanceOnTheFirstDayOfTheMonth",cigarette.getBalanceOnTheFirstDayOfTheMonth())
                .addValue("receivedForMonth",cigarette.getReceivedForMonth())
                .addValue("soldForMonth",cigarette.getSoldForMonth())
                .addValue("balanceOnTheLastDayOfTheMonth",cigarette.getBalanceOnTheLastDayOfTheMonth())
                .addValue("user_id",userId);
        if(cigarette.isNew()){
            //Выполните вставку, используя значения, переданные и возвращающие сгенерированный ключ.
            Number newId = insertAlcohol.executeAndReturnKey(map);
            cigarette.setId(newId.intValue());
        }else {
            if(namedParameterJdbcTemplate.update("UPDATE cigarette SET category=:category, productName=:productName," +
                            "amount=:amount, balanceOnTheFirstDayOfTheMonth=:balanceOnTheFirstDayOfTheMonth, receivedForMonth=:receivedForMonth," +
            "soldForMonth=:soldForMonth, balanceOnTheLastDayOfTheMonth=:balanceOnTheLastDayOfTheMonth"+
                    " WHERE id=:id AND user_id=:user_id", map)==0){
                return null;
            }
        }
        return cigarette;
    }

    @Override
    public boolean delete(int id, int userId) {
        return jdbcTemplate.update("DELETE FROM cigarette WHERE id=? AND user_id=?",id,userId) !=0;
    }

    @Override
    public Cigarette get(int id, int userId) {
        List<Cigarette> cigarettes = jdbcTemplate.query("SELECT * FROM cigarette WHERE id=?"
                        +" AND user_id=?",
                new CigaretteRowMapper(),id,userId);
        return (Cigarette) DataAccessUtils.singleResult(cigarettes);//Верните один объект результата из данной коллекции.
    }

    @Override
    public List<Cigarette> getAll(int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM cigarette WHERE user_id=? ORDER BY goodsReceiptDate DESC",
                new CigaretteRowMapper(),userId
        );
    }

    @Override
    public List<Cigarette> getCategory(String category, int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM cigarette WHERE category=? AND user_id=? ORDER BY goodsReceiptDate",
                new CigaretteRowMapper(),category,userId
        );
    }

    @Override
    public List<Cigarette> getSearchByProductName(String productName, String category, int userId) {
        return jdbcTemplate.query("SELECT * FROM cigarette WHERE productname=? AND category=? AND user_id=? ORDER BY goodsreceiptdate",
                new CigaretteRowMapper(),productName,category,userId);
    }

    @Override
    public List<Cigarette> getBetween(LocalDate startDate, LocalDate endDate, int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM cigarette WHERE user_id=?  AND goodsReceiptDate"
                        +" BETWEEN  ? AND ? ORDER BY goodsReceiptDate DESC",
        new CigaretteRowMapper(), userId, startDate, endDate);
    }
}
