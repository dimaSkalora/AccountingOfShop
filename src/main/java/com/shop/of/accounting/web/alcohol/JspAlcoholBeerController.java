package com.shop.of.accounting.web.alcohol;

import com.shop.of.accounting.model.Alcohol;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Objects;

@Controller
@RequestMapping("alcoholCategoryBeer")
public class JspAlcoholBeerController extends AbstractAlcoholController{
    /*-----Beer-----*/
    @GetMapping()
    public String categoryVodka(Model model){
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("пиво");
        model.addAttribute("alcohol",alcohol );
        model.addAttribute("categoryBeer",super.getCategory("пиво"));
        saveBeer(new Alcohol(LocalDate.now(),"пиво","ыпкф",2.0,2,2,2,2));
        return "alcoholCategoryBeer";
    }

    @PostMapping("saveBeer")
    public String saveBeer(Alcohol alcohol ){
        if(alcohol.isNew()){
            super.create(alcohol);
        }
        else{
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

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

}
