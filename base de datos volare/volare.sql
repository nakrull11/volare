-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-12-2018 a las 14:32:49
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `volare`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aerolinea`
--

CREATE TABLE `aerolinea` (
  `cuit_aerolinea` int(11) NOT NULL,
  `nombre_aerolinea` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aerolinea`
--

INSERT INTO `aerolinea` (`cuit_aerolinea`, `nombre_aerolinea`) VALUES
(176, 'Emirates'),
(12345, 'Latam');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aeropuerto`
--

CREATE TABLE `aeropuerto` (
  `id_aeropuerto` smallint(3) NOT NULL,
  `codigo_aeropuerto` varchar(3) NOT NULL,
  `id_ciudad` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aeropuerto`
--

INSERT INTO `aeropuerto` (`id_aeropuerto`, `codigo_aeropuerto`, `id_ciudad`) VALUES
(1, 'LUQ', 1),
(4, 'MDZ', 2),
(5, 'EZE', 3),
(6, 'COR', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asiento`
--

CREATE TABLE `asiento` (
  `id_asiento` int(11) NOT NULL,
  `numero_asiento` varchar(3) NOT NULL,
  `pasillo_asiento` bit(1) NOT NULL,
  `estado_asiento` bit(1) DEFAULT NULL,
  `id_avion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asiento`
--

INSERT INTO `asiento` (`id_asiento`, `numero_asiento`, `pasillo_asiento`, `estado_asiento`, `id_avion`) VALUES
(1, 'A45', b'0', b'0', 1),
(5, 'A46', b'0', b'0', 1),
(6, 'A47', b'0', b'0', 1),
(7, 'A48', b'0', b'0', 1),
(8, 'A49', b'0', b'0', 1),
(9, 'A50', b'0', b'0', 1),
(10, 'A51', b'0', b'0', 1),
(11, 'A52', b'0', b'0', 1),
(12, 'A45', b'0', b'0', 4),
(13, 'A46', b'0', b'0', 4),
(14, 'A47', b'0', b'0', 4),
(15, 'A48', b'0', b'0', 4),
(16, 'A49', b'0', b'0', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avion`
--

CREATE TABLE `avion` (
  `id_avion` int(11) NOT NULL,
  `modelo_avion` tinytext NOT NULL,
  `asiento_avion` int(11) NOT NULL,
  `cuit_aerolinea` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `avion`
--

INSERT INTO `avion` (`id_avion`, `modelo_avion`, `asiento_avion`, `cuit_aerolinea`) VALUES
(1, 'Boeing 747', 550, 12345),
(3, 'Airbus A320', 180, 12345),
(4, 'Boeing 737', 140, 176),
(5, 'Boeing 777', 365, 176);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `id_ciudad` smallint(6) NOT NULL,
  `nombre_ciudad` tinytext NOT NULL,
  `id_provincia` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`id_ciudad`, `nombre_ciudad`, `id_provincia`) VALUES
(1, 'San Luis', 1),
(2, 'La paz', 11),
(3, 'Mar del Plata', 12),
(4, 'Carlos Paz', 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL,
  `fecha_reserva` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estado_compra` varchar(15) NOT NULL,
  `id_vuelo` int(11) NOT NULL,
  `dni_pasajero` int(11) NOT NULL,
  `id_asiento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `id_pais` smallint(6) NOT NULL,
  `codigo_pais` varchar(2) NOT NULL,
  `nombre_pais` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id_pais`, `codigo_pais`, `nombre_pais`) VALUES
(1, 'AR', 'Argentina'),
(2, 'BR', 'Brasil'),
(4, 'PR', 'Paraguay'),
(5, 'CH', 'Chile');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajero`
--

CREATE TABLE `pasajero` (
  `dni_pasajero` int(11) NOT NULL,
  `pasaporte_pasajero` int(11) DEFAULT NULL,
  `correo_pasajero` varchar(255) NOT NULL,
  `nombre_pasajero` varchar(60) NOT NULL,
  `apellido_pasajero` varchar(40) NOT NULL,
  `fechanacimiento_pasajero` date NOT NULL,
  `password_pasajero` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pasajero`
--

INSERT INTO `pasajero` (`dni_pasajero`, `pasaporte_pasajero`, `correo_pasajero`, `nombre_pasajero`, `apellido_pasajero`, `fechanacimiento_pasajero`, `password_pasajero`) VALUES
(12345, NULL, 'admin', 'admin', 'admin', '2018-12-09', '1234'),
(123456, 0, 'mrodrig@gmail.com', 'martin', 'rodriguez', '1986-05-12', 'asd123'),
(4123654, 3781432, 'juanperez@gmail.com', 'juan', 'perez', '1975-03-22', 'password21'),
(18123165, NULL, 'gonzalesmartin@gmail.com', 'martin', 'gonzales', '1983-08-15', 'martincho20'),
(27784987, 0, 'dangonza@gmail.com', 'daniel', 'gonzales', '1986-02-23', 'dani19976'),
(35569987, 2223, 'aleramirez88@gmail.com', 'alejandra', 'ramirez', '1988-12-01', 'tobi1887'),
(35657789, 33256, 'gonzaro@gmail.com', 'gonzalo', 'rodriguez', '1984-02-03', 'gonzacapo92'),
(36395345, 0, 'rodricaceres@gmail.com', 'rodrigo', 'caceres', '1997-12-02', '1234password'),
(37723905, NULL, 'gusguz1994@gmail.com', 'Gustavo', 'Rivarola', '1994-03-21', 'pass1994'),
(38220411, NULL, 'micaelajquiroga@gmail.com', 'micaela', 'quiroga', '1996-02-01', 'quiroga333'),
(39990611, NULL, 'reybarbi1709', 'barbara', 'rey', '1997-04-12', 'barbarapass233'),
(43552172, 0, 'rctalquenca@live.com', 'rocio', 'talquenca', '2001-06-03', 'tanbionica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `id_provincia` smallint(6) NOT NULL,
  `nombre_provincia` tinytext NOT NULL,
  `id_pais` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`id_provincia`, `nombre_provincia`, `id_pais`) VALUES
(1, 'San Luis', 1),
(11, 'Mendoza', 1),
(12, 'Buenos Aires', 1),
(13, 'Cordoba', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE `vuelo` (
  `id_vuelo` int(11) NOT NULL,
  `precio_vuelo` float NOT NULL,
  `fechasalida_vuelo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fechallegada_vuelo` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `refuerzo_vuelo` bit(1) DEFAULT NULL,
  `estado_vuelo` varchar(15) NOT NULL,
  `id_aeropuerto_salida` smallint(6) NOT NULL,
  `id_aeropuerto_llegada` smallint(6) NOT NULL,
  `id_avion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vuelo`
--

INSERT INTO `vuelo` (`id_vuelo`, `precio_vuelo`, `fechasalida_vuelo`, `fechallegada_vuelo`, `refuerzo_vuelo`, `estado_vuelo`, `id_aeropuerto_salida`, `id_aeropuerto_llegada`, `id_avion`) VALUES
(1, 7500, '2018-12-15 20:45:56', '2018-12-16 13:00:00', NULL, 'normal', 1, 4, 1),
(2, 7500, '2018-12-15 20:58:56', '2018-12-16 19:00:00', NULL, 'normal', 1, 5, 1),
(3, 7500, '2018-12-15 20:58:08', '2018-12-17 19:00:00', NULL, 'normal', 1, 6, 1),
(4, 8500, '2018-12-17 05:40:39', '2018-12-19 13:00:00', b'0', 'normal', 1, 6, 4),
(5, 9500, '2018-12-17 06:00:24', '2018-12-19 16:00:00', b'0', 'normal', 5, 1, 4),
(6, 5200, '2018-12-17 06:00:24', '2018-12-19 16:00:00', b'0', 'normal', 4, 5, 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aerolinea`
--
ALTER TABLE `aerolinea`
  ADD PRIMARY KEY (`cuit_aerolinea`);

--
-- Indices de la tabla `aeropuerto`
--
ALTER TABLE `aeropuerto`
  ADD PRIMARY KEY (`id_aeropuerto`),
  ADD KEY `id_ciudad` (`id_ciudad`) USING BTREE;

--
-- Indices de la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD PRIMARY KEY (`id_asiento`),
  ADD KEY `id_avion` (`id_avion`) USING BTREE;

--
-- Indices de la tabla `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`id_avion`),
  ADD KEY `cuit_aerolinea` (`cuit_aerolinea`) USING BTREE;

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`id_ciudad`),
  ADD UNIQUE KEY `id_provincia` (`id_provincia`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id_compra`),
  ADD UNIQUE KEY `numero_asiento` (`id_asiento`) USING BTREE,
  ADD KEY `id_vuelo` (`id_vuelo`) USING BTREE,
  ADD KEY `numero_pasaporte` (`dni_pasajero`) USING BTREE;

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id_pais`);

--
-- Indices de la tabla `pasajero`
--
ALTER TABLE `pasajero`
  ADD PRIMARY KEY (`dni_pasajero`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`id_provincia`),
  ADD KEY `id_pais` (`id_pais`);

--
-- Indices de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`id_vuelo`) USING BTREE,
  ADD KEY `vuelo_ibfk_2` (`id_aeropuerto_llegada`),
  ADD KEY `vuelo_ibfk_3` (`id_avion`),
  ADD KEY `codigo_aeropuerto(_salida)` (`id_aeropuerto_salida`,`id_aeropuerto_llegada`,`id_avion`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aeropuerto`
--
ALTER TABLE `aeropuerto`
  MODIFY `id_aeropuerto` smallint(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `asiento`
--
ALTER TABLE `asiento`
  MODIFY `id_asiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `avion`
--
ALTER TABLE `avion`
  MODIFY `id_avion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `id_ciudad` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `id_compra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `id_pais` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `provincia`
--
ALTER TABLE `provincia`
  MODIFY `id_provincia` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  MODIFY `id_vuelo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aeropuerto`
--
ALTER TABLE `aeropuerto`
  ADD CONSTRAINT `aeropuerto_ibfk_1` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id_ciudad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD CONSTRAINT `asiento_ibfk_1` FOREIGN KEY (`id_avion`) REFERENCES `avion` (`id_avion`);

--
-- Filtros para la tabla `avion`
--
ALTER TABLE `avion`
  ADD CONSTRAINT `avion_ibfk_1` FOREIGN KEY (`cuit_aerolinea`) REFERENCES `aerolinea` (`cuit_aerolinea`);

--
-- Filtros para la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD CONSTRAINT `ciudad_ibfk_1` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`dni_pasajero`) REFERENCES `pasajero` (`dni_pasajero`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_vuelo`) REFERENCES `vuelo` (`id_vuelo`),
  ADD CONSTRAINT `compra_ibfk_3` FOREIGN KEY (`id_asiento`) REFERENCES `asiento` (`id_asiento`);

--
-- Filtros para la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD CONSTRAINT `provincia_ibfk_1` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD CONSTRAINT `vuelo_ibfk_1` FOREIGN KEY (`id_aeropuerto_salida`) REFERENCES `aeropuerto` (`id_aeropuerto`) ON UPDATE CASCADE,
  ADD CONSTRAINT `vuelo_ibfk_2` FOREIGN KEY (`id_aeropuerto_llegada`) REFERENCES `aeropuerto` (`id_aeropuerto`) ON UPDATE CASCADE,
  ADD CONSTRAINT `vuelo_ibfk_3` FOREIGN KEY (`id_avion`) REFERENCES `avion` (`id_avion`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
