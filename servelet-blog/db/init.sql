



-- 主外键关联的表，默认创建的主外键约束是严格模式
--


    drop database if exists servlet_blog;
    create database servlet_blog character set utf8mb4;
    use servlet_blog;
    create table user(
    id int primary key auto_increment,
    username varchar(20) not null unique,
    password varchar(20) not null,
    nickname varchar(20),
    sex bit,
    birthday date,
    head varchar(50)
    );
    drop table  if exists article  ;
    create table article(
    id int primary key auto_increment,
    title varchar(20) not null,
    content mediumtext not null,
    create_time timestamp default now(),
    view_count int default 0,
    user_id int,
    foreign key (user_id) references user(id)
    );
    insert into user(username,password) values('Alice','123');
    insert into user(username,password) values('Frame','456');
    insert into user(username,password) values('Grape','789');

    insert into article( title, content, user_id) values ('快速排序','public***',1);
    insert into article( title, content, user_id) values ('冒泡排序','public***',2);
    insert into article( title, content, user_id) values ('希尔排序','public***',3);
    insert into article( title, content, user_id) values ('堆排序','public***',1);
    insert into article( title, content, user_id) values ('归并排序','public***',3);


select username,password,nickname,sex,birthday,head from user where  username='?';
select id,title from article where user_id='?';