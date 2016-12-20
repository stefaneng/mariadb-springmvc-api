# Raw Notes

## MariaDB
- Installed using homebrew

How to do this automatically? Using JPA?

### Creating Database
```
CREATE DATABASE springJpaExample;
CREATE TABLE user (id iNt PRIMARY KEY AUTO_INCREMENT, first_name text NOT NULL, last_name text NOT NULL);
```

### Random DB Stuff
Our database is populated with the data we put in from spring
```
MariaDB [springJpaExample]> SELECT * FROM user;
+----+------------+-----------+
| id | first_name | last_name |
+----+------------+-----------+
|  1 | Stefan     | Eng       |
|  2 | John       | Smith     |
|  3 | Alex       | Johnson   |
+----+------------+-----------+
3 rows in set (0.00 sec)
```

We can add a user in mariadb and have it show up on our front end
```
INSERT INTO user VALUES ("Donald", "Trump");
```

Problem is that if we re-run then we will keep adding new users (since we have auto-incrementing key).
