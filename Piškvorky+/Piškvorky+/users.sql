

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";




-- Databáza: `piskvorky`



DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(50) COLLATE utf8_slovak_ci NOT NULL,
  
  `email` varchar(50) COLLATE utf8_slovak_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_slovak_ci NOT NULL,
  `trn_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_slovak_ci;






