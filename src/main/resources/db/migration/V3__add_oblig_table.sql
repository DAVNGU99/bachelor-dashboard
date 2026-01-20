CREATE TABLE oblig(
    id bigserial primary key,
    title varchar(255) not null,
    finished BOOLEAN not null default false
);