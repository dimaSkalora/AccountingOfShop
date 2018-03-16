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
@RequestMapping("alcoholCategoryVodka")
public class JspAlcoholVodkaController extends AbstractAlcoholController {
    /*-----Vodka-----*/
    @GetMapping()
    public String categoryVodka(Model model){
        Alcohol alcohol = new Alcohol();
        alcohol.setGoodsReceiptDate(LocalDate.now());
        alcohol.setCategory("водка");
        model.addAttribute("alcohol",alcohol );
        model.addAttribute("categoryVodka",super.getCategory("водка"));
        saveVodka(new Alcohol(LocalDate.now(),"водка","ыпкф",2.0,2,2,2,2));

        return "alcoholCategoryVodka";
    }

    @PostMapping("saveVodka")
    public String saveVodka(Alcohol alcohol ){
        if(alcohol.isNew()){
            super.create(alcohol);
        }
        else{
            super.update(alcohol,alcohol.getId());
        }
        return "redirect:/alcoholCategoryVodka";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:/alcoholCategoryVodka";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model){
        String s1 = request.getRequestURI();
        System.out.println(s1);
        model.addAttribute("alcohol",super.get(getId(request)));
        model.addAttribute("categoryVodka",super.getCategory("водка"));
        return "alcoholCategoryVodka";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

}
