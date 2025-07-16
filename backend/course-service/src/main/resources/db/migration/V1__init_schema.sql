-- V1__init_course_schema.sql

CREATE TABLE courses (
    course_id SERIAL PRIMARY KEY,
    course_title VARCHAR(255) NOT NULL,
    course_image_src VARCHAR(512)
);

CREATE TABLE units (
    unit_id SERIAL PRIMARY KEY,
    unit_title VARCHAR(255) NOT NULL,
    unit_description TEXT,
    unit_order INTEGER,
    course_id INTEGER NOT NULL,
    CONSTRAINT fk_unit_course FOREIGN KEY (course_id) REFERENCES courses (course_id) ON DELETE CASCADE
);

CREATE TABLE lessons (
    lesson_id SERIAL PRIMARY KEY,
    lesson_title VARCHAR(255) NOT NULL,
    lesson_order INTEGER,
    unit_id INTEGER NOT NULL,
    CONSTRAINT fk_lesson_unit FOREIGN KEY (unit_id) REFERENCES units (unit_id) ON DELETE CASCADE
);

CREATE INDEX idx_course_title ON courses(course_title);
CREATE INDEX idx_unit_course_id ON units(course_id);
CREATE INDEX idx_lesson_unit_id ON lessons(unit_id);