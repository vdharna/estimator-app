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
  
  INSERT INTO organization 
            (id, 
             NAME, 
             contact_name, 
             contact_email, 
             contact_phone, 
             active) 
VALUES      ('e254f8c-c442-4ebe-a82a-e2fc1d1ff78a', 
             'customer-crm-co', 
             'Dharminder Dharna', 
             'ddharna@custcrmco.com', 
             '823-555-1212', 
             true); 

INSERT INTO organization 
            (id, 
             NAME, 
             contact_name, 
             contact_email, 
             contact_phone, 
             active) 
VALUES      ('442adb6e-fa58-47f3-9ca2-ed1fecdfe86c', 
             'HR-PowerSuite', 
             'Doug Drewry', 
             'doug.drewry@hr.com', 
             '920-555-1212', 
             true); 