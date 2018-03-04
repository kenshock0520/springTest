/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springTest.domain.entity.TrnTest;
import com.example.springTest.domain.repository.TrnTestDao;

@Service
@Transactional
public class TestService {

    @Autowired
    TrnTestDao trnTestDao;

    public List<TrnTest> getTests() {
        return trnTestDao.selectAll();
    }
}