----- CREATING TABLES -----

DROP TABLE transMoney;
DROP TABLE payment;
DROP TABLE customer;
DROP TABLE merchant;

CREATE TABLE merchant
(
  id         INT            NOT NULL GENERATED ALWAYS AS IDENTITY,
  name       VARCHAR(60)    NOT NULL,
  charge     DECIMAL(5, 2)  NOT NULL,
  period     SMALLINT       NOT NULL,
  minSum     DECIMAL(19, 2) NOT NULL,
  bankName   VARCHAR(100)   NOT NULL,
  swift      VARCHAR(40)    NOT NULL,
  account    VARCHAR(20)    NOT NULL,
  needToSend DECIMAL(19, 2),
  sent       DECIMAL(19, 2),
  lastSent   DATE,
  PRIMARY KEY (id)
);

CREATE TABLE customer
(
  id       INT          NOT NULL GENERATED ALWAYS AS IDENTITY,
  name     VARCHAR(60)  NOT NULL,
  address  VARCHAR(300) NOT NULL,
  email    VARCHAR(90)  NOT NULL,
  ccNo     VARCHAR(20)  NOT NULL,
  ccType   VARCHAR(60)  NOT NULL,
  maturity DATE,
  PRIMARY KEY (id)
);

CREATE TABLE payment
(
  id          INT       NOT NULL GENERATED ALWAYS AS IDENTITY,
  dt          TIMESTAMP NOT NULL,
  merchantId  INT CONSTRAINT merchant_fk REFERENCES merchant,
  customerId  INT CONSTRAINT customer_fk REFERENCES customer,
  goods       VARCHAR(500),
  sumPayed    DECIMAL(15, 2),
  chargePayed DECIMAL(15, 2),
  PRIMARY KEY (id)
);

CREATE TABLE transMoney
(
  id         INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  merchantId INT CONSTRAINT merchmoney_fk REFERENCES merchant,
  sumSent    DECIMAL(19, 2),
  sentDate   TIMESTAMP,
  status     CHAR(1),
  PRIMARY KEY (id)
);

----- INSERT DATA -----

INSERT INTO merchant (name, charge, period, minSum, bankName, swift, account)
VALUES ('Jim Smith Ltd.', 5.1, 1, 100.0, 'Chase Manhatten', 'AA245BXW', '247991002');
INSERT INTO merchant (name, charge, period, minSum, bankName, swift, account)
VALUES ('Domby and sun Co.', 2.8, 2, 20.0, 'Paribas', 'XTW2NNM', '1188532009');
INSERT INTO merchant (name, charge, period, minSum, bankName, swift, account)
VALUES ('Victoria Shop Ltd.', 3.4, 3, 500.0, 'Swedbank', 'SWEE34YY', '557880234');
INSERT INTO merchant (name, charge, period, minSum, bankName, swift, account)
VALUES ('Software & Digital goods', 4.9, 1, 160.0, 'Credi Leone', 'FRTOPM', '367920489');

INSERT INTO customer (name, address, email, ccNo, ccType, maturity)
VALUES ('Dan Nelis', 'Vosselaar st. 19, Trnaut, Belgium', 'Dan@adw.com', '11345694671214', 'MasterCard', '2014-07-31');
INSERT INTO customer (name, address, email, ccNo, ccType, maturity)
VALUES ('Mark Wolf', 'Olaf st. 11, Stockholm, Sweden', 'mwolf@yahoo.com', '44402356988712', 'Visa', '2012-09-30');
INSERT INTO customer (name, address, email, ccNo, ccType, maturity)
VALUES ('Stein Brown', 'Oxford st. 223, Stockholm, Sweden', 'steinB@yahoo.com', '41233576012434', 'Visa', '2015-11-30');

INSERT INTO payment (dt, merchantId, customerId, goods, sumPayed)
VALUES ('2012-07-12 10:00:14', 3, 1, 'CD Europe Maps', 12.08);
INSERT INTO payment (dt, merchantId, customerId, goods, sumPayed)
VALUES ('2012-06-22 18:21:10', 4, 3, 'NOD32 Antivirus', 33.80);
INSERT INTO payment (dt, merchantId, customerId, goods, sumPayed)
VALUES ('2012-07-02 00:00:17', 1, 1, 'Railway return ticket Brussel-Paris', 255.58);
INSERT INTO payment (dt, merchantId, customerId, goods, sumPayed)
VALUES ('2012-07-06 11:22:40', 1, 2, 'Railway ticket Stockholm - Oslo', 1325.00);
INSERT INTO payment (dt, merchantId, customerId, goods, sumPayed)
VALUES ('2012-07-10 11:10:45', 3, 2, 'CD African music', 7.65);
INSERT INTO payment (dt, merchantId, customerId, goods, sumPayed)
VALUES ('2012-06-30 12:00:00', 2, 1, 'Acer computer', 654.00);
INSERT INTO payment (dt, merchantId, customerId, goods, sumPayed)
VALUES ('2012-07-02 22:28:50', 4, 2, 'NOD32 Antivirus', 33.80);
INSERT INTO payment (dt, merchantId, customerId, goods, sumPayed)
VALUES ('2012-07-09 02:12:53', 4, 3, 'MS Office', 400.23);
INSERT INTO payment (dt, merchantId, customerId, goods, sumPayed)
VALUES ('2012-07-15 22:28:50', 2, 2, 'Dell computer', 768.00);

UPDATE merchant
SET lastSent = '2015-02-21'
WHERE id = 1;
UPDATE merchant
SET lastSent = '2015-02-21'
WHERE id = 2;
UPDATE merchant
SET lastSent = '2015-02-21'
WHERE id = 3;
UPDATE merchant
SET lastSent = '2015-02-28'
WHERE id = 4;

