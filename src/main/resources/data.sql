insert into course(id, name, last_updated_date, created_date)
values (10001, 'Kalkulus', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, name, last_updated_date, created_date)
values (10002, 'Biofisika', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, name, last_updated_date, created_date)
values (10003, 'Persamaan Diferensial', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into student(id, name)
values (20001,'Rangga');
insert into student(id, name)
values (20002,'Adam');
insert into student(id, name)
values (20003,'June');

insert into passport(id, number)
values (40001,'E123456');
insert into passport(id, number)
values (40002,'N123456');
insert into passport(id, number)
values (40003,'L123456');

insert into review(id, rating, description)
values (50001, '5', 'Great Course');
insert into review(id, rating, description)
values (50002, '4', 'Awesome Course');
insert into review(id, rating, description)
values (50003, '5', 'Nice');