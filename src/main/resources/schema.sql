CREATE TABLE IF NOT EXISTS authors(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20)  NOT NULL,
birth_date DATE NOT NULL, nationality VARCHAR(15) NOT NULL);

CREATE TABLE IF NOT EXISTS books(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20) NOT NULL,
theme VARCHAR(10) NOT NULL, publication_date DATE NOT NULL, price DOUBLE NOT NULL, native_language VARCHAR(20) NOT NULL author_id BIGINT NOT NULL,
CONSTRAINT fk_authors FOREIGN KEY (author_id) REFERENCES author(id));

CREATE TABLE IF NOT EXISTS clients(id BIGSERIAL PRIMARY KEY, client_id VARCHAR(100) NOT NULL, client_secret VARCHAR(200),
scope VARCHAR(200));