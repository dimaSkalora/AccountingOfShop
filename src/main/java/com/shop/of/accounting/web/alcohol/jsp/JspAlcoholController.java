package com.shop.of.accounting.web.alcohol.jsp;

import com.shop.of.accounting.model.Alcohol;
import com.shop.of.accounting.web.alcohol.AbstractAlcoholController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Objects;

@Controller
@RequestMapping("alcohols")
public class JspAlcoholController extends AbstractAlcoholController {

    @GetMapping
    public String alcohols(Model model){
        model.addAttribute("alcohols", super.getAll());
        return "alcohols";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:/alcohols";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model){
        String s1 = request.getRequestURI();
        System.out.println(s1);
        model.addAttribute("alcohol",super.get(getId(request)));
        return "alcoholForm";
    }

    @GetMapping("/create")
    public String create(Model model ){
        model.addAttribute("alcohol", new Alcohol(LocalDate.now(),"","",0.0,0,0,0,0));
        return "alcoholForm";
    }


/*    @PostMapping("/save")
    public String save(@ModelAttribute("alcohol") Alcohol alcohol, int id){
        if(alcohol.isNew()){
            super.create(alcohol);
        }
        else{
            super.update(alcohol,id);
        }
        return "redirect:/alcohols";
    }*/
    @PostMapping("/save")
    public String save(Alcohol alcohol ){
        if(alcohol.isNew()){
            super.create(alcohol);
        }
        else{
            super.update(alcohol,alcohol.getId());
        }
            return "redirect:/alcohols";
    }

    /*-----WINE-----*/
    @GetMapping("category/wine")
    public String categoryWine(Model model){
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("вино");
        model.addAttribute("alcohol",alcohol );
        model.addAttribute("categoryWine",super.getCategory("вино"));
        return "alcoholCategoryWine";
    }
    @GetMapping("/create/wine")
    public String createWine(Model model){
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("вино");
        model.addAttribute("alcohol",alcohol );
        return "alcoholForm";
    }

    @PostMapping("/saveWine")
    public String saveWine(Alcohol alcohol ){
        if(alcohol.isNew()){
            super.create(alcohol);
        }
        else{
            super.update(alcohol,alcohol.getId());
        }
        return "redirect:/alcoholCategoryWine";
    }

    /*-----Vodka-----*/
    @GetMapping("category/vodka")
    public String categoryVodka(Model model){
        model.addAttribute("categoryVodka",super.getCategory("водка"));
        return "alcoholCategoryVodka";
    }

    @GetMapping("/create/vodka")
    public String createVodka(Model model){
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("водка");
        model.addAttribute("alcohol",alcohol);
        return "alcoholForm";
    }

    /*-----Beer-----*/
    @GetMapping("category/beer")
    public String categoryBeer(Model model){
        model.addAttribute("categoryBeer",super.getCategory("пиво"));
        return "alcoholCategoryBeer";
    }

    @GetMapping("/create/beer")
    public String createBeer(Model model){
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("пиво");
        model.addAttribute("alcohol",alcohol);
        return "alcoholForm";
    }


    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
