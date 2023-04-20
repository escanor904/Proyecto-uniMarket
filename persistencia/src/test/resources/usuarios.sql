insert into usuario values ("904","mario@gmail.com","mario","Heropro.12","cll28#14-09","3216758976");
insert into usuario values ("905","pedro@gmail.com","pedro","Heropro.13","cll28#14-10","3216758977");
insert into usuario values ("906","julian@gmail.com","julian","Heropro.14","cll28#14-11","3216758978");
insert into usuario values ("907","julia@gmail.com","pedro","Heropro.15","cll28#14-22","3336758978");
insert into usuario values ("908","lian@gmail.com","gabriel","Heropro.16","cll28#14-33","38916758978");

insert into categoria values ("301","ropa");
insert into categoria values ("302","vehiculo");
insert into categoria values ("303","Celulares");
insert into categoria values ("304","Electrodomesticos");
insert into categoria values ("305","Inmuebles");

insert into sub_categoria values ("21","motos","302");

insert into producto values ("1","celular 10 de 10","2023/10/23","2023/10/25","celular",32,4,"301","904");
insert into producto values ("2","moto con el moto en perfecto estado","2023/10/23","2023/10/25","moto",32,4,"302","904");
insert into producto values ("3","carro con 20.000 kilometros","2023/10/23","2023/10/25","carro",32,4,"302","905");
insert into producto values ("4","casa de 4 habitaciones","2023/10/23","2023/10/25","vivienda",32,4,"305","905");
insert into producto values ("5","bicicleta BMW","2023/10/23","2023/10/25","bicicleta",32,4,"302","906");
insert into producto values ("6","Televisor de 50 pulgadas smart tv","2023/10/23","2023/10/25","televisor",32,4,"304","906");

insert into usuario_productos_favoritos values ("908","1");
insert into usuario_productos_favoritos values ("908","2");

