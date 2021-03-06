-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-03-2021 a las 16:18:10
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_medicamentos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `componente`
--

CREATE TABLE `componente` (
  `principio` int(11) NOT NULL,
  `medicamento` int(11) NOT NULL,
  `concentracion` varchar(30) NOT NULL,
  `vigente` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `componente`
--

INSERT INTO `componente` (`principio`, `medicamento`, `concentracion`, `vigente`) VALUES
(1, 2, '250', 1),
(2, 2, '150', 1),
(1, 3, '250', 1),
(1, 4, '250', 1),
(2, 4, '100', 1),
(3, 4, '25', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `vigente` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`codigo`, `nombre`, `vigente`) VALUES
(1, 'Mi Farma', 1),
(2, 'Scientia', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

CREATE TABLE `medicamento` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `precio` double NOT NULL,
  `laboratorio` int(11) NOT NULL,
  `vigente` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `medicamento`
--

INSERT INTO `medicamento` (`codigo`, `nombre`, `precio`, `laboratorio`, `vigente`) VALUES
(1, 'Kitadol', 2, 1, 1),
(2, 'Kitadol', 15, 2, 1),
(3, 'Migrax', 1, 2, 1),
(4, 'Bio Electro', 3, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `principioactivo`
--

CREATE TABLE `principioactivo` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `vigente` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `principioactivo`
--

INSERT INTO `principioactivo` (`codigo`, `nombre`, `descripcion`, `vigente`) VALUES
(1, 'Paracetamol', 'Puro', 1),
(2, 'Cafeína', '--', 1),
(3, 'Ácido Acetilsalicílico', '100%', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `componente`
--
ALTER TABLE `componente`
  ADD PRIMARY KEY (`medicamento`,`principio`),
  ADD KEY `FK_Componente_PrincipioActivo` (`principio`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FK_Medicamento_Laboratorio` (`laboratorio`);

--
-- Indices de la tabla `principioactivo`
--
ALTER TABLE `principioactivo`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `principioactivo`
--
ALTER TABLE `principioactivo`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `componente`
--
ALTER TABLE `componente`
  ADD CONSTRAINT `FK_Componente_Medicamento` FOREIGN KEY (`medicamento`) REFERENCES `medicamento` (`codigo`),
  ADD CONSTRAINT `FK_Componente_PrincipioActivo` FOREIGN KEY (`principio`) REFERENCES `principioactivo` (`codigo`);

--
-- Filtros para la tabla `medicamento`
--
ALTER TABLE `medicamento`
  ADD CONSTRAINT `FK_Medicamento_Laboratorio` FOREIGN KEY (`laboratorio`) REFERENCES `laboratorio` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
