create table if not exists attaches
(
    attach_id       serial primary key,
    attach_name varchar(75) not null,
    path     varchar(75) not null,
    size     int8        not null
);

create table if not exists users
(
    user_id   serial primary key,
    firstname varchar(30)  not null,
    lastname  varchar(30),
    username  varchar(30)  not null,
    password  varchar(255) not null,
    user_role varchar(15)  not null,
    user_image_id  int,
    foreign key (user_image_id) references attaches (attach_id)
);

create table if not exists catalogs
(
    catalog_id   serial primary key,
    catalog_name varchar(255) not null,
    catalog_key  varchar(75)  not null,
    catalog_image_id int not null ,
    foreign key (catalog_image_id) references attaches(attach_id)
);

create table if not exists topics
(
    topic_id   serial primary key,
    topic_name varchar(255) not null,
    topic_key  varchar(75)  not null,
    topic_catalog_id int not null,
    foreign key (topic_catalog_id) references catalogs(catalog_id)
);

create table if not exists posts
(
    post_id           serial primary key,
    post_title        varchar(255) not null,
    post_content      text         not null,
    post_created_date date         not null,
    post_topic_id     int          not null,
    post_image_id     int          not null,
    post_creator_id   int          not null,
    foreign key (post_topic_id) references topics (topic_id),
    foreign key (post_creator_id) references users (user_id),
    foreign key (post_image_id) references attaches (attach_id)
);