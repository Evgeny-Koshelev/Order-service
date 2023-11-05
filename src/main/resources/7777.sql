CREATE TABLE if not exists orders
(
    uuid uuid not null,
    date Timestamp,
    client_id uuid not null,
    sum integer not null,
    order_items text,
    CONSTRAINT pk_status primary key(id)

);