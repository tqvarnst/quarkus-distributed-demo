-- INSERT INTO Price(id,salesId,country,currency,price) VALUES (nextval('hibernate_sequence'),'DAIRY_00034','SE','SEK',11.90);
-- INSERT INTO Price(id,salesId,country,currency,price) VALUES (nextval('hibernate_sequence'),'CANDY_01345','SE','SEK',6.95);
-- INSERT INTO Price(id,salesId,country,currency,price) VALUES (nextval('hibernate_sequence'),'FRUIT_00003','SE','SEK',22.99);
INSERT INTO Warehouse(id,name,location) VALUES('SWE','Sweden main central','Jönköping');
INSERT INTO Warehouse(id,name,location) VALUES('DE','Germany main central','Frankfurt');

INSERT INTO Inventory(id,salesId,warehouse_id,stock) VALUES (nextval('hibernate_sequence'),'DAIRY_00034','SWE',255);
INSERT INTO Inventory(id,salesId,warehouse_id,stock) VALUES (nextval('hibernate_sequence'),'CANDY_01345','SWE',2351);
INSERT INTO Inventory(id,salesId,warehouse_id,stock) VALUES (nextval('hibernate_sequence'),'FRUIT_00003','SWE',356);

INSERT INTO Inventory(id,salesId,warehouse_id,stock) VALUES (nextval('hibernate_sequence'),'DAIRY_00034','DE',1255);
INSERT INTO Inventory(id,salesId,warehouse_id,stock) VALUES (nextval('hibernate_sequence'),'CANDY_01345','DE',12351);
INSERT INTO Inventory(id,salesId,warehouse_id,stock) VALUES (nextval('hibernate_sequence'),'FRUIT_00003','DE',1356);
