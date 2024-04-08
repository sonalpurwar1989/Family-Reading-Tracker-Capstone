

-----------------------------
-- DEFAULT SCHEMA FOR BASE --
-----------------------------

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-----------------------------

CREATE TABLE IF NOT EXISTS books(
book_id SERIAL PRIMARY KEY,
title VARCHAR(50) NOT NULL,
author VARCHAR(50),
isbn VARCHAR(20) UNIQUE
);

CREATE TABLE families(
familiy_id SERIAL PRIMARY KEY,
family_name VARCHAR(30) UNIQUE NOT NULL
);




CREATE TABLE reading_sessions(
session_id SERIAL PRIMARY KEY,
user_id INTEGER NOT NULL,
book_id INTEGER NOT NULL,
reading_format VARCHAR(50),
duration_minutes INTEGER NOT NULL,
notes TEXT,
session_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES users(user_id),
FOREIGN KEY (book_id) REFERENCES books(book_id)
);

CREATE TABLE reading_milestones(
milestone_id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
description TEXT,
minutes_required INTEGER NOT NULL,
max_prizes INTEGER,
start_date DATE,
end_date DATE
);

CREATE TABLE prizes(
prize_id SERIAL PRIMARY KEY,
milestone_id INTEGER NOT NULL,
name VARCHAR(255) NOT NULL,
description TEXT,
FOREIGN KEY (milestone_id) REFERENCES reading_milestones(milestone_id)
);

