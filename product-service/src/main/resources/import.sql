INSERT INTO Category(id,name) VALUES (nextval('hibernate_sequence'),'Dairy');
INSERT INTO Category(id,name) VALUES (nextval('hibernate_sequence'),'Candy');
INSERT INTO Category(id,name) VALUES (nextval('hibernate_sequence'),'Fruit');

INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('DAIRY_00034','Milk',to_date('2018-08-24','YYYY-MM-DD'),1);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('DAIRY_00035','Eco Milk',to_date('2018-08-25','YYYY-MM-DD'),1);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('DAIRY_00036','Butter',to_date('2018-08-11','YYYY-MM-DD'),1);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('DAIRY_00037','Eco Butter',to_date('2018-08-12','YYYY-MM-DD'),1);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('CANDY_01345','Snickers',to_date('2018-02-13','YYYY-MM-DD'),2);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('CANDY_01346','Mars',to_date('2018-02-17','YYYY-MM-DD'),2);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('CANDY_01347','Bounty',to_date('2018-02-11','YYYY-MM-DD'),2);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('CANDY_01348','Milk chocolate',to_date('2018-02-05','YYYY-MM-DD'),2);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('FRUIT_00003','Banana',to_date('2020-12-02','YYYY-MM-DD'),3);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('FRUIT_00004','Apple',to_date('2020-12-12','YYYY-MM-DD'),3);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('FRUIT_00005','Cherry',to_date('2020-12-07','YYYY-MM-DD'),3);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('FRUIT_00006','Orange',to_date('2020-12-24','YYYY-MM-DD'),3);


