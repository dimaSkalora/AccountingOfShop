package com.shop.of.accounting.web.product;

import com.shop.of.accounting.AuthorizedUser;
import com.shop.of.accounting.model.Product;
import com.shop.of.accounting.service.ProductService;
import com.shop.of.accounting.to.ProductWithBalanceNegative;
import com.shop.of.accounting.util.ProductsUtil;
import com.shop.of.accounting.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstractProductController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductService productService;

    public Product get(int id){
        int userId = AuthorizedUser.id();
        log.info("get Product {} for user {} ",id, userId);
        return productService.get(id,userId);
    }

    public void delete(int id){
        int userId = AuthorizedUser.id();
        log.info("delete product {] for user {} ",id,userId);
        productService.delete(id,userId);
    }

    public List<ProductWithBalanceNegative> getAll(){
        int userId = AuthorizedUser.id();
        log.info("getAll product {} for user {} ",userId);
        return ProductsUtil.getBalanceNeagtive(productService.getAll(userId));
    }

    public List<ProductWithBalanceNegative> getCategory(String category){
        int userId = AuthorizedUser.id();
        log.info("getCategory product {] for user {} ",category,userId);
        return ProductsUtil.getBalanceNeagtive(productService.getCategory(category,userId));
    }

    public Product create(Product product){
        int userId = AuthorizedUser.id();
        ValidationUtil.checkNew(product);
        log.info("create product {] for user {} ",product,userId);
        return productService.create(product,userId);
    }

    public Product update(Product product, int id){
        int userId = AuthorizedUser.id();
        ValidationUtil.assureIdConsistent(product,id);
        log.info("update product {} for user {} ",product,userId);
        return productService.update(product,userId);
    }

    public List<ProductWithBalanceNegative> getBetween(LocalDate startDate, LocalDate endDate) {
        final LocalDate MIN_DATE = LocalDate.of(1, 1, 1);
        final LocalDate MAX_DATE = LocalDate.of(3000, 1, 1);
        int userId = AuthorizedUser.id();
        log.info("getBetween dates({} - {}) time({} - {}) for user {}", startDate, endDate, userId);
        System.out.println("getBetween dates({} - {}) time({} - {}) for user {} "+ startDate+" "+ endDate+" "+
                userId);

        List<Product> productDateFiltered = productService.getBetweenDates(
                startDate != null ? startDate : MIN_DATE,
                endDate != null ? endDate : MAX_DATE, userId);

        return ProductsUtil.getBalanceNeagtive(productDateFiltered);
    }

}
