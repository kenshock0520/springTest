package com.example.springTest.domain.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class TrnUpsertListener implements EntityListener<TrnUpsert> {

    @Override
    public void preInsert(TrnUpsert entity, PreInsertContext<TrnUpsert> context) {
    }

    @Override
    public void preUpdate(TrnUpsert entity, PreUpdateContext<TrnUpsert> context) {
    }

    @Override
    public void preDelete(TrnUpsert entity, PreDeleteContext<TrnUpsert> context) {
    }

    @Override
    public void postInsert(TrnUpsert entity, PostInsertContext<TrnUpsert> context) {
    }

    @Override
    public void postUpdate(TrnUpsert entity, PostUpdateContext<TrnUpsert> context) {
    }

    @Override
    public void postDelete(TrnUpsert entity, PostDeleteContext<TrnUpsert> context) {
    }
}