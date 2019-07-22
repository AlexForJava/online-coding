create table users
(
	id SERIAL,
	login varchar(255) null,
	name varchar(255) null,
	age int null,
	role varchar(20) null,
	constraint user_pk
		primary key (id)
);

create table course
(
	id SERIAL PRIMARY KEY,
	created_date BIGINT not null,
	name VARCHAR(255) null,
	cost INT null
);

create TABLE lesson
(
    id SERIAL PRIMARY KEY,
	created_date BIGINT not null,
	name VARCHAR (255) null,
	content VARCHAR (255) null,
	section_id BIGINT null
);


create TABLE comment
(
    id SERIAL PRIMARY KEY,
	created_date BIGINT not null,
	content VARCHAR (255),
	author_id BIGINT null,
	lesson_id BIGINT null
);

create table section
(
    id SERIAL PRIMARY KEY,
	created_date BIGINT not null,
	name VARCHAR(255) null,
	course_id BIGINT null
);


ALTER TABLE section
ADD CONSTRAINT fk_section_id FOREIGN KEY (course_id) REFERENCES course (id);

ALTER TABLE comment
add CONSTRAINT fk_comment_id FOREIGN KEY (lesson_id) REFERENCES lesson (id);

ALTER TABLE lesson
add CONSTRAINT fk_lesson_id FOREIGN KEY (section_id) REFERENCES section (id);