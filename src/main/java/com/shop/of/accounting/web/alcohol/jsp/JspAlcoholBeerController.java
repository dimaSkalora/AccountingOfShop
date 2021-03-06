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
@RequestMapping("alcoholCategoryBeer")
public class JspAlcoholBeerController extends AbstractAlcoholController {
    /*-----Beer-----*/
    @GetMapping()
    public String categoryVodka(Model model){
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("пиво");
        model.addAttribute("alcohol",alcohol );
        model.addAttribute("categoryBeer",super.getCategory("пиво"));
       // saveBeer(new Alcohol(LocalDate.now(),"пиво","ыпкф",2.0,2,2,2,2));
        return "alcoholCategoryBeer";
    }

    @PostMapping("searchByProductName")
    public String searchByProductName(Model model, HttpServletRequest request){
        String productParameter = request.getParameter("searchByProductName");
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("пиво");
        model.addAttribute("alcohol",alcohol );
        model.addAttribute("categoryBeer",super.getSearchByProductName(productParameter,"пиво"));
        return "alcoholCategoryBeer";
    }

    @PostMapping("saveBeer")
    public String saveBeer(Alcohol alcohol ){
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
        return "redirect:/alcoholCategoryBeer";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:/alcoholCategoryBeer";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model){
        String s1 = request.getRequestURI();
        System.out.println(s1);
        model.addAttribute("alcohol",super.get(getId(request)));
        model.addAttribute("categoryBeer",super.getCategory("пиво"));
        return "alcoholCategoryBeer";
    }

    @PostMapping("/filter")
    public String getBetween(HttpServletRequest request, Model model) {
        LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
        LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("пиво");
        model.addAttribute("alcohol",alcohol );
        model.addAttribute("categoryBeer", super.getBetween(startDate, endDate));
        model.addAttribute("categoryBeer",super.getCategory("пиво"));
        System.out.println(super.getBetween(startDate,endDate));
        return "alcoholCategoryBeer";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

}
