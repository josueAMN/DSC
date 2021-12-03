CREATE SEQUENCE discipline_sequence
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 999
    MINVALUE 1
    NO CYCLE;

CREATE TABLE discipline (
    id int8 NOT NULL DEFAULT nextval('discipline_sequence'),
    name varchar(400) NOT NULL,
    likes int8,
    note double(30)
)