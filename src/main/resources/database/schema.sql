-- Create database
CREATE DATABASE ownprojects

-- Connect to the created database
\c ownprojects

-- Drop table if exists
DROP TABLE IF EXISTS public.tbl_employees;

-- Create table
CREATE TABLE public.tbl_employees (
   id BIGSERIAL PRIMARY KEY,
   name TEXT NOT NULL DEFAULT 'anonymous',
   email TEXT NOT NULL DEFAULT 'example@example.com',
   department TEXT NOT NULL DEFAULT 'placeholder_department'
);