## Configuration
- spring.datasource.driver-class-name=com.mysql.jdbc.Driver 
- spring.datasource.url=jdbc:mysql://domain:port/dbName?useUnicode=true&characterEncoding=utf8 
- spring.datasource.username=dbUserName
- spring.datasource.password=dbPasswd

## User
```sql
create user 'reservation'@'%' identified by '1234';
grant all privileges on *.* to 'reservation'@'%';
grant all privileges on dbname.* to 'userid'@'%';
```

## DbInfo
- DB   : reservationdb
- User : reservation
- Pass : 1234

