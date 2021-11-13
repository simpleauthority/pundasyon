create table if not exists geographic_bound (
    bound_id bigint auto_increment primary key,
    northeast_latitude double not null,
    northeast_longitude double not null,
    southwest_latitude double not null,
    southwest_longitude double not null
);

create table if not exists geographic_location_currency_metadata (
    currency_metadata_id bigint auto_increment primary key,
    name varchar(128) null,
    symbol varchar(12) null,
    unambiguous_symbol varchar(36) null,
    place_symbol_first tinyint null,
    decimal_mark char null,
    thousands_separator char null,
    smallest_denomination int null,
    subunit_name varchar(36) null,
    subunit_to_unit int null
);

create table if not exists geographic_location_driving_metadata (
    driving_metadata_id bigint auto_increment primary key,
    side_of_road varchar(5) null,
    units_of_speed varchar(16) null
);

create table if not exists geographic_location_miscellaneous_metadata (
    miscellaneous_metadata_id bigint auto_increment primary key,
    flag varchar(255) null,
    calling_code int null,
    qibla float null
);

create table if not exists geographic_location_timezone_metadata (
    timezone_metadata_id bigint auto_increment primary key,
    name varchar(128) null,
    short_name varchar(128) null,
    in_daylight_savings tinyint null,
    offset_from_utc bigint null
);

create table if not exists geographic_location_metadata (
    metadata_id bigint auto_increment primary key,
    timezone_metadata_id bigint not null,
    driving_metadata_id bigint not null,
    currency_metadata_id bigint not null,
    miscellaneous_metadata_id bigint not null,
    constraint currency_metadata_fk
        foreign key (currency_metadata_id) references geographic_location_currency_metadata (currency_metadata_id)
            on update cascade on delete cascade,
    constraint driving_metadata_fk
        foreign key (driving_metadata_id) references geographic_location_driving_metadata (driving_metadata_id)
            on update cascade on delete cascade,
    constraint miscellaneous_metadata_fk
        foreign key (miscellaneous_metadata_id) references geographic_location_miscellaneous_metadata (miscellaneous_metadata_id)
            on update cascade on delete cascade,
    constraint tz_metadata_fk
            foreign key (timezone_metadata_id) references geographic_location_timezone_metadata (timezone_metadata_id)
                on update cascade on delete cascade
);

create table if not exists geographic_location (
    location_id bigint auto_increment primary key,
    continent varchar(128) null,
    country varchar(128) null,
    state varchar(128) null,
    region varchar(128) null,
    city varchar(128) null,
    latitude double not null,
    longitude double not null,
    bound_id bigint not null,
    metadata_id bigint not null,
    constraint geographic_location_geographic_bound_bound_id_fk
        foreign key (bound_id) references geographic_bound (bound_id)
            on update cascade on delete cascade,
    constraint geographic_location_geographic_location_metadata_metadata_id_fk
        foreign key (metadata_id) references geographic_location_metadata (metadata_id)
            on update cascade on delete cascade
);

create table if not exists forward_geocode_result (
    result_id bigint auto_increment primary key,
    query varchar(255) not null,
    created timestamp default current_timestamp() not null on update current_timestamp(),
    location_id bigint not null,
    constraint forward_geocode_result_geographic_location_location_id_fk
        foreign key (location_id) references geographic_location (location_id)
            on update cascade on delete cascade
);

create table if not exists reverse_geocode_result (
    result_id bigint auto_increment primary key,
    latitude double not null,
    longitude double not null,
    created timestamp default current_timestamp() not null on update current_timestamp(),
    location_id bigint not null,
    constraint reverse_geocode_result_geographic_location_location_id_fk
        foreign key (location_id) references geographic_location (location_id)
            on update cascade on delete cascade
);