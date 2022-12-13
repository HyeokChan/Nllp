drop table tb_nllp_acb;
-- 기초자료 테이블
create table tb_nllp_acb(
    nllp_acb_key varchar(11) not null,
    nllp_acb_no varchar(6) not null,
    lgo_cd char(3),
    nllp_nm varchar(4000),
    land_ar number(19,9),
    oalp number(15),
    oalp_yr varchar(4),
    zip varchar(6),
    stdg_cd varchar(10),
    lotno_bac_addr varchar(300),
    lotno_daddr varchar(300),
    mtn_se_cd char(2),
    mno number(4),
    sno number(4),
    spcl_dg varchar(15),
    spcl_ho varchar(30),
    ldcg_cd char(2),
    rm_cn varchar(4000),
    del_yn char(1) default 'N',
    init_user_id varchar(10) not null,
    init_date date not null,
    updt_user_id varchar(10) not null,
    updt_date date not null
);

alter table tb_nllp_acb add constraint tb_nllp_acb_pk primary key (sgb_cd, nllp_acb_key);
comment on table tb_nllp_acb is '재산정보';

select * from tb_nllp_acb;

-- 기초자료 키 시퀀스
create sequence sq_nllp_acb_key
increment by 1
start with 0000001
minvalue 0000001
maxvalue 9999999
nocycle
nocache;

-- 시퀀스 키 생성 function
create or replace function fn_crt_acb_key(p_acbNm in varchar2) 
    return varchar2 
is
    v_acbKey varchar2(11);
begin
    if p_acbNm = 'nllpAcb' then
        select to_char(sysdate, 'yyyy') || lpad(sq_nllp_acb_key.nextval, 7, '0') 
          into v_acbKey 
          from dual;
    end if;
    if p_acbNm = 'rchgAcb' then
        select to_char(sysdate, 'yyyy') || lpad(sq_rchg_acb_key.nextval, 7, '0') 
          into v_acbKey 
          from dual;
    end if;
    return v_acbKey;
end;

-- 컬럼 수정
alter table tb_nllp_acb
drop constraints tb_nllp_acb_pk;

alter table tb_nllp_acb
add constraints tb_nllp_acb_pk
primary key (nllp_acb_key);

alter table tb_nllp_acb drop column sgb_cd;
alter table tb_nllp_acb drop (nllp_acb_se_cd, bldg_ar, std_amt, std_yr, lotno_road_addr_se_cd, road_nm_cd, road_nm_bac_addr, road_nm_daddr, udgd_yn, bmno, bsno, bldg_strc_cd, roof_shpe_cd);
select *
from tb_nllp_acb;

alter table tb_nllp_acb modify updt_user_id varchar(50);

alter table tb_nllp_acb rename column lvy_trgt_nm to nllp_nm;


-- 계약자료 테이블
create table tb_rchg_acb(
    rchg_acb_key varchar(11) not null,
    rchg_acb_no varchar(6) not null,
    pyr_mng_no varchar(11) not null,
    pyr_se_cd char(2),
    pyr_addr_sn char(6),
    ctrt_mtd_cd char(2),
    ctrt_ymd char(8),
    prmsn_bgng_ymd char(8),
    prmsn_end_ymd char(8),
    ntntax_rt number(3),
    ctpv_rt number(3),
    sgg_rt number(3),
    rm_cn varchar(4000),
    del_yn char(1) default 'N',
    init_user_id varchar(50) not null,
    init_date date not null,
    updt_user_id varchar(50) not null,
    updt_date date not null
);

alter table tb_rchg_acb add constraint tb_rchg_acb_pk primary key (rchg_acb_key);
comment on table tb_rchg_acb is '계약정보';

-- 계약자료 키 시퀀스
create sequence sq_rchg_acb_key
increment by 1
start with 0000001
minvalue 0000001
maxvalue 9999999
nocycle
nocache;

-- 계약재산정보 테이블
create table tb_rchg_nllp_info(
    rchg_acb_key varchar(11) not null,
    rchg_nllp_sn char(3) not null,
    gl_mng_no varchar(11) not null,
    nllp_acb_key varchar(11) not null,
    ocpat_ar number(19,9) not null,
    vat_se_cd char(2),
    init_user_id varchar(50) not null,
    init_date date not null,
    updt_user_id varchar(50) not null,
    updt_date date not null
);

alter table tb_rchg_nllp_info add constraint tb_rchg_nllp_info_pk primary key (rchg_acb_key, rchg_nllp_sn);
comment on table tb_rchg_acb is '계약재산정보';