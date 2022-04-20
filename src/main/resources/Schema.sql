CREATE SCHEMA IF NOT EXISTS myschema;
CREATE TABLE IF NOT EXISTS myschema.coordinates_entity
(
    id        integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    driver_id integer,
    latitude  varchar(50),
    longitude varchar(50),
    time      TIMESTAMP WITHOUT TIME ZONE
);