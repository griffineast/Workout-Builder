BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Bench Press', 'Lying down on a flat bench, press the barbell up and down at chest height. It works the pectoral muscles, shoulders, and arms.
', 160, 10, 5, 'Chest');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Pull-Up', 'Hang from a pull-up bar by your hands with your palms facing away from you, and lifting your entire body up with your arm and back muscles.
', 150, 8, 5, 'Biceps');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Squat', 'A compound, multi-joint exercise designed to target many muscles of the lower body.
', 200, 10, 10, 'Legs');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Push-Up', 'In a prone position, with the hands down under the shoulders, the balls of the feet on the ground, and the back straight.
', 150, 20, 10, 'Shoulders');


COMMIT TRANSACTION;
