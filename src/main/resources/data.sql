INSERT INTO product_stock (`id`, `name_product`, `quantity`, `brand`, `price`, `category`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Running Shoes - Men', 30, 'Nike', 89.99, 'Men Shoes');
INSERT INTO product_stock (`id`, `name_product`, `quantity`, `brand`, `price`, `category`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Sneakers - Women', 25, 'Adidas', 79.50, 'Women Shoes');
INSERT INTO product_stock (`id`, `name_product`, `quantity`, `brand`, `price`, `category`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Dress Shoes - Men', 20, 'Cole Haan', 129.75, 'Men Shoes');
INSERT INTO product_stock (`id`, `name_product`, `quantity`, `brand`, `price`, `category`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Sandals - Women', 35, 'Birkenstock', 59.25, 'Women Shoes');
INSERT INTO product_stock (`id`, `name_product`, `quantity`, `brand`, `price`, `category`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Casual Shoes - Men', 8, 'Vans', 49.99, 'Men Shoes');
INSERT INTO product_stock (`id`, `name_product`, `quantity`, `brand`, `price`, `category`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Heels - Women', 22, 'Steve Madden', 89.50, 'Women Shoes');
INSERT INTO product_stock (`id`, `name_product`, `quantity`, `brand`, `price`, `category`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Sports Shoes - Men', 28, 'Under Armour', 99.75, 'Men Shoes');
INSERT INTO product_stock (`id`, `name_product`, `quantity`, `brand`, `price`, `category`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Boots - Women', 2, 'Timberland', 149.00, 'Women Shoes');
INSERT INTO product_stock (`id`, `name_product`, `quantity`, `brand`, `price`, `category`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Slippers - Men', 35, 'UGG', 79.99, 'Men Shoes');
INSERT INTO product_stock (`id`, `name_product`, `quantity`, `brand`, `price`, `category`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Flats - Women', 24, 'Toms', 54.49, 'Women Shoes');

INSERT INTO client (`id`, `name`, `email`, `address`, `phone_number`, `created_at`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'John Doe', 'johndoe@example.com', '123 Main St, CityA', '+1234567890', NOW());
INSERT INTO client (`id`, `name`, `email`, `address`, `phone_number`, `created_at`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Jane Smith', 'janesmith@example.com', '456 Elm St, CityB', '+1987654321', NOW());
INSERT INTO client (`id`, `name`, `email`, `address`, `phone_number`, `created_at`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Mike Johnson', 'mikejohnson@example.com', '789 Oak St, CityC', '+1555123456', NOW());
INSERT INTO client (`id`, `name`, `email`, `address`, `phone_number`, `created_at`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Emily Davis', 'emilydavis@example.com', '101 Pine St, CityD', '+1888777666', NOW());
INSERT INTO client (`id`, `name`, `email`, `address`, `phone_number`, `created_at`)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Alex Wilson', 'alexwilson@example.com', '202 Maple St, CityE', '+1444333222', NOW());
