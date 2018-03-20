DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS alcohol;
DROP TABLE IF EXISTS cigarette;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE alcohol (
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id INTEGER NOT NULL,
  goodsReceiptDate DATE NOT NULL,
  category VARCHAR NOT NULL,
  productName VARCHAR NOT NULL,
  liter DECIMAL NOT NULL,
  balanceOnTheFirstDayOfTheMonth INTEGER NOT NULL,
  receivedForMonth INTEGER NOT NULL,
  soldForMonth INTEGER NOT NULL,
  balanceOnTheLastDayOfTheMonth INTEGER NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX alcohol_unique_user_alcoholid_idx ON alcohol (id, user_id)

CREATE TABLE cigarette (
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id INTEGER NOT NULL,
  goodsReceiptDate DATE NOT NULL,
  category VARCHAR NOT NULL,
  productName VARCHAR NOT NULL,
  amount INTEGER NOT NULL,
  balanceOnTheFirstDayOfTheMonth INTEGER NOT NULL,
  receivedForMonth INTEGER NOT NULL,
  soldForMonth INTEGER NOT NULL,
  balanceOnTheLastDayOfTheMonth INTEGER NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX cigarette_unique_user_cigaretteid_idx ON cigarette (id, user_id)

CREATE TABLE product (
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id INTEGER NOT NULL,
  goodsReceiptDate DATE NOT NULL,
  category VARCHAR NOT NULL,
  productName VARCHAR NOT NULL,
  amount INTEGER NOT NULL,
  balanceOnTheFirstDayOfTheMonth INTEGER NOT NULL,
  receivedForMonth INTEGER NOT NULL,
  soldForMonth INTEGER NOT NULL,
  balanceOnTheLastDayOfTheMonth INTEGER NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX product_unique_user_productid_idx ON product (id, user_id)
