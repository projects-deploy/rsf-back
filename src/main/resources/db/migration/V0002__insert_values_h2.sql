INSERT INTO TBL_BRAND  (id, name, link_photo, created_at, updated_at) VALUES
(1, 'Nike', 'https://example.com/nike.jpg', '2023-12-14T12:00:00', '2023-12-14T12:00:00'),
(2, 'Adidas', 'https://example.com/adidas.jpg', '2023-12-14T12:10:00', '2023-12-14T12:10:00'),
(3, 'Puma', 'https://example.com/puma.jpg', '2023-12-14T12:20:00', '2023-12-14T12:20:00'),
(4, 'Reebok', 'https://example.com/reebok.jpg', '2023-12-14T12:30:00', '2023-12-14T12:30:00'),
(5, 'Under Armour', 'https://example.com/under_armour.jpg', '2023-12-14T12:40:00', '2023-12-14T12:40:00'),
(6, 'Converse', 'https://example.com/converse.jpg', '2023-12-14T12:50:00', '2023-12-14T12:50:00'),
(7, 'Vans', 'https://example.com/vans.jpg', '2023-12-14T13:00:00', '2023-12-14T13:00:00'),
(8, 'New Balance', 'https://example.com/new_balance.jpg', '2023-12-14T13:10:00', '2023-12-14T13:10:00'),
(9, 'Fila', 'https://example.com/fila.jpg', '2023-12-14T13:20:00', '2023-12-14T13:20:00'),
(10, 'ASICS', 'https://example.com/asics.jpg', '2023-12-14T13:30:00', '2023-12-14T13:30:00');

INSERT INTO tbl_department (id, name, created_at, updated_at) VALUES
(1, 'Women Clothing', '2023-12-14', '2023-12-14'),
(2, 'Men Clothing', '2023-12-14', '2023-12-14'),
(3, 'Kids Clothing', '2023-12-14', '2023-12-14'),
(4, 'Footwear', '2023-12-14', '2023-12-14'),
(5, 'Accessories', '2023-12-14', '2023-12-14'),
(6, 'Sports', '2023-12-14', '2023-12-14'),
(7, 'Electronics', '2023-12-14', '2023-12-14'),
(8, 'Home and Living', '2023-12-14', '2023-12-14'),
(9, 'Books', '2023-12-14', '2023-12-14'),
(10, 'Beauty', '2023-12-14', '2023-12-14');

INSERT INTO tbl_category (id, name, created_at, updated_at) VALUES
(1, 'Dresses', '2023-12-14', '2023-12-14'),
(2, 'T-shirts', '2023-12-14', '2023-12-14'),
(3, 'Jeans', '2023-12-14', '2023-12-14'),
(4, 'Sneakers', '2023-12-14', '2023-12-14'),
(5, 'Hats', '2023-12-14', '2023-12-14'),
(6, 'Running Shoes', '2023-12-14', '2023-12-14'),
(7, 'Smartphones', '2023-12-14', '2023-12-14'),
(8, 'Bedding', '2023-12-14', '2023-12-14'),
(9, 'Fiction', '2023-12-14', '2023-12-14'),
(10, 'Skincare', '2023-12-14', '2023-12-14'),
(11, 'Formal Shirts', '2023-12-14', '2023-12-14'),
(12, 'Shorts', '2023-12-14', '2023-12-14'),
(13, 'Jackets', '2023-12-14', '2023-12-14'),
(14, 'Sandals', '2023-12-14', '2023-12-14'),
(15, 'Watches', '2023-12-14', '2023-12-14'),
(16, 'Living Room Furniture', '2023-12-14', '2023-12-14'),
(17, 'Cookbooks', '2023-12-14', '2023-12-14'),
(18, 'Lamps', '2023-12-14', '2023-12-14'),
(19, 'Stationery', '2023-12-14', '2023-12-14'),
(20, 'Haircare', '2023-12-14', '2023-12-14'),
(21, 'Sweatshirts', '2023-12-14', '2023-12-14'),
(22, 'Headphones', '2023-12-14', '2023-12-14'),
(23, 'Backpacks', '2023-12-14', '2023-12-14');

INSERT INTO department_category (department_id, category_id) VALUES (1, 1), (1, 2), (1, 3);
INSERT INTO department_category (department_id, category_id) VALUES (2, 2), (2, 4), (2, 5);
INSERT INTO department_category (department_id, category_id) VALUES (3, 1), (3, 3), (3, 12);
INSERT INTO department_category (department_id, category_id) VALUES (4, 4), (4, 6), (4, 14);
INSERT INTO department_category (department_id, category_id) VALUES (5, 5), (5, 10), (5, 22);
INSERT INTO department_category (department_id, category_id) VALUES (6, 6), (6, 11), (6, 23);
INSERT INTO department_category (department_id, category_id) VALUES (7, 7), (7, 14), (7, 25);
INSERT INTO department_category (department_id, category_id) VALUES (8, 8), (8, 16), (8, 17);
INSERT INTO department_category (department_id, category_id) VALUES (9, 9), (9, 18), (9, 19);
INSERT INTO department_category (department_id, category_id) VALUES (10, 5), (10, 20), (10, 21);

--INSERT INTO tbl_product (id, name, detail, link_photo, price_product, price_promo, available, discount, delivery, in_stok, category_id, brand_id, created_at, updated_at)
--VALUES
--(1, 'Summer Dress', 'Stylish summer dress for women', 'https://example.com/summer_dress.jpg', 59.99, 49.99, 100, 10, 1, 50, 1, 1, '2023-12-14', '2023-12-14'),
--(2, 'Casual T-shirt', 'Comfortable casual t-shirt for men', 'https://example.com/casual_tshirt.jpg', 29.99, 25.99, 150, 5, 1, 100, 2, 2, '2023-12-14', '2023-12-14'),
--(3, 'Slim Fit Jeans', 'Slim fit jeans for a trendy look', 'https://example.com/slim_fit_jeans.jpg', 69.99, 59.99, 80, 15, 1, 30, 3, 3, '2023-12-14', '2023-12-14'),
--(4, 'Running Shoes', 'High-performance running shoes', 'https://example.com/running_shoes.jpg', 79.99, 69.99, 120, 10, 1, 60, 6, 1, '2023-12-14', '2023-12-14'),
--(5, 'Winter Jacket', 'Warm winter jacket for men', 'https://example.com/winter_jacket.jpg', 99.99, 89.99, 90, 15, 1, 40, 13, 2, '2023-12-14', '2023-12-14'),
--(6, 'Sneakers', 'Classic sneakers for everyday wear', 'https://example.com/sneakers.jpg', 49.99, 39.99, 110, 5, 1, 70, 4, 3, '2023-12-14', '2023-12-14'),
--(7, 'Short Sleeve Shirt', 'Casual short sleeve shirt for men', 'https://example.com/short_sleeve_shirt.jpg', 34.99, 29.99, 130, 10, 1, 80, 2, 4, '2023-12-14', '2023-12-14'),
--(8, 'Hiking Boots', 'Durable hiking boots for outdoor adventures', 'https://example.com/hiking_boots.jpg', 89.99, 79.99, 80, 10, 1, 40, 4, 5, '2023-12-14', '2023-12-14'),
--(9, 'Denim Shorts', 'Fashionable denim shorts for women', 'https://example.com/denim_shorts.jpg', 39.99, 34.99, 100, 5, 1, 60, 12, 6, '2023-12-14', '2023-12-14'),
--(10, 'Athletic Leggings', 'Comfortable athletic leggings for workouts', 'https://example.com/athletic_leggings.jpg', 29.99, 24.99, 120, 10, 1, 70, 6, 7, '2023-12-14', '2023-12-14'),
--(11, 'Smartphone Case', 'Protective case for smartphones', 'https://example.com/smartphone_case.jpg', 14.99, 9.99, 150, 35, 1, 90, 7, 8, '2023-12-14', '2023-12-14'),
--(12, 'Cozy Blanket', 'Soft and cozy blanket for home', 'https://example.com/cozy_blanket.jpg', 49.99, 44.99, 80, 10, 1, 50, 16, 9, '2023-12-14', '2023-12-14'),
--(13, 'Mystery Novel', 'Bestselling mystery novel', 'https://example.com/mystery_novel.jpg', 19.99, 15.99, 100, 20, 1, 80, 9, 10, '2023-12-14', '2023-12-14'),
--(14, 'Summer Hat', 'Stylish summer hat for women', 'https://example.com/summer_hat.jpg', 24.99, 19.99, 120, 20, 1, 60, 5, 5, '2023-12-14', '2023-12-14'),
--(15, 'Running Shorts', 'Breathable running shorts for men', 'https://example.com/running_shorts.jpg', 29.99, 24.99, 100, 10, 1, 70, 12, 6, '2023-12-14', '2023-12-14'),
--(16, 'Leather Jacket', 'Classic leather jacket for a timeless look', 'https://example.com/leather_jacket.jpg', 129.99, 119.99, 70, 15, 1, 30, 13, 2, '2023-12-14', '2023-12-14'),
--(17, 'Sweatpants', 'Comfortable sweatpants for lounging', 'https://example.com/sweatpants.jpg', 39.99, 34.99, 110, 10, 1, 80, 11, 3, '2023-12-14', '2023-12-14'),
--(18, 'Backpack', 'Durable and spacious backpack for daily use', 'https://example.com/backpack.jpg', 59.99, 49.99, 90, 15, 1, 50, 23, 7, '2023-12-14', '2023-12-14'),
--(19, 'Wireless Earbuds', 'High-quality wireless earbuds for music lovers', 'https://example.com/earbuds.jpg', 79.99, 69.99, 80, 10, 1, 40, 22, 8, '2023-12-14', '2023-12-14'),
--(20, 'Running Jacket', 'Lightweight running jacket for all seasons', 'https://example.com/running_jacket.jpg', 79.99, 69.99, 100, 10, 1, 60, 4, 6, '2023-12-14', '2023-12-14'),
--(21, 'Graphic T-shirt', 'Cool graphic t-shirt for a trendy look', 'https://example.com/graphic_tshirt.jpg', 34.99, 29.99, 120, 15, 1, 70, 2, 1, '2023-12-14', '2023-12-14'),
--(22, 'Denim Jacket', 'Classic denim jacket for a versatile style', 'https://example.com/denim_jacket.jpg', 89.99, 79.99, 80, 10, 1, 80, 13, 2, '2023-12-14', '2023-12-14'),
--(23, 'Skater Shoes', 'Stylish skater shoes for casual wear', 'https://example.com/skater_shoes.jpg', 59.99, 49.99, 110, 5, 1, 90, 4, 4, '2023-12-14', '2023-12-14'),
--(24, 'Leather Wallet', 'Elegant leather wallet for men', 'https://example.com/leather_wallet.jpg', 49.99, 39.99, 130, 10, 1, 40, 5, 5, '2023-12-14', '2023-12-14'),
--(25, 'Smartwatch', 'Feature-rich smartwatch for tech enthusiasts', 'https://example.com/smartwatch.jpg', 129.99, 119.99, 90, 15, 1, 50, 16, 9, '2023-12-14', '2023-12-14'),
--(26, 'Summer Sandals', 'Comfortable sandals for a day at the beach', 'https://example.com/summer_sandals.jpg', 39.99, 34.99, 100, 10, 1, 60, 14, 4, '2023-12-14', '2023-12-14'),
--(27, 'Winter Scarf', 'Warm winter scarf for cold days', 'https://example.com/winter_scarf.jpg', 19.99, 15.99, 120, 15, 1, 70, 5, 5, '2023-12-14', '2023-12-14'),
--(28, 'Fitness Tracker', 'Track your fitness with this advanced tracker', 'https://example.com/fitness_tracker.jpg', 69.99, 59.99, 80, 10, 1, 80, 6, 7, '2023-12-14', '2023-12-14'),
--(29, 'Formal Blouse', 'Elegant formal blouse for women', 'https://example.com/formal_blouse.jpg', 49.99, 44.99, 110, 5, 1, 90, 1, 1, '2023-12-14', '2023-12-14'),
--(30, 'Baseball Cap', 'Classic baseball cap for a sporty look', 'https://example.com/baseball_cap.jpg', 24.99, 19.99, 130, 10, 1, 40, 5, 5, '2023-12-14', '2023-12-14'),
--(31, 'Wireless Speaker', 'Portable wireless speaker for music on the go', 'https://example.com/wireless_speaker.jpg', 89.99, 79.99, 90, 15, 1, 50, 7, 8, '2023-12-14', '2023-12-14'),
--(32, 'Printed Dress', 'Vibrant printed dress for a stylish look', 'https://example.com/printed_dress.jpg', 59.99, 49.99, 100, 10, 1, 60, 1, 1, '2023-12-14', '2023-12-14'),
--(33, 'Running Jacket', 'Water-resistant running jacket for outdoor activities', 'https://example.com/running_jacket2.jpg', 79.99, 69.99, 120, 15, 1, 70, 6, 6, '2023-12-14', '2023-12-14'),
--(34, 'Denim Skirt', 'Classic denim skirt for a casual yet chic style', 'https://example.com/denim_skirt.jpg', 34.99, 29.99, 90, 10, 1, 80, 1, 1, '2023-12-14', '2023-12-14'),
--(35, 'Hooded Sweatshirt', 'Cozy hooded sweatshirt for cold days', 'https://example.com/hooded_sweatshirt.jpg', 49.99, 39.99, 110, 5, 1, 90, 21, 7, '2023-12-14', '2023-12-14'),
--(36, 'Leather Belt', 'Stylish leather belt for men', 'https://example.com/leather_belt.jpg', 29.99, 24.99, 130, 10, 1, 40, 2, 5, '2023-12-14', '2023-12-14'),
--(37, 'Smart Home Camera', 'Keep an eye on your home with this smart camera', 'https://example.com/smart_camera.jpg', 129.99, 119.99, 100, 20, 1, 50, 8, 8, '2023-12-14', '2023-12-14'),
--(38, 'Summer Sunglasses', 'Trendy sunglasses for a cool summer look', 'https://example.com/summer_sunglasses.jpg', 19.99, 15.99, 80, 10, 1, 60, 5, 5, '2023-12-14', '2023-12-14');