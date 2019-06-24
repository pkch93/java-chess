DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS turn;
DROP TABLE IF EXISTS result;

CREATE TABLE board (
	position VARCHAR(2) NOT NULL,
	name VARCHAR(1) NOT NULL,
    team VARCHAR(5) NOT NULL,
    primary key (position)
);

CREATE TABLE turn (
	id INTEGER NOT NULL,
	team VARCHAR(5) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE result (
	name VARCHAR(1) NOT NULL,
    team VARCHAR(5) NOT NULL,
    count INTEGER DEFAULT 0,
    PRIMARY KEY (name, team)
);