CREATE TABLE customers (
    customer_id BIGINT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_id BIGINT UNIQUE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);


CREATE TABLE card_info (
    card_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT,
    card_number VARCHAR(20) NOT NULL,
    expiry_date VARCHAR(7) NOT NULL,
    cvv INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


CREATE TABLE billing_address (
    address_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT,
    addressL1 VARCHAR(255) NOT NULL,
    addressL2 VARCHAR(255) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE shipping_address (
    address_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT,
    addressL1 VARCHAR(255) NOT NULL,
    addressL2 VARCHAR(255) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE user_products (
    user_id BIGINT,
    product_id BIGINT,
    PRIMARY KEY (user_id, product_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);