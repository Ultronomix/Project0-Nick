DROP TABLE tasks;

CREATE TABLE tasks (
	name varchar PRIMARY KEY NOT NULL,
	task varchar NOT null
);

INSERT INTO tasks(name, task)
VALUES ('nick', 'test project');

SELECT *
FROM tasks;