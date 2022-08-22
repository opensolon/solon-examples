appx_get
===
```sql
select app_id from appx limit 1
```

appx_get2
===
```sql
select * from appx where app_id = #{app_id} limit 1
```

appx_getlist
===
```sql
select * from appx where app_id > #{app_id} order by app_id asc limit 4
```

appx_getlist_page
===
```sql
select
    -- @pageTag(){
    app_id
    -- @} 
from appx where app_id > #{app_id}
```


appx_getids
===
```sql
select app_id from appx limit 4
```

appx_add
===
```sql
insert into test (v1) values (1024);
```