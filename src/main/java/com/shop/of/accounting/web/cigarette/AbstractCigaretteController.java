package com.shop.of.accounting.web.cigarette;

import com.shop.of.accounting.AuthorizedUser;
import com.shop.of.accounting.model.Cigarette;
import com.shop.of.accounting.service.CigaretteService;
import com.shop.of.accounting.to.CigarettelWithBalanceNegative;
import com.shop.of.accounting.util.CigarettesUtil;
import com.shop.of.accounting.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstractCigaretteController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CigaretteService cigaretteService;

    public Cigarette get(int id){
        int userId = AuthorizedUser.id();
        log.info("get cigarette {} for user {} ",id,userId);
        return cigaretteService.get(id,userId);
    }

    public void delete(int id){
        int userId = AuthorizedUser.id();
        log.info("delete cigarette {} for user {} ",id,userId);
        cigaretteService.delete(id,userId);
    }

    public List<CigarettelWithBalanceNegative> getAll(){
        int userId = AuthorizedUser.id();
        log.info("getAll CigarettelWithBalanceNegative {} for user {}",userId);
        return CigarettesUtil.getBalanceNeagtive(cigaretteService.getAll(userId));
    }

    public List<CigarettelWithBalanceNegative> getCategory(String category){
        int userId = AuthorizedUser.id();
        log.info("getCategory CigarettelWithBalanceNegative {} for user {}",category, userId);
        return CigarettesUtil.getBalanceNeagtive(cigaretteService.getCategory(category,userId));
    }

    public Cigarette create(Cigarette cigarette){
        int userId = AuthorizedUser.id();
        ValidationUtil.checkNew(cigarette);
        log.info("create cigarette {} for user ",cigarette, userId);
        return cigaretteService.create(cigarette,userId);
    }

    public Cigarette update(Cigarette cigarette, int id){
        int userId = AuthorizedUser.id();
        ValidationUtil.assureIdConsistent(cigarette,id);
        log.info("update cigarette {} for user {} ",cigarette, userId);
        return cigaretteService.update(cigarette,userId);
    }

    public List<CigarettelWithBalanceNegative> getBetween(LocalDate startDate, LocalDate endDate) {
        final LocalDate MIN_DATE = LocalDate.of(1, 1, 1);
        final LocalDate MAX_DATE = LocalDate.of(3000, 1, 1);
        int userId = AuthorizedUser.id();
        log.info("getBetween dates({} - {}) time({} - {}) for user {}", startDate, endDate, userId);
        System.out.println("getBetween dates({} - {}) time({} - {}) for user {} "+ startDate+" "+ endDate+" "+ userId);

        List<Cigarette> cigaretteDateFiltered = cigaretteService.getBetweenDates(
                startDate != null ? startDate : MIN_DATE,
                endDate != null ? endDate : MAX_DATE, userId);

        return CigarettesUtil.getBalanceNeagtive(cigaretteDateFiltered);
    }
}
