CREATE TABLE IF NOT EXISTS us_states (
    state_id serial PRIMARY KEY,
    name varchar(2) NOT NULL, 
    full_name varchar(20) NOT NULL);
