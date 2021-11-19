CREATE TABLE healthy (
	id bigint PRIMARY KEY auto_increment,
	title varchar(200),
	description TEXT,
	preco int,
	status int DEFAULT 100
);

CREATE TABLE user (
	id bigint PRIMARY KEY auto_increment,
	name varchar(200),
	email varchar(200),
	password varchar(200)
);

CREATE TABLE ROLE(
	id int primary key auto_increment,
	name varchar(200)
);

CREATE TABLE USER_ROLES(
	user_id int,
	roles_id int
);

INSERT INTO user (name, email, password) VALUES
('Maria ', 'maria@fiap.com', '$2a$12$iAFC7sgMoPSDNRV.6isc/.F1yT0R0L2tFypGPk6CQaRCFG/PiEjmO'),
('Pedro Utida', 'admin@admin.com', '$2a$12$iAFC7sgMoPSDNRV.6isc/.F1yT0R0L2tFypGPk6CQaRCFG/PiEjmO');


INSERT INTO healthy (title, description, preco, status) VALUES 
	('Salada de Beterrabas',
	'Receita de Beterraba, usados ingredientes acessiveis', 
	25,
	100);
	
	
INSERT INTO healthy (title, description, preco, status) VALUES 
	('Salada de Batatas','Salada de batatas cozidas', 35, 100);
	
;