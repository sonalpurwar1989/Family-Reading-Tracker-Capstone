

-----------------------------
-- DEFAULT SCHEMA FOR BASE --
-----------------------------

CREATE TABLE family (
    family_id SERIAL PRIMARY KEY,
    family_name VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL,
    family_id INTEGER,
    FOREIGN KEY (family_id) REFERENCES family(family_id)
);

CREATE TABLE book (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(50),
    isbn VARCHAR(20) UNIQUE
);

CREATE TABLE reading_sessions (
    session_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    reading_format VARCHAR(50),
    duration_minutes INTEGER NOT NULL,
    notes TEXT,
    session_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (book_id) REFERENCES book(book_id)
);
CREATE TABLE reading_milestones (
    milestone_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    minutes_required INTEGER NOT NULL,
    max_prizes INTEGER,
    start_date DATE,
    end_date DATE
);
CREATE TABLE prizes (
    prize_id SERIAL PRIMARY KEY,
    milestone_id INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    FOREIGN KEY (milestone_id) REFERENCES reading_milestones(milestone_id)
);
CREATE TABLE progress (
    progress_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    milestone_id INTEGER NOT NULL,
    minutes_read INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (milestone_id) REFERENCES reading_milestones(milestone_id)
);
CREATE TABLE users_book(
user_id INTEGER,
book_id INTEGER,
FOREIGN KEY (user_id) REFERENCES users(user_id),
FOREIGN KEY (book_id) REFERENCES book(book_id),
PRIMARY KEY (user_id, book_id)
);







