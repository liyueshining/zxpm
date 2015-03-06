package com.zxpm.biz.impl;

import java.util.List;

import com.zxpm.biz.GoodsBiz;
import com.zxpm.dao.GoodsDAO;
import com.zxpm.entity.Goods;

public class GoodsBizImpl implements GoodsBiz{

	//使用goodsdao接口声明goodsdao对象，并添加set方法用于依赖注入
	private GoodsDAO goodsDAO;
	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
	
	//获取在拍商品列表
	public List getOnSaleGoodsList() {
		Goods goods = new Goods();
		//获取状态为1 的商品，表示还未拍出
		goods.setGoodsStatus(new Integer(1));
		List list = goodsDAO.search(goods);
		return list;
	}

	public void addGoods(Goods goods) {
		goodsDAO.addGoods(goods);
	}

	public List getGoods(Goods condition) {
		List list = goodsDAO.search(condition);
		return list;
	}

	public Goods getGoodsByGoodsId(int goodsId) {
		return goodsDAO.getGoodsByGoodsId(goodsId);
	}

	public void updateGoods(Goods goods) {
		goodsDAO.updateGoods(goods);
	}

}
