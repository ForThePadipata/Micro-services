## 基于Spring Cloud 搭建的一套架构
------
## 技术架构
Micro-services是一个基于Spring cloud(Dalston.SR1) Spring Boot(1.5.4.RELEASE)的一个基础组件架构<br>
使用了Spring Cloud Eureka、Feign、Zuul、Spring config、Zipkin、Sleuth、Hystrix Turbine、Hystrix Dashboard等Spring cloud组件<br>
使用了前后端分离 前端放在服务网关中<br>
权限管理使用 jwt + spring security<br>
## MAVEN模块说明
#### 1. 基础组件说明
| 项目名称                                     | 端口   | 描述                     | URL             |
| ---------------------------------------- | ---- | ---------------------- | --------------- |
| api-gateway                | 5555 | 服务网关           | 无           |
| config-client               | 7003 | 配置中心客户端               | 无          |
| config-repo               | 无 | 配置文件
| config-server              | 7001 | 服务配置中心
| ec-auth-server               | 无 | 授权服务器     
| ec-compute-server               | 2224 | 后台管理服务生产者
| ec-entity               | 无 | 公共实体对象
| ec-eureka-server               | 1111 | 服务注册中心
| ec-monitoring               | 8999 | 服务监控Turbine + HystrixDashboard
| ec-spring-boot-admin               | 8040 | 服务监控Spring Boot Admin
| ec-user-client               | 8333 | 用户服务消费者
| ec-user-server               | 8334 | 用户服务生产者
| ecadmin-client               | 3333 | 后台管理系统
| padipata-ec-sleuth-zipkin               | 8091 | 服务跟踪系统 sleuth + zipkin
------






 
