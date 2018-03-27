package com.shop.of.accounting.web.cigarette.jsp;

import com.shop.of.accounting.model.Cigarette;
import com.shop.of.accounting.web.cigarette.AbstractCigaretteController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Objects;

import static com.shop.of.accounting.util.DateTimeUtil.parseLocalDate;

@Controller
@RequestMapping("cigaretteCategoryWithoutFilter")
public class JspCigaretteWithoutFilterController extends AbstractCigaretteController {

    @GetMapping
    public String getCategoryWithoutFilter(Model model){
        Cigarette cigarette = new Cigarette();
        cigarette.setGoodsReceiptDate(LocalDate.now());
        cigarette.setCategory("без фильтра");
        model.addAttribute("cigarette",cigarette);
        model.addAttribute("categoryWithoutFilter",super.getCategory("без фильтра"));

        return "cigaretteCategoryWithoutFilter";
    }

    @PostMapping("searchByProductName")
    public String searchByProductName(Model model, HttpServletRequest request){
        String productParameter = request.getParameter("searchByProductName");
        Cigarette cigarette = new Cigarette();
        cigarette.setGoodsReceiptDate(LocalDate.now());
        cigarette.setCategory("без фильтра");
        model.addAttribute("cigarette",cigarette);
        model.addAttribute("categoryWithoutFilter",super.getSearchByProductName(productParameter,"без фильтра"));
        return "cigaretteCategoryWithoutFilter";
    }

    @PostMapping("saveWithoutFilter")
    public String saveWithoutFilter(Cigarette cigarette){
        if(cigarette.isNew()){
            //Вычисляет остаток на конец месяца
            cigarette.setBalanceOnTheLastDayOfTheMonth(cigarette.getBalanceOnTheFirstDayOfTheMonth()
            + cigarette.getReceivedForMonth() - cigarette.getSoldForMonth());
            super.create(cigarette);
        }else {
            //Вычисляет остаток на конец месяца
            cigarette.setBalanceOnTheLastDayOfTheMonth(cigarette.getBalanceOnTheFirstDayOfTheMonth()
                    + cigarette.getReceivedForMonth() - cigarette.getSoldForMonth());
            super.update(cigarette,cigarette.getId());
        }
        return "redirect:/cigaretteCategoryWithoutFilter";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:/cigaretteCategoryWithoutFilter";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model){
        model.addAttribute("cigarette", super.get(getId(request)));
        model.addAttribute("categoryWithoutFilter",super.getCategory("без фильтра"));
        return "cigaretteCategoryWithoutFilter";
    }

    @PostMapping("/filter")
    public String getBetween(HttpServletRequest request, Model model) {
        LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
        LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
        Cigarette cigarette = new Cigarette();
        cigarette.setGoodsReceiptDate(LocalDate.now());
        cigarette.setCategory("без фильтра");
        model.addAttribute("cigarette",cigarette);
        model.addAttribute("categoryWithoutFilter", super.getBetween(startDate, endDate));
        model.addAttribute("categoryWithoutFilter",super.getCategory("без фильтра"));

        return "cigaretteCategoryWithoutFilter";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
