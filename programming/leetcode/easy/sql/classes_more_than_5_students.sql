-- Link: https://leetcode.com/problems/classes-more-than-5-students/description/
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(class) >= 5;

