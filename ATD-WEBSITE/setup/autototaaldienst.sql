-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Genereertijd: 20 mei 2015 om 10:56
-- Serverversie: 5.5.43-0ubuntu0.14.04.1
-- PHP-versie: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `autototaaldienst`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Resevering`
--
CREATE TABLE IF NOT EXISTS `Reservering` (
  `id` int(11) NOT NULL,
  `aankomst` date NOT NULL,
  `vertrek` date NOT NULL,
  `klant_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
--
-- Tabelstructuur voor tabel `Auto`
--

CREATE TABLE IF NOT EXISTS `Auto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Kenteken` text NOT NULL,
  `Merk` text NOT NULL,
  `Type` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Gegevens worden uitgevoerd voor tabel `Auto`
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
(12, 'asd', 'a', 'asd');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Berichten`
--

CREATE TABLE IF NOT EXISTS `Berichten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Bericht` text NOT NULL,
  `Tijd` text NOT NULL,
  `User` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=68 ;

--
-- Gegevens worden uitgevoerd voor tabel `Berichten`
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
(66, '&lt;script&gt;alert(1)&lt;/script&gt;', '2015-05-12 13:04:50', 10);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Klanten`
--

CREATE TABLE IF NOT EXISTS `Klanten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Password` text NOT NULL,
  `Username` text NOT NULL,
  `Volledigenaam` text NOT NULL,
  `Postcode` text NOT NULL,
  `Email` text NOT NULL,
  `Auto` int(11) NOT NULL,
  `Priv` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Gegevens worden uitgevoerd voor tabel `Klanten`
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
(14, '688787d8ff144c502c7f5cffaafe2cc588d86079f9de88304c26b0cb99ce91c6', 'asd', 'sd', 'das', 'm.balsmeer@gmail.com', 0, 3);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Log`
--

CREATE TABLE IF NOT EXISTS `Log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IP` text NOT NULL,
  `Tijd` text NOT NULL,
  `User` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=66 ;

--
-- Gegevens worden uitgevoerd voor tabel `Log`
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Naam` text NOT NULL,
  `Type` text NOT NULL,
  `Voorraad` int(11) NOT NULL,
  `Prijs` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Gegevens worden uitgevoerd voor tabel `Onderdeel`
--

INSERT INTO `Onderdeel` (`id`, `Naam`, `Type`, `Voorraad`, `Prijs`) VALUES
(1, 'Schakelbak', 'auto', 423423, 1234),
(2, 'Koppeling', 'intern', 12, 600.5),
(3, 'Voor ruit', '', 100, 43.22);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Privileges`
--

CREATE TABLE IF NOT EXISTS `Privileges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` text NOT NULL,
  `ADMIN` tinyint(1) NOT NULL,
  `VOORRAAD` tinyint(1) NOT NULL,
  `WERKPLAATS` tinyint(1) NOT NULL,
  `PARKEERGARAGE` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Gegevens worden uitgevoerd voor tabel `Privileges`
--

INSERT INTO `Privileges` (`id`, `naam`, `ADMIN`, `VOORRAAD`, `WERKPLAATS`, `PARKEERGARAGE`) VALUES
(1, 'Admin', 1, 1, 1, 1),
(2, 'Monteur', 0, 1, 1, 0),
(3, 'Klant', 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` text NOT NULL,
  `naam` text NOT NULL,
  `priv` int(11) NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Gegevens worden uitgevoerd voor tabel `Users`
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
(33, 'asd', '', 1, 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
