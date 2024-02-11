-- MOCK exam 1 (M5-6) [1 hour]

-- Write a query which shows the names of any trainees in the academy with academy_id 3 (10 rows)
SELECT name
FROM trainees
WHERE academy_id = 3;

/*
-- Correct answer:
SELECT name
FROM trainees
WHERE academy_id = 3;
*/



-- Write a query showing the trainee_ids of anyone scoring 100% in course_id 2 (3 rows)
SELECT trainee_id
FROM exam_results
WHERE course_id = 2
AND score = 100;

/*
-- Correct Answer:
SELECT trainee_id
FROM exam_results
WHERE course_id = 2
AND score = 100;  
*/



-- Write a query which shows the names of any trainees with start dates in the last 7 days (4 rows)
SELECT name
FROM trainees
WHERE start_date > DATE_ADD(NOW(), INTERVAL -7 DAY);

/*
-- Correct Answer:
SELECT name
FROM trainees
WHERE start_date > date_add(curdate(), INTERVAL -7 day);
*/

-- Write a query which shows the name of EVERY trainee and the name of their stream (60 rows)
SELECT t.name, s.name
FROM trainees t
INNER JOIN streams s
ON t.stream_id = s.stream_id;

/*
-- Correct Answer
SELECT t.name AS "trainee", s.name AS "stream"
FROM trainees t
LEFT OUTER JOIN streams s
ON t.stream_id = s.stream_id;
*/

-- Write a query which shows the names of each trainer and the names of any courses they teach (44 rows)

SELECT t.name, c.name
FROM trainers_courses tc
INNER JOIN trainers t
ON tc.trainer_id = t.trainer_id
INNER JOIN courses c
ON c.course_id = tc.course_id;

/*
-- Correct Answer
SELECT t.name AS trainer, c.name AS course
FROM trainers t
INNER JOIN trainers_courses tc
ON t.trainer_id = tc.trainer_id
INNER JOIN courses c
ON c.course_id = tc.course_id;
*/