CREATE TABLE board (
    idx         bigint not null auto_increment,
    title     varchar(100),
    content     varchar(255),
    primary key (idx)
);

INSERT INTO board (title, content) VALUES ('title1', 'hello It is first page');
INSERT INTO board (title, content) VALUES ('title2', 'bye this is last page');