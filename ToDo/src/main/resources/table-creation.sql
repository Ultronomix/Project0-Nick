DROP TABLE tasks.user_task;

CREATE TABLE tasks.user_task (
	id serial PRIMARY KEY NOT NULL ,
	name varchar NOT NULL,
	task varchar NOT null
);

SELECT *
FROM tasks.user_task ut;