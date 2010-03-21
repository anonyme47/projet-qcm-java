SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `QCM` ;
CREATE SCHEMA IF NOT EXISTS `QCM` DEFAULT CHARACTER SET utf8 ;

-- -----------------------------------------------------
-- Table `QCM`.`niveau`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCM`.`niveau` ;

CREATE  TABLE IF NOT EXISTS `QCM`.`niveau` (
  `id_niveau` INT NOT NULL AUTO_INCREMENT ,
  `libelle` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id_niveau`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCM`.`statut`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCM`.`statut` ;

CREATE  TABLE IF NOT EXISTS `QCM`.`statut` (
  `id_statut` INT NOT NULL AUTO_INCREMENT ,
  `libelle` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id_statut`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCM`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCM`.`user` ;

CREATE  TABLE IF NOT EXISTS `QCM`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(50) NOT NULL ,
  `nom` VARCHAR(255) NOT NULL ,
  `prenom` VARCHAR(255) NOT NULL ,
  `password` VARCHAR(32) NOT NULL ,
  `email` VARCHAR(255) NOT NULL ,
  `id_statut` INT NOT NULL ,
  PRIMARY KEY (`id_user`) ,
  INDEX `fk_user_statut` (`id_statut` ASC) ,
  CONSTRAINT `fk_user_statut`
    FOREIGN KEY (`id_statut` )
    REFERENCES `QCM`.`statut` (`id_statut` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCM`.`theme`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCM`.`theme` ;

CREATE  TABLE IF NOT EXISTS `QCM`.`theme` (
  `id_theme` INT NOT NULL AUTO_INCREMENT ,
  `libelle` VARCHAR(255) NOT NULL ,
  `descriptif` VARCHAR(255) NULL ,
  `id_user` INT NOT NULL ,
  PRIMARY KEY (`id_theme`) ,
  INDEX `fk_theme_user` (`id_user` ASC) ,
  CONSTRAINT `fk_theme_user`
    FOREIGN KEY (`id_user` )
    REFERENCES `QCM`.`user` (`id_user` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCM`.`questionnaire`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCM`.`questionnaire` ;

CREATE  TABLE IF NOT EXISTS `QCM`.`questionnaire` (
  `id_questionnaire` INT NOT NULL AUTO_INCREMENT ,
  `libelle` VARCHAR(255) NOT NULL ,
  `date_creation` DATE NOT NULL ,
  `limite_temps` INT NULL ,
  `est_actif` TINYINT(1) NOT NULL DEFAULT true ,
  `id_niveau` INT NOT NULL ,
  `id_theme` INT NOT NULL ,
  `id_user` INT NOT NULL ,
  PRIMARY KEY (`id_questionnaire`) ,
  INDEX `fk_questionnaire_niveau` (`id_niveau` ASC) ,
  INDEX `fk_questionnaire_theme` (`id_theme` ASC) ,
  INDEX `fk_questionnaire_user` (`id_user` ASC) ,
  CONSTRAINT `fk_questionnaire_niveau`
    FOREIGN KEY (`id_niveau` )
    REFERENCES `QCM`.`niveau` (`id_niveau` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionnaire_theme`
    FOREIGN KEY (`id_theme` )
    REFERENCES `QCM`.`theme` (`id_theme` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionnaire_user`
    FOREIGN KEY (`id_user` )
    REFERENCES `QCM`.`user` (`id_user` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCM`.`question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCM`.`question` ;

CREATE  TABLE IF NOT EXISTS `QCM`.`question` (
  `id_question` INT NOT NULL AUTO_INCREMENT ,
  `libelle` VARCHAR(255) NOT NULL ,
  `id_theme` INT NOT NULL ,
  `id_user` INT NOT NULL ,
  PRIMARY KEY (`id_question`) ,
  INDEX `fk_question_theme` (`id_theme` ASC) ,
  INDEX `fk_question_user` (`id_user` ASC) ,
  CONSTRAINT `fk_question_theme`
    FOREIGN KEY (`id_theme` )
    REFERENCES `QCM`.`theme` (`id_theme` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_user`
    FOREIGN KEY (`id_user` )
    REFERENCES `QCM`.`user` (`id_user` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCM`.`reponse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCM`.`reponse` ;

CREATE  TABLE IF NOT EXISTS `QCM`.`reponse` (
  `id_reponse` INT NOT NULL AUTO_INCREMENT ,
  `libelle` VARCHAR(255) NOT NULL ,
  `descriptif` VARCHAR(255) NULL ,
  `est_correcte` TINYINT(1) NOT NULL ,
  `note` INT NOT NULL ,
  `id_question` INT NOT NULL ,
  PRIMARY KEY (`id_reponse`) ,
  INDEX `fk_reponse_question` (`id_question` ASC) ,
  CONSTRAINT `fk_reponse_question`
    FOREIGN KEY (`id_question` )
    REFERENCES `QCM`.`question` (`id_question` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCM`.`historique`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCM`.`historique` ;

CREATE  TABLE IF NOT EXISTS `QCM`.`historique` (
  `id_questionnaire` INT NOT NULL ,
  `id_user` INT NOT NULL ,
  `note` INT NOT NULL ,
  `date` DATE NOT NULL ,
  PRIMARY KEY (`id_questionnaire`, `id_user`) ,
  INDEX `fk_questionnaire_has_user_questionnaire1` (`id_questionnaire` ASC) ,
  INDEX `fk_questionnaire_has_user_user1` (`id_user` ASC) ,
  CONSTRAINT `fk_questionnaire_has_user_questionnaire1`
    FOREIGN KEY (`id_questionnaire` )
    REFERENCES `QCM`.`questionnaire` (`id_questionnaire` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionnaire_has_user_user1`
    FOREIGN KEY (`id_user` )
    REFERENCES `QCM`.`user` (`id_user` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCM`.`contenu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCM`.`contenu` ;

CREATE  TABLE IF NOT EXISTS `QCM`.`contenu` (
  `id_contenu` INT NOT NULL AUTO_INCREMENT ,
  `id_questionnaire` INT NOT NULL ,
  `id_question` INT NOT NULL ,
  PRIMARY KEY (`id_contenu`) ,
  INDEX `fk_contenu_questionnaire` (`id_questionnaire` ASC) ,
  INDEX `fk_contenu_question` (`id_question` ASC) ,
  UNIQUE INDEX `id_questionnaire_id_question_UNIQUE` (`id_questionnaire`, `id_question`) ,
  CONSTRAINT `fk_contenu_questionnaire`
    FOREIGN KEY (`id_questionnaire` )
    REFERENCES `QCM`.`questionnaire` (`id_questionnaire` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contenu_question`
    FOREIGN KEY (`id_question` )
    REFERENCES `QCM`.`question` (`id_question` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `QCM`.`niveau`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `QCM`;
insert into `QCM`.`niveau` (`id_niveau`, `libelle`) values (1, 'Débutant');
insert into `QCM`.`niveau` (`id_niveau`, `libelle`) values (2, 'Avancé');
insert into `QCM`.`niveau` (`id_niveau`, `libelle`) values (3, 'Expert');

COMMIT;

-- -----------------------------------------------------
-- Data for table `QCM`.`statut`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `QCM`;
insert into `QCM`.`statut` (`id_statut`, `libelle`) values (1, 'Enseignant');
insert into `QCM`.`statut` (`id_statut`, `libelle`) values (2, 'Etudiant');
insert into `QCM`.`statut` (`id_statut`, `libelle`) values (3, 'Administrateur');

COMMIT;

-- -----------------------------------------------------
-- Data for table `QCM`.`user`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `QCM`;
insert into `QCM`.`user` (`id_user`, `login`, `nom`, `prenom`, `password`, `email`, `id_statut`) values (1, 'Lou', 'Ferrand', 'Lou', 'lou', 'ferrandlou@gmail.com', 3);
insert into `QCM`.`user` (`id_user`, `login`, `nom`, `prenom`, `password`, `email`, `id_statut`) values (2, 'Maria', 'Rabarison', 'Maria', 'maria', 'maryarabarison@gmail.com', 1);
insert into `QCM`.`user` (`id_user`, `login`, `nom`, `prenom`, `password`, `email`, `id_statut`) values (3, 'Test', 'Test', 'Test', 'test', 'test@test.fr', 2);

COMMIT;

-- -----------------------------------------------------
-- Data for table `QCM`.`theme`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `QCM`;
insert into `QCM`.`theme` (`id_theme`, `libelle`, `descriptif`, `id_user`) values (1, 'Java', 'Java', 1);
insert into `QCM`.`theme` (`id_theme`, `libelle`, `descriptif`, `id_user`) values (2, 'Ruby', 'Ruby', 1);
insert into `QCM`.`theme` (`id_theme`, `libelle`, `descriptif`, `id_user`) values (3, 'C++', 'C++', 2);
insert into `QCM`.`theme` (`id_theme`, `libelle`, `descriptif`, `id_user`) values (4, 'PHP', 'PHP', 2);
insert into `QCM`.`theme` (`id_theme`, `libelle`, `descriptif`, `id_user`) values (5, 'UML', 'UML', 3);
insert into `QCM`.`theme` (`id_theme`, `libelle`, `descriptif`, `id_user`) values (6, 'POO', 'Programmation Orientée Objet', 2);

COMMIT;

-- -----------------------------------------------------
-- Data for table `QCM`.`questionnaire`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `QCM`;
insert into `QCM`.`questionnaire` (`id_questionnaire`, `libelle`, `date_creation`, `limite_temps`, `est_actif`, `id_niveau`, `id_theme`, `id_user`) values (1, 'Les exceptions en Java', 'NOW()', 30, true, 1, 1, 1);
insert into `QCM`.`questionnaire` (`id_questionnaire`, `libelle`, `date_creation`, `limite_temps`, `est_actif`, `id_niveau`, `id_theme`, `id_user`) values (2, 'L\'héritage en Ruby', 'NOW()', 20, true, 2, 2, 1);
insert into `QCM`.`questionnaire` (`id_questionnaire`, `libelle`, `date_creation`, `limite_temps`, `est_actif`, `id_niveau`, `id_theme`, `id_user`) values (3, 'Le polymorphisme en C++', 'NOW()', 45, true, 1, 3, 2);
insert into `QCM`.`questionnaire` (`id_questionnaire`, `libelle`, `date_creation`, `limite_temps`, `est_actif`, `id_niveau`, `id_theme`, `id_user`) values (4, 'Test', 'NOW()', 45, true, 1, 4, 2);

COMMIT;

-- -----------------------------------------------------
-- Data for table `QCM`.`question`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `QCM`;
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (1, 'Question 1 Theme 1', 1, 2);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (2, 'Question 2 Theme 1', 1, 2);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (3, 'Question 3 Theme 1', 1, 2);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (4, 'Question 4 Theme 1', 1, 2);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (5, 'Question 5 Theme 1', 1, 2);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (6, 'Question 6 Theme 1', 1, 2);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (7, 'Question 7 Theme 1', 1, 2);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (8, 'Question 8 Theme 1', 1, 2);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (9, 'Question 9 Theme 1', 1, 2);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (10, 'Question 1 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (11, 'Question 2 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (12, 'Question 3 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (13, 'Question 4 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (14, 'Question 5 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (15, 'Question 6 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (16, 'Question 7 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (17, 'Question 8 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (18, 'Question 9 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (19, 'Question 10 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (20, 'Question 11 Theme 2', 2, 1);
insert into `QCM`.`question` (`id_question`, `libelle`, `id_theme`, `id_user`) values (21, 'Question 1 Theme 4', 3, 2);

COMMIT;

-- -----------------------------------------------------
-- Data for table `QCM`.`reponse`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `QCM`;
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (1, 'Réponse 1', 'Descriptif Réponse 1 Question 1', 0, 0, 1);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (2, 'Réponse 2', 'Descriptif Réponse 2 Question 1', 0, 0, 1);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (3, 'Réponse 3', 'Descriptif Réponse 3 Question 1', 1, 5, 1);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (4, 'Réponse 4', 'Descriptif Réponse 4 Question 1', 0, 0, 1);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (5, 'Réponse 1', 'Descriptif Réponse 1 Question 2', 0, 0, 2);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (6, 'Réponse 2', 'Descriptif Réponse 2 Question 2', 1, 3, 2);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (7, 'Réponse 3', 'Descriptif Réponse 3 Question 2', 0, 0, 2);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (8, 'Réponse 4', 'Descriptif Réponse 4 Question 2', 1, 3, 2);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (9, 'Réponse 5', 'Descriptif Réponse 5 Question 2', 0, 0, 2);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (10, 'Réponse 1', 'Descriptif Réponse 1 Question 3', 0, 0, 3);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (11, 'Réponse 2', 'Descriptif Réponse 2 Question 3', 1, 9, 3);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (12, 'Réponse 3', 'Descriptif Réponse 3 Question 3', 0, 0, 3);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (13, 'Réponse 1', 'Descriptif Réponse 1 Question 21', 0, 0, 21);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (14, 'Réponse 2', 'Descriptif Réponse 2 Question 21', 1, 3, 21);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (15, 'Réponse 3', 'Descriptif Réponse 3 Question 21', 1, 3, 21);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (16, 'Réponse 4', 'Descriptif Réponse 4 Question 21', 0, 0, 21);
insert into `QCM`.`reponse` (`id_reponse`, `libelle`, `descriptif`, `est_correcte`, `note`, `id_question`) values (17, 'Réponse 5', 'Descriptif Réponse 5 Question 21', 0, 0, 21);

COMMIT;

-- -----------------------------------------------------
-- Data for table `QCM`.`historique`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `QCM`;
insert into `QCM`.`historique` (`id_questionnaire`, `id_user`, `note`, `date`) values (1, 1, 15, 'NOW()');
insert into `QCM`.`historique` (`id_questionnaire`, `id_user`, `note`, `date`) values (2, 1, 10, 'NOW()');
insert into `QCM`.`historique` (`id_questionnaire`, `id_user`, `note`, `date`) values (3, 1, 5, 'NOW()');
insert into `QCM`.`historique` (`id_questionnaire`, `id_user`, `note`, `date`) values (1, 2, 15, 'NOW()');
insert into `QCM`.`historique` (`id_questionnaire`, `id_user`, `note`, `date`) values (2, 2, 10, 'NOW()');
insert into `QCM`.`historique` (`id_questionnaire`, `id_user`, `note`, `date`) values (3, 2, 5, 'NOW()');
insert into `QCM`.`historique` (`id_questionnaire`, `id_user`, `note`, `date`) values (1, 3, 15, 'NOW()');
insert into `QCM`.`historique` (`id_questionnaire`, `id_user`, `note`, `date`) values (2, 3, 10, 'NOW()');
insert into `QCM`.`historique` (`id_questionnaire`, `id_user`, `note`, `date`) values (3, 3, 5, 'NOW()');

COMMIT;

-- -----------------------------------------------------
-- Data for table `QCM`.`contenu`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `QCM`;
insert into `QCM`.`contenu` (`id_contenu`, `id_questionnaire`, `id_question`) values (1, 1, 1);
insert into `QCM`.`contenu` (`id_contenu`, `id_questionnaire`, `id_question`) values (2, 1, 2);
insert into `QCM`.`contenu` (`id_contenu`, `id_questionnaire`, `id_question`) values (3, 1, 3);
insert into `QCM`.`contenu` (`id_contenu`, `id_questionnaire`, `id_question`) values (4, 2, 11);
insert into `QCM`.`contenu` (`id_contenu`, `id_questionnaire`, `id_question`) values (5, 2, 12);
insert into `QCM`.`contenu` (`id_contenu`, `id_questionnaire`, `id_question`) values (6, 4, 21);

COMMIT;
