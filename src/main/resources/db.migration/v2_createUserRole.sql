CREATE TABLE roles (
    role_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role ENUM('CLIENT', 'VISITOR', 'ADMIN') DEFAULT 'VISITOR'
);


CREATE TABLE user_role (
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);


CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    image VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    unit VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    description VARCHAR(255) NOT NULL
);