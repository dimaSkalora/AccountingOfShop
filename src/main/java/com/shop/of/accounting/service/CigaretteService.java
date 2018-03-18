package com.shop.of.accounting.service;

import com.shop.of.accounting.model.Cigarette;
import com.shop.of.accounting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface CigaretteService {
    Cigarette get(int id, int userId) throws NotFoundException;
    void delete(int id, int userId) throws NotFoundException;
    List<Cigarette> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) throws NotFoundException;
    List<Cigarette> getAll(int userId);
    List<Cigarette> getCategory(String category, int userId);
    Cigarette update(Cigarette cigarette, int userId) throws NotFoundException;
    Cigarette create(Cigarette cigarette, int userId);
    Cigarette getWithUser(int id, int userId);
}
