create table payment
(
    pId     int auto_increment
        primary key,
    pType   varchar(45) not null,
    pStatus varchar(45) not null,
    pTotal  int         not null
);

create table property_facility
(
    pfId   int auto_increment
        primary key,
    pfName varchar(45) not null
);

create table property_type
(
    ptId   int auto_increment
        primary key,
    ptName varchar(45) not null
);

create table room_facility
(
    rfId   int auto_increment
        primary key,
    rfName varchar(45) not null
);

create table user
(
    uId        int auto_increment
        primary key,
    uFirstName varchar(45) not null,
    uLastName  varchar(45) not null,
    uPassport  varchar(45) not null,
    uEmail     varchar(45) not null,
    uPhone     varchar(45) not null,
    uPassword  varchar(45) not null,
    uType      varchar(45) not null,
    constraint user_uEmail_uindex
        unique (uEmail)
);

create table property
(
    pId           int auto_increment,
    pStars        varchar(1)   not null,
    pName         varchar(45)  not null,
    pDescription  varchar(300) not null,
    pRoad         varchar(45)  not null,
    pDistrict     varchar(45)  not null,
    pCity         varchar(45)  not null,
    pZipCode      varchar(45)  not null,
    pEmail        varchar(45)  not null,
    pPhone        varchar(45)  not null,
    pCheckInTime  varchar(45)  not null,
    pCheckOutTime varchar(45)  not null,
    propertyType  int          not null,
    userId        int          not null,
    primary key (pId, propertyType, userId),
    constraint fk_PROPERTY_PROPERTY_TYPE1
        foreign key (propertyType) references property_type (ptId),
    constraint fk_PROPERTY_USER1
        foreign key (userId) references user (uId)
);

create index fk_PROPERTY_PROPERTY_TYPE1_idx
    on property (propertyType);

create index fk_PROPERTY_USER1_idx
    on property (userId);

create table property_has_property_facility
(
    propertyId         int not null,
    propertyFacilityId int not null,
    primary key (propertyId, propertyFacilityId),
    constraint fk_PROPERTY_has_PROPERTY_FACILITY_PROPERTY1
        foreign key (propertyId) references property (pId),
    constraint fk_PROPERTY_has_PROPERTY_FACILITY_PROPERTY_FACILITY1
        foreign key (propertyFacilityId) references property_facility (pfId)
);

create index fk_PROPERTY_has_PROPERTY_FACILITY_PROPERTY1_idx
    on property_has_property_facility (propertyId);

create index fk_PROPERTY_has_PROPERTY_FACILITY_PROPERTY_FACILITY1_idx
    on property_has_property_facility (propertyFacilityId);

create table room
(
    rId        int auto_increment,
    rName      varchar(45) not null,
    rNumber    int         not null,
    rPrice     double      not null,
    rSize      double      not null,
    propertyId int         not null,
    primary key (rId, propertyId),
    constraint fk_ROOM_PROPERTY1
        foreign key (propertyId) references property (pId)
            on delete cascade
);

create table bed
(
    bId       int auto_increment,
    bName     varchar(45) not null,
    bCapacity int         not null,
    roomId    int         not null,
    primary key (bId, roomId),
    constraint fk_BED_ROOM1
        foreign key (roomId) references room (rId)
            on delete cascade
);

create index fk_BED_ROOM1_idx
    on bed (roomId);

create table booking
(
    bId            int auto_increment,
    bCheckIn       date        not null,
    bCheckOut      date        not null,
    bStatus        varchar(45) not null,
    userId         int         not null,
    roomId         int         not null,
    roomPropertyId int         not null,
    paymentId      int         not null,
    primary key (bId, paymentId, userId, roomId, roomPropertyId),
    constraint fk_BOOKING_PAYMENT1
        foreign key (paymentId) references payment (pId),
    constraint fk_BOOKING_ROOM1
        foreign key (roomId, roomPropertyId) references room (rId, propertyId),
    constraint fk_BOOKING_USER1
        foreign key (userId) references user (uId)
);

create index fk_BOOKING_PAYMENT1_idx
    on booking (paymentId);

create index fk_BOOKING_ROOM1_idx
    on booking (roomId, roomPropertyId);

create index fk_BOOKING_USER1_idx
    on booking (userId);

create index fk_ROOM_PROPERTY1_idx
    on room (propertyId);

create table room_has_room_facility
(
    roomId         int not null,
    roomFacilityId int not null,
    primary key (roomId, roomFacilityId),
    constraint fk_ROOM_has_ROOM_FACILITY_ROOM
        foreign key (roomId) references room (rId)
            on delete cascade,
    constraint fk_ROOM_has_ROOM_FACILITY_ROOM_FACILITY1
        foreign key (roomFacilityId) references room_facility (rfId)
            on delete cascade
);

create index fk_ROOM_has_ROOM_FACILITY_ROOM_FACILITY1_idx
    on room_has_room_facility (roomFacilityId);

create index fk_ROOM_has_ROOM_FACILITY_ROOM_idx
    on room_has_room_facility (roomId);


