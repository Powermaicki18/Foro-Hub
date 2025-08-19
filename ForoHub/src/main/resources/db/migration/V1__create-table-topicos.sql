create table topicos(

    id bigint nor null auto_incremente,
    mensaje varchar (100) not null,
    nombre_curso varchar (100) not null,
    titulo varchar (100) not null unique

        primary key (id)

)