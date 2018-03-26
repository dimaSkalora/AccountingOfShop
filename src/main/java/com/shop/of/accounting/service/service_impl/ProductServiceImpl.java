package com.shop.of.accounting.service.service_impl;

import com.shop.of.accounting.model.Product;
import com.shop.of.accounting.repository.ProductRepository;
import com.shop.of.accounting.service.ProductService;
import com.shop.of.accounting.util.ValidationUtil;
import com.shop.of.accounting.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    @Override
    public Product get(int id, int userId) throws NotFoundException {
        return ValidationUtil.checkNotFoundWithId(productRepository.get(id,userId),id);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        ValidationUtil.checkNotFoundWithId(productRepository.delete(id,userId),id);
    }

    @Override
    public List<Product> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) throws NotFoundException {
        //Убедитесь, что объект отсутствует null.
        Assert.notNull(startDate, "startDate must not be null");
        Assert.notNull(endDate, "endDate  must not be null");
        return productRepository.getBetween(startDate,endDate,userId);
    }

    @Override
    public List<Product> getAll(int userId) {
        return productRepository.getAll(userId);
    }

    @Override
    public List<Product> getCategory(String category, int userId) {
        return productRepository.getCategory(category,userId);
    }

    @Override
    public List<Product> getSearchByProductName(String productName, String category, int userId) {
        return productRepository.getSearchByProductName(productName,category,userId);
    }

    @Override
    public Product update(Product product, int userId) throws NotFoundException {
        return ValidationUtil.checkNotFoundWithId(productRepository.save(product,userId),product.getId());
    }

    @Override
    public Product create(Product product, int userId) {
        //Убедитесь, что объект отсутствует null.
        Assert.notNull(product,"product must not be null");
        return productRepository.save(product,userId);
    }

    @Override
    public Product getWithUser(int id, int userId) {
        return ValidationUtil.checkNotFoundWithId(productRepository.getWithUser(id,userId),id);
    }
}
