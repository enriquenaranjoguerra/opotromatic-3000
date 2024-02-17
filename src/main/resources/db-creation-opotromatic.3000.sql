-- schema creation
DROP SCHEMA IF EXISTS `opotromatic_3000`;
CREATE SCHEMA `opotromatic_3000` DEFAULT CHARACTER SET utf8;

CREATE TABLE `opotromatic_3000`.`o_category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  UNIQUE KEY (`id`),
  PRIMARY  KEY (`name`)
);

CREATE TABLE `opotromatic_3000`.`o_box` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `category` VARCHAR(200) NOT NULL,
  UNIQUE KEY (`name`, `category`),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`category`) REFERENCES `o_category`(`name`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `opotromatic_3000`.`o_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `category` VARCHAR(200) NOT NULL,
  `box` VARCHAR(200) NOT NULL,
  UNIQUE KEY (`name`, `category`, `box`),
  PRIMARY  KEY (`id`),
  FOREIGN KEY (`category`) REFERENCES `o_category`(`name`) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (`box`) REFERENCES `o_box`(`name`) ON UPDATE CASCADE ON DELETE CASCADE
);


INSERT IGNORE INTO `opotromatic_3000`.`o_category` (`name`) VALUES
("Dragon Ball"),
("Nintendo");

INSERT IGNORE INTO `opotromatic_3000`.`o_box` (`name`, `category`) VALUES
("Super Saiyan", "Dragon Ball"),
("Humanos", "Dragon Ball"),
("Super Mario Bros", "Nintendo"),
("Zelda", "Nintendo");

INSERT IGNORE INTO `opotromatic_3000`.`o_card` (`name`, `category`, `box`) VALUES
("Goku","Dragon Ball","Super Saiyan"),
("Brolly","Dragon Ball","Super Saiyan"),
("Krillin","Dragon Ball","Humanos"),
("Tenshinhan","Dragon Ball","Humanos"),
("Mario","Nintendo","Super Mario Bros"),
("Luigi","Nintendo","Super Mario Bros"),
("Link","Nintendo","Zelda"),
("Epona","Nintendo","Zelda");

