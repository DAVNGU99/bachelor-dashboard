create extension if not exists pgcrypto;

insert into users (id, email, password, name, created_at)
values
    (gen_random_uuid(), 'test1@local.dev', '{bcrypt}$2a$12$LzM6XCCBMgkpKjfrvYdadOBph8dcWAMeM5W6Maj7UbnjK3HUGZpKG', 'davidnguyen', now()),
    (gen_random_uuid(), 'test2@local.dev', '{bcrypt}$2a$12$VwwITgOg.42XDlXBqH6PdOQxHZqMs8WeptLWXmRtvbbjiugKdxGmW', 'marcuvs', now()),
    (gen_random_uuid(), 'test3@local.dev', '{bcrypt}$2a$12$4A4ah/CDLTVXtuiXbDs1Z.3DdJkT.vIxK7UE6F6/0sf.xuft1drQK', 'ingridvollset', now()),
    (gen_random_uuid(), 'test4@local.dev', '{bcrypt}$2a$12$oO1/LnThgQs1UG770.WN9u8Yyy5vnouWTY4MEHnHvyu1B0I0wE/Aq', 'mariahaukeberg', now())
    on conflict (email) do nothing;
