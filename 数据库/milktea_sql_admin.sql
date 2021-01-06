create table milktea_sql.admin
(
    id       int auto_increment,
    username varchar(50) not null,
    password varchar(50) not null,
    constraint admin_id_uindex
        unique (id),
    constraint admin_username_uindex
        unique (username)
);

alter table milktea_sql.admin
    add primary key (id);

INSERT INTO milktea_sql.admin (id, username, password) VALUES (1, 'root', '123');
