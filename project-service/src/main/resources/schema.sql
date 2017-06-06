DROP TABLE IF EXISTS project;

CREATE TABLE project (
  id        VARCHAR(100) PRIMARY KEY NOT NULL,
  organization_id   TEXT NOT NULL,
  name      TEXT NOT NULL,
  comment           VARCHAR(100));


INSERT INTO project (id,  organization_id, name)
VALUES ('f3831f8c-c338-4ebe-a82a-e2fc1d1ff78a', 'e254f8c-c442-4ebe-a82a-e2fc1d1ff78a','customer-crm-co');
INSERT INTO project (id,  organization_id, name)
VALUES ('t9876f8c-c338-4abc-zf6a-ttt1', 'e254f8c-c442-4ebe-a82a-e2fc1d1ff78a','suitability-plus');
INSERT INTO project (id,  organization_id, name)
VALUES ('38777179-7094-4200-9d61-edb101c6ea84', '442adb6e-fa58-47f3-9ca2-ed1fecdfe86c','HR-PowerSuite');
INSERT INTO project (id,  organization_id, name)
VALUES ('08dbe05-606e-4dad-9d33-90ef10e334f9', '442adb6e-fa58-47f3-9ca2-ed1fecdfe86c','WildCat Application Gateway');