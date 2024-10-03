-- Crear la extensión uuid-ossp si no existe
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS avatars (
    uuid_avatar UUID PRIMARY KEY,
    image TEXT NOT NULL,
    name VARCHAR NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    date_update TIMESTAMP,
    date_inactivation TIMESTAMP,
    status CHAR NOT NULL DEFAULT 'A',
    last_user VARCHAR NOT NULL,
    extension VARCHAR NOT NULL
);