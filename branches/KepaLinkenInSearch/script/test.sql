-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-01-2015 a las 09:19:50
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(120) NOT NULL,
  `apellido1` varchar(120) NOT NULL,
  `edad` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `nombre`, `apellido1`, `edad`) VALUES
(1, 'pepe', 'markinez', 12),
(2, 'pepa', 'markinez', 34),
(3, 'nuevo', 'braulkio', 34),
(4, 'ander', 'uraga', 34),
(5, 'manolo', 'Garimbolo', 34),
(6, 'otro nuevo', 'apelliedo', 34),
(7, 'Ander', 'Uraga', 34),
(8, 'ddd', 'ddddd', 34),
(9, 'hhh', 'dktjdvzs ', 34),
(10, 'datasource', 'datasource', 34),
(11, 'gggg', 'ggg', 69),
(12, 'Ã?u', 'LalÃ³z', 69),
(13, 'Ã?u', 'LÃ³pez', 69),
(14, 'Ñu', 'López', 69);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
