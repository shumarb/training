-- SECTION 2: SQL SELECT FUNDAMENTALS
-- Challenge: SELECT
-- Q1: Grab the first and last names of every customer and their email address
	SELECT first_name, last_name, email
	FROM customer;
 
-- Challenge: SELECT DISTINCT
-- Q1: Retrieve the distinct rating types our films could have in our database
	SELECT DISTINCT rating
	FROM film;

-- Challenge: SELECT WHERE
-- Q1: A customer forgot their wallet at our store. We need to track down their email to inform them. What is the email for the customer with the name Nancy Thomas?
	SELECT email
	FROM customer
	WHERE first_name = 'Nancy'
	AND last_name = 'Thomas';

-- Q2: A customer wants to know what the movie ‘Outlaw Hanky’ is about. Could you give them the description for the movie ‘Outlaw Hanky’?
	SELECT description
	FROM film
	WHERE title = 'Outlaw Hanky';

-- Q3: A customer is late on their movie return and we’ve mailed them a letter to their address at ‘259 Ipoh Drive’. We should also call them on the phone to let them know. Can you get the phone number for the customer who lives at ‘259 Ipoh Drive’?
	SELECT phone
	FROM address
	WHERE address = '259 Ipoh Drive';

-- Challenge: ORDER BY
-- Q1: We want to reward our first 10 paying customers. What are the customer ids of the first 10 customers who created a payment?
	SELECT customer_id
	FROM payment
	ORDER BY payment_date ASC
	LIMIT 10;

-- Q2: A customer wants to quickly rent a video to watch over their short lunch break. What are the titles of the 5 shortest (in length of runtime) movies?
	SELECT title, length
	FROM film
	ORDER BY length ASC
	LIMIT 5;

-- Q3: If the previous customer can watch any movie that is 50 minutes or less in run time, how many options does she have?
	SELECT COUNT(length)
	FROM film
	WHERE length <= 50;

-- General Challenge 1
-- Q1: How many payment transactions were greater than $5.00?
	SELECT COUNT(amount)
	FROM payment
	WHERE amount > 5;

-- Q2: How many actors have a first name that starts with the letter P?
	SELECT COUNT(first_name)
	FROM actor
	WHERE first_name ILIKE 'P%';

-- Q3: How many unique districts are our customers from?
	SELECT COUNT(DISTINCT(district))
	FROM address;

--Q4: Retrieve the list of names for those distinct districts from the previous question
	SELECT DISTINCT(district)
	FROM address;

-- Q5: How many films have a rating of R and a replacement cost between $5 and $15?
	SELECT COUNT(*)
	FROM film
	WHERE rating = 'R'
	AND replacement_cost BETWEEN 5 AND 15;

-- Q6: How many films have the word Truman somewhere in the title?
	SELECT COUNT(*)
	FROM film
	WHERE title LIKE '%Truman%';




-- SECTION 3: GROUP BY STATEMENTS
-- Challenge: GROUP BY
-- Q1: We have two staff members, with Staff IDs 1 and 2. We want to give a bonus to the staff member that handled the most payments (Most in terms of payments processed, not total dollar amount). How many payments did each staff member handle and who gets the bonus?
	SELECT staff_id, COUNT(*)
	FROM payment
	GROUP BY staff_id;

-- Challenge: HAVING
-- Q1: We are launching a platform service with our most loyal customers. We will assign a platinum status to customers that have had 40 or more transaction payments. What customer_ids are eligible for platinum status?
	SELECT customer_id, COUNT(customer_id)
	FROM payment
	GROUP BY customer_id
	HAVING COUNT(customer_id) >= 40;

-- Q2: What are the customer ids of customers who have spent more than $100 in payment transactions with out staff_id member 2?
	SELECT customer_id, SUM(amount)
	FROM payment
	WHERE staff_id = 2
	GROUP BY customer_id
	HAVING SUM(amount) > 100;




-- SECTION 4: Assessment Test 1
-- Q1: Return the customer IDs of customers who have spent at least $110 with the staff member who has an ID of 2.
	SELECT customer_id, SUM(amount)
	FROM payment
	WHERE staff_id = 2
	GROUP BY customer_id, staff_id
	HAVING SUM(amount) >= 110;

-- Q2: How many films begin with the letter J?
	SELECT COUNT(title)
	FROM film
	WHERE title LIKE 'J%';

-- Q3: What customer has the highest customer ID number whose name starts with an 'E' and has an address ID lower than 500?
	SELECT first_name, last_name
	FROM customer
	WHERE first_name LIKE 'E%' AND address_id < 500
	ORDER BY customer_id DESC
	LIMIT 1;




-- SECTION 5: JOINS
-- Challenge: JOIN
	-- Q1: California sales tax laws have changed and we need to alert our customers to this through email. What are the emails of the customers who live in California?
	SELECT district, email
	FROM customer
	INNER JOIN address
	ON customer.address_id = address.address_id
	WHERE district = 'California';

-- Q2: A customer walks in and is a huge fan of the actor “Nick Wahlberg” and wants to know which movies he is in. Get a list of all the movies “Nick Wahlberg” has been in.
	SELECT film.title, actor.first_name, actor.last_name
	FROM film
	INNER JOIN film_actor
	ON film.film_id = film_actor.film_id
	INNER JOIN actor
	ON actor.actor_id = film_actor.actor_id
	WHERE actor.first_name = 'Nick'
	AND actor.last_name = 'Wahlberg';




-- SECTION 6: Advanced SQL Commands
-- Challenge: Timestamps and Extract
	-- Q1: During which months did payments occur? Format your answer to return back the full month name
	SELECT DISTINCT(TO_CHAR(payment_date, 'MONTH'))
	FROM payment;
	-- Q2: How many payments occurred on a Monday?
	SELECT COUNT(*)
	FROM payment
	WHERE EXTRACT(dow FROM payment_date) = 1;




-- SECTION 7: Assessment Test 2
-- Q1: How can you retrieve all the information from the cd.facilities table?
	SELECT *
	FROM cd.facilities;

--Q2: You want to print out a list of all of the facilities and their cost to members. How would you retrieve a list of only facility names and costs?
	SELECT name, membercost
	FROM cd.facilities;

-- Q3: How can you produce a list of facilities that charge a fee to members?
	SELECT *
	FROM cd.facilities
	WHERE membercost > 0;

-- Q4: How can you produce a list of facilities that charge a fee to members, and that fee is less than 1/50th of the monthly maintenance cost? Return the facid, facility name, member cost, and monthly maintenance of the facilities in question.
	SELECT facid, name, membercost, monthlymaintenance
	FROM cd.facilities
	WHERE membercost > 0
	AND membercost < (monthlymaintenance / 50.0);

-- Q5: 	How can you produce a list of all facilities with the word 'Tennis' in their name?
	SELECT *
	FROM cd.facilities
	WHERE NAME LIKE '%Tennis%';

-- Q6: How can you retrieve the details of facilities with ID 1 and 5? Try to do it without using the OR operator.
	SELECT *
	FROM cd.facilities
	WHERE facid IN (1, 5);

-- Q7: How can you produce a list of members who joined after the start of September 2012? Return the memid, surname, firstname, and joindate of the members in question.
	SELECT memid, surname, firstname, joindate
	FROM cd.members
	WHERE EXTRACT(MONTH FROM joindate) >= 9;

-- (ToCheck) Q8: How can you produce an ordered list of the first 10 surnames in the members table? The list must not contain duplicates.
	SELECT DISTINCT(surname)
	FROM cd.members
	ORDER BY surname
	LIMIT 10;

-- Q9: You’d like to get the signup date of your last member. How can you retrieve this information?
	SELECT joindate
	FROM cd.members
	ORDER BY joindate DESC
	LIMIT 1;

-- Q10: Produce a count of the number of facilities that have a cost to guests of 10 or more
	SELECT COUNT(*)
	FROM cd.facilities
	WHERE guestcost >= 10;

-- Q11: Produce a list of the total number of slots booked per facility in the month of September 2012. Produce an output table consisting of facility id and slots, sorted by the number of slots.
	SELECT facid, SUM(slots) AS total_slots
	FROM cd.bookings
	WHERE EXTRACT(MONTH FROM starttime) = 9
	GROUP BY facid
	ORDER BY SUM(slots);

-- Q12: Produce a list of facilities with more than 1000 slots booked. Produce an output table consisting of facility id and total slots, sorted by facility id:
	SELECT facid, SUM(slots) AS total_slots
	FROM cd.bookings
	GROUP BY facid
	HAVING SUM(slots) > 1000
	ORDER BY SUM(facid);

-- Q13: How can you produce a list of the start times for bookings for tennis courts for the date ‘2012-09-21’? Return a list of start time and facility name pairings, ordered by time
	SELECT starttime, name
	FROM cd.bookings
	INNER JOIN cd.facilities
	ON cd.bookings.facid = cd.facilities.facid
	WHERE DATE(starttime) >= '2012-09-21'
	AND DATE(starttime) < '2012-09-22'
	AND name LIKE 'Tennis Court %'
	ORDER BY starttime;

-- Q14: How can you produce a list of the start times for bookings by members named 'David Farrell'?
	SELECT firstname, surname
	FROM cd.bookings
	INNER JOIN cd.members
	ON cd.bookings.memid = cd.members.memid
	WHERE firstname = 'David'
	AND surname = 'Farrell';




-- SECTION 9: Assessment 3
-- Q1: Create a new database called ‘School’. This database should have two tables: teachers and students. 
    -- The students table should have columns for student_id, first_name, last_name, homeroom_number, phone, email, and graduation_year.
    -- The teachers table should have columns for teacher_id, first_name, last_name, homeroom_number, department, email, and phone.
    -- The constraints are mostly up to you, but your table constraints do have to consider the following:
        -- We must have a phone number to contact students in case of an emergency.
        -- We must have ids as the primary key of the tables
        -- Phone numbers and emails must be unique to the individual

-- Q1a: Once you’ve made the tables, insert a student called Mark Watney (student_id = 1) who has a phone number of 777-555-1234 and does not have an email, He graduates in 2035 and has 5 as a homeroom number.
	CREATE TABLE students(
		student_id SERIAL PRIMARY KEY,
		first_name VARCHAR(50) NOT NULL,
		last_name VARCHAR(50) NOT NULL,
		homeroom_number SMALLINT,
		phone VARCHAR(50) UNIQUE NOT NULL,
		email VARCHAR(50) UNIQUE,
		graduation_year SMALLINT CHECK (graduation_year > 1950)
	);

	INSERT INTO TABLE students
	VALUES('Mark', 'Watney', 5, '777-555-1234', null, 2035);

-- Q1b: Then insert a teacher names Jonas Salk (teacher_id = 1) who as a homeroom number of 5 and is from the Biology department. His contact info is: jsalk@school.org and a phone number of 777-555-4321.
	CREATE TABLE teachers(
		teacher_id SERIAL PRIMARY KEY,
		first_name VARCHAR(50) NOT NULL,
		last_name VARCHAR(50) NOT NULL,
		homeroom_number smallint CHECK (homeroom_number > 0),
		department VARCHAR(50) NOT NULL,
		email VARCHAR(250) UNIQUE NOT NULL,
		phone VARCHAR(50) UNIQUE NOT NULL
	);
	
	INSERT INTO teachers(first_name, last_name, homeroom_number, department, email, phone)
	VALUES('Jonas', 'Salk', 5, 'Biology', 'jsalk@school.org', '777-666-4321');




-- SECTION 10: Conditional Expressions and Procedures
-- Challenge: CASE
-- Q1: We want to know and compare the various amounts of films we have per movie rating. Use CASE and the dvdrental database to recreate this table
	SELECT
	SUM
	(
		CASE
			WHEN rating = 'R' THEN 1
		END
	) AS r,
	SUM
	(
	CASE
		WHEN rating = 'PG' THEN 1
			ELSE 0
		END
	) AS pg,
	SUM
	(
		CASE
			WHEN rating = 'PG-13' THEN 1
			ELSE 0
		END
	) AS pg13
FROM film;
