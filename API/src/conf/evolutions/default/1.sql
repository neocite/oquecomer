# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table food_type (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_food_type primary key (id))
;

create table restaurant (
  id                        varchar(255) not null,
  name                      varchar(255),
  cep                       varchar(255),
  constraint pk_restaurant primary key (id))
;


create table food_type_restaurant (
  food_type_id                   varchar(255) not null,
  restaurant_id                  varchar(255) not null,
  constraint pk_food_type_restaurant primary key (food_type_id, restaurant_id))
;

create table restaurant_food_type (
  restaurant_id                  varchar(255) not null,
  food_type_id                   varchar(255) not null,
  constraint pk_restaurant_food_type primary key (restaurant_id, food_type_id))
;
create sequence food_type_seq;

create sequence restaurant_seq;




alter table food_type_restaurant add constraint fk_food_type_restaurant_food__01 foreign key (food_type_id) references food_type (id) on delete restrict on update restrict;

alter table food_type_restaurant add constraint fk_food_type_restaurant_resta_02 foreign key (restaurant_id) references restaurant (id) on delete restrict on update restrict;

alter table restaurant_food_type add constraint fk_restaurant_food_type_resta_01 foreign key (restaurant_id) references restaurant (id) on delete restrict on update restrict;

alter table restaurant_food_type add constraint fk_restaurant_food_type_food__02 foreign key (food_type_id) references food_type (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists food_type;

drop table if exists food_type_restaurant;

drop table if exists restaurant;

drop table if exists restaurant_food_type;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists food_type_seq;

drop sequence if exists restaurant_seq;

