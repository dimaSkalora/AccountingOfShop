package com.shop.of.accounting.service;

import com.shop.of.accounting.model.Alcohol;
import com.shop.of.accounting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface AlcoholService {
    Alcohol get(int id, int userId) throws NotFoundException;
    void delete(int id, int userId) throws NotFoundException;
    List<Alcohol> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) throws NotFoundException;
    List<Alcohol> getAll(int userId);
    List<Alcohol> getCategory(String category, int userId);
    Alcohol update(Alcohol alcohol, int userId) throws NotFoundException;
    Alcohol create(Alcohol alcohol, int userId);
    Alcohol getWithUser(int id, int userId);
}
