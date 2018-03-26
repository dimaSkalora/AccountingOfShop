package com.shop.of.accounting.repository;

import com.shop.of.accounting.model.Alcohol;

import java.time.LocalDate;
import java.util.List;

public interface AlcoholRepository {
    Alcohol save(Alcohol alcohol, int userId);
    boolean delete(int id, int userId);
    Alcohol get(int id, int userId);
    List<Alcohol> getAll(int userId);
    List<Alcohol> getCategory(String category, int userId);
    List<Alcohol> getSearchByProductName(String productName, String category, int userId);
    // ORDERED dateTime desc
    List<Alcohol> getBetween(LocalDate startDate, LocalDate endDate, int userId);
    default Alcohol getWithUser(int id, int userId) {
        throw new UnsupportedOperationException();
    }
}
