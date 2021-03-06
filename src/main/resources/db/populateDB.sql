DELETE FROM user_roles;
DELETE FROM alcohol;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', '{noop}password'),
  ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO alcohol (goodsReceiptDate, category, productName, liter, balanceOnTheFirstDayOfTheMonth, receivedForMonth, soldForMonth, balanceOnTheLastDayOfTheMonth, user_id) VALUES
('2018-03-11','вино', 'productName1', 1.5, 3, 5, 4, 4, 100001),
('2018-03-11','вино', 'productName2', 0.5, 3, 5, 4, 4, 100001),
('2018-03-11','вино', 'productName3', 0.7, 3, 5, 4, 4, 100001),
('2018-03-11','вино', 'productName4', 1.5, 3, 5, 4, 4, 100000),
('2018-03-11','вино', 'productName5', 0.5, 3, 5, 4, 4, 100000),
('2018-03-11','вино', 'productName6', 0.7, 3, 5, 4, 4, 100000);

INSERT INTO cigarette (goodsReceiptDate, category, productName, amount, balanceOnTheFirstDayOfTheMonth, receivedForMonth, soldForMonth, balanceOnTheLastDayOfTheMonth, user_id) VALUES
('2018-03-11','с фильтром', 'productName1', 20, 3, 5, 4, 4, 100001),
('2018-03-11','с фильтром', 'productName2', 20, 3, 5, 4, 4, 100001),
('2018-03-11','без фильтра', 'productName3', 20, 3, 5, 4, 4, 100001),
('2018-03-11','с фильтром', 'productName4', 25, 3, 5, 4, 4, 100000),
('2018-03-11','без фильтра', 'productName5', 20, 3, 5, 4, 4, 100000),
('2018-03-11','с фильтром', 'productName6', 10, 3, 5, 4, 4, 100000);

INSERT INTO product (goodsReceiptDate, category, productName, amount, balanceOnTheFirstDayOfTheMonth, receivedForMonth, soldForMonth, balanceOnTheLastDayOfTheMonth, user_id) VALUES
('2018-03-11','молочные', 'productName1', 20, 3, 5, 4, 4, 100001),
('2018-03-11','молочные', 'productName2', 20, 3, 5, 4, 4, 100001),
('2018-03-11','мясные', 'productName3', 20, 3, 5, 4, 4, 100001),
('2018-03-11','мясные', 'productName4', 25, 3, 5, 4, 4, 100000),
('2018-03-11','молочные', 'productName5', 20, 3, 5, 4, 4, 100000),
('2018-03-11','мясные', 'productName6', 10, 3, 5, 4, 4, 100000);



