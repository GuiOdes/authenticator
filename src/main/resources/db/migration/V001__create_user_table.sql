CREATE TABLE TB_USER (
    ID UUID PRIMARY KEY NOT NULL,
    USERNAME VARCHAR UNIQUE NOT NULL,
    EMAIL VARCHAR UNIQUE NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL,
    UPDATED_AT TIMESTAMP NOT NULL
);