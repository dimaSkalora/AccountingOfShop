package com.shop.of.accounting.repository.jdbc.row_mapper;

import com.shop.of.accounting.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*RowMapper спользуется JdbcTemplate для сопоставления строк ResultSet для каждой строки.
  Реализации этого интерфейса выполняют фактическую работу по отображению каждой строки в объект результата.*/
public class ProductRowMapper implements RowMapper<Product> {
    //Класс ResultSet представляет результирующий набор данных и обеспечивает приложению построчный доступ
    // к результатам запросов. При обработке запроса ResultSet поддерживает указатель на текущую обрабатываемую строку.
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        //Методы ResultSet.getXXX предоставляют доступ к значениям в колонках в текущей строке.
        // В пределах одной строки значения могут быть считаны в любом порядке
        Product product = new Product();
        product.setId(resultSet.getInt("id")); //cigarette.setId(resultSet.getInt(1));
        product.setGoodsReceiptDate(resultSet.getDate("goodsReceiptDate").toLocalDate());
        product.setCategory(resultSet.getString("category"));
        product.setProductName(resultSet.getString("productName"));
        product.setAmount(resultSet.getInt("amount"));
        product.setBalanceOnTheFirstDayOfTheMonth(resultSet.getInt("balanceOnTheFirstDayOfTheMonth"));
        product.setReceivedForMonth(resultSet.getInt("receivedForMonth"));
        product.setSoldForMonth(resultSet.getInt("soldForMonth"));
        product.setBalanceOnTheLastDayOfTheMonth(resultSet.getInt("balanceOnTheLastDayOfTheMonth"));

        return product;
    }
}
