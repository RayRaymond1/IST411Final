#Design a web-based application for Jupiter Company that helps them manage employee records. Jupiter is a company that handles airline ticket reservations.
#Employee records to consider should include: Employee ID, First Name, Last Name, Start Date, Start Salary, 
#Employee Contract Signed (Y/N), Social Security Number, Birthdate, Phone Number, Name of Person to Call in an Emergency, 
#and Phone of Person to Call in an Emergency.

CREATE database if not exists `jupiter`;
USE `jupiter`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Members Table
--

CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pw` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Insert John (Employee), Susan (Admin) and Mary (Manager) into members
-- Generation: https://www.luv2code.com/generate-bcrypt-password
-- Default passwords is test123
INSERT INTO `members`
VALUES
('john','{bcrypt}$2a$10$OhAnotzQSsbuErsd7mRzxebmXuCY8rNcX7HK1KlgYT5K1omSqjOBm',1),
('mary','{bcrypt}$2a$10$OhAnotzQSsbuErsd7mRzxebmXuCY8rNcX7HK1KlgYT5K1omSqjOBm',1),
('susan','{bcrypt}$2a$10$OhAnotzQSsbuErsd7mRzxebmXuCY8rNcX7HK1KlgYT5K1omSqjOBm',1);


--
-- Authorities Table
--

CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Adding Roles
--

INSERT INTO `roles`
VALUES
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');

-- 
-- RECORDS TABLE SETUP
-- DATE stored (yyyy-mm-dd)
-- CHAR(1) = 'y' or 'n'
-- 

use `jupiter`;

create table `employee_records` (
`emp_id` int NOT NULL AUTO_INCREMENT,
`first_name` varchar(45) DEFAULT NULL,
`last_name`  varchar(45) DEFAULT NULL,
`start_date`date,
`start_salary`double,
`signed_contract`char(1),
`ssn` varchar(45) DEFAULT NULL,
`birth_date` date,
`phone_number`  varchar(45) DEFAULT NULL,
`emergency_name` varchar(45) DEFAULT NULL,
`emergency_number` varchar(45) DEFAULT NULL,
primary key(`emp_id`)
) ENGINE=InnoDB  AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;








