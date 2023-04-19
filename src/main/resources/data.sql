insert into course(id, name, last_updated_date, created_date)
values (10001, 'Kalkulus', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, name, last_updated_date, created_date)
values (10002, 'Biofisika', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, name, last_updated_date, created_date)
values (10003, 'Persamaan Diferensial', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into passport(id, number)
values (40001,'E123456');
insert into passport(id, number)
values (40002,'N123456');
insert into passport(id, number)
values (40003,'L123456');

insert into student(id, name, passport_id)
values (20001,'Rangga', 40001);
insert into student(id, name, passport_id)
values (20002,'Adam', 40002);
insert into student(id, name, passport_id)
values (20003,'June', 40003);

insert into review(id, rating, description)
values (50001, '5', 'Great Course');
insert into review(id, rating, description)
values (50002, '4', 'Awesome Course');
insert into review(id, rating, description)
values (50003, '5', 'Nice');