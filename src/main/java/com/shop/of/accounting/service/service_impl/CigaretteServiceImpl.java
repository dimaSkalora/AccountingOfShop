package com.shop.of.accounting.service.service_impl;

import com.shop.of.accounting.model.Cigarette;
import com.shop.of.accounting.repository.CigaretteRepository;
import com.shop.of.accounting.service.CigaretteService;
import com.shop.of.accounting.util.ValidationUtil;
import com.shop.of.accounting.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@Service
public class CigaretteServiceImpl implements CigaretteService {

    private final CigaretteRepository cigaretteRepository;

    @Autowired
    public CigaretteServiceImpl(CigaretteRepository cigaretteRepository) {
        this.cigaretteRepository=cigaretteRepository;
    }

    @Override
    public Cigarette get(int id, int userId) throws NotFoundException {
        return ValidationUtil.checkNotFoundWithId(cigaretteRepository.get(id,userId),id);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        ValidationUtil.checkNotFoundWithId(cigaretteRepository.delete(id,userId),id);
    }

    @Override
    public List<Cigarette> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) throws NotFoundException {
        //Убедитесь, что объект отсутствует null.
        Assert.notNull(startDate, "startDate must not be null");
        Assert.notNull(endDate, "endDate  must not be null");
        return cigaretteRepository.getBetween(startDate,endDate,userId);
    }

    @Override
    public List<Cigarette> getAll(int userId) {
        return cigaretteRepository.getAll(userId);
    }

    @Override
    public List<Cigarette> getCategory(String category, int userId) {
        return cigaretteRepository.getCategory(category,userId);
    }

    @Override
    public List<Cigarette> getSearchByProductName(String productName, String category, int userId) {
        return cigaretteRepository.getSearchByProductName(productName,category,userId);
    }

    @Override
    public Cigarette update(Cigarette cigarette, int userId) throws NotFoundException {
        return ValidationUtil.checkNotFoundWithId(cigaretteRepository.save(cigarette,userId),cigarette.getId());
    }

    @Override
    public Cigarette create(Cigarette cigarette, int userId) {
        //Убедитесь, что объект отсутствует null.
        Assert.notNull(cigarette,"cigarette must not be null");
        return cigaretteRepository.save(cigarette,userId);
    }

    @Override
    public Cigarette getWithUser(int id, int userId) {
        return ValidationUtil.checkNotFoundWithId(cigaretteRepository.getWithUser(id,userId),id);
    }
}
