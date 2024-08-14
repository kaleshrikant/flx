$ sudo -u postgres psql

postgres=# CREATE USER shrikant WITH PASSWORD 'kale';
CREATE ROLE


postgres=# SELECT current_user, session_user;
 current_user | session_user
--------------+--------------
 postgres     | postgres
(1 row)



postgres=# \du
                                   List of roles
 Role name |                         Attributes                         | Member of
-----------+------------------------------------------------------------+-----------
 postgres  | Superuser, Create role, Create DB, Replication, Bypass RLS | {}
 shrikant  |                                                            | {}
 sonarqube |                                                            | {}


postgres=# ALTER USER shrikant WITH SUPERUSER;
ALTER ROLE


postgres=# ALTER ROLE shrikant WITH SUPERUSER;
ALTER ROLE

postgres=# \du
                                   List of roles
 Role name |                         Attributes                         | Member of
-----------+------------------------------------------------------------+-----------
 postgres  | Superuser, Create role, Create DB, Replication, Bypass RLS | {}
 shrikant  | Superuser                                                  | {}
 sonarqube |


######################################################################################################################

postgres=# CREATE DATABASE mclbs OWNER shrikant;
CREATE DATABASE


postgres=# \l
                                    List of databases
    Name     |   Owner   | Encoding |   Collate   |    Ctype    |    Access privileges
-------------+-----------+----------+-------------+-------------+-------------------------
 mclbs       | shrikant  | UTF8     | en_US.UTF-8 | en_US.UTF-8 |
 (1 rows)



postgres=# GRANT ALL PRIVILEGES ON DATABASE mclbs TO shrikant;
GRANT



postgres=# \c mclbs
You are now connected to database "mclbs" as user "postgres".



postgres=# CREATE SCHEMA IF NOT EXISTS offer_db AUTHORIZATION shrikant;
CREATE SCHEMA



mclbs=# CREATE TABLE offer_db.offer (
          employeeId VARCHAR(255),
          accountName VARCHAR(255),
          offerId BIGINT
        );

CREATE TABLE



mclbs=# \dn+
                           List of schemas
   Name   |  Owner   |  Access privileges   |      Description
----------+----------+----------------------+------------------------
 offer_db | shrikant |                      |
(1 rows)



mclbs=# \c offer_db
You are now connected to database "offer_db" as user "postgres".



offer_db=# \dt
         List of relations
 Schema | Name  | Type  |  Owner
--------+-------+-------+----------
 public | offer | table | postgres
(1 row)



offer_db=# \d offer
                         Table "public.offer"
   Column    |          Type          | Collation | Nullable | Default
-------------+------------------------+-----------+----------+---------
 employeeid  | character varying(255) |           |          |
 accountname | character varying(255) |           |          |
 offerid     | bigint                 |           |          |




offer_db=# select * from offer;
 employeeid | accountname | offerid
------------+-------------+---------
(0 rows)


                                                           | {}

postgres=#

