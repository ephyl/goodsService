DROP table IF EXISTS goods;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS goods
(
    id       uuid DEFAULT uuid_generate_v4 (),
    store_id int not null check ( goods.store_id >0 ),
    name     VARCHAR(100) not null UNIQUE,
    quantity int          not null check (goods.quantity > 0),
    price    decimal (10,2)      not null check (goods.price > 0)

);

INSERT INTO goods(store_id, name, quantity, price) VALUES (
                                                           1, 'name', 10, 12.01
                                                          );