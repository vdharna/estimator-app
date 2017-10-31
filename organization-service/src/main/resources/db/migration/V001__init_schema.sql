DROP TABLE IF EXISTS organization CASCADE; 

CREATE TABLE organization 
  ( 
     id                 VARCHAR(255) NOT NULL, 
     active             BOOLEAN NOT NULL, 
     contact_email      VARCHAR(255), 
     contact_name       VARCHAR(255), 
     contact_phone      VARCHAR(255), 
     created_date       BYTEA, 
     last_modified_date BYTEA, 
     name               VARCHAR(255) NOT NULL,
     PRIMARY KEY (id) 
  );