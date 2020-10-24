-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : sam. 24 oct. 2020 à 15:29
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `senforage`
--

-- --------------------------------------------------------

--
-- Structure de la table `CLIENT`
--

CREATE TABLE `CLIENT` (
  `ID` int(11) NOT NULL,
  `ADRESSE` varchar(255) DEFAULT NULL,
  `NOMFAMILLE` varchar(255) DEFAULT NULL,
  `NUMTEL` varchar(255) DEFAULT NULL,
  `UTILISATEUR_IDUSER` varchar(255) DEFAULT NULL,
  `VILLAGE_IDVILLAGE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `CLIENT`
--

INSERT INTO `CLIENT` (`ID`, `ADRESSE`, `NOMFAMILLE`, `NUMTEL`, `UTILISATEUR_IDUSER`, `VILLAGE_IDVILLAGE`) VALUES
(1, 'malika villa', 'GADIAGA', '123456789', '773511003', 'malika100'),
(2, 'dieyenne', 'DIEYE', '987654321', '773511003', 'keurmor 200'),
(3, 'Ndiop', 'DIENE', '147896325', '773511003', 'taiba'),
(4, 'Ouakam', 'SAGNA', '1596321478', '773511003', 'taiba');

-- --------------------------------------------------------

--
-- Structure de la table `UTILISATEUR`
--

CREATE TABLE `UTILISATEUR` (
  `IDUSER` varchar(255) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `URLPHOTO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `UTILISATEUR`
--

INSERT INTO `UTILISATEUR` (`IDUSER`, `EMAIL`, `NOM`, `PASSWORD`, `PRENOM`, `URLPHOTO`) VALUES
('773511003', 'mor@gmail.com', 'DIOP', 'passer', 'Mor', 'public/img/mortaiba.png'),
('773881896', 'cheikh@gmail.com', 'MBOW', 'passer', 'Cheikh', 'public/img/cheikh.png');

-- --------------------------------------------------------

--
-- Structure de la table `VILLAGE`
--

CREATE TABLE `VILLAGE` (
  `IDVILLAGE` varchar(255) NOT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `UTILISATEUR_IDUSER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `VILLAGE`
--

INSERT INTO `VILLAGE` (`IDVILLAGE`, `NOM`, `UTILISATEUR_IDUSER`) VALUES
('keurmor 200', 'Keur Mor Ndiaye', '773511003'),
('malika100', 'Malika', '773881896'),
('taiba', 'Taiba Ndiaye', '773511003');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `CLIENT`
--
ALTER TABLE `CLIENT`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_CLIENT_UTILISATEUR_IDUSER` (`UTILISATEUR_IDUSER`),
  ADD KEY `FK_CLIENT_VILLAGE_IDVILLAGE` (`VILLAGE_IDVILLAGE`);

--
-- Index pour la table `UTILISATEUR`
--
ALTER TABLE `UTILISATEUR`
  ADD PRIMARY KEY (`IDUSER`);

--
-- Index pour la table `VILLAGE`
--
ALTER TABLE `VILLAGE`
  ADD PRIMARY KEY (`IDVILLAGE`),
  ADD KEY `FK_VILLAGE_UTILISATEUR_IDUSER` (`UTILISATEUR_IDUSER`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `CLIENT`
--
ALTER TABLE `CLIENT`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `CLIENT`
--
ALTER TABLE `CLIENT`
  ADD CONSTRAINT `FK_CLIENT_UTILISATEUR_IDUSER` FOREIGN KEY (`UTILISATEUR_IDUSER`) REFERENCES `UTILISATEUR` (`IDUSER`),
  ADD CONSTRAINT `FK_CLIENT_VILLAGE_IDVILLAGE` FOREIGN KEY (`VILLAGE_IDVILLAGE`) REFERENCES `VILLAGE` (`IDVILLAGE`);

--
-- Contraintes pour la table `VILLAGE`
--
ALTER TABLE `VILLAGE`
  ADD CONSTRAINT `FK_VILLAGE_UTILISATEUR_IDUSER` FOREIGN KEY (`UTILISATEUR_IDUSER`) REFERENCES `UTILISATEUR` (`IDUSER`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
