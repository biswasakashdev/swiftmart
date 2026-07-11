DROP TABLE IF EXISTS shops;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id             VARCHAR(50) PRIMARY KEY,
    email          VARCHAR(100) NOT NULL UNIQUE,
    first_name     VARCHAR(50)  NOT NULL,
    last_name      VARCHAR(50)  NOT NULL,
    password       VARCHAR(100) NOT NULL,
    contact_number VARCHAR(30)  NOT NULL,
    country_code   VARCHAR(30)  NOT NULL,
    account_locked BOOLEAN      NOT NULL,
    created_on     DATE         NOT NULL
);


CREATE TABLE shops
(
    id         VARCHAR(50) PRIMARY KEY,
    shop_name  VARCHAR(50)  NOT NULL,
    owner_id   VARCHAR(100) NOT NULL,
    created_on DATE         NOT NULL,
    UNIQUE (owner_id, shop_name),
    FOREIGN KEY (owner_id) REFERENCES users (id) ON DELETE CASCADE
);
