package com.example.zuoye25.util;

import com.example.zuoye25.MyApp;
import com.example.zuoye25.bean.DaoBean;
import com.example.zuoye25.dao.DaoBeanDao;
import com.example.zuoye25.dao.DaoMaster;
import com.example.zuoye25.dao.DaoSession;

import java.util.List;

/**
 * Created by 康康 on 2019/6/21.
 */

public class DbUtil {
    private static DbUtil dbUtil;
    private final DaoBeanDao mDaoBeanDao;

    public DbUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getApp(), "info.db");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());

        DaoSession daoSession = daoMaster.newSession();

        mDaoBeanDao = daoSession.getDaoBeanDao();
    }

    public static DbUtil getDbUtil() {
        if(dbUtil==null){
            synchronized (DbUtil.class){
                if(dbUtil==null){
                    dbUtil=new DbUtil();
                }
            }
        }
        return dbUtil;
    }

    public void insert(DaoBean daoBean){

            mDaoBeanDao.insertOrReplaceInTx(daoBean);


    }

    public void delete(DaoBean daoBean){
        if(his(daoBean)){
            mDaoBeanDao.delete(daoBean);
        }
    }

    public List<DaoBean> query(){
        return mDaoBeanDao.queryBuilder().list();
    }

    public boolean his(DaoBean daoBean){
        List<DaoBean> list = mDaoBeanDao.queryBuilder().where(DaoBeanDao.Properties.Type.eq(daoBean.getType())).list();
        if(list!=null&&list.size()>0){
            return true;
        }
        return false;
    }
}
