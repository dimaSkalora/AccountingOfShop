package com.shop.of.accounting.repository.jdbc.row_mapper;

import com.shop.of.accounting.model.Alcohol;
import com.shop.of.accounting.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*RowMapper спользуется JdbcTemplate для сопоставления строк ResultSet для каждой строки.
  Реализации этого интерфейса выполняют фактическую работу по отображению каждой строки в объект результата.*/
public class AlcoholRowMapper implements RowMapper<Alcohol> {
    //Класс ResultSet представляет результирующий набор данных и обеспечивает приложению построчный доступ
    // к результатам запросов. При обработке запроса ResultSet поддерживает указатель на текущую обрабатываемую строку.
    @Override
    public Alcohol mapRow(ResultSet resultSet, int i) throws SQLException {
        //Методы ResultSet.getXXX предоставляют доступ к значениям в колонках в текущей строке.
        // В пределах одной строки значения могут быть считаны в любом порядке
        Alcohol alcohol = new Alcohol();
        alcohol.setId(resultSet.getInt("id"));// alcohol.setId(resultSet.getInt(1));
        alcohol.setGoodsReceiptDate(resultSet.getDate("goodsReceiptDate").toLocalDate());
        alcohol.setCategory(resultSet.getString("category"));
        alcohol.setProductName(resultSet.getString("productName"));
        alcohol.setLiter(resultSet.getDouble("liter"));
        alcohol.setBalanceOnTheFirstDayOfTheMonth(resultSet.getInt("balanceOnTheFirstDayOfTheMonth"));
        alcohol.setReceivedForMonth(resultSet.getInt("receivedForMonth"));
        alcohol.setReceivedForMonth(resultSet.getInt("soldForMonth"));
        alcohol.setBalanceOnTheLastDayOfTheMonth(resultSet.getInt("balanceOnTheLastDayOfTheMonth"));
        alcohol.setUser((User) resultSet.getObject("user"));

        return alcohol;
    }
}
