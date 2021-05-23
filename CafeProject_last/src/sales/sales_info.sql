
create table sales(
item varchar2(50),
num number(20),
pay number(20),
day varchar2(12)
)


select * from sales

insert into sales values('카페모카', 20, 1000,'2020-12-31');
insert into sales values('아메리카노', 5, 3000,'2020-12-31');
insert into sales values('페퍼민트', 2, 1000,'2020-12-31');


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

insert into jt_order values(20, '주문', '2020-12-20', 10000, null);
insert into jt_order values(21, '주문', '2020-12-20', 5800, null);
insert into jt_order values(22, '주문', '2020-12-20', 6500, null);
insert into jt_order values(23, '주문', '2020-12-21', 8500, null);
insert into jt_order values(24, '주문', '2020-12-22', 10000, null)
insert into jt_order values(25, '주문', '2020-12-23', 6500, null)
insert into jt_order values(26, '주문', '2020-12-24', 8500, null)
insert into jt_order values(27, '주문', '2020-12-25', 5800, null)
insert into jt_order values(28, '주문', '2020-12-25', 581000, null)


insert into jt_order_item values(20,20,1,'헤이즐넛','2020-12-20',3500, null)
insert into jt_order_item values(21,20,1,'헤이즐넛','2020-12-20',3500, null)
insert into jt_order_item values(22,20,2,'아메리카노','2020-12-20',3000, null)
insert into jt_order_item values(23,21,7,'퍼푸라떼','2020-12-20',2000, null)
insert into jt_order_item values(24,21,3,'바닐라라떼','2020-12-20',3800, null)
insert into jt_order_item values(25,22,2,'아메리카노','2020-12-20',3000, null)
insert into jt_order_item values(26,22,5,'카페라떼','2020-12-20',3500, null)




insert into jt_item values(it_no_seq.nextval,1,'헤이즐넛',3500,null,null,0);
insert into jt_item values(it_no_seq.nextval,1,'아메리카노',3000,null,null,0);
insert into jt_item values(it_no_seq.nextval,1,'바닐라라떼',3800,null,null,0);
insert into jt_item values(it_no_seq.nextval,1,'에스프레소',4000,null,null,0);
insert into jt_item values(it_no_seq.nextval,1,'카페라떼',3500,null,null,0);
insert into jt_item values(it_no_seq.nextval,2,'퍼푸치노',2000,null,null,0);
insert into jt_item values(it_no_seq.nextval,2,'퍼푸라떼',2000,null,null,0);
insert into jt_item values(it_no_seq.nextval,2,'퍼푸즐넛',2500,null,null,0);
insert into jt_item values(it_no_seq.nextval,2,'도그비어',2500,null,null,0);
insert into jt_item values(it_no_seq.nextval,2,'퍼피케이크',3000,null,null,0);


select * from jt_order where od_date ='2020/12/20'
select * from jt_order WHERE TO_CHAR(od_date, 'YYYY-MM-DD') = '2020-12-20'


create view daily_sales
as
select od_price, od_date
from jt_order j, jt_order_item i
where od_date = '2021-01-03'

drop view daily_sales
select * from daily_sales

insert into jt_order values(5, '주문', '2021-01-03', 3500)

WHERE TO_CHAR(REGDATE, 'YYYYMMDD') = '20190701';


select sum(od_price) as price from jt_order WHERE od_date BETWEEN TO_DATE('2020-12-01') AND TO_DATE('2020-12-31');


 
주문 고유번호
주문테이블번호
상품번호
주문명
주문날짜
주문금액
주문자