-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema software
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema software
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `software` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`role` (
                                             `id` INT NOT NULL,
                                             `name` VARCHAR(45) NOT NULL,
                                             PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `software`.`gender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software`.`gender` (
                                                   `gender_id` INT NOT NULL AUTO_INCREMENT,
                                                   `gender_name` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                   PRIMARY KEY USING BTREE (`gender_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 4
    DEFAULT CHARACTER SET = utf8mb3
    ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `software`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software`.`user` (
                                                 `user_id` INT NOT NULL AUTO_INCREMENT,
                                                 `user_name` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                 `user_email` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                 `user_phone` INT NULL DEFAULT NULL,
                                                 `user_pass` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                 `user_birth` DATE NULL DEFAULT NULL,
                                                 `user_address` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                 `gender_id` INT NULL DEFAULT NULL,
                                                 `roles` VARCHAR(20) NULL DEFAULT NULL,
                                                 `auth_provider` VARCHAR(255) NULL DEFAULT NULL,
                                                 `enable` BIT(1) NULL DEFAULT NULL,
                                                 PRIMARY KEY USING BTREE (`user_id`),
                                                 INDEX `fk_user_user_1` USING BTREE (`gender_id`) VISIBLE,
                                                 CONSTRAINT `fk_user_user_1`
                                                     FOREIGN KEY (`gender_id`)
                                                         REFERENCES `software`.`gender` (`gender_id`)
                                                         ON DELETE RESTRICT
                                                         ON UPDATE RESTRICT)
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb3
    ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `mydb`.`users_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users_roles` (
                                                    `role_id` INT NOT NULL,
                                                    `user_user_id` INT NOT NULL,
                                                    PRIMARY KEY (`role_id`, `user_user_id`),
                                                    INDEX `fk_role_has_user_user1_idx` (`user_user_id` ASC) VISIBLE,
                                                    INDEX `fk_role_has_user_role_idx` (`role_id` ASC) VISIBLE,
                                                    CONSTRAINT `fk_role_has_user_role`
                                                        FOREIGN KEY (`role_id`)
                                                            REFERENCES `mydb`.`role` (`id`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION,
                                                    CONSTRAINT `fk_role_has_user_user1`
                                                        FOREIGN KEY (`user_user_id`)
                                                            REFERENCES `software`.`user` (`user_id`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION)
    ENGINE = InnoDB;

USE `software` ;

-- -----------------------------------------------------
-- Table `software`.`admin_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software`.`admin_role` (
                                                       `admin_role_id` INT NOT NULL AUTO_INCREMENT,
                                                       `admin_role_name` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                       PRIMARY KEY USING BTREE (`admin_role_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 4
    DEFAULT CHARACTER SET = utf8mb3
    ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `software`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software`.`admin` (
                                                  `admin_id` INT NOT NULL AUTO_INCREMENT,
                                                  `admin_name` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                  `knowledge` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                  `gender_id` INT NULL DEFAULT NULL,
                                                  `admin_desc` TEXT CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                  `admin_email` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                  `admin_age` INT NULL DEFAULT NULL,
                                                  `admin_address` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                  `admin_country` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                  `employees_group` INT NULL DEFAULT NULL,
                                                  `admin_role_id` INT NULL DEFAULT NULL,
                                                  `admin_salary` INT NULL DEFAULT NULL,
                                                  `employee_group` INT NOT NULL,
                                                  PRIMARY KEY USING BTREE (`admin_id`),
                                                  INDEX `fk_employees_employees_2` USING BTREE (`admin_role_id`) VISIBLE,
                                                  INDEX `fk_employees_employees_6` USING BTREE (`gender_id`) VISIBLE,
                                                  CONSTRAINT `fk_admin_gender`
                                                      FOREIGN KEY (`gender_id`)
                                                          REFERENCES `software`.`gender` (`gender_id`)
                                                          ON DELETE RESTRICT
                                                          ON UPDATE RESTRICT,
                                                  CONSTRAINT `fk_admin_role`
                                                      FOREIGN KEY (`admin_role_id`)
                                                          REFERENCES `software`.`admin_role` (`admin_role_id`)
                                                          ON DELETE RESTRICT
                                                          ON UPDATE RESTRICT)
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb3
    ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `software`.`news_kind`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software`.`news_kind` (
                                                      `news_kind_id` INT NOT NULL AUTO_INCREMENT,
                                                      `news_kind_name` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                      `news_kind` INT NOT NULL,
                                                      PRIMARY KEY USING BTREE (`news_kind_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb3
    ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `software`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software`.`news` (
                                                 `news_id` INT NOT NULL AUTO_INCREMENT,
                                                 `tittle` TEXT CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                 `content` TEXT CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                 `news_desc` TEXT CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                 `news_source` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                 `news_date` TIMESTAMP NULL DEFAULT NULL,
                                                 `news_kind_id` INT NULL DEFAULT NULL,
                                                 `view_count` INT NULL DEFAULT NULL,
                                                 `like_count` INT NULL DEFAULT NULL,
                                                 `title_img` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                 `title` VARCHAR(255) NULL DEFAULT NULL,
                                                 PRIMARY KEY USING BTREE (`news_id`),
                                                 INDEX `fk_news_news_2` USING BTREE (`news_kind_id`) VISIBLE,
                                                 CONSTRAINT `fk_news_news_2`
                                                     FOREIGN KEY (`news_kind_id`)
                                                         REFERENCES `software`.`news_kind` (`news_kind_id`)
                                                         ON DELETE RESTRICT
                                                         ON UPDATE RESTRICT)
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb3
    ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `software`.`admin_news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software`.`admin_news` (
                                                       `admin_news_id` INT NOT NULL,
                                                       `admin_id` INT NULL DEFAULT NULL,
                                                       `news_id` INT NULL DEFAULT NULL,
                                                       PRIMARY KEY USING BTREE (`admin_news_id`),
                                                       INDEX `fk_admin_news1` USING BTREE (`admin_id`) VISIBLE,
                                                       INDEX `fk_admin_news2` USING BTREE (`news_id`) VISIBLE,
                                                       CONSTRAINT `fk_admin_news1`
                                                           FOREIGN KEY (`admin_id`)
                                                               REFERENCES `software`.`admin` (`admin_id`)
                                                               ON DELETE RESTRICT
                                                               ON UPDATE RESTRICT,
                                                       CONSTRAINT `fk_admin_news2`
                                                           FOREIGN KEY (`news_id`)
                                                               REFERENCES `software`.`news` (`news_id`)
                                                               ON DELETE RESTRICT
                                                               ON UPDATE RESTRICT)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3
    ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `software`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software`.`comment` (
                                                    `comment_id` INT NOT NULL AUTO_INCREMENT,
                                                    `news_id` INT NULL DEFAULT NULL,
                                                    `user_id` INT NULL DEFAULT NULL,
                                                    `comment_content` TEXT CHARACTER SET 'utf8' NULL DEFAULT NULL,
                                                    `level` INT NULL DEFAULT '1',
                                                    `parent_id` INT NULL DEFAULT NULL,
                                                    `comment_conten` VARCHAR(255) NULL DEFAULT NULL,
                                                    `lever` INT NOT NULL,
                                                    PRIMARY KEY USING BTREE (`comment_id`),
                                                    INDEX `fk_comment_comment_2` USING BTREE (`news_id`) VISIBLE,
                                                    INDEX `fk_comment_comment_3` USING BTREE (`user_id`) VISIBLE,
                                                    CONSTRAINT `fk_comment_comment_2`
                                                        FOREIGN KEY (`news_id`)
                                                            REFERENCES `software`.`news` (`news_id`)
                                                            ON DELETE RESTRICT
                                                            ON UPDATE RESTRICT,
                                                    CONSTRAINT `fk_comment_comment_3`
                                                        FOREIGN KEY (`user_id`)
                                                            REFERENCES `software`.`user` (`user_id`)
                                                            ON DELETE RESTRICT
                                                            ON UPDATE RESTRICT)
    ENGINE = InnoDB
    AUTO_INCREMENT = 4
    DEFAULT CHARACTER SET = utf8mb3
    ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `software`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software`.`hibernate_sequence` (
    `next_val` BIGINT NULL DEFAULT NULL)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `software`.`history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software`.`history` (
                                                    `history_id` INT NOT NULL,
                                                    `user_id` INT NULL DEFAULT NULL,
                                                    `news_id` INT NULL DEFAULT NULL,
                                                    `like` TINYINT(1) NULL DEFAULT NULL COMMENT '0 là ko like,1 là like',
                                                    `like_number` INT NULL DEFAULT NULL,
                                                    PRIMARY KEY USING BTREE (`history_id`),
                                                    INDEX `fk_history_user` USING BTREE (`user_id`) VISIBLE,
                                                    INDEX `fk_history_news` USING BTREE (`news_id`) VISIBLE,
                                                    CONSTRAINT `fk_history_news`
                                                        FOREIGN KEY (`news_id`)
                                                            REFERENCES `software`.`news` (`news_id`)
                                                            ON DELETE RESTRICT
                                                            ON UPDATE RESTRICT,
                                                    CONSTRAINT `fk_history_user`
                                                        FOREIGN KEY (`user_id`)
                                                            REFERENCES `software`.`user` (`user_id`)
                                                            ON DELETE RESTRICT
                                                            ON UPDATE RESTRICT)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3
    ROW_FORMAT = DYNAMIC;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
