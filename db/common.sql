drop table tb_user_info;
create table tb_user_info(
    sgb_cd char(7) not null,
    user_id varchar(10) not null,
    user_pw varchar(30),
    user_nm varchar(10),
    init_user_id varchar(10) not null,
    init_date date not null,
    updt_user_id varchar(10) not null,
    updt_date date not null
);    
alter table tb_user_info add constraint tb_user_info_pk primary key (sgb_cd, user_id);    
comment on table tb_user_info is '사용자정보';
select * from tb_user_info;


create table tb_user_req(
    sgb_cd char(7) not null,
    user_id varchar(10) not null,
    user_pw varchar(30) not null,
    user_nm varchar(10) not null,
    appv_yn char(1) default 'N' not null,
    init_user_id varchar(10) not null,
    init_date date not null,
    updt_user_id varchar(10) not null,
    updt_date date not null
);

alter table tb_user_req add constraint tb_user_req_pk primary key (sgb_cd, user_id);    
comment on table tb_user_req is '사용자신청정보';
select * from tb_user_req;

select count(1) from tb_user_req where sgb_cd = '3550000' and user_id = 'enis0001'