## SSM项目实践

设计一个简单的书籍管理系统作为实践项目。这个系统将允许用户增加、删除、更新和查询书籍信息。这个例子将包含使用SpringMVC处理HTTP请求、MyBatis与MySQL数据库交互以及Spring框架进行依赖注入。

### 1. 创建项目

Spring initiaolizr



### 2. 准备数据

1. **创建数据库和表**: 使用MySQL创建一个名为`book_management`的数据库，并创建一个`book`表。

```mysql
CREATE DATABASE book_management;

USE book_management;

CREATE TABLE book (
    id INT AUTO_INCREMENT PRCREATE TABLE book (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publish_date DATE,
    price DECIMAL(10, 2),
    PRIMARY KEY (id)
);
```

2. **添加样本数据**

``` mysql
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



### 5. 实现功能

#### 5.1 使用注解实现对数据库的操作

1. findAllBooks
2. findById
3. insertBook
4. deleteBook
5. updateBook

#### 5.2 动态sql

#### 5.3 分页查询

#### 5.4 统一响应结果Result

#### 5.5 登录验证

1. cookie

2. session

3. jwt

#### 5.6 filter

#### 5.7 异常处理
