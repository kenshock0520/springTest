/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {

//    @Autowired
//    TrnTestDao trnTestDao;

//	@Autowired
//	TrnUpsertDao trnUpsertDao;

//    public List<TrnTest> getTests() {
//        return trnTestDao.selectAll();
//    }
//
//    public void doUpsert() {
//    	TransactionManager tm = AppConfig.singleton().getTransactionManager();
//
//    	tm.required(() -> {
//	    	TrnUpsert entity = new TrnUpsert();
//	    	entity.setUpsertMid(1L);
//	    	entity.setUpsertRootId("00001");
//	    	entity.setUpsertId("1");
//	    	entity.setUpsertName("upsertName1");
//	    	entity.setSortNum(1);
//	    	trnUpsertDao.insert(entity);
//    	});
//    }
}