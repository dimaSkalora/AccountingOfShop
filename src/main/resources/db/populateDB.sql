DELETE FROM alcohol;

ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO alcohol (goodsReceiptDate, category, productName, liter, balanceOnTheFirstDayOfTheMonth, receivedForMonth, soldForMonth, balanceOnTheLastDayOfTheMonth) VALUES
('2018-03-11','вино', 'productName1', 1.5, 3, 5, 4, 1),
('2018-03-11','вино', 'productName2', 0.5, 3, 5, 4, 1),
('2018-03-11','вино', 'productName3', 0.7, 3, 5, 4, 1);



