INSERT INTO Category(id,name) VALUES (nextval('hibernate_sequence'),'Dairy');
INSERT INTO Category(id,name) VALUES (nextval('hibernate_sequence'),'Candy');
INSERT INTO Category(id,name) VALUES (nextval('hibernate_sequence'),'Fruit');

INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('DAIRY_00034','Milk',to_date('2018-08-24','YYYY-MM-DD'),1);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('CANDY_01345','Snickers',to_date('2018-02-13','YYYY-MM-DD'),2);
INSERT INTO Product(salesId, name,creationDate,category_id) VALUES ('FRUIT_00003','Banana',to_date('2020-12-02','YYYY-MM-DD'),3);


