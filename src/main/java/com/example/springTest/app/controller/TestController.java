/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springTest.domain.entity.TrnTest;
import com.example.springTest.domain.service.TestService;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public List<TrnTest> getTests() {
        return testService.getTests();
    }
}