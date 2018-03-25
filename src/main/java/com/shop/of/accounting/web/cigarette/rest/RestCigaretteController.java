package com.shop.of.accounting.web.cigarette.rest;

import com.shop.of.accounting.model.Cigarette;
import com.shop.of.accounting.to.CigarettelWithBalanceNegative;
import com.shop.of.accounting.web.cigarette.AbstractCigaretteController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
//produces - Воспроизводимые типы носителей запрошенного запроса, сужающие первичное отображение.
@RequestMapping(value = RestCigaretteController.REST_CIGARETTE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestCigaretteController extends AbstractCigaretteController {
    static final String REST_CIGARETTE = "rest/profile/cigarettes";

    @Override
    @GetMapping("/{id}")
    //@PathVariable - Аннотации, указывающие, что параметр метода должен быть привязан к переменной шаблона UR
    public Cigarette get(@PathVariable("id") int id) {
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
    public List<CigarettelWithBalanceNegative> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("category/{category}")
    public List<CigarettelWithBalanceNegative> getCategory(@PathVariable("category") String category) {
        return super.getCategory(category);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cigarette> createCigarette(@Valid @RequestBody Cigarette cigarette) {
        Cigarette created = super.create(cigarette);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_CIGARETTE +"/{id}")
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
    public Cigarette update(@Valid @RequestBody Cigarette cigarette, @PathVariable("id") int id) {
        return super.update(cigarette, id);
    }

    @Override
    @GetMapping(value = "/filter")//?startDate=2018-03-11&endDate=2018-03-16
    //@RequestParam - Аннотации, указывающие, что параметр метода должен быть привязан к параметру веб-запроса.
    //required - Требуется ли параметр.
    public List<CigarettelWithBalanceNegative> getBetween(@RequestParam(value = "startDate", required = false) LocalDate startDate,
                                      @RequestParam(value = "endDate", required = false) LocalDate endDate) {
        return super.getBetween(startDate, endDate);
    }
}
