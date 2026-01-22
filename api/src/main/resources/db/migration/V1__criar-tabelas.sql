DROP TABLE IF EXISTS `casas`;
CREATE TABLE IF NOT EXISTS `casas` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nome` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

DROP TABLE IF EXISTS `alunos`;
CREATE TABLE IF NOT EXISTS `alunos` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `id_casa` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_casas_alunos` (`id_casa`),
    CONSTRAINT `FK_casas_alunos` FOREIGN KEY (`id_casa`) REFERENCES `casas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

DROP TABLE IF EXISTS `pontucaoes`;
CREATE TABLE IF NOT EXISTS `pontucaoes` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `pontos` int(11) NOT NULL,
    `id_casa` int(11) NOT NULL,
    `data` datetime NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_casas_pontuacoes` (`id_casa`),
    CONSTRAINT `FK_casas_pontuacoes` FOREIGN KEY (`id_casa`) REFERENCES `casas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

DROP TABLE IF EXISTS `presencas`;
CREATE TABLE IF NOT EXISTS `presencas` (
    `data` datetime NOT NULL,
    `id_aluno` int(11) NOT NULL,
    PRIMARY KEY (`data`,`id_aluno`),
    KEY `FK_alunos_presencas` (`id_aluno`),
    CONSTRAINT `FK_alunos_presencas` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
    `email` varchar(255) NOT NULL,
    `senha` varchar(255) NOT NULL,
    `id_aluno` int(11) NOT NULL,
    PRIMARY KEY (`email`),
    KEY `FK_alunos_usuarios` (`id_aluno`),
    CONSTRAINT `FK_alunos_usuarios` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;