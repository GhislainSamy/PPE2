-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 15 avr. 2019 à 10:59
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `urcroller`
--

-- --------------------------------------------------------

--
-- Structure de la table `adherent`
--

DROP TABLE IF EXISTS `adherent`;
CREATE TABLE IF NOT EXISTS `adherent` (
  `id_adherent` int(11) NOT NULL AUTO_INCREMENT,
  `sexe` varchar(1000) DEFAULT NULL,
  `nom` varchar(1000) DEFAULT NULL,
  `prenom` varchar(1000) DEFAULT NULL,
  `datenaiss` date DEFAULT NULL,
  `nationalite` varchar(1000) DEFAULT NULL,
  `telephone` int(100) DEFAULT NULL,
  `adresse` varchar(1000) DEFAULT NULL,
  `cp` int(100) DEFAULT NULL,
  `ville` varchar(1000) DEFAULT NULL,
  `email` varchar(1000) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `infosup` int(11) DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL,
  `dateajout` datetime DEFAULT NULL,
  PRIMARY KEY (`id_adherent`),
  KEY `infosup` (`infosup`),
  KEY `iduser` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adherent`
--

INSERT INTO `adherent` (`id_adherent`, `sexe`, `nom`, `prenom`, `datenaiss`, `nationalite`, `telephone`, `adresse`, `cp`, `ville`, `email`, `date_creation`, `infosup`, `iduser`, `dateajout`) VALUES
(72, 'Homme', 'titi', 'toto', '2014-06-01', 'Française', 600000000, '55 Rue Ferdinand Buisson', 91210, 'Draveil', 'tototiti@gmail.com', '2014-01-01 00:00:00', NULL, 8, '2019-04-13 23:11:33');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `titre`, `description`, `adresse`, `date_debut`, `date_fin`) VALUES
(9, 'Paris Rollers Marathon  l evenement du week end	', 'Ce week end decouvrez Paris et profitez des derniers rayons de soleil a l occasion du Paris Rollers Marathon.	', '55 Rue Ferdinand Buisson 91210 Draveil14', '2019-03-23', '2019-03-23'),
(10, 'CARIO JAM', 'Les bloodthirsty dolls (equipe de roller derby de Roanne) sont heureuses de vous presenter pour la premiere fois a domicile des matchs de roller derby.	', 'Gymnase Municipal Fontalon Rue Lucien Sampaix, 42300 Roanne', '2019-03-31', '2019-03-31'),
(11, 'TRIPLE HEADER AVIGNON', 'Les Rabbit Skulls Roller Derby Avignon organisent le dimanche 28 avril 2019 un triple header. Prix d\'entree : 3 euros. Buvette et petite restauration maison sur place.	', 'Gymnase Jean Brunet 5-1 Rue Robert Schumann, 84000 Avignon	', '2019-04-28', '2019-04-28'),
(12, 'TRIPLE HEADER - VEUVES NOIRES', 'Les Veuves Noires et Les Croque-Morts presentent 3 matchs de Roller Derby le dimanche 28 avril a Mont-Saint-Aignan.	', 'Centre sportif des Coquets Rue du Dr Fleury, 76130 Mont-Saint-Aignan', '2019-04-28', '2019-04-28');

-- --------------------------------------------------------

--
-- Structure de la table `informationsup`
--

DROP TABLE IF EXISTS `informationsup`;
CREATE TABLE IF NOT EXISTS `informationsup` (
  `id_infosup` int(11) NOT NULL AUTO_INCREMENT,
  `type_mailing` varchar(100) NOT NULL,
  `accident` varchar(100) NOT NULL,
  `droitimage` varchar(100) NOT NULL,
  `infocomplem` varchar(100) NOT NULL,
  `assurance` varchar(100) NOT NULL,
  `optionassurance` int(11) NOT NULL,
  `type_paiement` int(11) NOT NULL,
  `niveau_technique` varchar(100) NOT NULL,
  `date_creation` datetime NOT NULL,
  `demande_facture` varchar(100) NOT NULL,
  `pass_jeune` varchar(100) NOT NULL,
  `dossier_complet` varchar(100) NOT NULL,
  `dateajout` datetime DEFAULT NULL,
  PRIMARY KEY (`id_infosup`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `migration_versions`
--

DROP TABLE IF EXISTS `migration_versions`;
CREATE TABLE IF NOT EXISTS `migration_versions` (
  `version` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `migration_versions`
--

INSERT INTO `migration_versions` (`version`) VALUES
('20190122125132'),
('20190129160237'),
('20190129161603');

-- --------------------------------------------------------

--
-- Structure de la table `participer`
--

DROP TABLE IF EXISTS `participer`;
CREATE TABLE IF NOT EXISTS `participer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) DEFAULT NULL,
  `idevenement` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `participer_ibfk_1` (`idevenement`),
  KEY `participer_ibfk_2` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roles` json NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telephone` int(11) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `adresse` varchar(38) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ville` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cp` int(11) DEFAULT NULL,
  `dateajout` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_8D93D649F85E0677` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `roles`, `password`, `telephone`, `email`, `adresse`, `ville`, `cp`, `dateajout`) VALUES
(2, 'a', '[\"ROLE_USER\"]', '$2y$13$s3cZQrYyXR6w40Aj3kX1WuRUXFYpd44Y5tyVtzqC9R4/YlGVdohKy', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'b', '[\"ROLE_ADMINISTRATEUR\"]', '$2y$13$s3cZQrYyXR6w40Aj3kX1WuRUXFYpd44Y5tyVtzqC9R4/YlGVdohKy', NULL, NULL, NULL, NULL, NULL, NULL),
(7, 'Admin', '[\"ROLE_ADMINISTRATEUR\"]', '$2y$13$ui1KSzxYt/rlD5svYVN81Oxt5W3riztiSGAibalD7QWgTL5ivQ2gW', 600000000, 'admin@urcdraveil.com', '55 rue ferdinand buisson', 'Draveil', 91210, '2019-04-13 23:03:08'),
(8, 'User', '[\"ROLE_USER\"]', '$2y$13$WE/wVRCC3Lon/iL2Pw9SEedGsxfk.cYRl6wqdTAE8pRzdzwDniBT2', 600000000, 'user@urcdraveil.com', '55 Rue Ferdinand Buisson', 'Draveil', 91210, '2019-04-13 23:05:31');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD CONSTRAINT `adherent_ibfk_1` FOREIGN KEY (`infosup`) REFERENCES `informationsup` (`id_infosup`),
  ADD CONSTRAINT `adherent_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `participer`
--
ALTER TABLE `participer`
  ADD CONSTRAINT `participer_ibfk_1` FOREIGN KEY (`idevenement`) REFERENCES `evenement` (`id`),
  ADD CONSTRAINT `participer_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
