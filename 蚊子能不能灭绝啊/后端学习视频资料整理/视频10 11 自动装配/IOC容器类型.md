1. **ApplicationContext**:

   - `ApplicationContext` 是一个顶层接口，为Spring容器提供了基本的功能。它管理应用中的bean定义并负责创建和管理应用中对象的生命周期和配置。
   - 所有的Spring应用上下文类型都实现了`ApplicationContext`接口，这就是它们被称为上下文的原因。
   - 它不直接用于实例化，因为它是一个接口。

2. **AnnotationConfigApplicationContext**:

   - `AnnotationConfigApplicationContext` 是针对Java注解配置的Spring应用上下文。

   - 使用这个上下文类型，可以通过Java类的方式配置Spring容器。这些Java类是用注解（如`@Configuration`, `@Component`等）进行标注的。

   - 创建`AnnotationConfigApplicationContext`的实例通常用于基于Java的配置：

     ```java
     ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
     ```

   - 其中`AppConfig.class`是一个使用`@Configuration`注解的Java类，它包含了bean的定义和配置。

3. **ClassPathXmlApplicationContext**:

   - `ClassPathXmlApplicationContext` 是针对基于XML配置文件的Spring应用上下文。

   - 使用这个上下文类型，可以加载类路径下的XML配置文件来配置Spring容器。

   - 创建`ClassPathXmlApplicationContext`的实例通常用于基于XML的配置：

     ```java
     ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
     ```

   - 其中`"applicationContext.xml"`是包含了bean定义的XML配置文件。

4. **FileSystemXmlApplicationContext**:

   - 与`ClassPathXmlApplicationContext`类似，但它加载的是文件系统内的XML配置文件，而不是类路径下的。

   - 创建方式类似，只是构造函数接受文件系统中配置文件的路径：

     ```java
     ApplicationContext context = new FileSystemXmlApplicationContext("path/to/applicationContext.xml");
     ```

5. **WebApplicationContext**:

   - 特别为Web应用设计，它是`ApplicationContext`的扩展。`WebApplicationContext`为Web应用提供了上下文，例如，在Spring MVC应用中非常重要。

   - 在Web应用中，通常不需要手动创建`WebApplicationContext`，它会通过在`web.xml`中配置`ContextLoaderListener`或使用Spring的Web初始化类自动初始化。

6. **AnnotationConfigWebApplicationContext**:

   - 适用于Web应用的Java注解配置方法。它允许在Web应用中使用注解配置Spring。

   - 与`WebApplicationContext`相似，通常由框架自身初始化，例如，可以在`web.xml`中配置或通过Spring的Web初始化类使用。