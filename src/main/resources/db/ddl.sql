create table product
(
    id                 bigserial
        constraint product_pkey
            primary key,
    title              varchar(255)                                    not null
        constraint product_title_key
            unique,
    cost               numeric(10, 2)                                  not null,
    manufacture_date   date                                            not null,
    version            integer     default 0                           not null,
    created_by         varchar(255),
    created_date       timestamp,
    last_modified_by   varchar(255),
    last_modified_date timestamp,
    status             varchar(20)
);

create table buyer
(
    id   bigserial
        constraint buyer_pkey
            primary key,
    name varchar(255)
);

create table orders
(
    id       bigserial
        constraint order_pkey
            primary key,
    cost     double precision,
    buyer_id bigint
        constraint fk_buyer
            references buyer
);

create table orders_product
(
    orders_id  bigserial not null
        constraint fk_order_product_order
            references orders,
    product_id bigint not null
        constraint fk_order_product_product
            references product,
    constraint orders_product_pkey
        primary key (orders_id, product_id)
);

create table cart
(
    id     bigserial
        constraint cart_pkey
            primary key,
    status varchar(255)
);

