alter table review add review_update_date date;

select * from review_member;

MERGE INTO review_member
		USING DUAL
		ON (review_no = 6 AND actor_id = 1)
		WHEN NOT
		MATCHED THEN
		INSERT (review_no, actor_id, review_scrap_yn,
		review_scrap_date)
		values (6, 1, 1, sysdate)
		WHEN MATCHED
		THEN
		UPDATE SET
		review_scrap_yn = 1, review_scrap_date = sysdate

create table review_member(
review_no number constraint review_member_review_no_nn not null,
actor_id varchar2(100) constraint review_member_actor_id_nn not null,
review_scrap_yn number(1),
review_gb number(1),
review_block_yn number(1),
review_rep_yn number(1),
review_rep_content varchar2(100),
review_scrap_date date,
review_gb_date date,
review_block_date date,
review_rep_date date,
foreign key (review_no) references review(review_no),
foreign key (actor_id) references member(id)
);

drop table member_member;
drop table review_member;
drop table rest_member;

select * from user_tables;

update review set review_content = '424214', review_update_date = sysdate where review_no = 7;

select * from user_tables;
select * from user_constraints;

select * from REVIEW_MEMBER where exists (select * from REVIEW_MEMBER where actor_id = '7');


update REVIEW_MEMBER set review_scrap_yn = 1 where actor_id = 7 and review_no = 1;

		MERGE INTO review_member
		USING DUAL
		ON (review_no = 6 AND actor_id = '1')
		WHEN NOT MATCHED THEN
			INSERT (review_no, actor_id, review_scrap_yn, review_scrap_date)
			values (6, '1', 1, sysdate)
		WHEN MATCHED THEN
		UPDATE SET
		review_scrap_yn = 1, review_scrap_date = sysdate		
		

select * from review_member;
select * from member_member;


create table review_member(
review_no number constraint review_member_review_no_nn not null,
actor_id varchar2(100) constraint review_member_actor_id_nn not null,
review_scrap_yn number(1),
review_gb number(1),
review_block_yn number(1),
review_rep_yn number(1),
review_rep_content varchar2(100),
review_scrap_date date,
review_gb_date date,
review_block_date date,
review_rep_date date,
foreign key (review_no) references review(review_no),
foreign key (actor_id) references member(id)
);

select * from review_pic where review_no = 1;
select * from reply where review_no = 1;

select * from review where review_no = '7';

update review set review_display = 1;
update review set review_display = 0 where review_no = 7;

select * from review;
select * from review_pic;
select * from reply;

insert into reply values (1, 4, sysdate, 1, 'dfsdfsdf', null);

select * from review order by review_post_date desc;

select * from review_pic where review_no = 4;

select * from category;

insert into category values (1, 'main', 'middle');

select * from member;

begin
    for r in ( select table_name, constraint_name
               from user_constraints
               where constraint_type = 'R' )
    loop
        execute immediate 'alter table '|| r.table_name
                          ||' drop constraint '|| r.constraint_name;
    end loop;
end;

drop table category;
drop table follow_member;
drop table interests;
drop table member;
drop table reply;
drop table category;
drop table review;
drop table review_rep;


select * from member;


create table category(
   code_no number constraint pk_category_code_no primary key,
   main_cate varchar2(10) constraint main_cate_nn not null,
   middle_cate varchar2(10) constraint middle_cate_nn not null,
   sub_cate varchar2(50) constraint sub_cate_nn not null,
	code varchar2(10) constraint code_nn not null
);

select * from review_pic;

SELECT * FROM USER_CONSTRAINTS;

select * from user_sequences;

select * from category;

select * from review;

select * from review_pic;


insert into review(review_no, id, code_no, review_content, review_score, review_display, p_date)
		values (review_no.nextval, 'id',  1, 'test', 0, 0, sysdate);

SELECT review_no.CURRVAL AS review_no FROM DUAL;


insert into category (code_no, main_cate, middle_cate, sub_cate, code) values (1, 'ma', 'mid', 'sub', 'code');

drop table member;

delete from member;


create table member(
	id varchar2(20) constraint pk_member_id primary key,
	pw varchar2(20) constraint pw_nn not null,
	name varchar2(50),
	nick varchar2(20) constraint nick_nn not null,
	tel varchar2(20),
	addr varchar2(50) constraint addr_nn not null,
	birth varchar2(50) constraint birth_nn not null,
	gender varchar2(10) constraint gender_nn not null,
	j_date date default sysdate,
	total_score varchar2(100) default 0,
	grade varchar2(10) default 0
);


insert into member (id, pw, name, nick, tel, addr, birth, gender, total_score, grade) values ('1', '1', '1', '1', '1', '1', '1', '남', 0, '0');

select * from member where id = '1' and pw = '1';

select last_insert_id();


create sequence review_no
   increment by 1
   start with 1
   maxvalue 999999999999999
   nocache
   nocycle;
   
   
create table review_pic(
	review_pic_no number constraint pk_review_pic_no primary key,
	review_no number constraint review_no_nn not null,
	review_pic_title varchar2(100) constraint review_pic_title_nn not null,
	review_pic_type varchar2(10) constraint review_pic_type_nn not null,
	review_pic_src varchar2(500) constraint review_pic_src_nn not null,
	review_pic_size varchar2(20) constraint review_pic_size_nn not null,
	foreign key (review_no) references review(review_no)
);

--select * from review_pic;

alter table review 

insert into review_pic(review_pic_no, review_no, review_pic_title, review_pic_type, review_pic_src, REVIEW_PIC_SIZE)
		values (review_pic_no.nextval, 3, 'title', 'type', 'src', 'size');


create sequence review_pic_no
   increment by 1
   start with 1
   maxvalue 999999999999999
   nocache
   nocycle;
   
   
 