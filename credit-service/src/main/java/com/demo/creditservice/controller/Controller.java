package com.demo.creditservice.controller;

import com.demo.creditservice.model.CreditInfo;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@Slf4j
public class Controller {

    private Random random = new Random();
    
    private static final Logger log = LoggerFactory.getLogger(Controller.class);


    @GetMapping("/creditInfo/accounts/{id}")
    public CreditInfo getCreditInfoByAccountId(@PathVariable long id) {
        log.info("Handling getCreditInfoByAccountId: id={}", id);
       

        // use delay to pretend processing is happening
        randomDelay();

        return new CreditInfo(id, new Date());
    }

    private void randomDelay() {
        try {
            // sleep a bit
            Thread.sleep((long)(2*random.nextDouble()*1000));
        } catch (Exception e) {
            // ignore
        }
    }
}
