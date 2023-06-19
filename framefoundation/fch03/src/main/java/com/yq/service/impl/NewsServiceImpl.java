package com.yq.service.impl;

import com.yq.dao.NewsDao;
import com.yq.dao.SimpleDaoFactory;
import com.yq.entity.News;
import com.yq.service.NewsService;

public class NewsServiceImpl implements NewsService {

    private NewsDao dao = SimpleDaoFactory.getInstance("mysql"); //解耦合

    public void addNews(News news) {
        dao.save(news);
    }


    @Override
    public void save(News news) {

    }

    public NewsDao getDao() {
        return dao;
    }

    public void setDao(NewsDao dao) {
        this.dao = dao;
    }
}
