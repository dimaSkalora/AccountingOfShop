package com.shop.of.accounting.web.alcohol.jsp;

import com.shop.of.accounting.model.Alcohol;
import com.shop.of.accounting.web.alcohol.AbstractAlcoholController;
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
@RequestMapping("/alcoholCategoryWine")
public class JspAlcoholWineController extends AbstractAlcoholController {
    /*-----WINE-----*/
    @GetMapping()
    public String categoryWine(Model model){
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("вино");
        model.addAttribute("alcohol",alcohol );
        model.addAttribute("categoryWine",super.getCategory("вино"));
        //saveWine(new Alcohol(LocalDate.now(),"вино","ыпкф",2.0,2,2,2,2));

        return "alcoholCategoryWine";
    }

    @PostMapping("saveWine")
    public String saveWine(Alcohol alcohol ){
        if(alcohol.isNew()){
            //Вычисляет остаток на конец месяца
           alcohol.setBalanceOnTheLastDayOfTheMonth(alcohol.getBalanceOnTheFirstDayOfTheMonth()
           +alcohol.getReceivedForMonth()-alcohol.getSoldForMonth());

            super.create(alcohol);
        }
        else{
            //Вычисляет остаток на конец месяца
            alcohol.setBalanceOnTheLastDayOfTheMonth(alcohol.getBalanceOnTheFirstDayOfTheMonth()
                    +alcohol.getReceivedForMonth()-alcohol.getSoldForMonth());

            super.update(alcohol,alcohol.getId());
        }
        return "redirect:/alcoholCategoryWine";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:/alcoholCategoryWine";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model){
        String s1 = request.getRequestURI();
        System.out.println(s1);
        model.addAttribute("alcohol",super.get(getId(request)));
        model.addAttribute("categoryWine",super.getCategory("вино"));
        return "alcoholCategoryWine";
    }

    @PostMapping("/filter")
    public String getBetween(HttpServletRequest request, Model model) {
        LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
        LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("вино");
        model.addAttribute("alcohol",alcohol );
        model.addAttribute("categoryWine", super.getBetween(startDate, endDate));
        model.addAttribute("categoryWine",super.getCategory("вино"));
        System.out.println(super.getBetween(startDate,endDate));
        return "alcoholCategoryWine";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
