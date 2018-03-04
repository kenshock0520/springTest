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
public class TrnTestListener implements EntityListener<TrnTest> {

    @Override
    public void preInsert(TrnTest entity, PreInsertContext<TrnTest> context) {
    }

    @Override
    public void preUpdate(TrnTest entity, PreUpdateContext<TrnTest> context) {
    }

    @Override
    public void preDelete(TrnTest entity, PreDeleteContext<TrnTest> context) {
    }

    @Override
    public void postInsert(TrnTest entity, PostInsertContext<TrnTest> context) {
    }

    @Override
    public void postUpdate(TrnTest entity, PostUpdateContext<TrnTest> context) {
    }

    @Override
    public void postDelete(TrnTest entity, PostDeleteContext<TrnTest> context) {
    }
}