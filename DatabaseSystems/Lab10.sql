----------------------------------------------------------------------------------------
-- Lab 10: Stored Procedure 
-- by Mutiat Alabala
-- Modified Version of
-- Courses and Prerequisites
-- by Alan G. Labouseur
-- Tested on Postgres 9.3.2
----------------------------------------------------------------------------------------

--
-- The table of courses.
--
CREATE TABLE Courses (
    num      INTEGER NOT NULL,
    name     TEXT    NOT NULL,
    credits  INTEGER NOT NULL,
  PRIMARY KEY (num)
);


INSERT INTO Courses(num, name, credits)
VALUES (499, 'CS/ITS Capping', 3 );

INSERT INTO Courses(num, name, credits)
VALUES (308, 'Database Systems', 4 );

INSERT INTO Courses(num, name, credits)
VALUES (221, 'Software Development Two', 4 );

INSERT INTO Courses(num, name, credits)
VALUES (220, 'Software Development One', 4 );

INSERT INTO Courses(num, name, credits)
VALUES (120, 'Introduction to Programming', 4);

SELECT * 
FROM courses
ORDER BY num ASC;


--
-- Courses and their prerequisites
--
CREATE TABLE Prerequisites (
    courseNum INTEGER NOT NULL REFERENCES Courses(num),
    preReqNum INTEGER NOT NULL REFERENCES Courses(num),
  PRIMARY KEY (courseNum, preReqNum)
);

INSERT INTO Prerequisites(courseNum, preReqNum)
VALUES (499, 308);

INSERT INTO Prerequisites(courseNum, preReqNum)
VALUES (499, 221);

INSERT INTO Prerequisites(courseNum, preReqNum)
VALUES (308, 120);

INSERT INTO Prerequisites(courseNum, preReqNum)
VALUES (221, 220);

INSERT INTO Prerequisites(courseNum, preReqNum)
VALUES (220, 120);

SELECT *
FROM Prerequisites
ORDER BY courseNum DESC;


--
-- An example stored procedure ("FUNCTION")
--
CREATE OR REPLACE FUNCTION get_courses_by_credits(INT, REFCURSOR) RETURNS refcursor AS 
$$
DECLARE
   num_credits INT	 := $1;
   resultset   REFCURSOR := $2;
BEGIN
   open resultset FOR 
      SELECT num, name, credits
      FROM   courses
       WHERE  credits >= num_credits;
   RETURN resultset;
END;
$$ 
LANGUAGE plpgsql;

-- 
-- Stored procedure PreReqFor(courseNum)
-- Returns the immediate prerequisites 
-- for the passed-in course number
--

CREATE OR REPLACE FUNCTION PreReqFor(INT, REFCURSOR) RETURNS refcursor AS 
$$
DECLARE
   ThisCourse  INT	 := $1;
   resultset   REFCURSOR := $2;
BEGIN
   open resultset FOR 
      SELECT courseNum, preReqNum
      FROM   Prerequisites
       WHERE  courseNum= ThisCourse;
   RETURN resultset;
END;
$$ 
LANGUAGE plpgsql;

-- 
-- Stored procedure isPreReqFor(courseNum)
-- Returns the courses for which the 
-- passed-in course number is an immediate
-- pre-requisite
--

CREATE OR REPLACE FUNCTION isPreReqFor(INT, REFCURSOR) RETURNS refcursor AS 
$$
DECLARE
   ThisCourse  INT	 := $1;
   resultset   REFCURSOR := $2;
BEGIN
   open resultset FOR 
      SELECT courseNum, preReqNum
      FROM   Prerequisites
       WHERE  preReqNum = ThisCourse;
   RETURN resultset;
END;
$$ 
LANGUAGE plpgsql;

SELECT get_courses_by_credits(0, 'results');
FETCH ALL FROM results;

SELECT*
FROM prerequisites

SELECT PreReqFor(499, 'results');
FETCH ALL FROM results;

SELECT isPreReqFor(120, 'results');
FETCH ALL FROM results;