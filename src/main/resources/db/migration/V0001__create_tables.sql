CREATE TABLE `tbl_user` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `email` VARCHAR(255),
    `username` VARCHAR(255),
    `name` VARCHAR(255),
    `user_active` INT,
    `password` VARCHAR(255),
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP
);

CREATE TABLE `tbl_category` (
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

CREATE TABLE `tbl_customer` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `uf` VARCHAR(255),
    `cpf` VARCHAR(255),
    `cep` VARCHAR(255),
    `name` VARCHAR(255),
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
    `shipping` DECIMAL(10, 2),
    `comments` TEXT,
    `status` INT,
    `customer_id` INT,
    `to_remove` INT,
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
    `discount` DECIMAL(10, 2),
    `delivery` INT,
    `brand_id` INT,
    `category_id` INT,
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP,
    FOREIGN KEY (`brand_id`) REFERENCES `tbl_brand`(`id`),
    FOREIGN KEY (`category_id`) REFERENCES `tbl_category`(`id`)
);

CREATE TABLE `tbl_item_order` (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `qtde_item` INT,
    `unit_price` DECIMAL(10, 2),
    `total_price` DECIMAL(10, 2),
    `order_id` INT,
    `product_id` INT,
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP,
    FOREIGN KEY (`order_id`) REFERENCES `tbl_order`(`id`),
    FOREIGN KEY (`product_id`) REFERENCES `tbl_product`(`id`)
);

INSERT INTO TBL_CATEGORY VALUES
(1, 'Moda Masculina', '2023-11-28', '2023-11-28'), 
(2, 'Moda Feminina', '2023-11-28', '2023-11-28'),
(3, 'Infantil', '2023-11-28', '2023-11-28'),
(4, 'Infanto Juvenil', '2023-11-28', '2023-11-28');

INSERT INTO TBL_BRAND VALUES
(1, 'Poko-lolo', 'img/brand/logo/01.png', '2023-11-28', '2023-11-28'),
(2, 'Bom Bocado', 'img/brand/logo/02.png', '2023-11-28', '2023-11-28'),
(3, 'Cheiro Bom', 'img/brand/logo/03.png', '2023-11-28', '2023-11-28'),
(4, 'Mi-Kel', 'img/brand/logo/04.png', '2023-11-28', '2023-11-28');

INSERT INTO TBL_CUSTOMER VALUES
(1, 'SP', '30890561869', '14056-150', 'Alexandre Guedes', 'aledguedes@gmail.com', '123456789', 278, 'Planalto Verde', 'Ribeirão Preto', 'Rua E JM Vasconcelos', 'casa', '1983-04-07', '2023-11-28', '2023-11-28'),
(2, 'SP', '402778098-19', '14056-150', 'Danielle Cristine Tenda Guedes', 'dani_helo@gmail.com', '123456789', 278, 'Planalto Verde', 'Ribeirão Preto', 'Rua E JM Vasconcelos', 'casa', '1991-05-15', '2023-11-28', '2023-11-28');

INSERT INTO TBL_PRODUCT VALUES
(1, 'Camisa Gola Polo', 'Camisa em algodão de ótima qualidade', 'products/1/polo_01.png', '95.00', '85.50', 1, 10, 1, 1, 1, '2023-11-28', '2023-11-28'),
(2, 'Vestido longo', 'Vestido longo', 'products/2/vestido_01.png', '75.00', '75.00', 1, 0, 1, 2, 2, '2023-11-28', '2023-11-28');
