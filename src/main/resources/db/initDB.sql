DROP TABLE IF EXISTS alcohol;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE alcohol (
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  goodsReceiptDate DATE NOT NULL,
  category VARCHAR NOT NULL,
  productName VARCHAR NOT NULL,
  liter DECIMAL NOT NULL,
  balanceOnTheFirstDayOfTheMonth INTEGER NOT NULL,
  receivedForMonth INTEGER NOT NULL,
  soldForMonth INTEGER NOT NULL,
  balanceOnTheLastDayOfTheMonth INTEGER NOT NULL
);
