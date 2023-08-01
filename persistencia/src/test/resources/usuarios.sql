insert into usuario values ("93","mario@gmail.com","cll28#14-10","mario","3216758976","Heropro.12","unimario");
insert into usuario values ("91","cll28#14-10","pedro@gmail.com","pedro","3216758977","Heropro.13","unipedron");
insert into usuario values ("96","cll28#14-11","julian@gmail.com","julian","3216758978","Heropro.14","unijulian");
insert into usuario values ("97","cll28#14-22","julia@gmail.com","pedro","3336758978","Heropro.15","unijulia");
insert into usuario values ("98","cll28#14-33","lian@gmail.com","gabriel","38916758978","Heropro.16","unilian");

insert into categoria values (311,"ropa");
insert into categoria values (312,"vehiculo");
insert into categoria values (313,"Celulares");
insert into categoria values (314,"Electrodomesticos");
insert into categoria values (315,"Inmuebles");

insert into producto values (1,"celular 10 de 10","2023-10-23","2024-10-25","celular",200000,4,"311","93");
insert into producto values (2,"moto con el moto en perfecto estado","2021-10-23","2024-10-25","moto",400000,4,"312","93");
insert into producto values (3,"carro con 20.000 kilometros","2021-10-23","2024-10-25","carro",32,4,"312","91");
insert into producto values (4,"casa de 4 habitaciones","2021-10-23","2024-10-25","vivienda",32,4,"315","91");
insert into producto values (5,"bicicleta BMW","2020-10-23","2024-10-25","bicicleta",32,4,"312","906");
insert into producto values (6,"Televisor de 50 pulgadas smart tv","2023-03-01","2024-10-25","televisor",32,4,"314","96");

insert into usuario_productos_favoritos values ("98",1);
insert into usuario_productos_favoritos values ("98",2);



insert into compra values (34,"2023-04-01","MASTERCARD",200000,"93");
insert into compra values (35,"2023-04-02","MASTERCARD",200000,"93");
insert into compra values (36,"2023-04-03","MASTERCARD",200000,"93");
insert into compra values (37,"2023-04-04","MASTERCARD",200000,"93");

insert into detalle_compra values (81,200000,1,"34","1");
insert into detalle_compra values (82,400000,1,"34","2");

insert into comentario values(51,"2023-07-02","cuanto vale","1","98");
insert into comentario values(52,"2023-07-02","donde esta ubicado","1","98");
insert into comentario values(53,"2023-07-02","viene con caja?","1","98");

--------------------------------------- Mas datos ---------------------------------------------

