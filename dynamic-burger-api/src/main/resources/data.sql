insert into ingrediente (nome, valor) values ('Alface', 0.40);
insert into ingrediente (nome, valor) values ('Bacon', 2);
insert into ingrediente (nome, valor) values ('Hanburger de Carne', 3);
insert into ingrediente (nome, valor) values ('Ovo', 0.8);
insert into ingrediente (nome, valor) values ('Queijo', 1.5);

insert into lanche (nome) values ('X-Bacon');
--Bacon, hambúrguer de carne e queijo
insert into LANCHE_INGREDIENTE values (1, 2);
insert into LANCHE_INGREDIENTE values (1, 3);
insert into LANCHE_INGREDIENTE values (1, 5);

insert into lanche (nome) values ('X-Burger');
--Hambúrguer de carne e queijo
insert into LANCHE_INGREDIENTE values (2, 3);
insert into LANCHE_INGREDIENTE values (2, 5);

insert into lanche (nome) values ('X-Egg');
--Ovo, hambúrguer de carne e queijo
insert into LANCHE_INGREDIENTE values (3, 3);
insert into LANCHE_INGREDIENTE values (3, 4);
insert into LANCHE_INGREDIENTE values (3, 5);

insert into lanche (nome) values ('X-Egg Bacon');
--Ovo, bacon, hambúrguer de carne e queijo
insert into LANCHE_INGREDIENTE values (4, 2);
insert into LANCHE_INGREDIENTE values (4, 3);
insert into LANCHE_INGREDIENTE values (4, 4);
insert into LANCHE_INGREDIENTE values (4, 5);

--insert into lanche (nome) values ('lancheLight');
--insert into LANCHE_INGREDIENTE values (1, 1);
--insert into LANCHE_INGREDIENTE values (1, 3);
--insert into LANCHE_INGREDIENTE values (1, 5);
--
--
--insert into lanche (nome) values ('LancheMuitaCarne');
--insert into LANCHE_INGREDIENTE values (2, 3);
--insert into LANCHE_INGREDIENTE values (2, 3);
--insert into LANCHE_INGREDIENTE values (2, 3);
--
--
--insert into lanche (nome) values ('lancheLightEMuitaCarne');
--insert into LANCHE_INGREDIENTE values (3, 3);
--insert into LANCHE_INGREDIENTE values (3, 3);
--insert into LANCHE_INGREDIENTE values (3, 3);
--insert into LANCHE_INGREDIENTE values (3, 1);
--
--insert into lanche (nome) values ('lancheMuitaCarneEQueijo');
--insert into LANCHE_INGREDIENTE values (4, 3);
--insert into LANCHE_INGREDIENTE values (4, 3);
--insert into LANCHE_INGREDIENTE values (4, 3);
--insert into LANCHE_INGREDIENTE values (4, 5);
--insert into LANCHE_INGREDIENTE values (4, 5);
--insert into LANCHE_INGREDIENTE values (4, 5);
--
--
--insert into lanche (nome) values ('lancheMuitaCarneEQueijoELight');
--insert into LANCHE_INGREDIENTE values (5, 3);
--insert into LANCHE_INGREDIENTE values (5, 3);
--insert into LANCHE_INGREDIENTE values (5, 3);
--insert into LANCHE_INGREDIENTE values (5, 5);
--insert into LANCHE_INGREDIENTE values (5, 5);
--insert into LANCHE_INGREDIENTE values (5, 5);
--insert into LANCHE_INGREDIENTE values (5, 1);
--
--insert into lanche (nome) values ('lancheMuitaCarne');
--insert into LANCHE_INGREDIENTE values (6, 3);
--insert into LANCHE_INGREDIENTE values (6, 3);
--insert into LANCHE_INGREDIENTE values (6, 3);
--insert into LANCHE_INGREDIENTE values (6, 5);
--insert into LANCHE_INGREDIENTE values (6, 5);

--insert into lanche (nome) values ('X-Bacon');
----Bacon, hambúrguer de carne e queijo
--insert into LANCHE_INGREDIENTE values (1, 2);
--insert into LANCHE_INGREDIENTE values (1, 3);
--insert into LANCHE_INGREDIENTE values (1, 5);