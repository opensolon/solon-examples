
#sql("appx_get")
select app_id from appx limit 1
#end

#sql("appx_get2")
select * from appx where app_id = #{app_id} limit 1
#end


#sql("appx_getlist")
select * from appx where app_id > #{app_id} order by app_id asc limit 4
#end


#sql("appx_getids")
select app_id from appx limit 4
#end

#sql("appx_add")
insert into test (v1) values (1024);
#end
