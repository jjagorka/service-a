CREATE TABLE ip_counter(
    ip_address varchar primary key,
    counter integer not null default 0,
    created_at timestamp default now(),
    updated_at timestamp default now()
)
