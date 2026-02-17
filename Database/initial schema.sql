CREATE TABLE `Staff`(
    `fk_user_id` CHAR(6) NOT NULL,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `position` VARCHAR(255) NOT NULL,
    `hourly_wage` DECIMAL(3, 2) NOT NULL,
    `account_password` VARCHAR(16) NOT NULL,
    PRIMARY KEY(`fk_user_id`)
);
ALTER TABLE
    `Staff` ADD UNIQUE `staff_account_password_unique`(`account_password`);
CREATE TABLE `Tools`(
    `tool_id_fk` VARCHAR(20) NOT NULL,
    `current_amount` BIGINT NOT NULL,
    `status` VARCHAR(20) NOT NULL COMMENT 'options: \"low\" or \"good\"',
    `supplier` VARCHAR(50) NULL,
    PRIMARY KEY(`tool_id_fk`)
);
CREATE TABLE `Ingredients`(
    `ingredient_id_fk` VARCHAR(20) NOT NULL,
    `current_amount` BIGINT NOT NULL,
    `min_amount` BIGINT NULL,
    `supplier` VARCHAR(50) NULL,
    PRIMARY KEY(`ingredient_id_fk`)
);
CREATE TABLE `Inventory`(
    `inventory_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `category_id (fk)` VARCHAR(20) NOT NULL COMMENT 'examples: \"Ingr00\" or \"Tool00\"',
    `bundle_cost` DECIMAL(4, 2) NOT NULL
);
CREATE TABLE `Menu`(
    `item_id` VARCHAR(50) NOT NULL,
    `customer_price` DECIMAL(2, 2) NOT NULL,
    `production_cost` DECIMAL(2, 2) NOT NULL,
    `fk_evaluation_id` VARCHAR(20) NOT NULL COMMENT 'options: \"day00,\" \"week00,\" \"month00\"',
    PRIMARY KEY(`item_id`)
);
CREATE TABLE `Table`(
    `table_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `waiter_id (fk)` VARCHAR(6) NOT NULL,
    `fk_evaluation_id` VARCHAR(20) NOT NULL COMMENT 'options: \"daily,\" \"weekly,\" \"monthly\"'
);
CREATE TABLE `WaitStaff`(
    `user_id_fk` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
);
CREATE TABLE `Day`(
    `evaluation_id_fk` VARCHAR(20) NOT NULL,
    `date` DATE NOT NULL,
    `day` VARCHAR(20) NOT NULL COMMENT 'day of the week',
    `order_frequency` BIGINT NOT NULL,
    PRIMARY KEY(`evaluation_id_fk`)
);
CREATE TABLE `Month`(
    `evaluation_id_fk` VARCHAR(20) NOT NULL,
    `month_start_date` DATE NOT NULL,
    `month_end_date` DATE NOT NULL,
    `order_submission_time` DECIMAL(3, 2) NOT NULL,
    `order_serve_time` DECIMAL(3, 2) NOT NULL,
    `table_clean_time` DECIMAL(3, 2) NOT NULL,
    PRIMARY KEY(`evaluation_id_fk`)
);
CREATE TABLE `Week`(
    `evaluation_id_fk` VARCHAR(20) NOT NULL,
    `week_start_date` DATE NOT NULL,
    `week_end_date` DATE NOT NULL,
    `order_submission_time` DECIMAL(3, 2) NOT NULL,
    `order_serve_time` DECIMAL(3, 2) NOT NULL,
    `table_clean_time` DECIMAL(3, 2) NOT NULL,
    PRIMARY KEY(`evaluation_id_fk`)
);
ALTER TABLE
    `Table` ADD CONSTRAINT `table_fk_evaluation_id_foreign` FOREIGN KEY(`fk_evaluation_id`) REFERENCES `Day`(`evaluation_id_fk`);
ALTER TABLE
    `Table` ADD CONSTRAINT `table_fk_evaluation_id_foreign` FOREIGN KEY(`fk_evaluation_id`) REFERENCES `Week`(`evaluation_id_fk`);
ALTER TABLE
    `Menu` ADD CONSTRAINT `menu_fk_evaluation_id_foreign` FOREIGN KEY(`fk_evaluation_id`) REFERENCES `Week`(`evaluation_id_fk`);
ALTER TABLE
    `Menu` ADD CONSTRAINT `menu_fk_evaluation_id_foreign` FOREIGN KEY(`fk_evaluation_id`) REFERENCES `Day`(`evaluation_id_fk`);
ALTER TABLE
    `Inventory` ADD CONSTRAINT `inventory_category_id (fk)_foreign` FOREIGN KEY(`category_id (fk)`) REFERENCES `Ingredients`(`ingredient_id_fk`);
ALTER TABLE
    `Table` ADD CONSTRAINT `table_waiter_id (fk)_foreign` FOREIGN KEY(`waiter_id (fk)`) REFERENCES `WaitStaff`(`user_id_fk`);
ALTER TABLE
    `Inventory` ADD CONSTRAINT `inventory_category_id (fk)_foreign` FOREIGN KEY(`category_id (fk)`) REFERENCES `Tools`(`tool_id_fk`);
ALTER TABLE
    `Menu` ADD CONSTRAINT `menu_fk_evaluation_id_foreign` FOREIGN KEY(`fk_evaluation_id`) REFERENCES `Month`(`evaluation_id_fk`);
ALTER TABLE
    `Table` ADD CONSTRAINT `table_fk_evaluation_id_foreign` FOREIGN KEY(`fk_evaluation_id`) REFERENCES `Month`(`evaluation_id_fk`);