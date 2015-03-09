CREATE TABLE users (
  UserId int(11) NOT NULL AUTO_INCREMENT,
  UserName varchar(16) NOT NULL,
  Password varchar(16) NOT NULL,
  Telephone varchar(16) NOT NULL,
  Address varchar(16) NOT NULL,
  BidStatus int(11) NOT NULL,
  PRIMARY KEY (UserId)
);
