
/* Drop Triggers */

DROP TRIGGER TRI_BOARD_BOARDNUM;
DROP TRIGGER TRI_BUY_BUYNUM;
DROP TRIGGER TRI_CREATECOUPON_CREATENUM;
DROP TRIGGER TRI_DELIVERY_DELIVERYNO;
DROP TRIGGER TRI_IMGUPLOAD_IMGNUM;
DROP TRIGGER TRI_PAYMENT_PAYMENTNUM;
DROP TRIGGER TRI_QABOARD_NUM;
DROP TRIGGER TRI_RETURNITEM_RETURNNO;



/* Drop Tables */

DROP TABLE BOARD CASCADE CONSTRAINTS;
DROP TABLE BUY CASCADE CONSTRAINTS;
DROP TABLE INTEREST CASCADE CONSTRAINTS;
DROP TABLE RETURNITEM CASCADE CONSTRAINTS;
DROP TABLE PAYMENT CASCADE CONSTRAINTS;
DROP TABLE ITEM CASCADE CONSTRAINTS;
DROP TABLE CATEGORY CASCADE CONSTRAINTS;
DROP TABLE CREATECOUPON CASCADE CONSTRAINTS;
DROP TABLE COUPON CASCADE CONSTRAINTS;
DROP TABLE DELIVERY CASCADE CONSTRAINTS;
DROP TABLE QABOARD CASCADE CONSTRAINTS;
DROP TABLE CUSTOMERINFO CASCADE CONSTRAINTS;
DROP TABLE STATISTIC CASCADE CONSTRAINTS;
DROP TABLE SUPPLIER CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_BOARD_BOARDNUM;
DROP SEQUENCE SEQ_BUY_BUYNUM;
DROP SEQUENCE SEQ_CREATECOUPON_CREATENUM;
DROP SEQUENCE SEQ_DELIVERY_DELIVERYNO;
DROP SEQUENCE SEQ_IMGUPLOAD_IMGNUM;
DROP SEQUENCE SEQ_PAYMENT_PAYMENTNUM;
DROP SEQUENCE SEQ_QABOARD_NUM;
DROP SEQUENCE SEQ_RETURNITEM_RETURNNO;




/* Create Sequences */

CREATE SEQUENCE SEQ_BOARD_BOARDNUM INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_BUY_BUYNUM INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_CREATECOUPON_CREATENUM INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_DELIVERY_DELIVERYNO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_IMGUPLOAD_IMGNUM INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_PAYMENT_PAYMENTNUM INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_QABOARD_NUM INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_RETURNITEM_RETURNNO INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE BOARD
(
	BOARDNUM number NOT NULL,
	TITLE varchar2(20 char),
	CONTENT varchar2(100 char),
	ID varchar2(15 char) NOT NULL,
	CODE varchar2(15 char) NOT NULL,
	IMGNAME varchar2(40 char),
	PRIMARY KEY (BOARDNUM)
);


CREATE TABLE BUY
(
	BUYNUM number NOT NULL,
	TOTALPRICE number,
	ID varchar2(15 char) NOT NULL,
	CODE varchar2(15 char) NOT NULL,
	PRIMARY KEY (BUYNUM)
);


CREATE TABLE CATEGORY
(
	CATEGORYLIST varchar2(15 char) NOT NULL,
	PRIMARY KEY (CATEGORYLIST)
);


CREATE TABLE COUPON
(
	NAME varchar2(15 char) NOT NULL,
	DISCOUNT number,
	PRIMARY KEY (NAME)
);


CREATE TABLE CREATECOUPON
(
	CREATENUM number NOT NULL,
	NAME varchar2(15 char) NOT NULL,
	ID varchar2(15 char) NOT NULL,
	USED varchar2(5 char),
	USEDATE date,
	PRIMARY KEY (CREATENUM)
);


CREATE TABLE CUSTOMERINFO
(
	ID varchar2(15 char) NOT NULL,
	PASSWORD varchar2(15 char) NOT NULL,
	QESLIST varchar2(25 char),
	ANS varchar2(15 char),
	NAME varchar2(15 char),
	GENDER varchar2(5 char),
	EMAIL varchar2(25 char),
	PHONENO varchar2(11 char),
	ADRESS varchar2(50 char),
	POSTNO varchar2(8 char),
	PRIMARY KEY (ID)
);


CREATE TABLE DELIVERY
(
	DELIVERYNO number NOT NULL,
	NAME varchar2(12 char),
	PHONENO varchar2(15 char),
	POSTNO varchar2(8 char),
	DELIVERYLOC varchar2(50 char),
	DELIVERYCONDI varchar2(8 char),
	ID varchar2(15 char) NOT NULL,
	PRIMARY KEY (DELIVERYNO)
);


CREATE TABLE INTEREST
(
	CODE varchar2(15 char) NOT NULL,
	ID varchar2(15 char) NOT NULL,
	UNIQUE (CODE, ID)
);


CREATE TABLE ITEM
(
	CODE varchar2(15 char) NOT NULL,
	PRICE number,
	INVENTORY number,
	NAME varchar2(15 char),
	RETAILPRICE number,
	ITEMIMGROOT varchar2(30 char),
	DETAILIMG varchar2(30 char),
	CATEGORYLIST varchar2(15 char) NOT NULL,
	SUPPLIER varchar2(20 char) NOT NULL,
	PRIMARY KEY (CODE)
);


CREATE TABLE PAYMENT
(
	PAYMENTNUM number NOT NULL,
	ITEMCOST number,
	RETAILPRICE number,
	CONDITION varchar2(10 char),
	COUPON varchar2(8 char),
	ID varchar2(15 char) NOT NULL,
	CODE varchar2(15 char) NOT NULL,
	DELIVERYNO number NOT NULL,
	YEAR_MONTH number NOT NULL,
	PRIMARY KEY (PAYMENTNUM)
);


CREATE TABLE QABOARD
(
	NUM number NOT NULL,
	REFNUM number,
	TITLE varchar2(20 char),
	CONTENT varchar2(100 char),
	ID varchar2(15 char) NOT NULL,
	QALIST varchar2(20 char),
	PRIMARY KEY (NUM)
);


CREATE TABLE RETURNITEM
(
	RETURNNO number NOT NULL,
	REASON varchar2(15 char),
	RETURNCONDI varchar2(8 char),
	PAYMENTNUM number NOT NULL,
	PRIMARY KEY (RETURNNO)
);


CREATE TABLE STATISTIC
(
	YEAR_MONTH number NOT NULL,
	TOTALRETAILPRICE number,
	TOTALSALES number,
	PRIMARY KEY (YEAR_MONTH)
);


CREATE TABLE SUPPLIER
(
	SUPPLIER varchar2(20 char) NOT NULL,
	MANAGER varchar2(10 char),
	CONTECT varchar2(15 char),
	PRIMARY KEY (SUPPLIER)
);



/* Create Foreign Keys */

ALTER TABLE ITEM
	ADD FOREIGN KEY (CATEGORYLIST)
	REFERENCES CATEGORY (CATEGORYLIST)
;


ALTER TABLE CREATECOUPON
	ADD FOREIGN KEY (NAME)
	REFERENCES COUPON (NAME)
;


ALTER TABLE BOARD
	ADD FOREIGN KEY (ID)
	REFERENCES CUSTOMERINFO (ID)
;


ALTER TABLE BUY
	ADD FOREIGN KEY (ID)
	REFERENCES CUSTOMERINFO (ID)
;


ALTER TABLE CREATECOUPON
	ADD FOREIGN KEY (ID)
	REFERENCES CUSTOMERINFO (ID)
;


ALTER TABLE DELIVERY
	ADD FOREIGN KEY (ID)
	REFERENCES CUSTOMERINFO (ID)
;


ALTER TABLE INTEREST
	ADD FOREIGN KEY (ID)
	REFERENCES CUSTOMERINFO (ID)
;


ALTER TABLE PAYMENT
	ADD FOREIGN KEY (ID)
	REFERENCES CUSTOMERINFO (ID)
;


ALTER TABLE QABOARD
	ADD FOREIGN KEY (ID)
	REFERENCES CUSTOMERINFO (ID)
;


ALTER TABLE PAYMENT
	ADD FOREIGN KEY (DELIVERYNO)
	REFERENCES DELIVERY (DELIVERYNO)
;


ALTER TABLE BOARD
	ADD FOREIGN KEY (CODE)
	REFERENCES ITEM (CODE)
;


ALTER TABLE BUY
	ADD FOREIGN KEY (CODE)
	REFERENCES ITEM (CODE)
;


ALTER TABLE INTEREST
	ADD FOREIGN KEY (CODE)
	REFERENCES ITEM (CODE)
;


ALTER TABLE PAYMENT
	ADD FOREIGN KEY (CODE)
	REFERENCES ITEM (CODE)
;


ALTER TABLE RETURNITEM
	ADD FOREIGN KEY (PAYMENTNUM)
	REFERENCES PAYMENT (PAYMENTNUM)
;


ALTER TABLE PAYMENT
	ADD FOREIGN KEY (YEAR_MONTH)
	REFERENCES STATISTIC (YEAR_MONTH)
;


ALTER TABLE ITEM
	ADD FOREIGN KEY (SUPPLIER)
	REFERENCES SUPPLIER (SUPPLIER)
;



