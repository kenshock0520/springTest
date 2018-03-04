package com.example.springTest.domain.repository;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.springTest.config.AppConfig;
import com.example.springTest.domain.entity.TrnTest;

/**
 */
@Dao(config = AppConfig.class)
@ConfigAutowireable
public interface TrnTestDao {

    /**
     * @param testMid
     * @return the TrnTest entity
     */
    @Select
    TrnTest selectById(Long testMid);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TrnTest entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TrnTest entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TrnTest entity);

    @Select
    List<TrnTest> selectAll();
}