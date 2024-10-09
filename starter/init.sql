create table truck.food_truck
(
    id              char(32)        not null comment 'id'
        primary key,
    third_id        varchar(20)     null comment 'third id',
    object_id       int unsigned    null comment 'object id',
    applicant       varchar(100)    null comment 'applicant',
    facility_type   varchar(10)     null comment 'facility type',
    cnn             varchar(10)     null comment 'cnn',
    address         varchar(200)    null comment 'address',
    permit          varchar(20)     null comment 'permit',
    status          varchar(10)     null comment 'status',
    food_items      varchar(500)    null comment 'food items',
    longitude       decimal(18, 15) null comment 'longitude',
    latitude        decimal(18, 15) null comment 'latitude',
    schedule        varchar(200)    null comment 'schedule',
    approved        datetime        null comment 'approved',
    received        int             null comment 'received',
    prior_permit    tinyint         null comment 'prior permit',
    expiration_date datetime        null comment 'expiration date',
    human_address   json            null comment 'human address',
    block_lot       varchar(20)     null comment 'block lot',
    block           varchar(10)     null comment 'block',
    lot             varchar(10)     null comment 'lot',
    x               decimal(14, 4)  null comment 'x',
    y               decimal(14, 4)  null comment 'y',
    location        point           null comment 'location'
)
    comment 'food truck info table';