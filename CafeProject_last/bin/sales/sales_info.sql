
create table sales(
item varchar2(50),
num number(20),
pay number(20),
day varchar2(12)
)


select * from sales

insert into sales values('ī���ī', 20, 1000,'2020-12-31');
insert into sales values('�Ƹ޸�ī��', 5, 3000,'2020-12-31');
insert into sales values('���۹�Ʈ', 2, 1000,'2020-12-31');


drop table sales;



select * from sales;


drop table monthly;

create table monthly(
month varchar2(15),
sales varchar2(20))




select * from jt_item;
select * from jt_category;
select * from jt_order_item;

selet 

create view daily_sales
as
select od_price, od_date
from jt_order, jt_order_item
where od_date = '2021-01-03'

drop view daily_sales
select * from daily_sales

select * from jt_order where od_date = '2020-12-23'

insert into jt_order values(20, '�ֹ�', '2020-12-20', 10000, null);
insert into jt_order values(21, '�ֹ�', '2020-12-20', 5800, null);
insert into jt_order values(22, '�ֹ�', '2020-12-20', 6500, null);
insert into jt_order values(23, '�ֹ�', '2020-12-21', 8500, null);
insert into jt_order values(24, '�ֹ�', '2020-12-22', 10000, null)
insert into jt_order values(25, '�ֹ�', '2020-12-23', 6500, null)
insert into jt_order values(26, '�ֹ�', '2020-12-24', 8500, null)
insert into jt_order values(27, '�ֹ�', '2020-12-25', 5800, null)
insert into jt_order values(28, '�ֹ�', '2020-12-25', 581000, null)


insert into jt_order_item values(20,20,1,'�������','2020-12-20',3500, null)
insert into jt_order_item values(21,20,1,'�������','2020-12-20',3500, null)
insert into jt_order_item values(22,20,2,'�Ƹ޸�ī��','2020-12-20',3000, null)
insert into jt_order_item values(23,21,7,'��Ǫ��','2020-12-20',2000, null)
insert into jt_order_item values(24,21,3,'�ٴҶ��','2020-12-20',3800, null)
insert into jt_order_item values(25,22,2,'�Ƹ޸�ī��','2020-12-20',3000, null)
insert into jt_order_item values(26,22,5,'ī���','2020-12-20',3500, null)




insert into jt_item values(it_no_seq.nextval,1,'�������',3500,null,null,0);
insert into jt_item values(it_no_seq.nextval,1,'�Ƹ޸�ī��',3000,null,null,0);
insert into jt_item values(it_no_seq.nextval,1,'�ٴҶ��',3800,null,null,0);
insert into jt_item values(it_no_seq.nextval,1,'����������',4000,null,null,0);
insert into jt_item values(it_no_seq.nextval,1,'ī���',3500,null,null,0);
insert into jt_item values(it_no_seq.nextval,2,'��Ǫġ��',2000,null,null,0);
insert into jt_item values(it_no_seq.nextval,2,'��Ǫ��',2000,null,null,0);
insert into jt_item values(it_no_seq.nextval,2,'��Ǫ���',2500,null,null,0);
insert into jt_item values(it_no_seq.nextval,2,'���׺��',2500,null,null,0);
insert into jt_item values(it_no_seq.nextval,2,'��������ũ',3000,null,null,0);


select * from jt_order where od_date ='2020/12/20'
select * from jt_order WHERE TO_CHAR(od_date, 'YYYY-MM-DD') = '2020-12-20'


create view daily_sales
as
select od_price, od_date
from jt_order j, jt_order_item i
where od_date = '2021-01-03'

drop view daily_sales
select * from daily_sales

insert into jt_order values(5, '�ֹ�', '2021-01-03', 3500)

WHERE TO_CHAR(REGDATE, 'YYYYMMDD') = '20190701';


select sum(od_price) as price from jt_order WHERE od_date BETWEEN TO_DATE('2020-12-01') AND TO_DATE('2020-12-31');


 
�ֹ� ������ȣ
�ֹ����̺��ȣ
��ǰ��ȣ
�ֹ���
�ֹ���¥
�ֹ��ݾ�
�ֹ���