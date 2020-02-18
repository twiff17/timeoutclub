
-- Dumping structure for table timeoutclub.game
CREATE TABLE IF NOT EXISTS `game` (
  `id` int NOT NULL AUTO_INCREMENT,
  `competitor` varchar(50) NOT NULL DEFAULT '',
  `scored` int NOT NULL DEFAULT '0',
  `conceded` int NOT NULL DEFAULT '0',
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `player` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping structure for table timeoutclub.game_events
CREATE TABLE IF NOT EXISTS `game_events` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` enum('GOAL','ASSIST','YELLOW','RED') NOT NULL,
  `player_id` int NOT NULL,
  `game_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_game_events_player` (`player_id`),
  KEY `FK_game_events_game` (`game_id`),
  CONSTRAINT `FK_game_events_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_game_events_player` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;