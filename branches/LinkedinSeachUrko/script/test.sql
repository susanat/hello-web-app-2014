-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 13-01-2015 a las 08:28:55
-- Versión del servidor: 5.6.12-log
-- Versión de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `deletePersona`(IN `p_codigo` INT)
    NO SQL
BEGIN
DELETE FROM persona WHERE codPersona = p_codigo;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAll`()
    NO SQL
BEGIN
SELECT codPersona, nombre, apellidos,foto 
FROM persona;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getById`(IN `p_codigo` INT)
    NO SQL
BEGIN

SELECT codPersona, nombre, apellidos, foto
FROM persona
WHERE codPersona = p_codigo;


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertPersona`(IN `p_nombre` VARCHAR(50), IN `p_apellidos` VARCHAR(250), IN `p_foto` VARCHAR(250))
BEGIN
    INSERT INTO pesona (nombre,apellidos,foto) VALUES(p_nombre,p_apellidos,p_fotos);
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updatePersona`(IN `p_nombre` VARCHAR(50), IN `p_apellidos` VARCHAR(250), IN `p_foto` VARCHAR(100), IN `p_codigo` INT)
    NO SQL
BEGIN
UPDATE persona 
    SET nombre=p_nombre,
    apellidos=p_apellidos,
     foto=p_foto 
WHERE codPersona = p_codigo;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `codPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(250) COLLATE utf8_bin NOT NULL,
  `foto` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`codPersona`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`codPersona`, `nombre`, `apellidos`, `foto`) VALUES
(1, 'kepa', 'escudero', ''),
(2, 'urko', 'villanueva alvarez', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
