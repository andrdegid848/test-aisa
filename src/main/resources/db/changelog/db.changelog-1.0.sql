create TABLE IF NOT EXISTS coffee
(
    id                     SERIAL PRIMARY KEY,
    name                   VARCHAR(64) NOT NULL,
    roast                  VARCHAR(64) NOT NULL,
    cooking_method         VARCHAR(64) NOT NULL,
    additional_ingredient  VARCHAR(64),
    dtype                  VARCHAR(64)
);