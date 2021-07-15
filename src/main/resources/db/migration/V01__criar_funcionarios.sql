CREATE TABLE FUNCIONARIO (
    id serial NOT NULL,
    nome character varying(30) NOT NULL,
    sobrenome character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    numero_nis character varying(15) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO FUNCIONARIO (nome, sobrenome, email, numero_nis) values ('Marcos', 'Daniel', 'marcos.mdbbr@gmail.com', '99403948761');
INSERT INTO FUNCIONARIO (nome, sobrenome, email, numero_nis) values ('João', 'Da Silva', 'joao.silva@gmail.com', '37556177540');
INSERT INTO FUNCIONARIO (nome, sobrenome, email, numero_nis) values ('Juliane', ' Silveira', 'julisil@gmail.com', '03565761590');
INSERT INTO FUNCIONARIO (nome, sobrenome, email, numero_nis) values ('André', 'Aragão', 'aragaoandre@gmail.com', '01006575399');
INSERT INTO FUNCIONARIO (nome, sobrenome, email, numero_nis) values ('Maria', 'Das Dores', 'mariadasdores@gmail.com', '29452967374');
INSERT INTO FUNCIONARIO (nome, sobrenome, email, numero_nis) values ('Carla', 'Brito', 'carlabrito@gmail.com', '65843643069');
INSERT INTO FUNCIONARIO (nome, sobrenome, email, numero_nis) values ('José', 'Antunes', 'antunesjose@gmail.com', '02951435562');
INSERT INTO FUNCIONARIO (nome, sobrenome, email, numero_nis) values ('Roberto', 'Gaucho', 'robertogaucho@gmail.com', '81048959711');
