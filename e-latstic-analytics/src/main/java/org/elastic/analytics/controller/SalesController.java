package org.elastic.analytics.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.elastic.analytics.model.CarSales;
import org.elastic.analytics.model.Response;
import org.elastic.analytics.repository.CarsSalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/v1/sales")
@RestController
public class SalesController {

    private static final String UNEXPECTED_ISSUE = "Unexpected issue occurred";

    @Autowired
    private CarsSalesRepository carsSalesRepository;


    @PostMapping()
    public Response saleCar(@Valid @RequestBody CarSales carSales) {
        log.info("Creating car sales document with data: {}", carSales);
        CarSales carSalesDoc;
        try {
            carSalesDoc = carsSalesRepository.save(carSales);
        } catch (Exception e) {
            log.error("Error occurred while saving car sales document", e);
            return new Response(false, UNEXPECTED_ISSUE);
        }
        log.info("Car sales document created successfully with id: {}", carSalesDoc.getId());
        return new Response(true, null);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        return new Response(false, ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

}
