-- Create table
DROP TABLE application IF EXISTS;
DROP TABLE contact IF EXISTS;
CREATE TABLE application (
  id           BIGINT GENERATED BY DEFAULT AS IDENTITY,
  dt_created   DATE,
  product_name VARCHAR(255) NOT NULL,
  contact_id   BIGINT,
  PRIMARY KEY (id)
);
CREATE TABLE contact (
  id   BIGINT GENERATED BY DEFAULT AS IDENTITY,
  PRIMARY KEY (id)
);
ALTER TABLE application
  ADD CONSTRAINT FKeq5wq4mv9ibi3og8awl1bwqa0 FOREIGN KEY (contact_id) REFERENCES contact;

-- Fill table in the data
INSERT INTO contact (id) VALUES (1);
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 1, '2015-01-01', 'app1_1');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 1, '2015-01-02', 'app1_2');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 1, '2015-01-03', 'app1_3');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 1, '2015-01-04', 'app1_4');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 1, '2015-01-05', 'app1_5');


INSERT INTO contact (id) VALUES (2);
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 2, '2016-01-01', 'app2_1');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 2, '2016-01-02', 'app2_2');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 2, '2016-01-03', 'app2_3');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 2, '2016-01-04', 'app2_4');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 2, '2016-01-05', 'app2_5');

INSERT INTO contact (id) VALUES (3);
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 3, '2017-01-01', 'app3_1');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 3, '2017-01-02', 'app3_2');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 3, '2017-01-03', 'app3_3');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 3, '2017-01-04', 'app3_4');
INSERT INTO application (id, contact_id, dt_created, product_name) VALUES (NULL, 3, '2017-01-05', 'app3_5');