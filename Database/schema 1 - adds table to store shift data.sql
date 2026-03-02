CREATE TABLE `Shift`(
    `shift_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `staff_id_fk` CHAR(6) NOT NULL COMMENT 'references \'fk_user_id\' of Staff table',
    `start_time` TIMESTAMP NOT NULL,
    `end_time` TIMESTAMP NOT NULL,
    `total_time` TIME NOT NULL COMMENT 'does not factor in the lunch_break time',
    `lunch_break` TIME NOT NULL COMMENT 'the amount of time taken for break, not the specific start and end times of the break'
);
ALTER TABLE
    `Shift` ADD CONSTRAINT `shift_staff_id_fk_foreign` FOREIGN KEY(`staff_id_fk`) REFERENCES `Staff`(`fk_user_id`);