CREATE DATABASE orderprocessing
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE orderprocessing
    IS 'Ecommerce Order processing Db';
    
CREATE SCHEMA orderprocessing
    AUTHORIZATION postgres;

-- Table: orderprocessing.billing_address

-- DROP TABLE orderprocessing.billing_address;

CREATE TABLE IF NOT EXISTS orderprocessing.billing_address
(
    billing_address_id numeric(15,0) NOT NULL,
    customer_id character varying(20) COLLATE pg_catalog."default",
    billing_addressline1 character varying(30) COLLATE pg_catalog."default",
    billing_addressline2 character varying(30) COLLATE pg_catalog."default",
    billing_city character varying(20) COLLATE pg_catalog."default",
    billing_state character varying(30) COLLATE pg_catalog."default",
    billing_zip character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT billing_address_pkey PRIMARY KEY (billing_address_id)
)

TABLESPACE pg_default;

ALTER TABLE orderprocessing.billing_address
    OWNER to postgres;

COMMENT ON TABLE orderprocessing.billing_address
    IS 'billing method';
    
-- Table: orderprocessing.customer

-- DROP TABLE orderprocessing.customer;

CREATE TABLE IF NOT EXISTS orderprocessing.customer
(
    customer_id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(30) COLLATE pg_catalog."default",
    last_name character varying(30) COLLATE pg_catalog."default",
    email character varying(80) COLLATE pg_catalog."default",
    mailing_address character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
)

TABLESPACE pg_default;

ALTER TABLE orderprocessing.customer
    OWNER to postgres;

COMMENT ON TABLE orderprocessing.customer
    IS 'a user who creates a new order ';
    
-- Table: orderprocessing.item

-- DROP TABLE orderprocessing.item;

CREATE TABLE IF NOT EXISTS orderprocessing.item
(
    item_id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    item_name character varying(40) COLLATE pg_catalog."default",
    item_discription character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT item_pkey PRIMARY KEY (item_id)
)

TABLESPACE pg_default;

ALTER TABLE orderprocessing.item
    OWNER to postgres;

COMMENT ON TABLE orderprocessing.item
    IS 'This is the product list';    
 
 -- Table: orderprocessing.payment

-- DROP TABLE orderprocessing.payment;

CREATE TABLE IF NOT EXISTS orderprocessing.payment
(
    payment_id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    customer_id character varying(20) COLLATE pg_catalog."default",
    order_id character varying(20) COLLATE pg_catalog."default",
    payment_method character varying(30) COLLATE pg_catalog."default",
    payment_date date,
    payment_confirm_number integer,
    CONSTRAINT payment_pkey PRIMARY KEY (payment_id)
)

TABLESPACE pg_default;

ALTER TABLE orderprocessing.payment
    OWNER to postgres;

COMMENT ON TABLE orderprocessing.payment
    IS 'payment detail';
    
-- Table: orderprocessing.shipping_address

-- DROP TABLE orderprocessing.shipping_address;

CREATE TABLE IF NOT EXISTS orderprocessing.shipping_address
(
    shipping_address_id numeric(15,0) NOT NULL,
    customer_id character varying(20) COLLATE pg_catalog."default",
    shipping_addressline1 character varying(30) COLLATE pg_catalog."default",
    shipping_addressline2 character varying(30) COLLATE pg_catalog."default",
    shipping_city character varying(20) COLLATE pg_catalog."default",
    shipping_state character varying(40) COLLATE pg_catalog."default",
    shipping_zip character varying(20) COLLATE pg_catalog."default",
    shipping_method character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT shipping_address_pkey PRIMARY KEY (shipping_address_id),
    CONSTRAINT fk_customer_id2 FOREIGN KEY (customer_id)
        REFERENCES orderprocessing.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE orderprocessing.shipping_address
    OWNER to postgres;

COMMENT ON CONSTRAINT fk_customer_id2 ON orderprocessing.shipping_address
    IS 'fk';    
    
  -- Table: orderprocessing.order

-- DROP TABLE orderprocessing."order";

CREATE TABLE IF NOT EXISTS orderprocessing."order"
(
    order_id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    customer_id character varying(20) COLLATE pg_catalog."default",
    order_status character varying(20) COLLATE pg_catalog."default",
    created_on date DEFAULT now(),
    modified_on date DEFAULT now(),
    completed_on date DEFAULT now(),
    item_id character varying(20) COLLATE pg_catalog."default",
    item_quantity integer NOT NULL DEFAULT 1,
    payment_method character varying(40) COLLATE pg_catalog."default",
    billing_address_id numeric(15,0),
    order_subtotal real DEFAULT 0.0,
    order_tax real DEFAULT 0.0,
    order_total real DEFAULT 0.0,
    shipping_address_id numeric(15,0),
    CONSTRAINT order_pkey PRIMARY KEY (order_id),
    CONSTRAINT "fk_customer-id" FOREIGN KEY (customer_id)
        REFERENCES orderprocessing.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_shipping_address_id FOREIGN KEY (shipping_address_id)
        REFERENCES orderprocessing.shipping_address (shipping_address_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE orderprocessing."order"
    OWNER to postgres;