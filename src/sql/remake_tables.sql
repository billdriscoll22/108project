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

delete from users;
delete from friends;
delete from requests;
delete from challenges;
delete from notes;
delete from announcements;
delete from results;
delete from achievements;
delete from question_response;
delete from picture;
delete from fill_in_the_blank;
delete from multiple_choice;
delete from answers;
delete from quizzes;
