
select * from s_voucher_type;

insert into s_voucher_type (voucher_type_code,voucher_type_name) values('1','收款凭证');
insert into s_voucher_type (voucher_type_code,voucher_type_name) values('2','付款凭证');
insert into s_voucher_type (voucher_type_code,voucher_type_name) values('3','转账凭证');


select * from t_voucher_detail

update t_voucher_detail set charge_flag='00' where trim(voucher_code) in('20100202-333')

select * from t_account  where account_code='10010'

select * from s_account_type


select * from t_voucher

delete from t_voucher where voucher_code='20100202-0003'

insert into t_voucher (voucher_type_code,debit_sum,credit_sum,staff_code,unit_code,voucher_code,op_time,id) 
values('3',200,200,'41000871','0101','20100202-0003',null,null)

select debit_sum from t_voucher

select * from t_staff 
select * from t_unit

update t_voucher set flag=10 where id in (x1,x2,x3)


select distinct a.debit_sum,a.credit_sum ,c.staff_name,d.unit_name,e.voucher_type_name,a.voucher_code,b.charge_flag 
from t_voucher a,t_voucher_detail b ,t_staff c,t_unit d,s_voucher_type e 
where a.voucher_code=b.voucher_code 
  and a.staff_code=c.staff_code   
  and a.unit_code=d.unit_code 
  and a.voucher_type_code=e.voucher_type_code   
  and a.voucher_type_code='3' 
  and b.charge_flag='00'

select a.debit_sum,a.credit_sum ,c.staff_name,d.unit_name,e.voucher_type_name,a.voucher_code,b.charge_flag from t_voucher a,t_voucher_detail b ,t_staff c,t_unit d,s_voucher_type e where a.voucher_code=b.voucher_code and a.staff_code=c.staff_code   and a.unit_code=d.unit_code and a.voucher_type_code=e.voucher_type_code  


select * from ( select a.debit_sum,a.credit_sum ,c.staff_name,d.unit_name,e.voucher_type_name,a.voucher_code,b.charge_flag from t_voucher a,t_voucher_detail b ,t_staff c,t_unit d,s_voucher_type e where a.voucher_code=b.voucher_code and a.staff_code=c.staff_code   and a.unit_code=d.unit_code and a.voucher_type_code=e.voucher_type_code ) where rownum <= 1

select count(*) from (select distinct *  from t_voucher a,t_voucher_detail b ,t_staff c,t_unit d,s_voucher_type e where a.voucher_code=b.voucher_code and a.staff_code=c.staff_code   and a.unit_code=d.unit_code and a.voucher_type_code=e.voucher_type_code  )

select distinct a.debit_sum,a.credit_sum ,c.staff_name,d.unit_name,e.voucher_type_name,a.voucher_code,b.charge_flag from t_voucher a,t_voucher_detail b ,t_staff c,t_unit d,s_voucher_type e where a.voucher_code=b.voucher_code and a.staff_code=c.staff_code   and a.unit_code=d.unit_code and a.voucher_type_code=e.voucher_type_code  



select count(*) from (select distinct a.debit_sum,a.credit_sum ,c.staff_name,d.unit_name,e.voucher_type_name,a.voucher_code,b.charge_flag from t_voucher a,t_voucher_detail b ,t_staff c,t_unit d,s_voucher_type e where a.voucher_code=b.voucher_code and a.staff_code=c.staff_code   and a.unit_code=d.unit_code and a.voucher_type_code=e.voucher_type_code  )


select * from t_voucher_detail a,t_account b where a.account_code=b.account_code and a.voucher_code='20100202-0003'