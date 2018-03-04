package com.example.springTest.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.springTest.config.AppConfig;
import com.example.springTest.domain.entity.TrnUpsert;

/**
 */
@Dao(config = AppConfig.class)
@ConfigAutowireable
public interface TrnUpsertDao {

    /**
     * @param upsertMid
     * @return the TrnUpsert entity
     */
    @Select
    TrnUpsert selectById(Long upsertMid);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TrnUpsert entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TrnUpsert entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TrnUpsert entity);
}