CREATE TABLE cart (
    cart_id BIGINT PRIMARY KEY,
    shipping_cost BIGINT NOT NULL,
    user_id BIGINT UNIQUE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE cart_item (
    ci_id BIGINT PRIMARY KEY,
    quantity INT NOT NULL,
    cart_id BIGINT UNIQUE,
    FOREIGN KEY (cart_id) REFERENCES cart(id) ON DELETE CASCADE
    product_id BIGINT UNIQUE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);