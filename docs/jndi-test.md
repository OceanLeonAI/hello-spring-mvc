# JNDI测试

1. MYSQL
   ```sql

      select * from sysuser;
      
      SHOW STATUS LIKE 'Threads%';
      
      show variables like '%max_connection%';
      
      show status like 'max%connections';
      
      SELECT USER AS login_user, LEFT ( HOST, POSITION( ':' IN HOST ) - 1 ) AS login_ip, count( 1 ) AS login_count
      FROM `information_schema`.`PROCESSLIST` P WHERE P.USER NOT IN ( 'root', 'repl', 'system user' )   GROUP BY USER,LEFT (
      HOST, POSITION( ':' IN HOST ) - 1 );
      
      SELECT * FROM performance_schema.hosts;
      
      select SUBSTRING_INDEX(host,':',1) as ip , count(*) from information_schema.processlist group by ip;
      
      show processlist;
      
      show full processlist;
      
      show status like 'Threads_connected';
      
      select * from sysuser;
      
      show full processlist;

    ```

2. SQLSERVER

   ```sql
      -- 查询数据库当前连接数
      select *
      from sysprocesses
      where dbid in (select dbid from sysdatabases where name = 'Leon');
   ```

