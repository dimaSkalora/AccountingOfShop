package com.shop.of.accounting.web.product;

import com.shop.of.accounting.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Objects;

@Controller
@RequestMapping("productCategoryMeat")
public class JspProductMeatController extends AbstractProductController{

    @GetMapping
    public String getCategory(Model model){
        Product product = new Product();
        product.setGoodsReceiptDate(LocalDate.now());
        product.setCategory("мясные");
        model.addAttribute("product",product);
        model.addAttribute("categoryMeat", super.getCategory("мясные"));

        return "productCategoryMeat";
    }

    @PostMapping("saveMeat")
    public String saveMeat(Product product){
        if(product.isNew()){
            //Вычисляет остаток на конец месяца
            product.setBalanceOnTheLastDayOfTheMonth(product.getBalanceOnTheFirstDayOfTheMonth()
                    + product.getReceivedForMonth() - product.getSoldForMonth());
            super.create(product);
        }else {
            //Вычисляет остаток на конец месяца
            product.setBalanceOnTheLastDayOfTheMonth(product.getBalanceOnTheFirstDayOfTheMonth()
                    + product.getReceivedForMonth() - product.getSoldForMonth());
            super.update(product, product.getId());
        }

        return "redirect:/productCategoryMeat";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest httpServletRequest){
        super.delete(getId(httpServletRequest));
        return "redirect:/productCategoryMeat";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest httpServletRequest, Model model){
        model.addAttribute("product", super.get(getId(httpServletRequest)));
        model.addAttribute("categoryMeat", super.getCategory("мясные"));
        return "productCategoryMeat";
    }


    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
