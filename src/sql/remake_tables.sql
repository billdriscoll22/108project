drop table quizzes;

create table quizzes(
	quiz_id char(64),
	date_created char(64),
	creator_id char(64),
	num_questions int,
	is_random boolean,
	is_one_page boolean,
	is_immediate boolean,
	times_taken int
);