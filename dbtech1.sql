SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `dbtech1` ;
CREATE SCHEMA IF NOT EXISTS `dbtech1` DEFAULT CHARACTER SET latin1 ;
USE `dbtech1` ;


-- -----------------------------------------------------
-- Table `dbtech1`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtech1`.`employees` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `region_id` INT(6) NOT NULL,
  `manager_id` INT(6) NOT NULL,
  `department_id` INT(6) NOT NULL,
  `first_name` VARCHAR(50) NULL DEFAULT NULL,
  `last_name` VARCHAR(50) NULL DEFAULT NULL,
  `email_address` VARCHAR(50) NULL DEFAULT NULL,
  `job_title` VARCHAR(50) NULL DEFAULT NULL,
  `salary` FLOAT(11) NULL DEFAULT NULL,
  `mobile_phone` VARCHAR(25) NULL DEFAULT NULL,
  `address` LONGTEXT NULL DEFAULT NULL,
  `birth_date` DATE NULL DEFAULT NULL, 
  `hire_date` DATE NULL DEFAULT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (region_id) REFERENCES regions(id),
  FOREIGN KEY (manager_id) REFERENCES manager(id),
  FOREIGN KEY (department_id) REFERENCES deparment(id),
  INDEX `first_name` (`first_name` ASC),
  INDEX `last_name` (`last_name` ASC)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbtech1`.`regions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtech1`.`regions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `dbtech1`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtech1`.`departments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `dbtech1`.`managers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtech1`.`managers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `region_id` INT(11) NOT NULL,
   `first_name` VARCHAR(10) NOT NULL,
   `last_name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (region_id) REFERENCES regions(id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `dbtech1`.`directors` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `department_id` INT(11) NOT NULL,
  `first_name` VARCHAR(10) NOT NULL,
   `last_name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (department_id) REFERENCES departments(id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- Table `dbtech1`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtech1`.`users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB 
AUTO_INCREMENT=8 
DEFAULT CHARSET=utf8;



INSERT INTO regions VALUES(1,"Middle East");
INSERT INTO regions VALUES(2,"Europe");
INSERT INTO regions VALUES(3,"Asia");
INSERT INTO regions VALUES(4,"North America");
INSERT INTO regions VALUES(5,"Latin America");
INSERT INTO regions VALUES(6,"Africa");

INSERT INTO departments VALUES(1,"IT");
INSERT INTO departments VALUES(2,"Finance");
INSERT INTO departments VALUES(3,"Human Resources");
INSERT INTO departments VALUES(4,"Marketing");
INSERT INTO departments VALUES(5,"Sales");
INSERT INTO departments VALUES(6,"Administrative Affairs");
INSERT INTO departments VALUES(7,"Legal");
INSERT INTO managers VALUES(1,2,"Donalds","Jafferson");
INSERT INTO managers VALUES(2,4,"Taylor","Clement");




INSERT INTO employees VALUES(1,2,1,1,'Davolio','Nancy','nancydavolio@yahoo.com','Senior Software Developer',8000.0,'+410543999999','Cenevre,Switzerland','1983-12-08','2023-01-02');
INSERT INTO employees VALUES(2,4,2,2,'Fuller','Andrew','andrew93@gmail.com','Accountant',10000.0,'+11054999','Gurnee,Illinois,US','1993-3-12','2022-06-04');


INSERT INTO users VALUES(1,'yunus@example.com','yunus@example.com','$2a$10$WL7Flvhs6VEBYzyy7QO8WOw.4D1tyHAFhcejrvweXOsw8vRhtFr/m','ADMIN');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;