package com.shop.of.accounting.service;

import com.shop.of.accounting.model.Product;
import com.shop.of.accounting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {
    Product get(int id, int userId) throws NotFoundException;
    void delete(int id, int userId) throws NotFoundException;
    List<Product> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) throws NotFoundException;
    List<Product> getAll(int userId);
    List<Product> getCategory(String category, int userId);
    List<Product> getSearchByProductName(String productName, String category, int userId);
    Product update(Product product, int userId) throws NotFoundException;
    Product create(Product product, int userId);
    Product getWithUser(int id, int userId);
}
