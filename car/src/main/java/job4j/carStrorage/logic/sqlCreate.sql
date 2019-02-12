create table userStorage (
    id serial primary key,
    name varchar(2000),
    login varchar(2000),
    password varchar(2000),
    phone varchar(2000),
    email varchar(2000)
)

create table carStorage (
    id serial primary key,
    name varchar(2000),
    engine varchar(2000),
    carBody varchar(2000),
    transmission varchar(2000),
    color varchar(2000)
)

create table adStorage (
    id serial primary key,
    name varchar(2000),
    users integer references userStorage(id),
    description varchar(2000),
    sale integer,
    status boolean,
    image bytea,
    car integer references carStorage(id)
)