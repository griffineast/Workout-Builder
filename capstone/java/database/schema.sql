BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE exercise (
	exercise_id SERIAL,
	exercise_name varchar(50) NOT NULL UNIQUE,
	exercise_description varchar(1000) NOT NULL,
	suggested_weight int,
	num_of_reps int,
	duration int,
	target_area varchar (50),
	
	CONSTRAINT PK_exercise PRIMARY KEY (exercise_id)
);

COMMIT TRANSACTION;
