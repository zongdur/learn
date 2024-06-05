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
                               return_date DATE DEFAULT '1000-01-01',
                               PRIMARY KEY (id),
                               FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                               FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE
);
```

3. **样本数据**

user

```sql
INSERT INTO user (username, password) 
VALUES 
	('cat', '123456'),
	('dog', '123456'),
	('pig', '123456'),
	('tiger', '123456'),
	('lion', '123456'),
	('elephant', '123456'),
	('monkey', '123456'),
	('giraffe', '123456'),
    ('zebra', '123456');
```

book

```sql
INSERT INTO book (name, author, publish_date, price)
VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald', '1925-04-10', 19.99),
    ('To Kill a Mockingbird', 'Harper Lee', '1960-07-11', 24.99),
    ('1984', 'George Orwell', '1949-06-08', 22.99),
    ('Pride and Prejudice', 'Jane Austen', '1813-01-28', 18.99),
    ('The Catcher in the Rye', 'J.D. Salinger', '1951-07-16', 20.99),
    ('The Hobbit', 'J.R.R. Tolkien', '1937-09-21', 25.99),
    ('Moby Dick', 'Herman Melville', '1851-10-18', 17.99),
    ('War and Peace', 'Leo Tolstoy', '1869-01-01', 29.99),
    ('Crime and Punishment', 'Fyodor Dostoevsky', '1866-01-01', 21.99),
    ('The Brothers Karamazov', 'Fyodor Dostoevsky', '1880-01-01', 23.99),
    ('The Lord of the Rings', 'J.R.R. Tolkien', '1954-07-29', 27.99),
    ('One Hundred Years of Solitude', 'Gabriel Garcia Marquez', '1967-05-30', 26.99),
    ('Frankenstein', 'Mary Shelley', '1818-01-01', 18.99),
    ('Jane Eyre', 'Charlotte Bronte', '1847-10-16', 19.99),
    ('The Picture of Dorian Gray', 'Oscar Wilde', '1890-07-01', 20.99),
    ('The Alchemist', 'Paulo Coelho', '1988-01-01', 14.99),
    ('The Count of Monte Cristo', 'Alexandre Dumas', '1844-01-01', 22.99),
    ('The Little Prince', 'Antoine de Saint-Exupery', '1943-04-06', 12.99),
    ('To the Lighthouse', 'Virginia Woolf', '1927-05-05', 16.99),
    ('Brave New World', 'Aldous Huxley', '1932-01-01', 19.99),
    ('The Adventures of Tom Sawyer', 'Mark Twain', '1876-12-01', 14.99),
    ('Gone with the Wind', 'Margaret Mitchell', '1936-06-30', 21.99),
    ('Anna Karenina', 'Leo Tolstoy', '1877-01-01', 20.99),
    ('The Great Expectations', 'Charles Dickens', '1861-01-01', 18.99),
    ('The Scarlet Letter', 'Nathaniel Hawthorne', '1850-01-01', 17.99),
    ('Alice\'s Adventures in Wonderland', 'Lewis Carroll', '1865-11-26', 13.99),
    ('Don Quixote', 'Miguel de Cervantes', '1605-01-01', 23.99),
    ('The Grapes of Wrath', 'John Steinbeck', '1939-04-14', 22.99),
    ('The Divine Comedy', 'Dante Alighieri', '1320-01-01', 16.99),
    ('The Canterbury Tales', 'Geoffrey Chaucer', '1400-01-01', 15.99),
    ('Les Misérables', 'Victor Hugo', '1862-01-01', 19.99),
    ('Wuthering Heights', 'Emily Bronte', '1847-12-01', 18.99),
    ('The Sun Also Rises', 'Ernest Hemingway', '1926-10-22', 20.99),
    ('The Old Man and the Sea', 'Ernest Hemingway', '1952-09-01', 17.99);
```



borrow_book

```sql

INSERT INTO borrow_book (user_id, book_id, borrow_date, return_date)
VALUES
    (1, 1, '2023-05-10', '2023-05-20'),
    (2, 5, '2023-06-02', '2023-06-12'),
    (3, 9, '2023-07-15', '2023-07-25'),
    (4, 12, '2023-08-03', '2023-08-13'),
    (5, 18, '2023-09-18', '2023-09-28'),
    (6, 22, '2023-10-05', '2023-10-15'),
    (7, 28, '2023-11-09', '2023-11-19'),
    (8, 31, '2023-12-12', '2023-12-22'),
    (7, 7, '2024-01-02', '2024-01-12'),
    (8, 13, '2024-01-10', '2024-01-20'),
    (9, 7, '2024-01-18', '2024-01-28'),
    (9, 34, '2024-01-21', '2024-01-31'),
    (1, 13, '2024-02-01', '2024-02-11'),
    (2, 7, '2024-02-08', '2024-02-18'),
    (3, 13, '2024-02-15', '2024-02-25'),
    (1, 2, '2024-02-20', '2024-03-01'),
    (2, 6, '2024-02-25', '2024-03-06'),
    (3, 10, '2024-02-29', '2024-03-10');

INSERT INTO borrow_book (user_id, book_id, borrow_date)
VALUES
    (4, 13, '2024-03-05'),
    (5, 19, '2024-03-10'),
    (6, 23, '2024-03-15');
    
UPDATE book set borrowed=true WHERE id=13;
UPDATE book set borrowed=true WHERE id=19;
UPDATE book set borrowed=true WHERE id=23;
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
7. （仅mapper）借书：borrowBook
8. （仅mapper）还书：returnBook

##### user相关逻辑

1. 添加用户：insertUser
2. 删除用户：deleteUser

   - 触发selectByCondition1获取bookId列表
   - 触发deleteByBookId

   - 触发deleteByUser
   - 触发returnBook

##### borrow_book相关逻辑

1. （仅mapper）根据book的id删除所有借阅记录：deleteByBookId

2. （仅mapper）根据user的id删除所有借阅记录：deleteByUserId

3. 新增借阅记录：insertBorrow

   - 需补充当前时间到borrow_date

   - 触发checkState
   - 触发borrowBook
4. 新增还书记录：insertRetrun
   - 需要补充当前时间到return_date
   - 触发returnBook
5. （仅mapper）根据条件查找借阅记录
   - 根据userId和returnDate找到当前用户没还的书id：selectByCondition1



#### 5.2 动态sql

##### 5.2.1 三个条件：

1. 同包同名：XML映射文件的名称与mapper接口名称一致，并且同包下

2. XML映射文件的namespace属性与mapper接口全限定名一致

3. XML映射文件中sql语句的id与Mapper接口中的方法名一致，并保持返回类型一致

##### 5.2.2 plugins下载插件mybatis：

<img src="图书管理系统SpringBoot版.assets/image-20240331144004648.png" alt="image-20240331144004648" style="zoom:50%;" />

##### 5.2.3 头部声明：

搜索[mybatis中文网](https://mybatis.net.cn/getting-started.html)，找到并添加：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.yoyo.mapper.xxx">
    
</mapper>
```

##### 5.2.4 打开日志

```yml
  log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

##### 5.2.4 具体代码：

`<sql>`和`<include>`：findAllBooks和findById为例

`<if>`和`<where>`：deleteUser和findByCondition为例

`<foreach>`：deleteBooks为例



#### 5.3 分页查询：pagehelper

##### 5.3.1 添加依赖

```xml
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.4.6</version>
        </dependency>
```

##### 5.3.2 添加pojo：PageBean

```java
package com.yoyo.module4.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageBean {

    private Long total;
    private List rows;

    public PageBean() {
    }

    public PageBean(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}

```



##### 5.3.2 更改service文件

更改接口文件

``` java
public PageBean findAllBooks(Integer page, Integer pageSize);
```

更改impl问价：

```java
    @Override
    public PageBean findAllBooks(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Book> bookList=bookMapper.findAllBooks();
        Page<Book> bookPage=(Page<Book>) bookList;

        PageBean pageBean=new PageBean(bookPage.getTotal(),bookPage.getResult());
        return pageBean;

    }
```

##### 5.3.3 更改controller文件

```java
    @GetMapping("/list")
    public List<Book> findAllBooks(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize){
        PageBean pageBean=bookService.findAllBooks(page,pageSize);
        return pageBean.getRows();
    }

```

##### 5.3.4 通过前端页面看效果

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book List with Pagination</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        #paginationControl {
            margin-bottom: 20px;
        }
        input[type="number"] {
            padding: 5px;
            width: 50px;
            margin-right: 10px;
        }
        button {
            padding: 5px 15px;
            cursor: pointer;
        }
    </style>
    <script>
        function fetchBooks() {
            const pageNum = document.getElementById('pageNum').value || 1;
            const pageSize = document.getElementById('pageSize').value || 5;
            fetch(`http://localhost:8080/book/list?page=${pageNum}&pageSize=${pageSize}`)
                .then(response => response.json())
                .then(data => {
                    const books = data;
                    const table = document.getElementById('booksTable');
                    table.innerHTML = '<tr><th>Name</th><th>Author</th></tr>'; // Reset table and add headers
                    books.forEach(book => {
                        const row = table.insertRow();
                        const nameCell = row.insertCell(0);
                        nameCell.textContent = book.name;
                        const authorCell = row.insertCell(1);
                        authorCell.textContent = book.author;
                    });
                })
                .catch(error => console.error('Error fetching data:', error));
        }
    </script>
</head>
<body>
<h1>Book List with Pagination</h1>
<div id="paginationControl">
    Page Number: <input type="number" id="pageNum" value="1">
    Page Size: <input type="number" id="pageSize" value="10">
    <button onclick="fetchBooks()">Load Books</button>
</div>
<table id="booksTable">
    <tr>
        <th>Name</th>
        <th>Author</th>
    </tr>
</table>
</body>
</html>
```

放在resources/static下面，页面假设命名为findBooks.html，通过访问http://localhost:8080/findBooks.html 实现效果

#### 5.4 Restful和统一响应结果Result

- **REST**（Representational State Transfer）是一组架构原则，它定义了在网络上客户端和服务器之间传输和处理资源（如文本、图片、音频等）的方式。
- **RESTful**则更多地用于描述那些遵循REST原则的服务或API。简言之，当一个Web服务实现了REST原则时，我们称它为RESTful服务。

##### 5.4.1 请求

- **资源命名**：URL应该指向资源，而资源应该被命名为名词。例如，用 `/books` 来访问书籍资源，`/users` 来访问用户资源。
- **使用HTTP方法**：GET用于检索资源，POST用于创建新资源，PUT用于更新资源，DELETE用于删除资源。

| **http方法** | **资源操作** | **幂等** | **安全** |
| ------------ | ------------ | -------- | -------- |
| GET          | SELECT       | 是       | 是       |
| POST         | INSERT       | 否       | 否       |
| PUT          | UPDATE       | 是       | 否       |
| DELETE       | DELETE       | 是       | 否       |

幂等性：对同一REST接口的多次访问，得到的资源状态是相同的。

安全性：对该REST接口访问，不会使服务器端资源的状态发生改变。

##### 5.4.2 响应

Result

```java
package com.yoyo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//响应码，1 代表成功; 0 代表失败
    private String msg;  //响应信息 描述字符串
    private Object data; //返回的数据

    //增删改 成功响应
    public static Result success(){
        return new Result(1,"success",null);
    }
    //查询 成功响应
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    //失败响应
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}

```

修改controller的返回结果

修改了service层的insertBorrow返回为布尔类型

修改了删除用户时的部分bug

#### 5.5 登录验证

1. cookie

2. session

3. jwt

#### 5.6 filter

#### 5.7 异常处理



