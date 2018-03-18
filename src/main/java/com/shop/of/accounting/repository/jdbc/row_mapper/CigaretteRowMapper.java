package com.shop.of.accounting.repository.jdbc.row_mapper;

import com.shop.of.accounting.model.Cigarette;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*RowMapper спользуется JdbcTemplate для сопоставления строк ResultSet для каждой строки.
  Реализации этого интерфейса выполняют фактическую работу по отображению каждой строки в объект результата.*/
public class CigaretteRowMapper implements RowMapper<Cigarette>{
    //Класс ResultSet представляет результирующий набор данных и обеспечивает приложению построчный доступ
    // к результатам запросов. При обработке запроса ResultSet поддерживает указатель на текущую обрабатываемую строку.
    @Override
    public Cigarette mapRow(ResultSet resultSet, int i) throws SQLException {
        //Методы ResultSet.getXXX предоставляют доступ к значениям в колонках в текущей строке.
        // В пределах одной строки значения могут быть считаны в любом порядке
        Cigarette cigarette = new Cigarette();
        cigarette.setId(resultSet.getInt("id")); //cigarette.setId(resultSet.getInt(1));
        cigarette.setGoodsReceiptDate(resultSet.getDate("goodsReceiptDate").toLocalDate());
        cigarette.setCategory(resultSet.getString("category"));
        cigarette.setProductName(resultSet.getString("productName"));
        cigarette.setAmount(resultSet.getInt("amount"));
        cigarette.setBalanceOnTheFirstDayOfTheMonth(resultSet.getInt("balanceOnTheFirstDayOfTheMonth"));
        cigarette.setReceivedForMonth(resultSet.getInt("receivedForMonth"));
        cigarette.setSoldForMonth(resultSet.getInt("soldForMonth"));
        cigarette.setBalanceOnTheLastDayOfTheMonth(resultSet.getInt("balanceOnTheLastDayOfTheMonth"));

        return cigarette;
    }
}
