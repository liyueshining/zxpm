CREATE TABLE goods (
  GoodsId int(11) NOT NULL AUTO_INCREMENT,
  BuyerId int(11) NOT NULL,
  SalerId int(11) NOT NULL,
  GoodsName varchar(16) NOT NULL,
  GoodsPrice float NOT NULL,
  GoodsPic varchar(200) NULL,
  GoodsDesc longtext NULL,
  GoodsStatus int(11) NOT NULL,
  PRIMARY KEY (GoodsId),
  FOREIGN KEY(BuyerId) REFERENCES users(UserId),
  FOREIGN KEY(SalerId) REFERENCES users(UserId)
);
