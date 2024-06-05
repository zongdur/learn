## 项目实践

### 1. 创建项目

Spring initiaolizr



### 2. 准备数据(更新)

1. **创建数据库**: 使用MySQL创建一个名为`book_management`的数据库。

```mysql
CREATE DATABASE book_management;
USE book_management;
```

2. **建表**

book表

``` sql
CREATE TABLE book (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publish_date DATE,
    price DECIMAL(10, 2),
    borrowed BOOLEAN DEFAULT 0,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
```

user表

```sql
CREATE TABLE user (
                      id INT(11) NOT NULL AUTO_INCREMENT,
                      username VARCHAR(100) NOT NULL,
                      password VARCHAR(100) NOT NULL,
                      PRIMARY KEY (id)
);
```

borrow_book表

```sql
CREATE TABLE borrow_book (
                               id INT(11) NOT NULL AUTO_INCREMENT,
                               user_id INT(11) NOT NULL,
                               book_id INT(11) NOT NULL,
                               borrow_date DATE,
                               PRIMARY KEY (id),
                               FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                               FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE
);
```

3. **样本数据**

user

```sql
INSERT INTO user (username, password) VALUES ('cat', '123456');
INSERT INTO user (username, password) VALUES ('dog', '123456');
INSERT INTO user (username, password) VALUES ('pig', '123456');
```

book

```sql
INSERT INTO book (name, author, publish_date, price) VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', '1925-04-10', 19.99);
INSERT INTO book (name, author, publish_date, price) VALUES ('To Kill a Mockingbird', 'Harper Lee', '1960-07-11', 24.99);
INSERT INTO book (name, author, publish_date, price) VALUES ('1984', 'George Orwell', '1949-06-08', 22.99);
INSERT INTO book (name, author, publish_date, price) VALUES ('Pride and Prejudice', 'Jane Austen', '1813-01-28', 18.99);
INSERT INTO book (name, author, publish_date, price) VALUES ('The Catcher in the Rye', 'J.D. Salinger', '1951-07-16', 20.99);
INSERT INTO book (name, author, publish_date, price) VALUES ('The Hobbit', 'J.R.R. Tolkien', '1937-09-21', 25.99);
INSERT INTO book (name, author, publish_date, price) VALUES ('Moby Dick', 'Herman Melville', '1851-10-18', 17.99);
INSERT INTO book (name, author, publish_date, price) VALUES ('War and Peace', 'Leo Tolstoy', '1869-01-01', 29.99);
INSERT INTO book (name, author, publish_date, price) VALUES ('Crime and Punishment', 'Fyodor Dostoevsky', '1866-01-01', 21.99);
INSERT INTO book (name, author, publish_date, price) VALUES ('The Brothers Karamazov', 'Fyodor Dostoevsky', '1880-01-01', 23.99);
```





### 3. 添加依赖

pom.xml



```xml
 <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.3.1</version>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.16</version>
        </dependency>
    </dependencies>
```

### 4.配置文件

application.yml

```yml
server:
  port:8080

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/book_management
    username: root
    password: 123456
    type: com.alibaba.druid.pool.DruidDataSource

mybatis:
  configuration:
    map-underscore-to-camel-case: true
```



### 5. 设计要实现的功能

#### 5.1 使用注解实现对数据库的操作

##### book相关逻辑

1. 找所有的书：findAllBooks
2. 通过id找书：findById
3. 通过id删书：deleteBook
   - 触发deleteByBook
4. 插入书本信息：insertBook
   - 需更新update_date
5. 更新书本信息：updateBook
   - 需更新update_date
6. （仅mapper）借阅状态查询：checkState
7. （仅mapper）修改借阅状态：borrowBook

##### user相关逻辑

1. 添加用户：insertUser
2. 删除用户：deleteUser
   - 触发deleteByUser

##### borrow_book相关逻辑

1. （仅mapper）根据book的id删除所有借阅记录：deleteByBookId

2. （仅mapper）根据user的id删除所有借阅记录：deleteByUserId

3. 新增借阅记录：insertBorrow

   - 需补充当前时间

   - 触发checkState
   - 触发borrowBook

***<u>发现一些设计的bug：没有做还书的业务</u>***

设计清单：

##### 增加pojo实体类：包含所有属性即可

- **Book**
- **User**
- **BorrowBook**

##### 增加mapper：

- **BookMapper：**findAllBooks、findById、deleteBook、insertBook、updateBook、checkState、borrowBook
- **UserMapper：**insertUser、deleteUser
- **BorrowBookMapper：**deleteByBookId、deleteByUserId、insertBorrow

##### 增加service接口/impl：

- **BookService/BookServiceImpl：**findAllBooks、findById、deleteBook（触发BorrowBookMapper的deleteByBookId）、insertBook（book.setUpdateDate(time)）、updateBook（book.setUpdateDate(time)）
- **UserService/UserServiceImpl：**insertUser、deleteUser（触发BorrowBookMapper的deleteByUserId）
- **BorrowBookService/BorrowBookServiceImpl：**insertBorrow（borrowBook.setBorrowDate(time)，触发BookMapper的borrowBook）

##### 增加controller：

- **BookController：**findAllBooks、findById、deleteBook、insertBook、updateBook
- **UserController：**insertUser、deleteUser
- **BorrowBookController：**insertBorrow
