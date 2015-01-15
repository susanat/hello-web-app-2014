-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 15-01-2015 a las 08:11:39
-- Versión del servidor: 5.6.12-log
-- Versión de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `srncodesnippet`
--
CREATE DATABASE IF NOT EXISTS `srncodesnippet` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `srncodesnippet`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificaciones`
--

CREATE TABLE IF NOT EXISTS `calificaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nota` float NOT NULL,
  `id_persona` int(11) NOT NULL,
  `calificacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  KEY `id_persona` (`id_persona`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `calificaciones`
--

INSERT INTO `calificaciones` (`id`, `nota`, `id_persona`, `calificacion`) VALUES
(1, 4.5, 31, NULL),
(2, 9, 31, NULL),
(3, 8, 38, NULL),
(4, 9.99, 38, NULL),
(5, 3, 40, NULL),
(6, 7, 40, NULL),
(7, 3, 40, NULL),
(8, 7, 40, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador del usuario',
  `username` varchar(250) DEFAULT NULL,
  `apellidos` text NOT NULL,
  `password` text NOT NULL COMMENT 'password del usuario',
  `email` varchar(255) DEFAULT NULL COMMENT 'Email del usuario',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT 'El estado del retgistro (1 activo defecto, 0 inactivo)',
  `timezone` varchar(255) DEFAULT NULL COMMENT 'Nombre del  Time Zone del usuario',
  `photo` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Tabla con la información del usuario' AUTO_INCREMENT=41 ;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`, `photo`) VALUES
(31, 'MARIA CECILIA 1', 'GONZALEZ DACAL 2', '', NULL, 1, NULL, 'https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-128.png'),
(38, 'asdf asdf', 'asdf 2 modificado', '', NULL, 1, NULL, 'https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-128.png'),
(40, 'Sergio', 'Moreno Fdez', '', NULL, 1, NULL, 'https://media.licdn.com/mpr/mpr/shrink_120_120/p/4/005/03f/304/0700d03.jpg');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_medias`
--
CREATE TABLE IF NOT EXISTS `vista_medias` (
`id_persona` int(11)
,`nota_minima` double(19,2)
,`nota_maxima` double(19,2)
,`examenes` bigint(21)
,`media` double(19,2)
);
-- --------------------------------------------------------

--
-- Estructura para la vista `vista_medias`
--
DROP TABLE IF EXISTS `vista_medias`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_medias` AS select `calificaciones`.`id_persona` AS `id_persona`,round(min(`calificaciones`.`nota`),2) AS `nota_minima`,round(max(`calificaciones`.`nota`),2) AS `nota_maxima`,count(`calificaciones`.`nota`) AS `examenes`,round(avg(`calificaciones`.`nota`),2) AS `media` from `calificaciones` where ((`calificaciones`.`nota` >= 0) and (`calificaciones`.`nota` <= 10)) group by `calificaciones`.`id_persona`;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  ADD CONSTRAINT `USER-CALIFICACION` FOREIGN KEY (`id_persona`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
