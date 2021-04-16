CREATE TABLE user (
    idx         bigint not null auto_increment,
    email     varchar(200),
    name     varchar(100),
    primary key (idx)
);

INSERT INTO user (email, name) VALUES ('hoho@email.com', 'hoho');
INSERT INTO user (email, name) VALUES ('haha@email.com', 'haha');