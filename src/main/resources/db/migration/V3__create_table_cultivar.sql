CREATE TABLE `cultivar`
(
    `id`           bigint       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nomeFantasia` varchar(255),
    `nomeRegistro` varchar(255) NOT NULL,
    `pmsMedio` double,
    `plantasMetroLinear` double
);
