/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.domain.service;

import java.util.List;

import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springTest.config.AppConfig;
import com.example.springTest.domain.entity.TrnTest;
import com.example.springTest.domain.entity.TrnUpsert;
import com.example.springTest.domain.repository.TrnTestDao;
import com.example.springTest.domain.repository.TrnUpsertDao;

@Service
@Transactional
public class TestService {

    @Autowired
    TrnTestDao trnTestDao;

    @Autowired
    TrnUpsertDao trnUpsertDao;

    public List<TrnTest> getTests() {
        return trnTestDao.selectAll();
    }

    public void doUpsert() {
    	TransactionManager tm = AppConfig.singleton().getTransactionManager();

    	tm.required(() -> {
	    	TrnUpsert entity = new TrnUpsert();
	    	entity.setUpsertMid(1L);
	    	entity.setUpsertRootId("00001");
	    	entity.setUpsertId("1");
	    	entity.setUpsertName("upsertName1");
	    	entity.setSortNum(1);
	    	trnUpsertDao.insert(entity);
    	});
    }
}