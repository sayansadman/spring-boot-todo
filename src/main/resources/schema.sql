CREATE TABLE IF todos (
    id SERIAL PRIMARY KEY,
    starred BOOLEAN,
    completed BOOLEAN,
    description TEXT,
    title TEXT
);