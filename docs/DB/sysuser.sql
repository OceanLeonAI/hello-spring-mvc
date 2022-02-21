CREATE TABLE `sysuser`
(
    `id`         varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `username`   varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `usercode`   varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `password`   varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `sex`        varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `createdate` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `isvalid`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `isstop`     varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `organid`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;