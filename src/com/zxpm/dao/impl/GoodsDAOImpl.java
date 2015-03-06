package com.zxpm.dao.impl;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

import com.zxpm.dao.GoodsDAO;
import com.zxpm.entity.Goods;

public class GoodsDAOImpl extends HibernateDaoSupport implements GoodsDAO{

	public List search(final Goods condition) {
		return super.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					
					public Object doInHibernate(Session session) throws HibernateException,
							SQLException {
						Criteria criteria = session.createCriteria(Goods.class);
						if(condition != null){
							if(condition.getGoodsStatus() != null && !condition.getGoodsStatus().equals("")){
								criteria.add(Restrictions.eq("goodsStatus", condition.getGoodsStatus()));
							}
							if(condition.getSaler() != null){
								criteria.add(Restrictions.eq("saler", condition.getSaler()));
							}
						}
						return criteria.list();
					}
				});
	}

	public void addGoods(Goods goods) {
		
		super.getHibernateTemplate().save(goods);
	}

	//根据商品编号获取商品信息
	public Goods getGoodsByGoodsId(int goodsId) {
		Goods goods = (Goods)super.getHibernateTemplate().get(Goods.class, new Integer(goodsId));
		return goods;
	}

	public void updateGoods(Goods goods) {
		super.getHibernateTemplate().update(goods);
	}
}
