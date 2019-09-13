DROP SCHEMA IF EXISTS `hb-university-department`;

CREATE SCHEMA `hb-university-department`;

USE `hb-university-department`;

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(54) DEFAULT NULL,
`budget` int(11) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=latin1;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) DEFAULT NULL,
`last_name` VARCHAR(45) DEFAULT NULL,
`adress` VARCHAR(45) DEFAULT NULL,
`speciality` VARCHAR(45) DEFAULT NULL,
`department_id` int(11) DEFAULT NULL,
PRIMARY KEY(`id`),
KEY `FK_DEPARTMENT_idx` (`department_id`),
CONSTRAINT `FK_DEPARTMENT` 
FOREIGN KEY (`department_id`) 
REFERENCES `department` (`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=latin1;

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) DEFAULT NULL,
`last_name` VARCHAR(45) DEFAULT NULL,
`email` VARCHAR(45) DEFAULT NULL,
`salary` int(11) DEFAULT NULL,
`department_id` int(11) DEFAULT NULL,
PRIMARY KEY(`id`),
KEY `FK_DEPARTMENT_idx` (`department_id`),
CONSTRAINT `FK_DEPARTMENT_TEACHER` 
FOREIGN KEY (`department_id`) 
REFERENCES `department` (`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=latin1;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`topic` VARCHAR(255) DEFAULT NULL,
`teacher_id` int(11) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `FK_TEACHER_idx` (`teacher_id`),
CONSTRAINT `FK_TEACHER` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT=1 CHARSET=latin1;

DROP TABLE IF EXISTS `student_course`;

CREATE TABLE `student_course`(
`student_id` int (11) NOT NULL,
`course_id` int (11) NOT NULL,
PRIMARY KEY (`student_id`, `course_id`),
KEY `FK_STUDENT_idx` (`student_id`),
CONSTRAINT `FK_STUDENT` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION,
KEY `FK_COURSE_id` (`course_id`),
CONSTRAINT `FK_COURSE` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION
)ENGINE = InnoDB AUTO_INCREMENT=1 CHARSET=latin1;

INSERT INTO `department` VALUES 
	(1,'Chemical Engineering & Biotechnology','300000'),
	(2,'Engineering', '250000');
    
INSERT INTO `student` VALUES 
(1, 'Peter', 'Ivanov', 'Bulgaria', 'Biotechnology', '1'),
(2, 'Aurora', 'Bianci', 'Italy', 'Engineering', '2');

INSERT INTO `teacher` VALUES
(1, 'Katq', 'Todorova', 'kateto83@gmail.com', '1234', '1'),
(2, 'Gabriel', 'Charpentier', 'gosho@abv.bg', '2500', '2');

INSERT INTO `course` VALUES
(1, 'Civil engineering', '2');