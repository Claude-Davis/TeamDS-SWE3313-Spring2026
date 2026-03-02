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
CREATE TABLE `WaitStaff`(
    `user_id_fk` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE `Inventory`(
    `inventory_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `fk_category_id` VARCHAR(20) NOT NULL -- 'examples: \"Ingr00\" or \"Tool00\"',
    `bundle_cost` DECIMAL(4, 2) NOT NULL
);
CREATE TABLE `Tools`(
    `tool_id_fk` VARCHAR(20) NOT NULL,
    `current_amount` BIGINT NOT NULL,
    `status` VARCHAR(20) NOT NULL -- 'options: \"low\" or \"good\"',
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

CREATE TABLE `Menu`(
    `item_id` VARCHAR(50) NOT NULL,
    `customer_price` DECIMAL(2, 2) NOT NULL,
    `production_cost` DECIMAL(2, 2) NOT NULL,
    `fk_evaluation_id` VARCHAR(20) NOT NULL -- 'options: \"day00,\" \"week00,\" \"month00\"',
    PRIMARY KEY(`item_id`)
);
CREATE TABLE `Table`(
    `table_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `waiter_id_fk` VARCHAR(6) NOT NULL,
    `fk_evaluation_id` VARCHAR(20) NOT NULL -- 'options: \"daily,\" \"weekly,\" \"monthly\"'
);

CREATE TABLE `DailyMenuData`(
    `evaluation_id_fk` VARCHAR(20) NOT NULL,
    `date` DATE NOT NULL,
    `day` VARCHAR(20) NOT NULL -- 'day of the week',
    `order_frequency` BIGINT NOT NULL,
    PRIMARY KEY(`evaluation_id_fk`)
);
CREATE TABLE `WeeklyMenuData`(
    `evaluation_id_fk` VARCHAR(20) NOT NULL,
    `order_frequency` BIGINT NOT NULL,
    `week_start_date` DATE NOT NULL,
    `week_end_date` DATE NOT NULL,
    PRIMARY KEY(`evaluation_id_fk`)
);
CREATE TABLE `MonthlyMenuData`(
    `evaluation_id_fk` VARCHAR(20) NOT NULL,
    `order_frequency` BIGINT NOT NULL,
    `month_start_date` DATE NOT NULL,
    `month_end_date` DATE NOT NULL,
    PRIMARY KEY(`evaluation_id_fk`)
);

CREATE TABLE `DailyTableData`(
    `evaluation_id_fk` VARCHAR(20) NOT NULL,
    `order_serve_time` TIME NOT NULL -- 'the amount of time it takes from when the customer gives their order to when they recieve their order',
    `order_submission_time` TIME NOT NULL -- 'the amount of time it takes from when the customer sits/the table becomes occupied to when the customer gives their order',
    `table_clean_time` TIME NOT NULL -- 'the amount of time from when the table is marked red/the customers leave to when the table is marked green/the table is deemed available for new customers',
    `date` DATE NOT NULL,
    `day` VARCHAR(20) NOT NULL -- 'day of the week',
    PRIMARY KEY(`evaluation_id_fk`)
);
CREATE TABLE `WeeklyTableData`(
    `evaluation_id_fk` VARCHAR(20) NOT NULL,
    `week_start_date` DATE NOT NULL,
    `week_end_date` DATE NOT NULL,
    `order_submission_time` TIME NOT NULL,
    `order_serve_time` TIME NOT NULL,
    `table_clean_time` TIME NOT NULL,
    PRIMARY KEY(`evaluation_id_fk`)
);
CREATE TABLE `MonthlyTableData`(
    `evaluation_id_fk` VARCHAR(20) NOT NULL,
    `month_start_date` DATE NOT NULL,
    `month_end_date` DATE NOT NULL,
    `order_submission_time` TIME NOT NULL,
    `order_serve_time` TIME NOT NULL,
    `table_clean_time` TIME NOT NULL,
    PRIMARY KEY(`evaluation_id_fk`)
);

ALTER TABLE
    `WaitStaff` ADD CONSTRAINT `waitstaff_user_id_fk_foreign` FOREIGN KEY(`user_id_fk`) REFERENCES `Staff`(`fk_user_id`);
ALTER TABLE
    `Table` ADD CONSTRAINT `table_waiter_id_fk_foreign` FOREIGN KEY(`waiter_id_fk`) REFERENCES `WaitStaff`(`user_id_fk`);
ALTER TABLE
    `Ingredients` ADD CONSTRAINT `ingredients_ingredient_id_fk_foreign` FOREIGN KEY(`ingredient_id_fk`) REFERENCES `Inventory`(`fk_category_id`);
ALTER TABLE
    `Tool` ADD CONSTRAINT `tools_tool_id_fk_foreign` FOREIGN KEY(`tool_id_fk`) REFERENCES `Inventory`(`fk_category_id`);
ALTER TABLE
    `DailyTableData` ADD CONSTRAINT `dailytabledata_evaluation_id_fk_foreign` FOREIGN KEY(`evaluation_id_fk`) REFERENCES `Table`(`fk_evaluation_id`);
ALTER TABLE
    `WeeklyTableData` ADD CONSTRAINT `weeklytabledata_evaluation_id_fk_foreign` FOREIGN KEY(`evaluation_id_fk`) REFERENCES `Table`(`fk_evaluation_id`);
ALTER TABLE
    `MonthlyTableData` ADD CONSTRAINT `monthlytabledata_evaluation_id_fk_foreign` FOREIGN KEY(`evaluation_id_fk`) REFERENCES `Table`(`fk_evaluation_id`);
ALTER TABLE
    `DailyMenuData` ADD CONSTRAINT `dailymenudata_evaluation_id_fk_foreign` FOREIGN KEY(`evaluation_id_fk`) REFERENCES `Menu`(`fk_evaluation_id`);
ALTER TABLE
    `WeeklyMenuData` ADD CONSTRAINT `week_evaluation_id_fk_foreign` FOREIGN KEY(`evaluation_id_fk`) REFERENCES `Menu`(`fk_evaluation_id`);
ALTER TABLE
    `MonthlyMenuData` ADD CONSTRAINT `month_evaluation_id_fk_foreign` FOREIGN KEY(`evaluation_id_fk`) REFERENCES `Menu`(`fk_evaluation_id`);