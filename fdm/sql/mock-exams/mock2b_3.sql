/* Mock 2b */

-- Write a query which shows trainer_ids of trainers who teach 4 or more courses (4 rows)
SELECT trainer_id
FROM trainers_courses
GROUP BY trainer_id
HAVING count(course_id) >= 4;

/*
Answer
-- Write a query which shows trainer_ids of trainers who teach 4
-- or more courses
select trainer_id
from trainers_courses
group by trainer_id
having count(course_id) >=4;
*/



-- Write a query which shows the trainee_ids of any trainee who has
-- taken 3 or more exams in the last 7 days (2 rows)
-- incorrect
SELECT trainee_id
FROM exam_results
WHERE exam_date > DATE_ADD(NOW(), INTERVAL -7 DAY)
GROUP BY trainee_id
HAVING COUNT(exam_date) >= 3;

/*
Answer
-- Write a query which shows the trainee_ids of any trainee who has
-- taken 3 or more exams in the last 7 days
select trainee_id
from exam_results
where exam_date > date_add(curdate(), interval -7 day)
group by trainee_id
having count(score) >=3;
*/



/* Mock exam 3 */

-- Write a query which shows the trainee_id of the trainee with the lowest
-- score in the exam_results table. (1 row) – use a simple subquery
SELECT trainee_id
FROM exam_results
WHERE score IN (
	SELECT MIN(score)
    FROM exam_results
);

/*
Answer
-- Write a query which shows the trainee_id of the trainee with the lowest
-- score in the exam_results table. (1 row) – use a simple subquery
SELECT trainee_id
FROM   exam_results
WHERE  score = (
	SELECT MIN(score)
	FROM   exam_results);
*/


-- Write a query showing the name of the trainee who has been in the academy
-- the longest. (1 row) - use a simple subquery
SELECT trainee_id, start_date
FROM trainees
WHERE start_date = (
	SELECT MIN(start_date)
    FROM trainees
);

/*
Answer
-- Write a query showing the name of the trainee who has been in the academy
-- the longest. (1 row) - use a simple subquery
SELECT name
FROM   trainees
WHERE  start_date = (
	SELECT MIN(start_date)
	FROM   trainees);
*/


-- Write a query which lists the longest serving trainer in each academy.
-- There should be 3 columns – academy_id, trainer name and start date.
-- (3 rows) – use a correlated subquery
SELECT t.academy_id, t.name, t.start_date
FROM trainers t
INNER JOIN academies a
ON t.academy_id = a.academy_id
WHERE t.start_date = (
	SELECT MIN(start_date)
	FROM trainers
);

/*
Answer
SELECT t.academy_id,
       t.name,
       t.start_date
FROM   trainers t
WHERE  t.start_date =(
	SELECT MIN(t2.start_date)
	FROM   trainers t2
	WHERE  t2.academy_id = t.academy_id);
*/


-- Write a query which shows the highest number of exams taken by a single
-- trainee. (1 row) – use an inline view
SELECT trainee_id
FROM exam_results
GROUP BY trainee_id
ORDER BY COUNT(trainee_id) DESC
LIMIT 1;

select *
from exam_results
where exam_date;

/*
Answer
SELECT MAX(er.exams)
FROM (      
	SELECT COUNT(*) AS exams
	FROM   exam_results
	GROUP BY trainee_id) er;
*/

