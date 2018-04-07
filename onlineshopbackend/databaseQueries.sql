CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id) 

);

-- ajouter des catégories
INSERT INTO category (name, description,image_url,is_active) VALUES ('Laptop', 'Description pour la categorie Laptop!', 'CAT_1.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Television', 'Description pour la categorie Television!', 'CAT_2.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Telephone', 'Description pour la categorie Telephone!', 'CAT_3.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Vetements', 'Description pour la categorie Vetements!', 'CAT_4.png', false);






CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

-- Ajouter des utilisateurs 
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Tagne', 'Edgar', 'ADMIN', true, 'admin', 'edgar.test99@gmail.com', '695333841');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Ngoaze', 'Michel', 'SUPPLIER', true, 'azerty', 'michel@gmail.com', '697250683');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Test', 'Test', 'SUPPLIER', true, 'azerty', 'test@gmail.com', '699009900');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Mekonchou', 'Cedric', 'USER', true, 'azerty', 'cedric@gmail.com', '694251420');





-- stock les produits
CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(9,3),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);	

-- ajout de 05 produits
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone X', 'apple', 'Le meilleure smartphone du moment !', 850000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung Galaxy S9', 'samsung', 'Le meilleure smartphone Samsung du monent !', 700000, 2, true, 3, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Tecno phantom 8', 'Tecno', 'Le meilleure smartphone Tecno du monent !', 150000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'Le meilleure Laptop Apple du monent !', 500000, 3, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Lenovo G50', 'dell', 'Laptop aux performances satisfaisantes et a bon prix', 300000, 5, true, 1, 3, 0, 0 );






-- stocker les adresses de facturation et d'expédition de l'utilisateur
CREATE TABLE address (
	id IDENTITY,
	user_id int,
	address_line_one VARCHAR(100),
	address_line_two VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(10),
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);

-- ajouter une adresse de facturation
INSERT INTO address( user_id, address_line_one, address_line_two, city, state, country, postal_code, is_billing, is_shipping) 
VALUES (4, '1540, Rue Djoungolo', 'Etoa-meki', 'Yaounde', 'Centre', 'Cameroun', '70025', true, false );





-- stocker les détails du panier de l'utilisateur
CREATE TABLE cart (
	id IDENTITY,
	user_id int,
	grand_total DECIMAL(9,3),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);

-- adding a cart for testing 
INSERT INTO cart (user_id, grand_total, cart_lines) VALUES (4, 0, 0);





-- pour stocker les détails du panier
CREATE TABLE cart_line (
	id IDENTITY,
	cart_id int,
	total DECIMAL(9,3),
	product_id int,
	product_count int,
	buying_price DECIMAL(9,3),
	is_available boolean,
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id ) REFERENCES product (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);




-- détails pour stocker la commande
CREATE TABLE order_detail (
	id IDENTITY,
	user_id int,
	order_total DECIMAL(9,3),
	order_count int,
	shipping_id int,
	billing_id int,
	order_date date,
	CONSTRAINT fk_order_detail_user_id FOREIGN KEY (user_id) REFERENCES user_detail (id),
	CONSTRAINT fk_order_detail_shipping_id FOREIGN KEY (shipping_id) REFERENCES address (id),
	CONSTRAINT fk_order_detail_billing_id FOREIGN KEY (billing_id) REFERENCES address (id),
	CONSTRAINT pk_order_detail_id PRIMARY KEY (id)
);




-- ordre des commandes
CREATE TABLE order_item (
	id IDENTITY,
	order_id int,
	total DECIMAL(9,3),
	product_id int,
	product_count int,
	buying_price DECIMAL(9,3),
	CONSTRAINT fk_order_item_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_order_item_order_id FOREIGN KEY (order_id) REFERENCES order_detail (id),
	CONSTRAINT pk_order_item_id PRIMARY KEY (id)
);












