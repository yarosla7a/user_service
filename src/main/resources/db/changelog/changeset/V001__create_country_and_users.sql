--liquibase formatted sql

--changeset yas:V001-create-country-table
CREATE TABLE country (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title varchar(64) UNIQUE NOT NULL
);

--changeset yas:V001-create-users-table
CREATE TABLE users (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username varchar(64) UNIQUE NOT NULL,
    password varchar(128) NOT NULL,
    email varchar(64) UNIQUE NOT NULL,
    phone varchar(32) UNIQUE,
    about_me varchar(4096),
    active boolean DEFAULT true NOT NULL,
    city varchar(64),
    country_id bigint NOT NULL,
    experience int,
    created_at timestamptz DEFAULT current_timestamp NOT NULL,
    updated_at timestamptz DEFAULT current_timestamp NOT NULL,

    CONSTRAINT fk_users_country_id FOREIGN KEY (country_id) REFERENCES country (id)
);
