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
@RequestMapping("cigaretteCategoryFilter")
public class JspCigaretteFilterController extends AbstractCigaretteController {

    @GetMapping
    public String getCategoryFilter(Model model){
        Cigarette cigarette = new Cigarette();
        cigarette.setGoodsReceiptDate(LocalDate.now());
        cigarette.setCategory("с фильтром");
        model.addAttribute("cigarette",cigarette);
        model.addAttribute("categoryFilter",super.getCategory("с фильтром"));

        return "cigaretteCategoryFilter";
    }

    @PostMapping("saveFilter")
    public String saveFilter(Cigarette cigarette){
        if(cigarette.isNew()){
            //Вычисляет остаток на конец месяца
            cigarette.setBalanceOnTheLastDayOfTheMonth(cigarette.getBalanceOnTheFirstDayOfTheMonth()
            + cigarette.getReceivedForMonth() - cigarette.getSoldForMonth());
            super.create(cigarette);
        }else {
            //Вычисляет остаток на конец месяца
            cigarette.setBalanceOnTheLastDayOfTheMonth(cigarette.getBalanceOnTheFirstDayOfTheMonth()
                    + cigarette.getReceivedForMonth() - cigarette.getSoldForMonth());
            super.update(cigarette, cigarette.getId());
        }

        return "redirect:/cigaretteCategoryFilter";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:/cigaretteCategoryFilter";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model){
        model.addAttribute("cigarette", super.get(getId(request)));
        model.addAttribute("categoryFilter",super.getCategory("с фильтром"));
        return "cigaretteCategoryFilter";
    }

    @PostMapping("/filter")
    public String getBetween(HttpServletRequest request, Model model) {
        LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
        LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
        Cigarette cigarette = new Cigarette();
        cigarette.setGoodsReceiptDate(LocalDate.now());
        cigarette.setCategory("с фильтром");
        model.addAttribute("cigarette",cigarette);
        model.addAttribute("categoryFilter", super.getBetween(startDate, endDate));
        model.addAttribute("categoryFilter",super.getCategory("с фильтром"));

        return "cigaretteCategoryFilter";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
