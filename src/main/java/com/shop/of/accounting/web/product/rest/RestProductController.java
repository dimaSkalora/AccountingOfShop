package com.shop.of.accounting.web.product.rest;

import com.shop.of.accounting.model.Product;
import com.shop.of.accounting.to.ProductWithBalanceNegative;
import com.shop.of.accounting.web.product.AbstractProductController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.awt.*;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
//produces - Воспроизводимые типы носителей запрошенного запроса, сужающие первичное отображение.
@RequestMapping(value = RestProductController.REST_PRODUCT, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestProductController extends AbstractProductController {
    static final String REST_PRODUCT = "rest/profile/products";

    @Override
    @GetMapping("/{id}")
    //@PathVariable - Аннотации, указывающие, что параметр метода должен быть привязан к переменной шаблона UR
    public Product get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    //ResponseStatus -Маркирует метод или класс исключения со статусом code()и reason()который должен быть возвращен.
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @GetMapping
    public List<ProductWithBalanceNegative> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/category/{category}")
    public List<ProductWithBalanceNegative> getCategory(@PathVariable("category") String category) {
        return super.getCategory(category);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product created = super.create(product);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_PRODUCT+"/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    //consumes - Типы расходных материалов отображаемого запроса, сужающие первичное отображение.
    //RequestBody - Аннотации, указывающие параметр метода, должны быть привязаны к телу веб-запроса.
    // Тело запроса передается через HttpMessageConverter для разрешения аргумента метода в зависимости
    // от типа содержимого запроса. Необязательно, автоматическая проверка может быть применена
    // путем аннотации аргумента с помощью @Valid.
    //@Valid для получения заполненных атрибутов из формы
    //Помечает свойство, метод или метод возвращаемого типа для каскадирования валидации.
    //Ограничения, определенные для объекта и его свойств, проверяются, когда проверяются тип свойства, метода или
    //метод возврата метода.
    public Product update(@Valid @RequestBody Product product,@PathVariable("id") int id) {
        return super.update(product, id);
    }

    @Override
    @GetMapping("/filter")//?startDate=2018-03-11&endDate=2018-03-16
    //@RequestParam - Аннотации, указывающие, что параметр метода должен быть привязан к параметру веб-запроса.
    //required - Требуется ли параметр.
    public List<ProductWithBalanceNegative> getBetween(@RequestParam(value = "startDate", required = false) LocalDate startDate,
                                    @RequestParam(value = "endDate", required = false) LocalDate endDate) {
        return super.getBetween(startDate, endDate);
    }
}
