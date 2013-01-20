CREATE TABLE person
(
  name  character varying(255),
  work  character varying(255),
  CONSTRAINT person_pkey PRIMARY KEY (name )
)

INSERT INTO person(name, work)
VALUES ('munni','housewife')

select * from person