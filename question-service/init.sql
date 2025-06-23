CREATE TABLE IF NOT EXISTS question (
  id SERIAL PRIMARY KEY,
  question_title VARCHAR(255),
  option1 VARCHAR(255),
  option2 VARCHAR(255),
  option3 VARCHAR(255),
  option4 VARCHAR(255),
  right_answer VARCHAR(255),
  difficultylevel VARCHAR(255),
  category VARCHAR(255)
);

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category) VALUES
-- Java
('What is JVM?', 'Java Virtual Method', 'Java Very Modern', 'Java Virtual Machine', 'Java Verified Mode', 'Java Virtual Machine', 'Easy', 'java'),
('Which keyword is used to inherit a class in Java?', 'this', 'super', 'extends', 'implements', 'extends', 'Easy', 'java'),
('Which data type is used to create a variable that should store text?', 'string', 'String', 'text', 'char[]', 'String', 'Easy', 'java'),
('What does the "static" keyword mean in Java?', 'Method can be called without object', 'Method is private', 'Method is abstract', 'Method is synchronized', 'Method can be called without object', 'Medium', 'java'),
('Which exception is thrown when dividing by zero?', 'NullPointerException', 'ArithmeticException', 'IllegalArgumentException', 'IndexOutOfBoundsException', 'ArithmeticException', 'Easy', 'java'),

-- DBMS
('Which language is used to create schema in DBMS?', 'DML', 'DCL', 'DDL', 'TCL', 'DDL', 'Easy', 'dbms'),
('What is the purpose of normalization?', 'To remove data', 'To increase redundancy', 'To reduce redundancy', 'To remove schema', 'To reduce redundancy', 'Medium', 'dbms'),
('Which of the following is not a type of join in SQL?', 'INNER JOIN', 'OUTER JOIN', 'UPPER JOIN', 'LEFT JOIN', 'UPPER JOIN', 'Easy', 'dbms'),
('Which constraint ensures unique values in a column?', 'NOT NULL', 'UNIQUE', 'CHECK', 'DEFAULT', 'UNIQUE', 'Easy', 'dbms'),
('Which command is used to remove a table from the database?', 'DELETE', 'REMOVE', 'DROP', 'CLEAR', 'DROP', 'Easy', 'dbms'),

-- CN
('What does IP stand for?', 'Internet Process', 'Internal Protocol', 'Internet Protocol', 'Internet Packet', 'Internet Protocol', 'Easy', 'cn'),
('Which device operates at the Data Link Layer?', 'Router', 'Switch', 'Modem', 'Hub', 'Switch', 'Easy', 'cn'),
('Which protocol is used to assign IP addresses automatically?', 'FTP', 'SMTP', 'DHCP', 'IPSec', 'DHCP', 'Medium', 'cn'),
('What is the purpose of DNS?', 'Send emails', 'Translate IP to hostname', 'Assign MAC address', 'Encrypt data', 'Translate IP to hostname', 'Easy', 'cn'),
('Which layer ensures reliable transmission?', 'Physical Layer', 'Transport Layer', 'Application Layer', 'Network Layer', 'Transport Layer', 'Medium', 'cn'),

-- OS
('What is a deadlock?', 'Infinite loop', 'Lack of memory', 'Processes waiting on each other', 'File not found', 'Processes waiting on each other', 'Medium', 'os'),
('Which of the following is not a scheduling algorithm?', 'Round Robin', 'FIFO', 'LIFO', 'SJF', 'LIFO', 'Easy', 'os'),
('Which memory is volatile?', 'ROM', 'SSD', 'RAM', 'Hard Disk', 'RAM', 'Easy', 'os'),
('What does a semaphore do?', 'Controls access to resources', 'Encrypts data', 'Schedules processes', 'Handles paging', 'Controls access to resources', 'Medium', 'os'),

-- OOPs
('Which principle is being used when same function name behaves differently?', 'Inheritance', 'Encapsulation', 'Polymorphism', 'Abstraction', 'Polymorphism', 'Easy', 'oops'),
('Which concept hides internal implementation?', 'Polymorphism', 'Abstraction', 'Encapsulation', 'Inheritance', 'Abstraction', 'Medium', 'oops');
