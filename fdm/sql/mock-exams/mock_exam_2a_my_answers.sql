-- Mock Exam - 2a

-- Write a query which shows the shortest stream duration (1 row)
SELECT min(duration_weeks) AS "Shortest stream duration"
FROM streams;

/*
-- Correct Answer
SELECT min(duration_weeks) 
FROM streams; 
*/


-- Write a query showing the longest and shortest stream durations.
-- The results should be displayed in a single column (2 rows)
SELECT min(duration_weeks) AS "Shortest and longest stream duration"
FROM streams
UNION
SELECT max(duration_weeks) AS "Shortest and longest stream duration"
FROM streams;

/*
-- Correct Answer
select min(duration_weeks) as longest_and_shortest  
from streams 
union
select max(duration_weeks)
from streams;
select duration_weeks
from streams
where duration_weeks = ( 
select min(duration_weeks) 
from streams) 
or duration_weeks = ( 
select max(duration_weeks) 
from streams); 
*/



-- Write a query which shows the average score for each course_id;
-- use the exam_results table. Round the averages to zero
-- decimal places and order by the average score (13 rows)
SELECT course_id, ROUND(AVG(score), 0) AS "Average score"
FROM exam_results
GROUP BY course_id
ORDER BY AVG(score);

/*
-- Correct Answer
select course_id, round(avg(score),0) as average_score 
from exam_results 
group by course_id 
order by avg(score); 
*/
