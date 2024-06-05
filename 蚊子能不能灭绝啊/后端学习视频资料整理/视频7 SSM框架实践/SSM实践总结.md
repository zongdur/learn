## SSM项目实践

设计一个简单的书籍管理系统作为实践项目。这个系统将允许用户增加、删除、更新和查询书籍信息。这个例子将包含使用SpringMVC处理HTTP请求、MyBatis与MySQL数据库交互以及Spring框架进行依赖注入。

### 1. 创建项目

**在IDEA中创建Maven项目**: 选择`org.apache.maven.archetypes:maven-archetype-webapp`，会创建一个包含`src/main/webapp`目录的简单Java项目。

（使用Spring Initializr会快速生成一个Spring Boot项目，这个项目已经配置好了Spring的基础结构。由于我们是要学习Spring，所以不能选择它）



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

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>org.yoyo</groupId>
  <artifactId>BooksManagementSystem</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <name>BooksManagementSystem Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <dependencies>
    <!--Spring-->
    <!--Spring MVC-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.3.20</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>5.2.10.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>5.3.20</version>
    </dependency>
    <!--mybatis-->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.10</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>2.0.7</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.29</version>
    </dependency>
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.16</version>
    </dependency>
    <!--jstl-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <!--servlet-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
    </dependency>
    <!-- Lombok -->
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.6</version>
      <scope>provided</scope>
    </dependency>

  </dependencies>

  <build>

    <resources>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.xml</include>
        </includes>
      </resource>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>*.xml</include>
          <include>*.properties</include>
        </includes>
      </resource>
    </resources>
    <finalName>BooksManagementSystem</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>

```

### 4. 添加源码目录和配置文件

web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
  <display-name>Archetype Created Web Application</display-name>
  <!--启动Spring上下文-->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

  <!--字符编码过滤器-->
  <filter>
    <filter-name>characterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>characterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <!--dispatcherServlet-->
  <servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>


</web-app>
```

applicaitonContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="
         http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context
         http://www.springframework.org/schema/context/spring-context.xsd
         http://www.springframework.org/schema/tx
         http://www.springframework.org/schema/tx/spring-tx.xsd">
    <!--整合mybatis-->
    <context:property-placeholder location="classpath:jdbc.properties"/>
    <!--配置数据库连接池-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
        init-method="init" destroy-method="close">
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="initialSize" value="${jdbc.initialSize}"/>
        <property name="maxActive" value="${jdbc.maxActive}"/>
    </bean>
    <!--SqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="mapperLocations" value="classpath:com/yoyo/mapper/*.xml"/>
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
    </bean>

    <!--扫描自定义的mapper接口-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.yoyo.mapper"></property>
    </bean>

    <!-- 组件扫描，自动发现和注册Bean -->
    <context:component-scan base-package="com.yoyo" />


</beans>
```

jdbc.properties

```properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/book_management
jdbc.username=root
jdbc.password=123456


jdbc.initialSize=1 
jdbc.maxActive=5  
```

mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
    <typeAliases>
        <!-- 批量配置别名：指定批量定义别名的类包，别名为类名（首字母大小写都可） -->
        <!--配置别名是方便在mapper.xml里面的resultType和parameterType不用写全限定类名，只需要写别名就行-->
        <package name="com.yoyo.pojo"/>
    </typeAliases>
</configuration>

```

spring-mvc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/mvc
                           http://www.springframework.org/schema/mvc/spring-mvc.xsd
                           http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 启动注解驱动 -->
    <mvc:annotation-driven></mvc:annotation-driven>
    <!-- 组件扫描 -->
    <context:component-scan base-package="com.yoyo.controller" ></context:component-scan>

    <!-- 视图解析器配置 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/view/" />
        <property name="suffix" value=".jsp" />
    </bean>
</beans>
```

新建源码目录：

```css
src/
└── main/
    ├── java/
    │   ├── com/
    │   │   └── example/
    │   │       ├── controller/
    │   │       ├── service/
    │   │           └──impl/
    │   │       ├── mapper/
    │   │       ├── pojo/
    ├── resources/
    │   └── applicationContext.xml
    │   └── mybatis-config.xml
    │   └── jdbc.properties
    │   └── spring-mvc.xml    
    └── webapp/
        ├── WEB-INF/ 
        │   ├── views/
        │   └── web.xml
        └── static/
```

### 5. 添加源码

Book.java

```java
package com.yoyo.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Book {
    private Integer id;
    private String name;
    private String author;
    private Date publishDate;
    private BigDecimal price;    
}
```

BookMapper.java

```java
package com.yoyo.mapper;

import com.yoyo.pojo.Book;
import java.util.List;
public interface BookMapper {
    List<Book> findAllBooks();
    Book findBookById(int id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
}
```



BookMapper.xml

```xml
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.yoyo.mapper.BookMapper">

<select id="findAllBooks" resultType="com.yoyo.pojo.Book">
    SELECT * FROM book
</select>

<select id="findBookById" parameterType="int" resultType="com.yoyo.pojo.Book">
    SELECT * FROM book WHERE id = #{id}
</select>

<insert id="addBook" parameterType="com.yoyo.pojo.Book">
    INSERT INTO book (name, author, publish_date, price) VALUES (#{name}, #{author}, #{publishDate}, #{price})
</insert>

<update id="updateBook" parameterType="com.yoyo.pojo.Book">
    UPDATE book SET name = #{name}, author = #{author}, publish_date = #{publishDate}, price = #{price} WHERE id = #{id}
</update>

<delete id="deleteBook" parameterType="int">
    DELETE FROM book WHERE id = #{id}
</delete>
    
</mapper>

```

BookService.java

```java
package com.yoyo.service;

import com.yoyo.pojo.Book;
import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBookById(int id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
}
```

BookServiceImpl.java

````java
package com.yoyo.service.impl;

import com.yoyo.mapper.BookMapper;
import com.yoyo.pojo.Book;
import com.yoyo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public Book findBookById(int id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookMapper.deleteBook(id);
    }
}

````

BookController.java

```java
package com.yoyo.controller;

import com.yoyo.pojo.Book;
import com.yoyo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String listBooks(Model model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "listBooks"; // 对应的JSP页面名
    }
}
```

listBooks.jsp

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>
    <head>
    <title>Book List</title>
</head>
<body>
<h2>Book List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>PublishDate</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.publishDate}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

```



### 6. 配置Tomcat