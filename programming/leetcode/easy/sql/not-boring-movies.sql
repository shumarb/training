-- Question: https://leetcode.com/problems/not-boring-movies/
SELECT *
FROM Cinema c
WHERE (c.id % 2 != 0)
AND c.description != "boring"
ORDER BY c.rating DESC;
