-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Gegenereerd op: 20 jun 2015 om 18:02
-- Serverversie: 5.6.24
-- PHP-versie: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ATD`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Afspraken`
--

CREATE TABLE IF NOT EXISTS `Afspraken` (
  `id` int(11) NOT NULL,
  `Klant_ID` int(11) NOT NULL,
  `Monteur_ID` int(11) NOT NULL,
  `Auto_ID` int(11) NOT NULL,
  `Datum` date NOT NULL,
  `Omschrijving` text NOT NULL,
  `Status` varchar(50) NOT NULL DEFAULT 'NIEUW'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `Afspraken`
--

INSERT INTO `Afspraken` (`id`, `Klant_ID`, `Monteur_ID`, `Auto_ID`, `Datum`, `Omschrijving`, `Status`) VALUES
(1, 1, 1, 1, '2015-06-20', 'Deze auto moet gemaakt worden want hij is stuk duhhh..', 'INBEHANDELING'),
(2, 1, 20, 1, '2015-06-26', 'kgskrgnsrkngskrngksrngskrng', 'NIEUW'),
(3, 2, 20, 2, '2015-06-18', 'Dit is nog een omschrijving bla bla bla', 'NIEUW');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Auto`
--

CREATE TABLE IF NOT EXISTS `Auto` (
  `id` int(11) NOT NULL,
  `Kenteken` text NOT NULL,
  `Merk` text NOT NULL,
  `Type` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `Auto`
--

INSERT INTO `Auto` (`id`, `Kenteken`, `Merk`, `Type`) VALUES
(1, '12-32-32', 'Mercedes', 'AMG'),
(2, '20-12-12', 'Audi', 'Cabrio'),
(3, '23-12-42', 'Audi', 'Cabrio'),
(4, '12-21-31', 'LarpA', 'auto'),
(5, 'dqw', 'qwdqw', 'qd'),
(6, 'asds', 'asd', 'asd'),
(7, 'asd', 'asd', 'asd'),
(8, 'x', 'x', 'x'),
(9, 'asd', 'asd', 'asd'),
(10, 'asd', 'sd', 'asd'),
(11, 'a', 'a', 'a'),
(12, 'asd', 'a', 'asd'),
(13, '3453452345', 'audi', 'cabrio'),
(14, '1342-234-3', 'audi', 'cabrio');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Berichten`
--

CREATE TABLE IF NOT EXISTS `Berichten` (
  `id` int(11) NOT NULL,
  `Bericht` text NOT NULL,
  `Tijd` text NOT NULL,
  `User` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `Berichten`
--

INSERT INTO `Berichten` (`id`, `Bericht`, `Tijd`, `User`) VALUES
(21, 'yo', '2015-04-29 04:57:17', 20),
(24, 'jawel', '2015-04-29 04:58:43', 20),
(30, 'swag yolo', '2015-04-29 05:06:06', 21),
(51, 'Testing123', '2015-05-01 09:52:19', 10),
(52, 'Joepie tijd staat goed!', '2015-05-01 10:28:18', 10),
(53, 'Nog niet', '2015-05-01 10:29:52', 10),
(54, 'Volgende test', '2015-05-01 16:30:44', 10),
(60, 'testbericht', '2015-05-11 14:44:40', 10),
(63, 'bericht', '2015-05-11 14:51:30', 10),
(65, 'asdfs', '2015-05-11 15:02:03', 10),
(66, '&lt;script&gt;alert(1)&lt;/script&gt;', '2015-05-12 13:04:50', 10),
(68, 'test', '2015-05-27 09:45:38', 20),
(69, 'test', '2015-05-27 09:47:23', 20),
(70, 'tesr', '2015-05-27 09:48:07', 20),
(71, 'test34234', '2015-05-27 09:49:06', 20),
(72, 'klafadfsdfsdf', '2015-05-27 09:52:25', 20),
(73, 'sdfsadfadsfa', '2015-05-27 09:57:02', 20),
(74, 'etstestest', '2015-05-27 09:58:05', 20),
(75, 'fasdfasdfas', '2015-05-27 09:59:02', 20),
(76, 'test', '2015-05-27 10:00:24', 20),
(77, 'testset', '2015-05-27 10:02:34', 20),
(78, 'adfasdfasdfasdf', '2015-05-27 10:04:15', 20),
(79, 'adfasdfasdf', '2015-05-27 10:04:18', 20),
(80, 'adfasdfasdf', '2015-05-27 10:04:20', 20),
(81, 'asdfasdfasdf', '2015-05-27 10:05:44', 20),
(82, 'sadfsdafasdf', '2015-05-27 10:08:56', 20),
(83, 'asfdfsa', '2015-05-27 10:11:29', 20),
(84, 'dfasdfadsf', '2015-05-27 10:11:42', 20),
(85, 'tstetserser', '2015-05-27 10:12:27', 20),
(86, 'testestset', '2015-05-27 10:13:04', 20),
(87, 'asdfasdfasdf', '2015-05-27 10:13:44', 20),
(88, 'testsetset', '2015-05-27 10:14:51', 20),
(89, 'fasdfasdf', '2015-05-27 10:20:35', 20),
(90, 'testserser', '2015-05-27 10:23:20', 20),
(91, 'etsetserse', '2015-05-27 10:40:08', 20),
(93, 'test2', '2015-05-27 10:42:29', 20),
(94, 'testestset', '2015-06-03 11:32:39', 20),
(95, 'testestset', '2015-06-03 11:34:01', 20),
(96, 'test', '2015-06-18 13:22:04', 20);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `GebruiktOnderdeel`
--

CREATE TABLE IF NOT EXISTS `GebruiktOnderdeel` (
  `Afspraak_ID` int(11) NOT NULL,
  `Onderdeel_ID` int(11) NOT NULL,
  `aantal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `GebruiktOnderdeel`
--

INSERT INTO `GebruiktOnderdeel` (`Afspraak_ID`, `Onderdeel_ID`, `aantal`) VALUES
(2, 46, 50);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Klanten`
--

CREATE TABLE IF NOT EXISTS `Klanten` (
  `id` int(11) NOT NULL,
  `Password` text NOT NULL,
  `Username` text NOT NULL,
  `Volledigenaam` text NOT NULL,
  `Postcode` text NOT NULL,
  `Email` text NOT NULL,
  `Auto` int(11) NOT NULL,
  `Priv` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `Klanten`
--

INSERT INTO `Klanten` (`id`, `Password`, `Username`, `Volledigenaam`, `Postcode`, `Email`, `Auto`, `Priv`) VALUES
(1, 'pwd', 'martijn', 'Martijn Boers', '2803 BS', 'm@b.com', 1, 3),
(2, 'pwd', 'dirk', 'Dirkie Baas', '8203 LS', 'a@b.com', 1, 3),
(3, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8', 'klant', 'Klant 1 ', '20-12-32', 'me@you.com', 0, 3),
(4, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8', 'klant2', 'Klant nummer 2', '1283 LS', 'me@you.com', 0, 3),
(5, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8', 'cara', 'Cara de Slak', '2034 BS', 'cara@deslak.nl', 0, 3),
(6, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8', 'henkie', 'Henkie Sjek', '2834 BS', 'm.balsmeer@gmail.com', 0, 3),
(10, '2d711642b726b04401627ca9fbac32f5c8530fb1903cc4db02258717921a4881', 'x', 'x', 'x', 'm.balsmeer@gmail.com', 0, 3),
(11, '043a718774c572bd8a25adbeb1bfcd5c0256ae11cecf9f9c3f925d0e52beaf89', 's', 'ss', 's', 'm.balsmeer@gmail.com', 0, 3),
(12, '8254c329a92850f6d539dd376f4816ee2764517da5e0235514af433164480d7a', 'lk', 'lk', 'lk', 'm.balsmeer@gmail.com', 0, 3),
(13, '043a718774c572bd8a25adbeb1bfcd5c0256ae11cecf9f9c3f925d0e52beaf89', 'sucker', 's', 's', 'martijn.s.boers@gmail.com', 0, 3),
(14, '688787d8ff144c502c7f5cffaafe2cc588d86079f9de88304c26b0cb99ce91c6', 'asd', 'sd', 'das', 'm.balsmeer@gmail.com', 0, 3),
(15, 'a2b23cc05a376e1b0ff01e749c4866049303a367be3c9d8e8fa18f8fa69541de', 'klant12', 'jan', '1544TW', 'sgsfg@gmail.com', 0, 3),
(16, 'ae5deb822e0d71992900471a7199d0d95b8e7c9d05c40a8245a281fd2c1d6684', 'testuser', 'testuser', '152TW', 'klaas.foppen@gmail.com', 0, 3),
(18, 'klantklaas', 'klantklaas', 'klaas', '1541TW', 'klaas.foppen@gmail.com', 1, 3);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Log`
--

CREATE TABLE IF NOT EXISTS `Log` (
  `id` int(11) NOT NULL,
  `IP` text NOT NULL,
  `Tijd` text NOT NULL,
  `User` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `Log`
--

INSERT INTO `Log` (`id`, `IP`, `Tijd`, `User`) VALUES
(1, '127.0.0.1', '2015-04-21 19:45:19', 15),
(2, '127.0.0.1', '2015-04-21 23:30:50', 16),
(3, '127.0.0.1', '2015-04-22 11:33:41', 16),
(4, '127.0.0.1', '2015-04-22 11:46:38', 16),
(5, '127.0.0.1', '2015-04-22 11:51:23', 16),
(6, '127.0.0.1', '2015-04-22 11:55:49', 16),
(7, '127.0.0.1', '2015-04-22 11:56:50', 16),
(8, '127.0.0.1', '2015-04-22 11:59:05', 10),
(9, '127.0.0.1', '2015-04-22 12:58:47', 10),
(10, '127.0.0.1', '2015-04-22 13:40:08', 10),
(11, '127.0.0.1', '2015-04-22 13:54:03', 10),
(12, '127.0.0.1', '2015-04-22 13:54:27', 10),
(13, '127.0.0.1', '2015-04-22 14:28:30', 10),
(14, '127.0.0.1', '2015-04-22 18:07:03', 10),
(15, '127.0.0.1', '2015-04-22 18:07:43', 10),
(16, '127.0.0.1', '2015-04-22 18:19:23', 10),
(17, '127.0.0.1', '2015-04-22 18:19:46', 10),
(18, '127.0.0.1', '2015-04-22 18:20:14', 10),
(19, '127.0.0.1', '2015-04-22 18:21:33', 10),
(20, '127.0.0.1', '2015-04-22 23:35:33', 10),
(21, '127.0.0.1', '2015-04-22 23:35:42', 10),
(22, '127.0.0.1', '2015-04-22 23:35:59', 10),
(23, '127.0.0.1', '2015-04-23 10:02:04', 10),
(24, '127.0.0.1', '2015-04-23 10:02:11', 10),
(25, '127.0.0.1', '2015-04-23 10:02:45', 10),
(26, '127.0.0.1', '2015-04-23 10:49:50', 10),
(27, '127.0.0.1', '2015-04-29 09:33:05', 15),
(28, '127.0.0.1', '2015-04-29 10:10:42', 15),
(29, '173.245.53.219', '2015-04-29 04:45:53', 17),
(30, '173.245.53.219', '2015-04-29 04:50:28', 17),
(31, '173.245.53.219', '2015-04-29 04:50:51', 17),
(32, '173.245.53.163', '2015-04-29 04:55:20', 18),
(33, '173.245.53.163', '2015-04-29 04:55:34', 18),
(34, '173.245.53.163', '2015-04-29 04:55:44', 18),
(35, '173.245.53.198', '2015-04-29 04:56:05', 20),
(36, '173.245.53.219', '2015-04-29 04:57:53', 17),
(37, '173.245.53.198', '2015-04-29 05:01:53', 20),
(38, '141.101.104.232', '2015-04-29 05:05:53', 21),
(39, '141.101.105.59', '2015-04-29 05:10:42', 23),
(40, '173.245.53.219', '2015-04-29 05:13:59', 17),
(41, '0:0:0:0:0:0:0:1', '2015-04-29 11:22:42', 20),
(42, '0:0:0:0:0:0:0:1', '2015-04-29 11:22:44', 20),
(43, '0:0:0:0:0:0:0:1', '2015-04-29 11:22:43', 20),
(44, '0:0:0:0:0:0:0:1', '2015-04-29 11:27:05', 20),
(45, '0:0:0:0:0:0:0:1', '2015-04-29 11:29:07', 20),
(46, '0:0:0:0:0:0:0:1', '2015-04-29 11:29:08', 20),
(47, '0:0:0:0:0:0:0:1', '2015-04-29 11:32:07', 20),
(48, '0:0:0:0:0:0:0:1', '2015-04-29 11:40:50', 20),
(49, '0:0:0:0:0:0:0:1', '2015-04-29 11:44:17', 20),
(50, '0:0:0:0:0:0:0:1', '2015-04-29 11:44:46', 20),
(51, '0:0:0:0:0:0:0:1', '2015-04-29 11:54:23', 20),
(52, '0:0:0:0:0:0:0:1', '2015-04-29 11:59:44', 20),
(53, '141.101.75.95', '2015-04-29 06:20:13', 20),
(54, '141.101.81.207', '2015-04-29 06:21:14', 10),
(55, '173.245.53.219', '2015-04-29 07:14:13', 17),
(56, '173.245.53.219', '2015-04-30 03:40:43', 17),
(57, '173.245.53.163', '2015-04-30 05:50:53', 18),
(58, '173.245.53.219', '2015-04-30 05:51:05', 17),
(59, '173.245.53.186', '2015-04-30 05:52:26', 23),
(60, '173.245.53.74', '2015-05-01 08:05:20', 10),
(61, '173.245.53.74', '2015-05-01 09:52:05', 10),
(62, '173.245.53.74', '2015-05-01 10:07:11', 10),
(63, '173.245.53.74', '2015-05-01 16:30:38', 10),
(64, '173.245.53.157', '2015-05-04 13:39:59', 17),
(65, '173.245.53.74', '2015-05-08 11:25:18', 10);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Onderdeel`
--

CREATE TABLE IF NOT EXISTS `Onderdeel` (
  `id` int(11) NOT NULL,
  `Naam` text NOT NULL,
  `Type` text NOT NULL,
  `Voorraad` int(11) NOT NULL,
  `Prijs` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `Onderdeel`
--

INSERT INTO `Onderdeel` (`id`, `Naam`, `Type`, `Voorraad`, `Prijs`) VALUES
(46, 'Motor', 'auto', 1, 500),
(47, 'Raam', 'auto', 20, 4),
(48, 'test onderdeel', 'test', 50, 700),
(49, 'test ', 'test', 10, 900);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Privileges`
--

CREATE TABLE IF NOT EXISTS `Privileges` (
  `id` int(11) NOT NULL,
  `naam` text NOT NULL,
  `ADMIN` tinyint(1) NOT NULL,
  `VOORRAAD` tinyint(1) NOT NULL,
  `WERKPLAATS` tinyint(1) NOT NULL,
  `PARKEERGARAGE` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `Privileges`
--

INSERT INTO `Privileges` (`id`, `naam`, `ADMIN`, `VOORRAAD`, `WERKPLAATS`, `PARKEERGARAGE`) VALUES
(1, 'Admin', 1, 1, 1, 1),
(2, 'Monteur', 0, 1, 1, 0),
(3, 'Klant', 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Reservering`
--

CREATE TABLE IF NOT EXISTS `Reservering` (
  `id` int(11) NOT NULL,
  `aankomst` date NOT NULL,
  `vertrek` date NOT NULL,
  `klant_id` int(11) NOT NULL,
  `betaald` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `Reservering`
--

INSERT INTO `Reservering` (`id`, `aankomst`, `vertrek`, `klant_id`, `betaald`) VALUES
(49, '2015-06-23', '2015-06-23', 16, NULL),
(50, '2015-06-26', '2015-06-28', 16, NULL),
(51, '2015-06-30', '2015-07-24', 16, NULL),
(52, '2015-06-23', '2015-06-25', 16, NULL),
(60, '2015-06-18', '2015-06-27', 5, 1),
(61, '2015-06-23', '2015-06-30', 16, 1),
(62, '2015-06-18', '2015-06-30', 16, 1),
(63, '2015-06-30', '2015-07-02', 16, 1),
(64, '2015-06-27', '2015-06-30', 16, 0),
(65, '2015-06-16', '2015-06-30', 16, 0),
(66, '2015-06-19', '2015-06-30', 16, 0),
(67, '2015-06-25', '2015-06-30', 16, 0),
(68, '2015-06-19', '2015-06-24', 16, 0),
(69, '2015-06-23', '2015-06-30', 16, 0),
(70, '2015-06-23', '2015-06-30', 16, 0),
(71, '2015-06-30', '2015-07-30', 16, 0),
(72, '2015-06-28', '2015-06-30', 16, 0),
(73, '2015-06-28', '2015-06-30', 16, 0),
(74, '2015-06-28', '2015-06-30', 16, 0),
(75, '2015-06-28', '2015-06-30', 16, 0);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `id` int(11) NOT NULL,
  `username` text NOT NULL,
  `naam` text NOT NULL,
  `priv` int(11) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `Users`
--

INSERT INTO `Users` (`id`, `username`, `naam`, `priv`, `password`) VALUES
(9, 'enc', 'Mart ', 1, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8'),
(10, 'martijn', 'Martijn Boers', 1, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8'),
(11, 'dirk', 'Dirk ', 1, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8'),
(12, 'sjoerd', 'Sjoerd ''JeBoy'' Swaggerlicious', 1, '7c0abcfdba156373acb393045e70929e42c42d73b6ecbc51aecf595752b2705a'),
(13, 'Gebruiker', 'Henk Geb', 1, 'dc00c903852bb19eb250aeba05e534a6d211629d77d055033806b783bae09937'),
(14, 'henk', 'Gekke Henk', 1, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8'),
(15, 'ferdi', 'Ferdie SJon', 1, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8'),
(16, 'test', 'Tezt', 1, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8'),
(17, 'harry', 'Brede Harry', 1, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8'),
(18, 'mees', 'mees', 1, '2b347871c8149b7170bd173de8e75a23e32fa971bd949dd10818a02e9b8386d6'),
(19, 'leo', 'Leo', 1, 'a1159e9df3670d549d04524532629f5477ceb7deec9b45e47e8c009506ecb2c8'),
(20, 'klaas', 'klaas', 1, '6c399ee6a9c60eb1b2b269d5a6e0c166eee2a9cca6da4dc1c38fa274ec371f57'),
(21, 'henkie', 'tomas', 1, 'f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b'),
(22, 'dirk', 'Dirk', 1, '764e8ab23aba697ce8365352a91b8e3c57b8f6672c6873f7d9de17f254a31cce'),
(23, 'test100', 'test100', 1, '1c9829230647c7cdd03a4d27971a1a9c2df276e5e2b207f11eb37d7d0b0bb198'),
(24, 'jan', 'jan', 1, '6a0ac0fd972c325d6ca5512b67a5e0ad996c4a3e9b59971d125164e6d4db1a1c'),
(25, 'jan', 'jan', 1, '6a0ac0fd972c325d6ca5512b67a5e0ad996c4a3e9b59971d125164e6d4db1a1c'),
(26, 'kees', 'kees', 1, '159eea4303125de0a60fbce8d362778cfe915166d42de1339d9bc79523d9e9a8'),
(33, 'asd', '', 1, 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855'),
(34, 'connor', 'connor', 1, 'cc0b8a95a883bc0b5f64a536de42349e0ce0673918a3c446255ddc8354887140');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `Afspraken`
--
ALTER TABLE `Afspraken`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `Auto`
--
ALTER TABLE `Auto`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `Berichten`
--
ALTER TABLE `Berichten`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `Klanten`
--
ALTER TABLE `Klanten`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `Log`
--
ALTER TABLE `Log`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `Onderdeel`
--
ALTER TABLE `Onderdeel`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `Privileges`
--
ALTER TABLE `Privileges`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `Reservering`
--
ALTER TABLE `Reservering`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `Afspraken`
--
ALTER TABLE `Afspraken`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT voor een tabel `Auto`
--
ALTER TABLE `Auto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT voor een tabel `Berichten`
--
ALTER TABLE `Berichten`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=97;
--
-- AUTO_INCREMENT voor een tabel `Klanten`
--
ALTER TABLE `Klanten`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT voor een tabel `Log`
--
ALTER TABLE `Log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=66;
--
-- AUTO_INCREMENT voor een tabel `Onderdeel`
--
ALTER TABLE `Onderdeel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT voor een tabel `Privileges`
--
ALTER TABLE `Privileges`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT voor een tabel `Reservering`
--
ALTER TABLE `Reservering`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=76;
--
-- AUTO_INCREMENT voor een tabel `Users`
--
ALTER TABLE `Users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=35;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
