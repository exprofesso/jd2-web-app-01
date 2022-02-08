create table Discounts
(
    id      int auto_increment
        primary key,
    percent int null
);

create table Roles
(
    id   int auto_increment
        primary key,
    role varchar(45) null
);

create table Transfers
(
    id   int auto_increment
        primary key,
    Type varchar(45) null
);

create table Types_of_holidays
(
    id   int auto_increment
        primary key,
    Type varchar(45) not null
);

create table Tours
(
    id                   int auto_increment
        primary key,
    Types_of_holidays_id int         not null,
    town                 varchar(45) null,
    date                 date        null,
    days                 int         null,
    food                 int         null,
    price                int         null,
    Transfers_id         int         not null,
    constraint fk_Tours_Transfers1
        foreign key (Transfers_id) references Transfers (id),
    constraint fk_Tours_Types_of_holidays
        foreign key (Types_of_holidays_id) references Types_of_holidays (id)
);

create index fk_Tours_Transfers1_idx
    on Tours (Transfers_id);

create index fk_Tours_Types_of_holidays_idx
    on Tours (Types_of_holidays_id);

create table Users
(
    id           int auto_increment
        primary key,
    login        varchar(45) not null,
    password     varchar(45) not null,
    name         varchar(45) null,
    surname      varchar(45) null,
    email        varchar(45) null,
    Discounts_id int         not null,
    Roles_id     int         not null,
    constraint fk_Users_Discounts1
        foreign key (Discounts_id) references Discounts (id),
    constraint fk_Users_Roles1
        foreign key (Roles_id) references Roles (id)
);

create index fk_Users_Discounts1_idx
    on Users (Discounts_id);

create index fk_Users_Roles1_idx
    on Users (Roles_id);

create table Users_has_Tours
(
    Users_id    int  not null,
    Tours_id    int  not null,
    payment     int  null,
    payment_day date null,
    primary key (Users_id, Tours_id),
    constraint fk_Users_has_Tours_Tours1
        foreign key (Tours_id) references Tours (id),
    constraint fk_Users_has_Tours_Users1
        foreign key (Users_id) references Users (id)
);

create index fk_Users_has_Tours_Tours1_idx
    on Users_has_Tours (Tours_id);

create index fk_Users_has_Tours_Users1_idx
    on Users_has_Tours (Users_id);


