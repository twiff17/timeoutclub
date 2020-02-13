-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.19 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table timeoutclub.game: ~0 rows (approximately)
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` (`id`, `competitor`, `scored`, `conceded`, `date`) VALUES
	(1, 'Red Bisons', 8, 3, '2020-02-10');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;

-- Dumping data for table timeoutclub.game_events: ~2 rows (approximately)
/*!40000 ALTER TABLE `game_events` DISABLE KEYS */;
INSERT INTO `game_events` (`id`, `type`, `player_id`, `game_id`) VALUES
	(1, 'GOAL', 3, 1),
	(2, 'GOAL', 3, 1),
	(3, 'ASSIST', 2, 1);
/*!40000 ALTER TABLE `game_events` ENABLE KEYS */;

-- Dumping data for table timeoutclub.hibernate_sequence: ~0 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(4);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping data for table timeoutclub.player: ~5 rows (approximately)
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` (`id`, `name`) VALUES
	(3, 'Alexandr Svirid'),
	(1, 'Boris Dusenok'),
	(6, 'Denis Lobko'),
	(4, 'Kolya Zheltov'),
	(8, 'Sergey Nabokin'),
	(5, 'Sergey Zelenko'),
	(2, 'Zhenya Minchuk');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
