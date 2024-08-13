$ mysql -u shrikant -p

mysql> create database flx_rb;
Query OK, 1 row affected (0.01 sec)

mysql> use flx_rb;
Database changed
mysql> CREATE TABLE participant (
    ->     employeeId varchar(255) NOT NULL,
    ->     name varchar(255) NOT NULL,
    ->     age int,
    ->     city varchar(255)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> show tables;
+------------------+
| Tables_in_flx_rb |
+------------------+
| participant      |
+------------------+
1 row in set (0.00 sec)

mysql> desc participant;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| employeeId | varchar(255) | NO   | PRI | NULL    |       |
| name       | varchar(255) | NO   |     | NULL    |       |
| age        | int          | YES  |     | NULL    |       |
| city       | varchar(255) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

