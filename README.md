## Spring Boot配置多数据源

Spring Boot结合Spring Data JPA对于配置单数据源的情况非常简单，只需要在application.properties或application.yml中配置数据库连接参数即可。但在实际应用中，经常会使用到**多数据源**，尤其是各个数据源采用的是**不同的数据库**。

此示例展示连接两个数据源，一个为H2，一个为Mysql。其中H2数据库对应实体为Book，Mysql数据库对应实体为User，H2数据库作为主数据源。

详细说明可以参考[博客](http://101.132.162.138/blog/20.html)。