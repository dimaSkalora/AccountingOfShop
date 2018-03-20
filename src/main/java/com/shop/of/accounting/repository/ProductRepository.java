package com.shop.of.accounting.repository;

import com.shop.of.accounting.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository {
    Product save(Product product, int userId);
    boolean delete(int id, int userId);
    Product get(int id, int userId );
    List<Product> getAll(int userId);
    List<Product> getCategory(String category, int userId);
    // ORDERED date desc
    List<Product> getBetween(LocalDate startDate, LocalDate endDate, int userId);
    default Product getWithUser(int id, int userId) {
        throw new UnsupportedOperationException();
    }

}
