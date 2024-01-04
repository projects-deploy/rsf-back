CREATE TABLE `tbl_user` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `email` VARCHAR(255),
    `username` VARCHAR(255),
    `name` VARCHAR(255),
    `link_photo` VARCHAR(255),
    `user_active` INT,
    `password` VARCHAR(255),
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP
);

CREATE TABLE `tbl_department` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP
);

CREATE TABLE `tbl_brand` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `link_photo` VARCHAR(255),
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP
);

CREATE TABLE `tbl_category` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP
);

CREATE TABLE `department_category` (
    `department_id` BIGINT,
    `category_id` BIGINT,
    PRIMARY KEY (`department_id`, `category_id`),
    FOREIGN KEY (`department_id`) REFERENCES `tbl_department` (`id`),
    FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`id`)
);

CREATE TABLE `tbl_customer` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `uf` VARCHAR(255),
    `cpf` VARCHAR(255),
    `cep` VARCHAR(255),
    `name` VARCHAR(255),
    `surname` VARCHAR(255),
    `email` VARCHAR(255),
    `phone` VARCHAR(255),
    `numero` VARCHAR(255),
    `bairro` VARCHAR(255),
    `localidade` VARCHAR(255),
    `logradouro` VARCHAR(255),
    `complemento` VARCHAR(255),
    `birth_date` TIMESTAMP,
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP
);

CREATE TABLE `tbl_order` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `date_order` TIMESTAMP,
    `value_total` DECIMAL(10, 2),
    `shipping` INT,
    `comments` TEXT,
    `status` INT,
    `payment` INT,
    `customer_id` INT,
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP,
    FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer`(`id`)
);

CREATE TABLE `tbl_product` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `detail` TEXT,
    `link_photo` VARCHAR(255),
    `price_product` DECIMAL(10, 2),
    `price_promo` DECIMAL(10, 2),
    `available` INT,
    `discount` INT,
    `delivery` INT,
    `in_stok` INT,
    `average_rating` DOUBLE DEFAULT 0.0,
    `review_count` INT DEFAULT 0,
    `product_size` TEXT,
    `product_colors` TEXT,
    `category_id` BIGINT,
    `department_id` BIGINT,
    `brand_id` INT,
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP,
    FOREIGN KEY (`category_id`) REFERENCES `tbl_category`(`id`),
    FOREIGN KEY (`department_id`) REFERENCES `tbl_department`(`id`),
    FOREIGN KEY (`brand_id`) REFERENCES `tbl_brand`(`id`)
);

CREATE TABLE `tbl_products_images` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `product_id` BIGINT,
    FOREIGN KEY (`product_id`) REFERENCES `tbl_product`(`id`)
);

CREATE TABLE `product_images` (
    `product_image_id` BIGINT,
    `images_url` VARCHAR(255),
    FOREIGN KEY (`product_image_id`) REFERENCES `tbl_products_images`(`id`)
);

CREATE TABLE `tbl_item_order` (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `qtde_item` INT,
    `unit_price` DECIMAL(10, 2),
    `amount` DECIMAL(10, 2),
    `order_id` INT,
    `product_id` INT,
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP,
    FOREIGN KEY (`order_id`) REFERENCES `tbl_order`(`id`),
    FOREIGN KEY (`product_id`) REFERENCES `tbl_product`(`id`)
);

CREATE TABLE `tbl_favorites` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `added_in` TIMESTAMP,
    `customer_id` BIGINT,
    `product_id` BIGINT,
    FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer`(`id`),
    FOREIGN KEY (`product_id`) REFERENCES `tbl_product`(`id`)
);

CREATE TABLE `tbl_menu_entity` (
    `id` SERIAL PRIMARY KEY,
    `categories` TEXT,
    `departments` TEXT
);

CREATE TABLE `tbl_review` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(255),
    `rating` INT,
    `comment` VARCHAR(255),
    `product_id` BIGINT,
    `customer_id` BIGINT,
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP,
    FOREIGN KEY (`product_id`) REFERENCES `tbl_product`(`id`),
    FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer`(`id`)
);


INSERT INTO tbl_menu_entity (id, categories, departments) VALUES (1, null, null);
