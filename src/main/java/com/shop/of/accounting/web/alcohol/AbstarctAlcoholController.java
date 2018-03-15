package com.shop.of.accounting.web.alcohol;

import com.shop.of.accounting.AuthorizedUser;
import com.shop.of.accounting.model.Alcohol;
import com.shop.of.accounting.service.AlcoholService;
import com.shop.of.accounting.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstarctAlcoholController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AlcoholService alcoholService;

    public Alcohol get(int id){
        int userId = AuthorizedUser.id();
        log.info("get alcohol {} for user {} ", id, userId);
        System.out.println("get alcohol {} for user {} "+ id+" "+userId);
        return alcoholService.get(id,userId);
    }

    public void delete(int id){
        int userId = AuthorizedUser.id();
        log.info("delete alcohol {} for user {} ",id,userId);
        System.out.println("delete alcohol {} for user {] "+id+" "+userId);
        alcoholService.delete(id,userId);
    }

    public List<Alcohol> getAll(){
        int userId = AuthorizedUser.id();
        log.info("getAll alcohol {} fro user {} ",userId);
        System.out.println("getAll alcohol {} fro user {} "+userId);
        return alcoholService.getAll(userId);
    }

    public List<Alcohol> getCategory(String category){
         int userId = AuthorizedUser.id();
        log.info("getCategory alcohol {} fro user {} ",userId);
        System.out.println("getCategory alcohol {} fro user {} "+userId);
        return alcoholService.getCategory(category,userId);
    }


    public Alcohol create(Alcohol alcohol){
        int userId = AuthorizedUser.id();
        ValidationUtil.checkNew(alcohol);
        log.info("create {} fro user {} "+alcohol,userId);
        System.out.println("create {} fro user {} "+alcohol+" "+userId);
        return alcoholService.create(alcohol,userId);
    }

    public void update(Alcohol alcohol, int id){
        int userId = AuthorizedUser.id();
        ValidationUtil.assureIdConsistent(alcohol,id);
        log.info("update {} for user {} "+alcohol,userId);
        System.out.println("update {} for user {} "+alcohol+" "+userId);
        alcoholService.update(alcohol,userId);
    }

    public List<Alcohol> getBetween(LocalDate startDate, LocalDate endDate) {
        final LocalDate MIN_DATE = LocalDate.of(1, 1, 1);
        final LocalDate MAX_DATE = LocalDate.of(3000, 1, 1);
        int userId = AuthorizedUser.id();
        log.info("getBetween dates({} - {}) time({} - {}) for user {}", startDate, endDate, userId);
        System.out.println("getBetween dates({} - {}) time({} - {}) for user {} "+ startDate+" "+ endDate+" "+ userId);

        List<Alcohol> alcoholDateFiltered = alcoholService.getBetweenDates(
                startDate != null ? startDate : MIN_DATE,
                endDate != null ? endDate : MAX_DATE, userId);

        return alcoholDateFiltered;
    }

}
