package com.zxpm.dao;

import com.zxpm.entity.Goods;

import java.util.List;

public interface GoodsDAO {

	//根据条件获取商品列表
	public List search(Goods condition);
	
	//添加待拍商品
	public void addGoods(Goods goods);
	
	//根据商品编号获取商品信息
	public Goods getGoodsByGoodsId(int goodsId);
	
	//更新goods
	public void updateGoods(Goods goods);
	
}
