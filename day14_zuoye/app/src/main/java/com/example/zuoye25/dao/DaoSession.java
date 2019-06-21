package com.example.zuoye25.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.zuoye25.bean.DaoBean;

import com.example.zuoye25.dao.DaoBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig daoBeanDaoConfig;

    private final DaoBeanDao daoBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        daoBeanDaoConfig = daoConfigMap.get(DaoBeanDao.class).clone();
        daoBeanDaoConfig.initIdentityScope(type);

        daoBeanDao = new DaoBeanDao(daoBeanDaoConfig, this);

        registerDao(DaoBean.class, daoBeanDao);
    }
    
    public void clear() {
        daoBeanDaoConfig.clearIdentityScope();
    }

    public DaoBeanDao getDaoBeanDao() {
        return daoBeanDao;
    }

}
