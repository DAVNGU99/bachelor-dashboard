create table calendar_events(
    id bigserial PRIMARY KEY,
    title text NOT NULL,
    start_time timestamptz not null,
    end_time timestamptz not null ,
    created_at timestamptz not null default now()
);

alter table calendar_events
    add constraint chk_event_time
        check (end_time > start_time);
