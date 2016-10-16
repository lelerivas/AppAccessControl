CREATE TABLE `accesscontrol`.`tbuser` (
  `coduser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  PRIMARY KEY (`coduser`));
  
CREATE TABLE `accesscontrol`.`tbadress` (
  `codadress` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `neighborhood` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `usercod` INT NOT NULL,
  PRIMARY KEY (`codadress`),
  INDEX `usercod_idx` (`usercod` ASC),
  CONSTRAINT `usercod`
    FOREIGN KEY (`usercod`)
    REFERENCES `accesscontrol`.`tbuser` (`coduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);