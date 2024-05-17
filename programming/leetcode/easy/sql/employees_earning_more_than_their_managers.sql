SELECT employees.name AS 'Employee'
FROM Employee employees
WHERE employees.salary > (
    SELECT managers.salary
    FROM Employee managers
    WHERE employees.managerID = managers.id
);
