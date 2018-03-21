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
@RequestMapping("productCategoryMilk")
public class JspProductMilkController extends AbstractProductController {

    @GetMapping
    public String getCategory(Model model){
        Product product = new Product();
        product.setGoodsReceiptDate(LocalDate.now());
        product.setCategory("молочные");
        model.addAttribute("product",product);
        model.addAttribute("categoryMilk", super.getCategory("молочные"));
        return "productCategoryMilk";
    }

    @PostMapping("saveMilk")
    public String save(Product product){
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

        return "redirect:/productCategoryMilk";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:/productCategoryMilk";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model){
        model.addAttribute("product", super.get(getId(request)));
        model.addAttribute("categoryMilk", super.getCategory("молочные"));
        return "productCategoryMilk";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
