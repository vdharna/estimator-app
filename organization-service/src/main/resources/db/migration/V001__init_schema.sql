CREATE TABLE organization (
  ID        			 VARCHAR(100) PRIMARY KEY NOT NULL,
  NAME                   TEXT NOT NULL,
  CONTACT_NAME           TEXT,
  CONTACT_EMAIL          TEXT,
  CONTACT_PHONE          TEXT,
  ACTIVE				 BOOLEAN,
  CREATED_DATE 			 DATE,
  LAST_MODIFIED_DATE 	 DATE
  );
