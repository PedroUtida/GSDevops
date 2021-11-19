CREATE TABLE acc_alimento (
id_alimento NUMBER(6) NOT NULL,
nm_alimento VARCHAR2(40) NOT NULL,
ds_descricao_alimento VARCHAR2(100) NOT NULL,
acc_usuario_id_usuario NUMBER(5) NOT NULL
);



ALTER TABLE acc_alimento ADD CONSTRAINT pk_acc_alimento PRIMARY KEY ( id_alimento );



CREATE TABLE acc_receita (
id_receita NUMBER(4) NOT NULL,
nm_receita VARCHAR2(30) NOT NULL,
ds_descricao_alimento VARCHAR2(100) NOT NULL,
acc_usuario_id_usuario NUMBER(5) NOT NULL
);



ALTER TABLE acc_receita ADD CONSTRAINT pk_acc_receita PRIMARY KEY ( id_receita );



CREATE TABLE acc_receita_alimento (
id_alimento NUMBER(6) NOT NULL,
id_receita NUMBER(4) NOT NULL
);



CREATE TABLE acc_usuario (
id_usuario NUMBER(5) NOT NULL,
id_alimento NUMBER(6) NOT NULL,
id_receita NUMBER(4) NOT NULL,
nm_usuario VARCHAR2(50) NOT NULL,
nm_email VARCHAR2(30) NOT NULL,
ds_senha VARCHAR2(20) NOT NULL,
nr_celular NUMBER(15)
);




ALTER TABLE acc_usuario ADD CONSTRAINT pk_acc_usuario PRIMARY KEY ( id_usuario );



ALTER TABLE acc_usuario
ADD CONSTRAINT fk_usu_alim FOREIGN KEY ( id_alimento )
REFERENCES acc_alimento ( id_alimento );



ALTER TABLE acc_usuario
ADD CONSTRAINT fk_usu_acc_receita FOREIGN KEY ( id_receita )
REFERENCES acc_receita ( id_receita );



ALTER TABLE acc_receita_alimento
ADD CONSTRAINT fk_alimento_receita FOREIGN KEY ( id_alimento )
REFERENCES acc_alimento ( id_alimento );



ALTER TABLE acc_receita_alimento
ADD CONSTRAINT fk_receita_alimento FOREIGN KEY ( id_receita )
REFERENCES acc_receita ( id_receita );