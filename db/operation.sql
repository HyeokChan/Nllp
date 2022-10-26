create table tb_nllp_acb(
    sgb_cd char(7) not null,
    nllp_acb_key varchar(11) not null,
    nllp_acb_no varchar(6) not null,
    nllp_acb_se_cd char(2) not null,
    lgo_cd char(3),
    lvy_trgt_nm varchar(4000),
    land_ar number(19,9),
    bldg_ar number(19,9),
    oalp number(15),
    oalp_yr varchar(4),
    std_amt number(15),
    std_yr varchar(4),
    lotno_road_addr_se_cd char(2),
    zip varchar(6),
    stdg_cd varchar(10),
    lotno_bac_addr varchar(300),
    lotno_daddr varchar(300),
    mtn_se_cd char(2),
    mno number(4),
    sno number(4),
    road_nm_cd varchar(12),
    road_nm_bac_addr varchar(300),
    road_nm_daddr varchar(300),
    udgd_yn char(1),
    bmno number(5),
    bsno number(5),
    spcl_dg varchar(15),
    spcl_ho varchar(30),
    ldcg_cd char(2),
    bldg_strc_cd char(2),
    roof_shpe_cd char(2),
    rm_cn varchar(4000),
    init_user_id varchar(10) not null,
    init_date date not null,
    updt_user_id varchar(10) not null,
    updt_date date not null
);

alter table tb_nllp_acb add constraint tb_nllp_acb_pk primary key (sgb_cd, nllp_acb_key);
comment on table tb_nllp_acb is '재산정보';

select * from tb_nllp_acb;