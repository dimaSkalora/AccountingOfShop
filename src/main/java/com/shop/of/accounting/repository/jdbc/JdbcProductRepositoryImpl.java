package com.shop.of.accounting.repository.jdbc;

import com.shop.of.accounting.model.Product;
import com.shop.of.accounting.repository.ProductRepository;
import com.shop.of.accounting.repository.jdbc.row_mapper.ProductRowMapper;
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
public class JdbcProductRepositoryImpl implements ProductRepository {
    //Статический метод фабрики для создания нового BeanPropertyRowMapper (с отображенным классом,
    // указанным только один раз).
    private static final RowMapper<Product> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Product.class);

    /*
     *  JdbcTemplate - это мощный механизм для подключения к базе данных и выполнения SQL-запросов.
     *  Мы можем выполнять все операции с базой данных с помощью класса JdbcTemplate, такие как вставка,
     *  обновление, удаление и извлечение данных из базы данных.*/
    private final JdbcTemplate jdbcTemplate;
    //способ вставки данных по именованному параметру. Таким образом мы используем имена вместо? (Знак вопроса)
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    /*многопоточный, многоразовый объект, обеспечивающий удобные возможности вставки для таблицы.
    Он обеспечивает обработку метаданных, чтобы упростить код, необходимый для построения
     основного оператора insertProduct. Фактическая вставка обрабатывается с помощью Spring JdbcTemplate*/
    private final SimpleJdbcInsert insertProduct;

    @Autowired
    public JdbcProductRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate
            namedParameterJdbcTemplate) {
        this.insertProduct = new SimpleJdbcInsert(dataSource)
                //Укажите имя таблицы, которое будет использоваться для вставки.
                .withTableName("product")
                //Укажите имена любых столбцов, в которых есть автоматически сгенерированные ключи.
                .usingGeneratedKeyColumns("id");
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Product save(Product product, int userId) {
        //Этот класс предназначен для передачи в простой Map значений параметров методам NamedParameterJdbcTemplate класса.
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id",product.getId()) //Добавьте параметр к этому источнику параметра.
                .addValue("goodsReceiptDate",product.getGoodsReceiptDate())
                .addValue("category",product.getCategory())
                .addValue("productName",product.getProductName())
                .addValue("amount",product.getAmount())
                .addValue("balanceOnTheFirstDayOfTheMonth",product.getBalanceOnTheFirstDayOfTheMonth())
                .addValue("receivedForMonth",product.getReceivedForMonth())
                .addValue("soldForMonth",product.getSoldForMonth())
                .addValue("balanceOnTheLastDayOfTheMonth",product.getBalanceOnTheLastDayOfTheMonth())
                .addValue("user_id",userId);
        if(product.isNew()){
            //Выполните вставку, используя значения, переданные и возвращающие сгенерированный ключ.
            Number newId = insertProduct.executeAndReturnKey(map);
            product.setId(newId.intValue());
        }else {
            if(namedParameterJdbcTemplate.update("UPDATE product SET category=:category, productName=:productName," +
                    "amount=:amount, balanceOnTheFirstDayOfTheMonth=:balanceOnTheFirstDayOfTheMonth, receivedForMonth=:receivedForMonth," +
                    "soldForMonth=:soldForMonth, balanceOnTheLastDayOfTheMonth=:balanceOnTheLastDayOfTheMonth"+
                    " WHERE id=:id AND user_id=:user_id", map)==0){
                return null;
            }
        }
        return product;
    }

    @Override
    public boolean delete(int id, int userId) {
        return jdbcTemplate.update("DELETE FROM product WHERE id=? AND user_id=?",id,userId) !=0;
    }

    @Override
    public Product get(int id, int userId) {
        List<Product> products = jdbcTemplate.query("SELECT * FROM product WHERE id=? AND user_id=?",
                new ProductRowMapper(),id,userId);
        return (Product) DataAccessUtils.singleResult(products);//Верните один объект результата из данной коллекции.
    }

    @Override
    public List<Product> getAll(int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM product WHERE user_id=? ORDER BY goodsReceiptDate DESC",
                new ProductRowMapper(),userId);
    }

    @Override
    public List<Product> getCategory(String category, int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM product WHERE category=? AND user_id=? ORDER BY goodsReceiptDate DESC",
                new ProductRowMapper(),category,userId
        );
    }

    @Override
    public List<Product> getBetween(LocalDate startDate, LocalDate endDate, int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM product WHERE user_id=?  AND goodsReceiptDate"
                        +" BETWEEN  ? AND ? ORDER BY goodsReceiptDate DESC",
                new ProductRowMapper(), userId, startDate, endDate);
    }
}
