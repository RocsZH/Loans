<img src="http://nepxion.gitee.io/docs/polaris-doc/Banner.png">

# Polaris【北极星】企业级云原生微服务框架
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?label=license)](https://github.com/Nepxion/Polaris/blob/master/LICENSE)  [![Codacy Badge](https://api.codacy.com/project/badge/Grade/8e39a24e1be740c58b83fb81763ba317)](https://www.codacy.com/project/HaojunRen/Polaris/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Nepxion/Polaris&amp;utm_campaign=Badge_Grade_Dashboard)

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 如果本文档由于Github网速原因无法完整阅读，请访问
- [Polaris【北极星】企业级云原生微服务框架(PDF版)](http://nepxion.gitee.io/docs/link-doc/polaris-framework-pdf.html)
- [Polaris【北极星】企业级云原生微服务框架(HTML版)](http://nepxion.gitee.io/docs/link-doc/polaris-framework.html)

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 如果本代码由于Github网速原因无法快速阅读，请访问
- [源码Gitee同步镜像](https://gitee.com/Nepxion/Polaris)
- [源码Github原镜像](https://github.com/Nepxion/Polaris)

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 如果指南代码由于Github网速原因无法快速阅读，请访问
- [指南Gitee同步镜像](https://gitee.com/Nepxion/PolarisGuide)
- [指南Github原镜像](https://github.com/Nepxion/PolarisGuide)

Polaris【北极星】企业级云原生微服务框架，围绕Discovery【探索】框架打造，基于Spring Cloud Discovery服务注册发现、Ribbon负载均衡、Feign和RestTemplate调用等组件全方位增强的企业级云原生微服务开源解决方案，面向企业级生产需求精雕细琢，赋能和助力企业快速搭建基础架构的底层云原生微服务框架。整个架构体系打造，遵循最严格的Maven对称结构和规范，最严格的命名格式，给予使用者最舒适的使用体验

支持如下中间件的集成和封装
- 支持阿里巴巴Nacos、Eureka、Consul三个服务注册发现中心
- 支持阿里巴巴Nacos、携程Apollo两个远程配置中心
- 支持阿里巴巴Sentinel和Hystrix两个熔断限流降级权限中间件
- 支持Uber Jaeger、Apache Skywalking两个符合OpenTracing规范的调用链中间件
- 支持Prometheus Micrometer和Spring Boot Admin监控中间件
- 支持Java Agent解决异步跨线程ThreadLocal上下文传递
- 支持Spring Cloud Gateway、Zuul网关、微服务、控制台、自动化测试五个独立的应用模块
- 支持和兼容Spring Cloud Finchley版、Greenwich版和Hoxton版。默认集成Hoxton版，如果需要，请使用者自行修改成其它两个版本

支持如下应用型的功能
- 支持灰度蓝绿发布、灰度路由过滤、流量权重、限流、熔断、降级、隔离、监控、追踪等企业生产级功能
- 支持动态域名、双云双活和SET单元化的配置，支持跨云的服务注册和配置读取（例如，阿里云上的微服务想要注册到华为云上的Nacos注册中心，或者跨云读取Apollo配置中心的配置，通过运维侧修改相关配置驱动即可）。一套SDK体系可以同时适配和运行在不同的云上
- 支持在核心的pom.xml上实现同类型的组件的快速切换（例如，Eureka注册中心切换到Consul，Apollo配置中心切换到Nacos等），但同类型组件不可并存使用（例如，Eureka和Consul注册中心不可同时并存，Apollo和Nacos配置中心不可同时并存等）
- 支持框架层面实现每个组件对四个环境（DEV | FAT | UAT | PRO）的内置最佳配置，遵循全局公共配置和局部环境配置相结合的方式，遵循“约定大于配置”的策略，业务层面实现微量配置甚至零配置。框架集成人员可以内置定制化的配置，业务开发人员在业务层可以把内置的配置覆盖掉，达到扩展性强、灵活使用的目的
- 支持业务开发人员使用该框架的时候，对其尽最大可能屏蔽一切跟Spring Cloud和中间件有关的代码书写、配置参数、环境地址等，零Spring Cloud经验的业务开发人员也可以快速上手研发基于Spring Cloud微服务技术栈的业务服务，最大程度上减轻业务人员的压力

## 目录
- [请联系我](#请联系我)
- [相关链接](#相关链接)
    - [源码主页](#源码主页)
    - [指南主页](#指南主页)
    - [文档主页](#文档主页)
- [架构工程](#架构工程)
    - [工程介绍](#工程介绍)
- [集成步骤](#集成步骤)
    - [集成入口](#集成入口)
    - [组件切换](#组件切换)
        - [注册发现组件切换](#注册发现组件切换)
        - [配置组件切换](#配置组件切换)
        - [监控组件切换](#监控组件切换)
        - [防护组件切换](#防护组件切换)
    - [环境切换](#环境切换)
        - [环境和域名解析](#环境和域名解析)
        - [环境和域名设置](#环境和域名设置)
    - [注解切换](#注解切换)
    - [配置切换](#配置切换)
- [使用步骤](#使用步骤)
    - [应用搭建](#应用搭建)
        - [引入Parent](#引入Parent)
        - [引入Jar](#引入Jar)
        - [添加注解](#添加注解)
        - [添加配置](#添加配置)
    - [应用启动](#应用启动)	
        - [中间件服务启动](#中间件服务启动)
        - [Spring-Boot应用启动](#Spring-Boot应用启动)
        - [Skywalking-Agent启动](#Skywalking-Agent启动)
        - [Polaris-Agent启动](#Polaris-Agent启动)
    - [启动参数](#启动参数)
        - [Agent启动参数](#Agent启动参数)
        - [Discovery框架启动参数](#Discovery框架启动参数)
    - [验证结果](#验证结果)
        - [Postman方式验证](#Postman方式验证)
        - [自动化测试方式验证](#自动化测试方式验证)
- [回馈社区](#回馈社区)

## 请联系我
微信、公众号和文档

![Alt text](http://nepxion.gitee.io/docs/zxing-doc/微信-1.jpg)![Alt text](http://nepxion.gitee.io/docs/zxing-doc/公众号-1.jpg)![Alt text](http://nepxion.gitee.io/docs/zxing-doc/文档-1.jpg)

## 相关链接

### 源码主页
[Polaris源码主页](https://github.com/Nepxion/Polaris)

[Discovery源码主页](https://github.com/Nepxion/Discovery)

### 指南主页
[Polaris指南主页](https://github.com/Nepxion/PolarisGuide)

[Discovery指南主页](https://github.com/Nepxion/DiscoveryGuide)

### 文档主页
[文档主页](https://gitee.com/Nepxion/Docs/tree/master/web-doc)

## 架构工程

### 工程介绍

| 工程名 | 描述 |
| --- | --- |
| <img src="http://nepxion.gitee.io/docs/icon-doc/direction_east.png"> polaris-parent | Polaris Parent定义 |
| <img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-platform | Polaris平台目录 |
| &nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component | Polaris组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-common | Polaris通用组件 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-env | Polaris环境组件，支持动态域名、双云双活和SET单元化<br>支持DEV、FAT、UAT、PRO四个环境配置动态读取 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-banner | Polaris旗标组件，启动时显示旗标和重要中间件版本号信息 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-apollo | Polaris Apollo组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-apollo-starter-config | Polaris Apollo配置组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-nacos | Polaris Nacos组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-nacos-starter-config | Polaris Nacos配置组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-nacos-starter-discovery | Polaris Nacos注册发现组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-consul | Polaris Consul组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-consul-starter-discovery | Polaris Consul注册发现组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-eureka | Polaris Eureka组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-eureka-starter-discovery | Polaris Eureka注册发现组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-jaeger | Polaris OpenTracing + Jaeger组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-jaeger-starter | Polaris OpenTracing + Jaeger监控组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-jaeger-starter-sentinel | Polaris OpenTracing + Jaeger监控组件集成Sentinel的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-skywalking | Polaris SkyWalking组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-skywalking-starter | Polaris SkyWalking监控组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-skywalking-starter-sentinel | Polaris SkyWalking监控组件集成Sentinel的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-prometheus | Polaris Prometheus组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-prometheus-starter-micrometer | Polaris Prometheus监控组件集成Micrometer的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-spring-boot-admin | Polaris Spring Boot Admin组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-spring-boot-admin-starter | Polaris Polaris Spring Boot Admin监控组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-gray | Polaris Gray版本灰度蓝绿，区域路由，环境隔离等组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-gray-common | Polaris Gray通用组件 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-gray-starter-gateway | Polaris Gray集成Spring Cloud Gateway网关的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-gray-starter-zuul | Polaris Gray集成Zuul网关的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-gray-starter-service | Polaris Gray集成微服务的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-agent | Polaris Java Agent组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-agent-starter-cross-thread | Polaris支持跨线程异步调用Agent组件 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-hystrix | Polaris Hystrix限流熔断组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-hystrix-starter | Polaris支持Hystrix跨线程异步调用组件 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-sentinel | Polaris Sentinel限流熔断组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-sentinel-common | Polaris Sentinel通用组件 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-sentinel-config-starter-apollo | Polaris Sentinel集成Apollo配置组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-sentinel-config-starter-nacos | Polaris Sentinel集成Nacos配置组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-sentinel-starter-gateway | Polaris Sentinel集成Spring Cloud Gateway网关的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-sentinel-starter-zuul | Polaris Sentinel集成Zuul网关的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-sentinel-starter-service | Polaris Sentinel集成微服务的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-console | Polaris控制台组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-console-config-starter-apollo | Polaris控制台集成Apollo配置组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-console-config-starter-nacos | Polaris控制台集成Nacos配置组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-console-starter | Polaris控制台组件 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-core | Polaris核心组件目录，主要是组装和代理基础底层组件 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-banner | Polaris旗标组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-discovery | Polaris注册发现组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-discovery-gray | Polaris灰度蓝绿对注册发现组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-config | Polaris配置组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-config-gray | Polaris灰度蓝绿对配置组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-config-console | Polaris控制台对配置组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-config-sentinel | Polaris Sentinel对配置组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-protector-gateway | Polaris防护组件集成Spring Cloud Gateway网关的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-protector-zuul | Polaris防护组件集成Zuul网关的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-protector-service | Polaris防护组件集成微服务的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-monitor | Polaris监控组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-gray-gateway | Polaris灰度蓝绿组件集成Spring Cloud Gateway网关的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-gray-zuul | Polaris灰度蓝绿组件集成Zuul网关的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-gray-service | Polaris灰度蓝绿组件集成微服务的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-console | Polaris控制台组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-test | Polaris测试组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-test | Polaris测试组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-test-starter-automation | Polaris自动化测试组件 |
| &nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-framework | Polaris框架目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-framework-starter-console | Polaris框架对控制台的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-framework-starter-gateway | Polaris框架对Spring Cloud Gateway网关的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-framework-starter-zuul | Polaris框架对Zuul网关的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-framework-starter-service | Polaris框架对微服务的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-framework-starter-test | Polaris框架对测试的封装 |

## 集成步骤

### 集成入口
集成入口位于polaris-framework模块下，包括如下五个子模块
- polaris-framework-starter-gateway
- polaris-framework-starter-zuul
- polaris-framework-starter-service
- polaris-framework-starter-console
- polaris-framework-starter-test

以polaris-framework-starter-service为例，展现出高度对称统一的架构美感
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <artifactId>polaris-framework-starter-service</artifactId>
    <name>Nepxion Polaris Framework Starter Service</name>
    <packaging>jar</packaging>
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.nepxion</groupId>
        <artifactId>polaris-framework</artifactId>
        <version>1.0.0</version>
    </parent>

    <dependencies>
        <!-- 旗标核心组件 -->
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>polaris-component-core-starter-banner</artifactId>
            <version>${project.version}</version>
        </dependency>

        <!-- 注册发现核心组件 -->
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>polaris-component-core-starter-discovery</artifactId>
            <version>${project.version}</version>
        </dependency>

        <!-- 配置核心组件 -->
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>polaris-component-core-starter-config</artifactId>
            <version>${project.version}</version>
        </dependency>

        <!-- 监控核心组件 -->
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>polaris-component-core-starter-monitor</artifactId>
            <version>${project.version}</version>
        </dependency>

        <!-- 防护核心组件 -->
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>polaris-component-core-starter-protector-service</artifactId>
            <version>${project.version}</version>
        </dependency>

        <!-- 灰度蓝绿核心组件 -->
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>polaris-component-core-starter-gray-service</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>
</project>
```

### 组件切换
![](http://nepxion.gitee.io/docs/icon-doc/information.png) 框架默认生效的组件，如下
- 注册发现组件：Nacos
- 配置组件：Nacos
- 监控组件：Jaeger
- 防护组件：Sentinel
- 灰度蓝绿组件：Discovery（不需要切换）

#### 注册发现组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```xml
You can choose Nacos or Eureka or Consul Discovery
```
把搜索出来的两个pom.xml换成使用者想要的组件

#### 配置组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```xml
You can choose Apollo or Nacos Config
```
把搜索出来的四个pom.xml换成使用者想要的组件

#### 监控组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```xml
You can choose Skywalking or Jaeger Monitor
```
把搜索出来的一个pom.xml换成使用者想要的组件，使用者可以激活其它监控组件（例如，Prometheus Micrometer和Spring Boot Admin）

#### 防护组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```xml
You can choose Sentinel or Hystrix Protector
```
把搜索出来的三个pom.xml换成使用者想要的组件

### 环境切换

#### 环境和域名解析
所有的组件都支持四个环境（DEV | FAT | UAT | PRO），分别对应开发环境、测试环境、准生产环境、生产环境。框架支持动态解析和创建多活、多云和SET单元化模式的域名

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 框架默认的组件环境配置（表格中以Nacos注册为示例），如下

| 环境 | 域名或者IP地址 | 配置文件 | 示例 |
| --- | --- | --- | --- |
| DEV | 默认为127.0.0.1:port | `组件名`-dev<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>127.0.0.1:8848 |
| FAT | `组件名`-fat-`可选的区域名`.`根域` | `组件名`-fat<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>nacos-fat[-%zone%].nepxion.com |
| UAT | `组件名`-uat-`可选的区域名`.`根域` | `组件名`-uat<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>nacos-uat[-%zone%].nepxion.com |
| PRO | `组件名`-pro-`可选的区域名`.`根域` | `组件名`-pro<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>nacos-pro[-%zone%].nepxion.com |
| COMMON | 无需配置 | `组件名`-common<br>.properties | 无需配置 |

① 环境（env）号
- 定义为用来区别不同环境的标识
- 四个环境的配置文件除了定义域名或者IP地址外，也支持根据环境不同设置不同的配置值或者开关（例如，Swagger功能需要在生产环境关闭，需要在PRO配置文件里关闭）
- 除了四个环境的配置文件外，还存在一个公共配置文件，其作用是设置全局的不会随环境改变的默认配置，共享给四个环境，避免重复冗余配置。公共配置和环境配置，其关系是全局配置和局部配置的关系，如果同一个配置在公共配置文件和环境配置文件里都存在，环境配置文件优先
- 所有配置文件的位置在各个组件的src/main/resources/META-INF目录下

② 区域（zone）名
- 定义为用来区别多活、多云和SET单元化的域名的后缀或者前缀标识
- 域名表达式为`组件名`-`环境号`-`可选的区域名`.`根域`。使用者可以改变前缀或者后缀的组装形式和顺序，前缀中的“-”可以用其它符号来代替
- 实现占位处理，占位格式为[-%zone%]。如果区域（zone）名不设置，那么变成“组件名-环境号.根域”的简单格式
- 通过运维侧来实现环境号和区域名的指定（下文“环境和域名设置”会讲到）
- 如果使用者没有条件实现多环境的域名支持，那么采用IP地址也可以

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 使用者需要根据企业的实际情况，把组件的四个环境域名或者IP地址一一做更改

#### 环境和域名设置
① 通过运维侧进行环境（env）号设置
- 通过System Property或者-Denv=`环境号`，进行设置。例如，-Denv=dev
- 通过server.properties进行设置。Windows环境下该文件路径为C:/opt/settings/server.properties，Linux环境下该文件路径为/opt/settings/server.properties
```xml
env=dev
```
- 通过System Env环境变量方式进行设置
- 上述设置都未执行，则缺省为dev

② 通过运维侧进行区域（zone）名设置
- 通过System Property或者-Dzone=`区域名`，进行设置。例如，-Denv=SET-sha，SET表示单元名，sha表示双活或者多活的机房名，两者可以独立配置其中之一，也可以同时并存
- 通过server.properties进行设置。Windows环境下该文件路径为C:/opt/settings/server.properties，Linux环境下该文件路径为/opt/settings/server.properties
```xml
zone=SET-sha
```
- 通过System Env环境变量方式进行设置
- 上述设置都未执行，则缺省为空，即非多活或者多云的环境

③ 读取优先级由高到低，如下：
- System.getProperty
- System.getenv
- server.properties

### 注解切换
当配置组件切换到Apollo的时候，需要激活Apollo注解@EnableApolloConfig；非Apollo配置组件需要注释掉该注解，否则无法编译通过。需要在如下四个注解进行切换
- `@`EnablePolarisGateway
- `@`EnablePolarisZuul
- `@`EnablePolarisService
- `@`EnablePolarisConsole

### 配置切换
当防护中心选择Sentinel，并选择Apollo和Nacos做DataSource的时候，例如，当选择Apollo的时候，需要注释掉其它所有的Nacos配置。需要在如下三个模块的sentinel-common.properties配置文件里进行切换配
- polaris-component-sentinel-starter-gateway
- polaris-component-sentinel-starter-zuul
- polaris-component-sentinel-starter-service

## 使用步骤

参考[Polaris指南主页](https://github.com/Nepxion/PolarisGuide)的源码

### 应用搭建

#### 引入Parent
```xml
<parent>
    <groupId>com.nepxion</groupId>
    <artifactId>polaris-parent</artifactId>
    <version>${polaris.version}</version>
</parent>
```

#### 引入Jar
① 微服务引入
```xml
<dependency>
    <groupId>com.nepxion</groupId>
    <artifactId>polaris-framework-starter-service</artifactId>
    <version>${polaris.version}</version>
</dependency>
```

② Spring Cloud Gateway网关引入
```xml
<dependency>
    <groupId>com.nepxion</groupId>
    <artifactId>polaris-framework-starter-gateway</artifactId>
    <version>${polaris.version}</version>
</dependency>
```

③ Zuul网关引入
```xml
<dependency>
    <groupId>com.nepxion</groupId>
    <artifactId>polaris-framework-starter-zuul</artifactId>
    <version>${polaris.version}</version>
</dependency>
```

④ 控制台引入
```xml
<dependency>
    <groupId>com.nepxion</groupId>
    <artifactId>polaris-framework-starter-console</artifactId>
    <version>${polaris.version}</version>
</dependency>
```

⑤ 测试端引入
```xml
<dependency>
    <groupId>com.nepxion</groupId>
    <artifactId>polaris-framework-starter-test</artifactId>
    <version>${polaris.version}</version>
</dependency>
```

#### 添加注解
下面四个注解封装了标准Spring Boot、Spring Cloud、Apollo、服务注册发现等多个注解，可以有效的降低业务使用成本

① 微服务引入
```java
@EnablePolarisService
public class PolarisApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PolarisApplication.class).run(args);
    }
}
```

② Spring Cloud Gateway网关引入
```java
@EnablePolarisGateway
public class PolarisApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PolarisApplication.class).run(args);
    }
}
```

③ Zuul网关引入
```java
@EnablePolarisZuul
public class PolarisApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PolarisApplication.class).run(args);
    }
}
```

④ 控制台引入
```java
@EnablePolarisConsole
public class PolarisApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PolarisApplication.class).run(args);
    }
}
```

#### 添加配置
由于大量配置已经内置到框架里，除了服务名和端口号之外，业务层原则上不需要再添加Spring Cloud和中间件其它配置，当然也可以覆盖掉默认内置的配置

### 应用启动

#### 中间件服务启动
Polaris默认集成，需要依赖Nacos Server和Jaeger Server

- Nacos [必须]
    - Nacos服务器版本，推荐用最新版本，从[https://github.com/alibaba/nacos/releases](https://github.com/alibaba/nacos/releases)获取
    - 功能界面主页，[http://localhost:8848/nacos/index.html](http://localhost:8848/nacos/index.html)

- Jaeger [可选]
    - Jaeger服务器版本，推荐用最新版本，从[https://github.com/jaegertracing/jaeger/releases](https://github.com/jaegertracing/jaeger/releases)获取
    - 功能界面主页，[http://localhost:16686](http://localhost:16686)

#### Spring-Boot应用启动
跟原生的Spring Boot应用程序启动方式一致。在IDE中，启动四个应用服务和两个网关服务，控制平台服务，如下 

| 类名 | 微服务 | 服务端口 | 版本 | 区域 | 子环境 |
| --- | --- | --- | --- | --- | -- | 
| PolarisServiceA1.java | A1 | 3001 | 1.0 | dev | env1 |
| PolarisServiceA2.java | A2 | 3002 | 1.1 | qa | common |
| PolarisServiceB1.java | B1 | 4001 | 1.0 | qa | env1 |
| PolarisServiceB2.java | B2 | 4002 | 1.1 | dev | common | 
| PolarisGateway.java | Gateway | 5001 | 1.0 | 无 | 无 |
| PolarisZuul.java | Zuul | 5002 | 1.0 | 无 | 无 |
| PolarisConsole.java | Console | 6001 | 1.0 | 无 | 无 |

#### Skywalking-Agent启动
获取Skywalking Agent，放置在指定目录（例如，C:/opt/apache-skywalking-apm-bin/agent/），通过-javaagent命令启动
		
#### Polaris-Agent启动
灰度路由Header和调用链Span在Hystrix线程池隔离模式下或者线程、线程池、@Async注解等异步调用Feign或者RestTemplate时，通过线程上下文切换会存在丢失Header的问题，通过下述步骤解决，同时适用于网关端和服务端。该方案可以替代Hystrix线程池隔离模式下的解决方案，也适用于其它有相同使用场景的基础框架和业务场景，例如：Dubbo

在如下源码目录下获取Polaris Agent
```xml
polaris-platform\polaris-component\polaris-component-agent\polaris-component-agent-starter-cross-thread\agent
```

① 插件使用
- polaris-agent.jar为Agent引导启动程序，JVM启动时进行加载；agent/plugin目录包含polaris-agent-plugin.jar为Polaris/Discovery框架自带的实现方案，业务系统可以自定义plugin，解决业务自己定义的上下文跨线程传递
- 通过如下-javaagent启动
```xml
-javaagent:/agent/polaris-agent.jar -Dthread.scan.packages=com.abc;com.xyz -Dthread.request.decorator.enabled=true
```
- 参数说明
    - /agent：Agent所在的目录，需要对应到实际的目录上
    - thread.scan.packages：Runnable，Callable对象所在的扫描目录，该目录下的Runnable，Callable对象都会被装饰。该目录最好精细和准确，这样可以减少被装饰的对象数，提高性能，目录如果有多个，用“;”分隔
    - thread.request.decorator.enabled：异步调用场景下在服务端的Request请求的装饰，当主线程先于子线程执行完的时候，Request会被Destory，导致Header仍旧拿不到，开启装饰，就可以确保拿到。默认为关闭，根据实践经验，大多数场景下，需要开启这个开关	

```xml
扫描目录thread.scan.packages定义，该参数只作用于服务侧，网关侧不需要加
1. @Async场景下的扫描目录为org.springframework.aop.interceptor
2. Hystrix线程池隔离场景下的扫描目录为com.netflix.hystrix
3. 线程、线程池的扫描目录为自定义Runnable，Callable对象所在类的目录
```

② 插件扩展
- 根据规范开发一个插件，插件提供了钩子函数，在某个类被加载的时候，可以注册一个事件到线程上下文切换事件当中，实现业务自定义ThreadLocal的跨线程传递。参考：discovery-plugin-strategy-starter-agent-plugin模块的com.nepxion.discovery.plugin.strategy.starter.agent.plugin.service下的实现方式
- plugin目录为放置需要在线程切换时进行ThreadLocal传递的自定义插件。业务自定义插件开发完后，放入到plugin目录下即可

### 启动参数

#### Agent启动参数
Polaris应用完整启动参数如下（可以忽略包括-Dmetadata.version后面的启动参数，，）
```xml
PolarisServiceA（同步服务）:
-javaagent:C:/opt/apache-skywalking-apm-bin/agent/skywalking-agent.jar -Dskywalking.agent.service_name=polaris-service-a -Dpolaris.skywalking.agent.version=1.0.0

PolarisServiceA（异步服务）:
-javaagent:C:/opt/polaris-agent/polaris-agent.jar -Dthread.scan.packages=com.nepxion.polaris.guide.service;org.springframework.aop.interceptor;com.netflix.hystrix -Dthread.request.decorator.enabled=true -javaagent:C:/opt/apache-skywalking-apm-bin/agent/skywalking-agent.jar -Dskywalking.agent.service_name=polaris-service-a -Dpolaris.skywalking.agent.version=1.0.0

PolarisServiceB（同步服务）:
-javaagent:C:/opt/apache-skywalking-apm-bin/agent/skywalking-agent.jar -Dskywalking.agent.service_name=polaris-service-b -Dpolaris.skywalking.agent.version=1.0.0

PolarisZuul（同步网关）:
-javaagent:C:/opt/apache-skywalking-apm-bin/agent/skywalking-agent.jar -Dskywalking.agent.service_name=polaris-zuul -Dpolaris.skywalking.agent.version=1.0.0

PolarisGateway（异步网关）:
-javaagent:C:/opt/apache-skywalking-apm-bin/agent/skywalking-agent.jar -Dskywalking.agent.service_name=polaris-gateway -Dpolaris.skywalking.agent.version=1.0.0
```

#### Discovery框架启动参数
灰度蓝绿发布和子环境隔离路由的元数据注册的启动参数，分别对应灰度蓝绿版本号，区域号，子环境号，最后一项是启动的时候是否显示旗标为彩色，可以忽略
```xml
-Dmetadata.version=polaris-001 -Dmetadata.region=region1 -Dmetadata.env=env1 -Dnepxion.banner.shown.ansi.mode=true
```

### 验证结果

#### Postman方式验证
- 导入Postman的测试脚本，[脚本地址](https://github.com/Nepxion/PolarisGuide/raw/master/postman.json)
- 执行“Polaris网关测试用例”，观察输出结果，5002端口对应的是Zuul网关，5001端口对应的是Spring Cloud Gateway网关
- 执行“Polaris网关全链路侦测测试用例”，观察输出结果，5002端口对应的是Zuul网关，5001端口对应的是Spring Cloud Gateway网关

#### 自动化测试方式验证
- 运行PolarisTest，观察输出结果，自动化测试用例是否都通过

## 回馈社区
- 使用者可以添加更多的中间件到框架里，并希望能回馈给社区
- 使用者可以根据企业实际情况，添加更多的配置到框架层并优化内置的参数，并希望能回馈给社区