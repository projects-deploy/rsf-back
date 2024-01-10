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
INSERT INTO department_category (department_id, category_id) VALUES (7, 7), (7, 14), (7, 2);
INSERT INTO department_category (department_id, category_id) VALUES (8, 8), (8, 16), (8, 17);
INSERT INTO department_category (department_id, category_id) VALUES (9, 9), (9, 18), (9, 19);
INSERT INTO department_category (department_id, category_id) VALUES (10, 5), (10, 20), (10, 21);

INSERT INTO TBL_CUSTOMER VALUES(1, 'SP', '308.905.618-69', '14056-150', 'Alexandre Guedes', 'aledguedes@gmail.com', '(16) 99304-4438', 278, 'Planalto Verde',  'Ribeirão Preto', 'Rua Escritor José Mauro de Vasconcelos', 'casa', '1983-04-07', '2023-12-19', '2023-12-19');

INSERT INTO tbl_product (id, name, detail, link_photo, price_product, price_promo, available, discount, delivery, in_stok, is_new, brand_id, category_id, department_id, created_at, updated_at)
VALUES
(1, 'Summer Dress', 'Stylish summer dress for women', 'https://5.imimg.com/data5/ANDROID/Default/2022/6/ZW/VF/UA/144923424/product-jpeg-500x500.jpg', 59.99, 49.99, 100, 00, 1, 50, FALSE, 1, 1, 1, '2023-12-14', '2023-12-14'),
(2, 'Casual T-shirt', 'Comfortable casual t-shirt for men', 'https://montink.s3.amazonaws.com/mockups/139328/Preto_854571.png', 29.99, 25.99, 150, 0, 1, 100, FALSE, 2, 2, 1, '2023-12-14', '2023-12-14'),
(3, 'Slim Fit Jeans', 'Slim fit jeans for a trendy look', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhyL-3KtYxjtIn1IUwuSNkBJ5HgOHDaq0m4w&usqp=CAU', 69.99, 59.99, 80, 05, 1, 30, FALSE, 3, 3, 1, '2023-12-14', '2023-12-14'),
(4, 'Running Shoes', 'High-performance running shoes', 'https://cdn.thewirecutter.com/wp-content/media/2021/10/running-shoes-2048px-3097.jpg', 79.99, 69.99, 120, 00, 1, 60, FALSE, 1, 6, 2, '2023-12-14', '2023-12-14'),
(5, 'Winter Jacket', 'Warm winter jacket for men', 'https://www.switchbacktravel.com/sites/default/files/image_fields/Best%20Of%20Gear%20Articles/Winter/Winter%20jackets/The%20North%20Face%20McMurdo%20Down%20Parka%20%28winter%20jacket%29.jpg', 99.99, 89.99, 90, 05, 1, 40, FALSE,  2,13, 2, '2023-12-14', '2023-12-14'),
(6, 'Sneakers', 'Classic sneakers for everyday wear', 'https://images.tcdn.com.br/img/img_prod/961720/tenis_sneaker_colorido_couro_conforto_twist_119_1_358673d5a6ed7032b740405cd841e424.jpg', 49.99, 39.99, 110, 0, 1, 70, FALSE, 3, 4, 2, '2023-12-14', '2023-12-14'),
(7, 'Short Sleeve Shirt', 'Casual short sleeve shirt for men', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRwi4ze2KDOxxp8oZhZwJj85ah2bRuNibDMQ&usqp=CAU', 34.99, 29.99, 130, 00, 1, 80, FALSE, 4, 2, 3, '2023-12-14', '2023-12-14'),
(8, 'Hiking Boots', 'Durable hiking boots for outdoor adventures', 'https://cdn.thewirecutter.com/wp-content/media/2023/03/hikingboots-2048px-2820.jpg', 89.99, 79.99, 80, 00, 1, 40, FALSE, 5, 4, 3, '2023-12-14', '2023-12-14'),
(9, 'Denim Shorts', 'Fashionable denim shorts for women', 'https://cdn-images.farfetch-contents.com/14/16/01/84/14160184_18904041_600.jpg', 39.99, 34.99, 100, 0, 1, 60, FALSE,  6,12, 3, '2023-12-14', '2023-12-14'),
(10, 'Athletic Leggings', 'Comfortable athletic leggings for workouts', 'https://static.wixstatic.com/media/80d4bf_f453d9b183544c61900166f24768df7c~mv2.webp', 29.99, 24.99, 120, 00, 1, 70, FALSE, 7, 6, 4, '2023-12-14', '2023-12-14'),
(11, 'Shorts Man', 'Protective case for smartphones', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMwqsP3NJA6d3rLKdoepgCnTSlqWrAcfJ8Og&usqp=CAU', 14.99, 9.99, 150, 05, 1, 90, FALSE, 8, 7, 4, '2023-12-14', '2023-12-14'),
(12, 'Cozy Blanket', 'Soft and cozy blanket for home', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-6xA3rtq5BJ5TN_pWDRR_l_Vs-YG88cSYow&usqp=CAU', 49.99, 44.99, 80, 00, 1, 50, FALSE,  9,16, 4, '2023-12-14', '2023-12-14'),
(13, 'Summer Hat Woman', 'Bestselling mystery novel', 'https://media.glamourmagazine.co.uk/photos/62a06c0af321fea9799cfd4b/1:1/w_773,h_773,c_limit/SUN%20HATS%20080622%20SQUARE.jpg', 19.99, 15.99, 100, 00, 1, 80, FALSE, 10, 9, 5, '2023-12-14', '2023-12-14'),
(14, 'Summer Hat Man', 'Stylish summer hat for women', 'https://i.etsystatic.com/11251143/r/il/ceeac6/3646493794/il_570xN.3646493794_p4uj.jpg', 24.99, 19.99, 120, 00, 1, 60, FALSE, 5, 5, 5, '2023-12-14', '2023-12-14'),
(15, 'Running Shorts', 'Breathable running shorts for men', 'https://images.ctfassets.net/hnk2vsx53n6l/2CtlwNBk5agQwmn7Yl5WO1/133d360fdce9a0288ccd761c10cf16f9/zpe2kyg0id6nkacgiatx.png?fm=webp', 29.99, 24.99, 100, 00, 1, 70, FALSE,  6,12, 5, '2023-12-14', '2023-12-14'),
(16, 'Leather Jacket', 'Classic leather jacket for a timeless look', 'https://specials-images.forbesimg.com/imageserve/653922bb2f1b53d85a377cdd/Schott-s-Waxed-Natural-Pebbled-Cowhide-Cafe-Leather-Jacket/960x0.jpg?fit=scale', 129.99, 119.99, 70, 05, 1, 30, FALSE,  2,13, 6, '2023-12-14', '2023-12-14'),
(17, 'Sweatpants', 'Comfortable sweatpants for lounging', 'https://cdn11.bigcommerce.com/s-233ct/images/stencil/500x659/products/291/5435/SWEATPANT_BLACK_WEB_PANTS_STOREVIEW_NEW__47681.1638316640.jpg?c=2', 39.99, 34.99, 110, 00, 1, 80, FALSE,  3,11, 6, '2023-12-14', '2023-12-14'),
(18, 'Backpack', 'Durable and spacious backpack for daily use', 'https://target.scene7.com/is/image/Target/GUEST_7c141190-46d8-4ee7-8ccc-ef10e69140a8?wid=488&hei=488&fmt=pjpeg', 59.99, 49.99, 90, 05, 1, 50, FALSE,  7,23, 6, '2023-12-14', '2023-12-14'),
(19, 'Wireless Earbuds', 'High-quality wireless earbuds for music lovers', 'https://rigouts.co.uk/cdn/shop/products/jd_453866_a_e009ba84-e66e-40d7-8467-5034d1f62639_800x.jpg?v=1637418662', 79.99, 69.99, 80, 00, 1, 40, FALSE,  8,22, 7, '2023-12-14', '2023-12-14'),
(20, 'Running Jacket', 'Lightweight running jacket for all seasons', 'https://hips.hearstapps.com/hmg-prod/images/run-womens-runningjackets-1638895544.jpg?crop=0.502xw:1.00xh;0.250xw,0&resize=640:*', 79.99, 69.99, 100, 00, 1, 60, FALSE, 6, 4, 7, '2023-12-14', '2023-12-14'),
(21, 'Graphic T-shirt', 'Cool graphic t-shirt for a trendy look', 'https://assets.adidas.com/images/w_600,f_auto,q_auto/dd9e94ec40da47cba2d52cdf1474789b_9366/FB_GRAPHIC_TEE_Preto_IT8183_HM1.jpg', 34.99, 29.99, 120, 05, 1, 70, FALSE, 1, 2, 7, '2023-12-14', '2023-12-14'),
(22, 'Denim Jacket', 'Classic denim jacket for a versatile style', 'https://thursdayboots.com/cdn/shop/products/1024x1024-Mens-Jackets-Denim-Trucker-WashedIndigo-010423-1.jpg?v=1673282143', 89.99, 79.99, 80, 00, 1, 80, FALSE,  2,13, 7, '2023-12-14', '2023-12-14'),
(23, 'Skater Shoes', 'Stylish skater shoes for casual wear', 'https://blakelyclothing.com/cdn/shop/products/Vancouver1D_grande.jpg?v=1626638952', 59.99, 49.99, 110, 0, 1, 90, FALSE, 4, 4, 8, '2023-12-14', '2023-12-14'),
(24, 'Leather Wallet', 'Elegant leather wallet for men', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ179r2b7_homHNHmrO-o3Y6gpfKLilloxqmQ&usqp=CAU', 49.99, 39.99, 130, 00, 1, 40, FALSE, 5, 5, 8, '2023-12-14', '2023-12-14'),
(25, 'Smartwatch', 'Feature-rich smartwatch for tech enthusiasts', 'https://images.tcdn.com.br/img/img_prod/892439/casaco_jaqueta_jeans_c_silk_floral_costas_1895_1_b94fdb4cfca4fcb81673131d8cab2d74.jpg', 129.99, 119.99, 90, 05, 1, 50, FALSE,  9,16, 8, '2023-12-14', '2023-12-14'),
(26, 'Summer Sandals', 'Comfortable sandals for a day at the beach', 'https://cdn.media.amplience.net/i/clarks/ss20-journal__img-summer-sandals-guide-1-wk25?w=874&fmt=auto', 39.99, 34.99, 100, 00, 1, 60, FALSE,  4,14, 9, '2023-12-14', '2023-12-14'),
(27, 'Winter Scarf', 'Warm winter scarf for cold days', 'https://img.huffingtonpost.com/asset/61ddc3fe20000025688d6d81.jpg?cache=1fNyqyyKVv&ops=scalefit_720_noupscale', 19.99, 15.99, 120, 05, 1, 70, FALSE, 5, 5, 9, '2023-12-14', '2023-12-14'),
(28, 'Fitness Tracker', 'Track your fitness with this advanced tracker', 'https://i5.walmartimages.com/asr/abc6938f-8acb-4244-89ff-1e4b28ac7ceb.bb8184e1ecbecf3c3103952dc52af24f.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF', 69.99, 59.99, 80, 00, 1, 80, FALSE, 7, 6, 9, '2023-12-14', '2023-12-14'),
(29, 'Formal Blouse', 'Elegant formal blouse for women', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaObFhc5K2Tf60pqzWoa-hVturTrEZWC5Ngw&usqp=CAU', 49.99, 44.99, 110, 0, 1, 90, FALSE, 1, 1, 10, '2023-12-14', '2023-12-14'),
(30, 'Baseball Cap', 'Classic baseball cap for a sporty look', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqbL7YTayxZ4t82UfcdDxNQphsqzrVDutkPg&usqp=CAU', 24.99, 19.99, 130, 00, 1, 40, FALSE, 5, 5, 10, '2023-12-14', '2023-12-14'),
(31, 'Wireless Speaker', 'Portable wireless speaker for music on the go', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLpXiPc6oKp3squ5vQ3U9ie-5MkZgpJQOhXQ&usqp=CAU', 89.99, 79.99, 90, 05, 1, 50, FALSE, 8, 7, 10, '2023-12-14', '2023-12-14'),
(32, 'Printed Dress', 'Vibrant printed dress for a stylish look', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuiT0vEi-F05BoxpVGf2s7gEf2XDCeNESowA&usqp=CAU', 59.99, 49.99, 100, 00, 1, 60, FALSE, 1, 1, 1, '2023-12-14', '2023-12-14'),
(33, 'Running Jacket', 'Water-resistant running jacket for outdoor activities', 'https://cdn11.bigcommerce.com/s-cuo9ht/images/stencil/original/products/400/4591/82464523_MAIN_UltraJacketM_Navy__25458.1679492439.jpg?c=2', 79.99, 69.99, 120, 05, 1, 70, FALSE, 6, 6, 2, '2023-12-14', '2023-12-14'),
(34, 'Denim Skirt', 'Classic denim skirt for a casual yet chic style', 'https://www.milkandthistle.com.au/cdn/shop/products/denim-skirt-3_1333x.jpg?v=1662005351', 34.99, 29.99, 90, 00, 1, 80, FALSE, 1, 1, 3, '2023-12-14', '2023-12-14'),
(35, 'Hooded Sweatshirt', 'Cozy hooded sweatshirt for cold days', 'https://target.scene7.com/is/image/Target/GUEST_c81a03ed-17b5-4d65-b32f-4b67fea4eb52?wid=488&hei=488&fmt=pjpeg', 49.99, 39.99, 110, 0, 1, 90, FALSE,  7,21, 4, '2023-12-14', '2023-12-14'),
(36, 'Leather Belt', 'Stylish leather belt for men', 'https://solidleather.com/cdn/shop/products/Mens_brown_leather_belt_600x.jpg?v=1540059369', 29.99, 24.99, 130, 00, 1, 40, FALSE, 5, 2, 5, '2023-12-14', '2023-12-14'),
(37, 'Smart Home Camera', 'Keep an eye on your home with this smart camera', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9PGrj3uNlB9nps1VESl2WmOh2Q4er3CtKaQ&usqp=CAU', 129.99, 119.99, 100, 00, 1, 50, FALSE, 8, 8, 6, '2023-12-14', '2023-12-14'),
(38, 'Summer Sunglasses', 'Trendy sunglasses for a cool summer look', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlHOWPOMHcErfDhwMOTEPbBHMejBBjoNy0sA&usqp=CAU', 19.99, 15.99, 80, 00, 1, 60, FALSE, 5, 5, 7, '2023-12-14', '2023-12-14');
