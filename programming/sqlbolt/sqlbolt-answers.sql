-- SQL Lesson 1: SELECT queries 101 
-- (Link: https://sqlbolt.com/lesson/select_queries_introduction)
-- Exercise 1 Tasks
-- Q1: Find the title of each film
SELECT Title
FROM Movies;

-- Q2: Find the director of each film
SELECT Director
FROM Movies;

-- Q3: Find the title and director of each film
SELECT Title, Director
FROM Movies;

-- Q4: Find the title and year of each film
SELECT Title, Year
FROM Movies;

-- Q5: Find all the information about the film
SELECT *
FROM Movies;



-- SQL Lesson 2: Queries with constraints (Pt. 1)  (Link: https://sqlbolt.com/lesson/select_queries_with_constraints)
-- Exercise 2 - Tasks
-- Q1: Find the movie with the row id of 6
SELECT * FROM movies
WHERE Id = 6;

-- Q2: Find the movies released in the years between 2000 and 2010
SELECT *
FROM Movies
WHERE Year >= 2000 AND Year <= 2010;

-- Q3: Find the movies not released in the years between 2000 and 2010
SELECT *
FROM Movies
WHERE NOT (Year >= 2000 AND YEAR <= 2010);

-- Q4: Find the first 5 Pixar movies and their release year
SELECT Title, Year
FROM Movies
LIMIT 5;




-- SQL Lesson 3: Queries with constraints (Pt. 2) (Link: https://sqlbolt.com/lesson/select_queries_with_constraints_pt_2)
-- Exercise 3 Tasks
-- Q1: Find all the Toy Story movies
SELECT * FROM movies
WHERE Title LIKE "Toy Story%";

-- Q2: Find all the movies directed by John Lasseter
SELECT * FROM movies
WHERE Director = "John Lasseter";

-- Q3: Find all the movies (and director) not directed by John Lasseter
SELECT *
FROM Movies
WHERE Director != "John Lasseter";

-- Q4: Find all the WALL-* movies
SELECT *
FROM Movies
WHERE Title LIKE "WALL-%";




-- SQL Lesson 4: Filtering and sorting Query results (Link: https://sqlbolt.com/lesson/filtering_sorting_query_results)
-- xercise 4 Tasks

-- Q1: List all directors of Pixar movies (alphabetically), without duplicates
SELECT Distinct Director
FROM Movies
ORDER BY Director;

-- Q2: List the last four Pixar movies released (ordered from most recent to least)
SELECT *
FROM Movies
ORDER BY Year DESC
LIMIT 4;

-- Q3: List the first five Pixar movies sorted alphabetically
SELECT *
FROM Movies
ORDER BY Title ASC
LIMIT 5;

-- Q4: List the next five Pixar movies sorted alphabetically
SELECT *
FROM Movies
ORDER BY Title ASC
LIMIT 5 OFFSET 5;




-- SQL Review: Simple SELECT Queries (Link: https://sqlbolt.com/lesson/select_queries_review)
-- Exercise Tasks
-- Q1: List all the Canadian cities and their populations
SELECT City, Population
FROM North_american_cities
WHERE Country = "Canada";

-- Q2: Order all the cities in the United States by their latitude from north to south
SELECT City, Latitude
FROM North_american_cities
WHERE Country = "United States"
ORDER BY Latitude DESC;

-- Q3: List all the cities west of Chicago, ordered from west to east 
SELECT City, Longitude
FROM North_american_cities
WHERE Longitude < 
(
    SELECT Longitude
    FROM North_american_cities
    WHERE City = "Chicago"
)
ORDER BY Longitude ASC;

-- Q4: List the two largest cities in Mexico (by population)
SELECT City, Population, Country
FROM North_american_cities
WHERE Country = "Mexico"
ORDER BY Population DESC
LIMIT 2;

-- Q5: List the third and fourth largest cities (by population) in the United States and their population 
SELECT City, Population, Country
FROM North_american_cities
WHERE Country = "United States"
ORDER BY Population DESC
LIMIT 2 OFFSET 2;



-- SQL Lesson 6: Multi-table queries with JOINs (Link: https://sqlbolt.com/lesson/select_queries_with_joins)
-- Exercise 6 Tasks
-- Q1: Find the domestic and international sales for each movie 
SELECT Title, Domestic_sales, International_sales
FROM Movies
INNER JOIN Boxoffice
ON Movies.Id = Boxoffice.Movie_Id;

-- Q2: Show the sales numbers for each movie that did better internationally rather than domestically 
SELECT Title, Domestic_sales, International_sales
FROM Movies
INNER JOIN Boxoffice
ON Movies.Id = Boxoffice.Movie_Id
WHERE International_sales > Domestic_sales;

-- Q3: List all the movies by their ratings in descending order 
SELECT Title, Rating
FROM Movies
INNER JOIN Boxoffice
ON Movies.Id = Boxoffice.Movie_Id
ORDER BY Rating DESC;



-- SQL Lesson 7: Outer JOINs (Link: https://sqlbolt.com/lesson/select_queries_with_outer_joins)
-- Exercise 7 Tasks
-- Q1: Find the list of all buildings that have employees
SELECT Distinct Building
FROM Employees;

-- Q2: Find the list of all buildings and their capacity
SELECT *
FROM Buildings;

-- Q3: List all buildings and the distinct employee roles in each building (including empty buildings) 
SELECT Distinct Building_name, Role
FROM Buildings
LEFT OUTER JOIN Employees
ON Buildings.Building_name = Employees.Building;



-- SQL Lesson 8: A short note on NULLs (Link: https://sqlbolt.com/lesson/select_queries_with_nulls)
-- Exercise 8 - Tasks
-- Q1: Find the name and role of all employees who have not been assigned to a building 
SELECT Name, Role
FROM Employees
WHERE Building IS NULL;


-- Q2: Find the names of the buildings that hold no employees
SELECT Building_name, Name
FROM Buildings
LEFT OUTER JOIN Employees
ON Buildings.Building_name = Employees.Building
WHERE NAME IS NULL;



-- SQL Lesson 9: Queries with expressions (Link: https://sqlbolt.com/lesson/select_queries_with_expressions)
-- Exercise 9 - Tasks
-- Q1: List all movies and their combined sales in millions of dollars
SELECT Title, ((Domestic_sales + International_sales) / 1000000) AS combined_sales
FROM Boxoffice
INNER JOIN Movies
ON Boxoffice.Movie_id = Movies.Id;

-- Q2: List all movies and their ratings in percent
SELECT Title, (Rating * 10.0) AS rating_percent
FROM Movies
INNER JOIN Boxoffice
ON Movies.Id = Boxoffice.Movie_id;

-- Q3: List all movies that were released on even number years 
SELECT *
FROM Movies
INNER JOIN Boxoffice
ON Movies.Id = Boxoffice.Movie_id
WHERE ((Year % 2) == 0);



-- SQL Lesson 10: Queries with aggregates (Pt. 1) (Link: https://sqlbolt.com/lesson/select_queries_with_aggregates)
--  Exercise 10 - Tasks
--  Q1: Find the longest time that an employee has been at the studio 
SELECT Name, MAX(Years_employed)
FROM Employees;

--  Q2: For each role, find the average number of years employed by employees in that role 
SELECT ROLE, AVG(Years_employed) AS average_years_employed
FROM Employees
GROUP BY Role;

--  Q3: Find the total number of employee years worked in each building 
SELECT Building, SUM(Years_employed) AS sum_years_employed
FROM Employees
GROUP BY Building;



--  SQL Lesson 11: Queries with aggregates (Pt. 2) (Link: https://sqlbolt.com/lesson/select_queries_with_aggregates_pt_2)
--  Exercise 11 - Tasks
--  Q1: Find the number of Artists in the studio (without a HAVING clause) 
SELECT Role, COUNT(*) AS total
FROM Employees
WHERE Role = "Artist";

--  Q2: Find the number of Employees of each role in the studio 
SELECT Role, COUNT(*) AS total
FROM Employees
GROUP BY Role;

--  Q3: Find the total number of years employed by all Engineers 
SELECT Role, SUM(Years_employed) AS total_years_employed
FROM Employees
WHERE Role = "Engineer";



-- SQL Lesson 11: Queries with aggregates (Pt. 2) (Link: https://sqlbolt.com/lesson/select_queries_with_aggregates_pt_2)
-- Exercise 11 - Tasks
-- Q1: Find the number of Artists in the studio (without a HAVING clause) 
SELECT Role, COUNT(*) AS total
FROM Employees
WHERE Role = "Artist";

-- Q2: Find the number of Employees of each role in the studio 
SELECT Role, COUNT(*) AS total
FROM Employees
GROUP BY Role;

-- Q3: Find the total number of years employed by all Engineers 
SELECT Role, SUM(Years_employed) AS total_years_employed
FROM Employees
WHERE Role = "Engineer";



-- SQL Lesson 12: Order of execution of a Query (Link: https://sqlbolt.com/lesson/select_queries_with_aggregates_pt_2)
-- Exercise 12 - Tasks
-- Q1: Find the number of movies each director has directed 
SELECT Director, COUNT(*) AS total_number_of_movies_directed
FROM Movies
GROUP BY Director;

-- Q2: Find the total domestic and international sales that can be attributed to each director 
SELECT Director, SUM(Domestic_sales + International_sales) AS total_sales
FROM Movies
INNER JOIN Boxoffice
ON Movies.Id = Boxoffice.Movie_Id
GROUP BY DIRECTOR;



-- SQL Lesson 13: Inserting Rows (Link: https://sqlbolt.com/lesson/inserting_rows)
-- Exercise 13 - Tasks
-- Q1: Add the studio's new production, Toy Story 4 to the list of movies (you can use any director) ✓
INSERT INTO Movies VALUES
(6, "Toy Story 4", "John Lasseter", 2016, 102);

-- Q2: Toy Story 4 has been released to critical acclaim! It had a rating of 8.7, and made 340 million domestically and 270 million internationally. Add the record to the BoxOffice table. 
INSERT INTO Boxoffice VALUES
(6, 8.7, 340000000, 270000000);



-- SQL Lesson 14: Updating rows (Link: https://sqlbolt.com/lesson/updating_rows)
-- Exercise 14 - Tasks
-- Q1: The director for A Bug's Life is incorrect, it was actually directed by John Lasseter 
UPDATE Movies
SET Director = "John Lasseter"
WHERE Title = "A Bug's Life";

-- Q2: The year that Toy Story 2 was released is incorrect, it was actually released in 1999 
UPDATE Movies
SET Year = 1999
WHERE Title = "Toy Story 2";

-- Q3: Both the title and director for Toy Story 8 is incorrect! The title should be "Toy Story 3" and it was — directed by Lee Unkrich 
UPDATE Movies
SET Title = "Toy Story 3",
    	Director = "Lee Unkrich"
WHERE Title = "Toy Story 8";



-- SQL Lesson 15: Deleting rows (Link: https://sqlbolt.com/lesson/deleting_rows)
-- Exercise 15 - Tasks
-- Q1: This database is getting too big, lets remove all movies that were released before 2005.
DELETE FROM Movies
WHERE Year < 2005;

-- Q2: Andrew Stanton has also left the studio, so please remove all movies directed by him. 
DELETE FROM Movies
WHERE Director = "Andrew Stanton";



-- SQL Lesson 15: Deleting rows (Link: https://sqlbolt.com/lesson/deleting_rows)
-- Exercise 15 - Tasks
-- Q1: This database is getting too big, lets remove all movies that were released before 2005.
DELETE FROM Movies
WHERE Year < 2005;

-- Q2: Andrew Stanton has also left the studio, so please remove all movies directed by him. 
DELETE FROM Movies
WHERE Director = "Andrew Stanton";



-- SQL Lesson 16: Creating tables (Link: https://sqlbolt.com/lesson/creating_tables)
-- Exercise 16 Tasks
-- Q1: Create a new table named Database with the following columns:
-- Name A string (text) describing the name of the database– Version A number (floating point) of the latest version of this database– Download_count An integer count of the number of times this database was downloaded
-- This table has no constraints.
CREATE TABLE Database (
    Name TEXT,
    Version FLOAT,
    Download_count INTEGER
);



-- SQL Lesson 17: Altering tables (Link: https://sqlbolt.com/lesson/altering_tables)
-- Q1: Add a column named Aspect_ratio with a FLOAT data type to store the aspect-ratio each movie was released in. 
ALTER TABLE Movies
ADD COLUMN Aspect_ratio FLOAT;

-- Q2: Add another column named Language with a TEXT data type to store the language that the movie was released in. Ensure — that the default for this language is English. 
ALTER TABLE Movies
ADD COLUMN Language TEXT DEFAULT English;




-- SQL Lesson 18: Dropping tables (Link: https://sqlbolt.com/lesson/dropping_tables)
-- Q1: We've sadly reached the end of our lessons, lets clean up by removing the Movies table
DROP TABLE IF EXISTS Movies;

-- Q2: And drop the BoxOffice table as well 
DROP TABLE IF EXISTS BoxOffice;
