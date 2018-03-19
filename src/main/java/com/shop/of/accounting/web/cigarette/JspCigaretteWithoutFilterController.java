package com.shop.of.accounting.web.cigarette;

import com.shop.of.accounting.model.Cigarette;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Objects;

@Controller
@RequestMapping("cigaretteWithoutFilter")
public class JspCigaretteWithoutFilterController extends AbstractCigaretteController {

    @GetMapping
    public String getCategoryWithoutFilter(Model model){
        Cigarette cigarette = new Cigarette();
        cigarette.setGoodsReceiptDate(LocalDate.now());
        cigarette.setCategory("без фильтра");
        model.addAttribute("cigarette",cigarette);
        model.addAttribute("categoryWithoutFilter",super.getCategory("без фильтра"));

        return "cigaretteWithoutFilter";
    }

    @PostMapping("saveWithoutFilter")
    public String saveWithoutFilter(Cigarette cigarette){
        if(cigarette.isNew()){
            //Вычисляет остаток на конец месяца
            cigarette.setBalanceOnTheLastDayOfTheMonth(cigarette.getBalanceOnTheFirstDayOfTheMonth()
            + cigarette.getReceivedForMonth() + cigarette.getSoldForMonth());
            super.create(cigarette);
        }else {
            //Вычисляет остаток на конец месяца
            cigarette.setBalanceOnTheLastDayOfTheMonth(cigarette.getBalanceOnTheFirstDayOfTheMonth()
                    + cigarette.getReceivedForMonth() + cigarette.getSoldForMonth());
            super.update(cigarette,cigarette.getId());
        }
        return "redirect:/cigaretteWithoutFilter";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:/cigaretteWithoutFilter";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model){
        model.addAttribute("cigarette", super.get(getId(request)));
        model.addAttribute("categoryWithoutFilter",super.getCategory("без фильтра"));
        return "cigaretteWithoutFilter";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
