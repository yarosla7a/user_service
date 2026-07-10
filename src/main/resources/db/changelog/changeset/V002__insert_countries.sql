--liquibase formatted sql

--changeset yas:V002-insert-countries
INSERT INTO country (title) VALUES
    ('Russia'),
    ('Lithuania'),
    ('Italy'),
    ('Germany'),
    ('France'),
    ('Spain'),
    ('United States');
