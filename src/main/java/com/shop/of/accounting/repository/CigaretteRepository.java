package com.shop.of.accounting.repository;

import com.shop.of.accounting.model.Cigarette;

import java.time.LocalDate;
import java.util.List;

public interface CigaretteRepository {
    Cigarette save(Cigarette cigarette, int userId);
    boolean delete(int id, int userId);
    Cigarette get(int id, int userId);
    List<Cigarette> getAll(int userId);
    List<Cigarette> getCategory(String category, int userId);
    List<Cigarette> getSearchByProductName(String productName, String category, int userId);
    // ORDERED dateTime desc
    List<Cigarette> getBetween(LocalDate startDate, LocalDate endDate, int userId);
    default Cigarette getWithUser(int id, int userId) {
        throw new UnsupportedOperationException();
    }
}
