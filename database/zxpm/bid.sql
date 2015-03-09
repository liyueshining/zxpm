CREATE TABLE bid (
  BidId int(11) NOT NULL AUTO_INCREMENT,
  BuyerId int(11) NOT NULL,
  GoodsId int(11) NOT NULL,
  BidTime datetime NOT NULL,
  BidPrice float NOT NULL,
  BidStatus int(11) NOT NULL,
  PRIMARY KEY (BidId),
  FOREIGN KEY (BuyerId) REFERENCES users(UserId),
  FOREIGN KEY (GoodsId) REFERENCES goods(GoodsId)
);
