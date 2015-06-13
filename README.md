# Project "Auto Totaal Dienst"
*JSP/Java Code Auto Totaal Dienst*

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/MartijnDevNull/Thema-Opdracht-Web?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=body_badge) [![Build Status](https://travis-ci.org/MartijnDevNull/Thema-Opdracht-Web.svg?branch=master)](https://travis-ci.org/MartijnDevNull/Thema-Opdracht-Web)

![alt tag](https://i.imgur.com/O7eExDz.png)

# Geting the code
`git clone https://github.com/MartijnDevNull/Thema-Opdracht-Web.git`

Or use [EGIT](https://eclipse.org/egit/) to import the project

# Install
First make a new database using the given [example database](ATD-WEBSITE/setup/autototaaldienst.sql) or create a new one using the following statements:

```
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS `Auto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Kenteken` text NOT NULL,
  `Merk` text NOT NULL,
  `Type` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

CREATE TABLE IF NOT EXISTS `Berichten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Bericht` text NOT NULL,
  `Tijd` text NOT NULL,
  `User` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=68 ;


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

CREATE TABLE IF NOT EXISTS `Log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IP` text NOT NULL,
  `Tijd` text NOT NULL,
  `User` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=66 ;


CREATE TABLE IF NOT EXISTS `Onderdeel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Naam` text NOT NULL,
  `Type` text NOT NULL,
  `Voorraad` int(11) NOT NULL,
  `Prijs` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;


CREATE TABLE IF NOT EXISTS `Privileges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` text NOT NULL,
  `ADMIN` tinyint(1) NOT NULL,
  `VOORRAAD` tinyint(1) NOT NULL,
  `WERKPLAATS` tinyint(1) NOT NULL,
  `PARKEERGARAGE` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;


CREATE TABLE IF NOT EXISTS `Users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` text NOT NULL,
  `naam` text NOT NULL,
  `priv` int(11) NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;
```

**Important for devs**

Use 

`git update-index --assume-unchanged ATD-WEBSITE/war/config/database.properties` 

to not upload database credentials

And check .project and .classpath builpaths for wrong Java SDK or libraries
