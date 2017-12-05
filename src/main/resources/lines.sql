-- MySQL Script generated by MySQL Workbench
-- Sat Dec  2 18:03:38 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lines
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lines
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lines` DEFAULT CHARACTER SET utf8 ;
USE `lines` ;

-- -----------------------------------------------------
-- Table `lines`.`fittings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`fittings` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mark` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`insulators`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`insulators` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mark` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`gps_coordinates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`gps_coordinates` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `latitude` DOUBLE NOT NULL,
  `longitude` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idgps_coordinates_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`tower_marks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`tower_marks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mark` VARCHAR(256) NOT NULL,
  `height` DOUBLE NULL,
  `weight` DOUBLE NULL,
  `type` VARCHAR(45) NULL,
  `material` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`towers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`towers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tower_mark_id` INT NOT NULL,
  `tower_center_gps_coordinates_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_tower_tower_marks1_idx` (`tower_mark_id` ASC),
  INDEX `fk_tower_gps_coordinates1_idx` (`tower_center_gps_coordinates_id` ASC),
  CONSTRAINT `fk_tower_tower_marks1`
    FOREIGN KEY (`tower_mark_id`)
    REFERENCES `lines`.`tower_marks` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tower_gps_coordinates1`
    FOREIGN KEY (`tower_center_gps_coordinates_id`)
    REFERENCES `lines`.`gps_coordinates` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`junctions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`junctions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `gps_coordinates_id` INT NOT NULL,
  `tower_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_junctions_gps_coordinates_idx` (`gps_coordinates_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_junctions_towers1_idx` (`tower_id` ASC),
  CONSTRAINT `fk_junctions_gps_coordinates`
    FOREIGN KEY (`gps_coordinates_id`)
    REFERENCES `lines`.`gps_coordinates` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_junctions_towers1`
    FOREIGN KEY (`tower_id`)
    REFERENCES `lines`.`towers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`junctions_has_fittings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`junctions_has_fittings` (
  `junction_id` INT NOT NULL,
  `fitting_id` INT NOT NULL,
  `fittings_quantity` INT NULL,
  PRIMARY KEY (`junction_id`, `fitting_id`),
  INDEX `fk_junctions_has_fittings_fittings1_idx` (`fitting_id` ASC),
  INDEX `fk_junctions_has_fittings_junctions1_idx` (`junction_id` ASC),
  CONSTRAINT `fk_junctions_has_fittings_junctions1`
    FOREIGN KEY (`junction_id`)
    REFERENCES `lines`.`junctions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_junctions_has_fittings_fittings1`
    FOREIGN KEY (`fitting_id`)
    REFERENCES `lines`.`fittings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`junctions_has_insulators`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`junctions_has_insulators` (
  `junction_id` INT NOT NULL,
  `insulator_id` INT NOT NULL,
  `insulators_quantity` INT NULL,
  PRIMARY KEY (`junction_id`, `insulator_id`),
  INDEX `fk_junctions_has_insulators_insulators1_idx` (`insulator_id` ASC),
  INDEX `fk_junctions_has_insulators_junctions1_idx` (`junction_id` ASC),
  CONSTRAINT `fk_junctions_has_insulators_junctions1`
    FOREIGN KEY (`junction_id`)
    REFERENCES `lines`.`junctions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_junctions_has_insulators_insulators1`
    FOREIGN KEY (`insulator_id`)
    REFERENCES `lines`.`insulators` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`wires`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`wires` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mark` VARCHAR(256) NOT NULL,
  `weight_per_meter` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`transmit_lines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`transmit_lines` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `voltage` INT NOT NULL,
  `begin` VARCHAR(256) NOT NULL,
  `end` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`spans`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`spans` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `begin_tower_id` INT NOT NULL,
  `end_tower_id` INT NOT NULL,
  `transmit_line_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idspans_UNIQUE` (`id` ASC),
  INDEX `fk_spans_towers1_idx` (`begin_tower_id` ASC),
  INDEX `fk_spans_towers2_idx` (`end_tower_id` ASC),
  INDEX `fk_spans_transmit_lines1_idx` (`transmit_line_id` ASC),
  CONSTRAINT `fk_spans_towers1`
    FOREIGN KEY (`begin_tower_id`)
    REFERENCES `lines`.`towers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_spans_towers2`
    FOREIGN KEY (`end_tower_id`)
    REFERENCES `lines`.`towers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_spans_transmit_lines1`
    FOREIGN KEY (`transmit_line_id`)
    REFERENCES `lines`.`transmit_lines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`links`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`links` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `begin_junction_id` INT NOT NULL,
  `end_junction_id` INT NOT NULL,
  `wire_id` INT NOT NULL,
  `phase` VARCHAR(1) NOT NULL,
  `span_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_spans_junctions1_idx` (`begin_junction_id` ASC),
  INDEX `fk_spans_junctions2_idx` (`end_junction_id` ASC),
  INDEX `fk_spans_wires1_idx` (`wire_id` ASC),
  INDEX `fk_links_spans1_idx` (`span_id` ASC),
  CONSTRAINT `fk_spans_junctions1`
    FOREIGN KEY (`begin_junction_id`)
    REFERENCES `lines`.`junctions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_spans_junctions2`
    FOREIGN KEY (`end_junction_id`)
    REFERENCES `lines`.`junctions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_spans_wires1`
    FOREIGN KEY (`wire_id`)
    REFERENCES `lines`.`wires` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_links_spans1`
    FOREIGN KEY (`span_id`)
    REFERENCES `lines`.`spans` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lines`.`transmit_lines_has_towers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lines`.`transmit_lines_has_towers` (
  `transmit_line_id` INT NOT NULL,
  `tower_id` INT NOT NULL,
  PRIMARY KEY (`transmit_line_id`, `tower_id`),
  INDEX `fk_transmit_lines_has_towers_towers1_idx` (`tower_id` ASC),
  INDEX `fk_transmit_lines_has_towers_transmit_lines1_idx` (`transmit_line_id` ASC),
  CONSTRAINT `fk_transmit_lines_has_towers_transmit_lines1`
    FOREIGN KEY (`transmit_line_id`)
    REFERENCES `lines`.`transmit_lines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transmit_lines_has_towers_towers1`
    FOREIGN KEY (`tower_id`)
    REFERENCES `lines`.`towers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
