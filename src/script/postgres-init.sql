-- Drop existing database and user
DROP DATABASE IF EXISTS restdb;
DROP USER IF EXISTS restadmin;

-- Create database with UTF8 encoding
CREATE DATABASE restdb
    ENCODING 'UTF8'
    LC_COLLATE 'en_US.UTF-8'
    LC_CTYPE 'en_US.UTF-8'
    TEMPLATE template0;

-- Create user with password
CREATE USER restadmin WITH PASSWORD 'password';

-- Grant privileges on the database
GRANT ALL PRIVILEGES ON DATABASE restdb TO restadmin;

-- Connect to the database, then grant schema privileges
\c restdb

GRANT ALL PRIVILEGES ON SCHEMA public TO restadmin;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO restadmin;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO restadmin;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public TO restadmin;

-- Ensure future objects are also accessible
ALTER DEFAULT PRIVILEGES IN SCHEMA public
    GRANT ALL PRIVILEGES ON TABLES TO restadmin;
ALTER DEFAULT PRIVILEGES IN SCHEMA public
    GRANT ALL PRIVILEGES ON SEQUENCES TO restadmin;
ALTER DEFAULT PRIVILEGES IN SCHEMA public
    GRANT ALL PRIVILEGES ON FUNCTIONS TO restadmin;