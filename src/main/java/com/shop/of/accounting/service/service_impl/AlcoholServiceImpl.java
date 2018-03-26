package com.shop.of.accounting.service.service_impl;

import com.shop.of.accounting.model.Alcohol;
import com.shop.of.accounting.repository.AlcoholRepository;
import com.shop.of.accounting.service.AlcoholService;
import com.shop.of.accounting.util.ValidationUtil;
import com.shop.of.accounting.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlcoholServiceImpl implements AlcoholService {

    private final AlcoholRepository alcoholRepository;

    @Autowired
    public AlcoholServiceImpl(AlcoholRepository alcoholRepository) {
        this.alcoholRepository = alcoholRepository;
    }

    @Override
    public Alcohol get(int id, int userId) throws NotFoundException {
        return ValidationUtil.checkNotFoundWithId(alcoholRepository.get(id,userId),id);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        ValidationUtil.checkNotFoundWithId(alcoholRepository.delete(id,userId),id);
    }

    @Override
    public List<Alcohol> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) throws NotFoundException {
        //Убедитесь, что объект отсутствует null.
        Assert.notNull(startDate, "startDate must not be null");
        Assert.notNull(endDate, "endDate  must not be null");
        return alcoholRepository.getBetween(startDate,endDate,userId);
    }

    @Override
    public List<Alcohol> getAll(int userId) {
        return alcoholRepository.getAll(userId);
    }

    @Override
    public List<Alcohol> getCategory(String category, int userId) {
        return alcoholRepository.getCategory(category,userId);
    }

    @Override
    public List<Alcohol> getSearchByProductName(String productName, String category, int userId) {
        return alcoholRepository.getSearchByProductName(productName,category,userId);
    }

    @Override
    public Alcohol update(Alcohol alcohol, int userId) throws NotFoundException {
        return ValidationUtil.checkNotFoundWithId(alcoholRepository.save(alcohol,userId),alcohol.getId());
    }

    @Override
    public Alcohol create(Alcohol alcohol, int userId) {
        //Убедитесь, что объект отсутствует null.
        Assert.notNull(alcohol,"alcohol must not be null");
        return alcoholRepository.save(alcohol,userId);
    }

    @Override
    public Alcohol getWithUser(int id, int userId) {
        return ValidationUtil.checkNotFoundWithId(alcoholRepository.getWithUser(id,userId),id);
    }
}
