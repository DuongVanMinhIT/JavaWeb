create database servlet;
use servlet;
create table role(
	id bigint not null primary key auto_increment,
    name varchar(150) not null,
    code varchar(150) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(150) null,
    modifiedby varchar(150) null
);
create table user(
	id bigint not null primary key auto_increment,
    role_id bigint not null,
	username varchar(150) not null,
	password varchar(150) not null,
	fullname varchar(150) not null,
    status int not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(150) null,
    modifiedby varchar(150) null,
    foreign key (role_id) references role(id)
);

create table category(
	id bigint not null primary key auto_increment,
	name varchar(100) not null,
    code varchar(100) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(150) null,
    modifiedby varchar(150) null
);

create table news(
	id bigint not null primary key auto_increment,
    category_id bigint not null,
	title varchar(150)  null,
	thumbnail varchar(150)  null,
	shortdecription text null,
    content text null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(150) null,
    modifiedby varchar(150) null,
    foreign key (category_id) references category(id)
);

create table comment(
	id bigint not null primary key auto_increment,
    content text not null,
    news_id bigint not null,
    user_id bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(150) null,
    modifiedby varchar(150) null,
    foreign key (news_id) references news(id),
    foreign key (user_id) references user(id)
)

select * from news;



