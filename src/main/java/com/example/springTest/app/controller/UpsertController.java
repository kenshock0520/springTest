/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springTest.domain.service.TestService;

@RestController
@RequestMapping(value = "/upsert")
public class UpsertController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/upsert", method = RequestMethod.GET)
    public String doUpsert() {
    	testService.doUpsert();
        return "OK";
    }
}