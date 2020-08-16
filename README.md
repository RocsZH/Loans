<img src="http://nepxion.gitee.io/docs/polaris-doc/Banner.png">

# Polaris【北极星】企业级云原生微服务框架
[![Total lines](https://tokei.rs/b1/github/Nepxion/Polaris?category=lines)](https://tokei.rs/b1/github/Nepxion/Polaris?category=lines)  [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?label=license)](https://github.com/Nepxion/Polaris/blob/master/LICENSE)  [![Build Status](https://travis-ci.org/Nepxion/Polaris.svg?branch=master)](https://travis-ci.org/Nepxion/Polaris)  [![Codacy Badge](https://api.codacy.com/project/badge/Grade/8e39a24e1be740c58b83fb81763ba317)](https://www.codacy.com/project/HaojunRen/Polaris/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Nepxion/Polaris&amp;utm_campaign=Badge_Grade_Dashboard)

Polaris【北极星】企业级云原生微服务框架，围绕Discovery【探索】框架打造，基于Spring Cloud Discovery服务注册发现、Ribbon负载均衡、Feign和RestTemplate调用等组件全方位增强的企业级微服务开源解决方案，更贴近企业级需求，赋能和助力企业快速搭建基础架构的底层云原生微服务框架

支持如下中间件的集成和封装，遵从最严格的Maven对称结构和规范，最严格的命名格式
- 支持阿里巴巴Nacos、Eureka、Consul三个服务注册发现中心
- 支持阿里巴巴Nacos、携程Apollo两个远程配置中心
- 支持阿里巴巴Sentinel和Hystrix两个熔断隔离限流降级中间件
- 支持Uber Jaeger、Apache Skywalking两个符合OpenTracing调用链中间件
- 支持Java Agent解决异步跨线程ThreadLocal上下文传递
- 支持Prometheus Micrometer和Spring Boot Admin监控中间件
- 支持Spring Cloud Gateway、Zuul网关、微服务、控制台、自动化测试五个独立微服务模块
- 支持和兼容Spring Cloud Finchley版、Greenwich版和Hoxton版

支持如下的应用型功能
- 支持动态域名和双云双活的配置，支持跨云的服务注册和配置读取（例如，阿里云上的微服务想要注册到华为云上的Nacos注册中心或者跨云读取Apollo配置中心的配置，通过运维侧修改相关配置驱动在域名上的跨云实现）
- 支持不需要更改任何代码，在pom.xml上实现同类型的组件一键切换（例如，Eureka注册中心切换到Consul，Apollo配置中心切换到Nacos等），但需要注意的是同类型组件不可并行使用（例如，Eureka和Consul注册中心不可同时存在，Apollo和Nacos配置中心不可同时存在等）
- 支持每个组件对四个环境（DEV | FAT | UAT | PRO）的内置最佳配置，遵守“约定大于配置”的策略，业务层面零配置或微量配置即可。框架集成人员可以在里面定制个性化配置，业务开发人员支持在业务层把内置的配置覆盖掉，达到灵活使用的目的
- 支持业务开发人员使用该框架的时候，对他们尽量屏蔽一切跟Spring Cloud和中间件有关的代码书写、配置参数、环境地址等，有助于减轻业务侧的压力

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 友情提示

- Polaris【北极星】企业级云原生微服务框架的使用指南，请参考下面的“相关链接”
- Discovery【探索】框架的相关功能，请参考下面的“相关链接”

## 目录
- [请联系我](#请联系我)
- [相关链接](#相关链接)
    - [Polaris源码主页](#Polaris源码主页)
    - [Polaris指南主页](#Polaris指南主页)
    - [Discovery源码主页](#Discovery源码主页)
    - [Discovery指南主页](#Discovery指南主页)
    - [Discovery文档主页](#Discovery文档主页)
- [架构工程](#架构工程)
    - [工程介绍](#工程介绍)
- [集成步骤](#集成步骤)
    - [组件切换](#组件切换)
        - [注册发现组件切换](#注册发现组件切换)
        - [配置组件切换](#配置组件切换)
        - [监控组件切换](#监控组件切换)
        - [防护组件切换](#防护组件切换)
    - [环境切换](#环境切换)
    - [注解切换](#注解切换)
- [使用步骤](#使用步骤)
    - [环境和域名配置](#环境和域名配置)
    - [Agent使用和配置](#Agent使用和配置)
- [Star走势图](#Star走势图)

## 请联系我
微信、公众号和文档

![Alt text](http://nepxion.gitee.io/docs/zxing-doc/微信-1.jpg)![Alt text](http://nepxion.gitee.io/docs/zxing-doc/公众号-1.jpg)![Alt text](http://nepxion.gitee.io/docs/zxing-doc/文档-1.jpg)

## 相关链接

### Polaris源码主页
[访问链接](https://github.com/Nepxion/Polaris)

### Polaris指南主页
[访问链接](https://github.com/Nepxion/PolarisGuide)

### Discovery源码主页
[访问链接](https://github.com/Nepxion/Discovery)

### Discovery指南主页
[访问链接](https://github.com/Nepxion/DiscoveryGuide)

### Discovery文档主页
[访问链接](https://gitee.com/Nepxion/Docs/tree/master/web-doc)

## 架构工程

### 工程介绍

| 工程名 | 描述 |
| --- | --- |
| <img src="http://nepxion.gitee.io/docs/icon-doc/direction_east.png"> polaris-parent | Polaris Parent定义 |
| <img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-platform | Polaris平台目录 |
| &nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component | Polaris组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-common | Polaris通用组件 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-env | Polaris环境组件，支持动态域名，双云双活，<br>支持DEV、FAT、UAT、PRO四个环境配置动态读取 |
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

### 组件切换
![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 框架默认的组件，如下：
- 注册发现组件：Nacos
- 配置组件：Nacos
- 监控组件：Jaeger
- 防护组件：Sentinel
- 灰度蓝绿组件：Discovery（不需要切换）

#### 注册发现组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```
You can choose Nacos or Eureka or Consul Discovery
```
把搜索出来的两个pom.xml换成使用者想要的组件

#### 配置组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```
You can choose Apollo or Nacos Config
```
把搜索出来的四个pom.xml换成使用者想要的组件

#### 监控组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```
You can choose Skywalking or Jaeger Monitor
```
把搜索出来的一个pom.xml换成使用者想要的组件，使用者可以激活其它监控组件

#### 防护组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```
You can choose Sentinel or Hystrix Protector
```
把搜索出来的三个pom.xml换成使用者想要的组件

### 环境切换
所有的组件都支持四个环境（DEV | FAT | UAT | PRO），分别对应开发环境、测试环境、准生产环境、生产环境

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 框架默认的组件环境配置，并以Nacos注册为示例，如下：

| 环境 | 域名或者IP地址 | 示例 |
| --- | --- | --- |
| DEV | 默认为127.0.0.1:port | spring.cloud.nacos.discovery.server-addr=<br>127.0.0.1:8848 |
| FAT | {组件名}-fat-{可选的区域名}.{根域} | spring.cloud.nacos.discovery.server-addr=<br>nacos-fat{-%zone%}.nepxion.com |
| UAT | {组件名}-uat-{可选的区域名}.{根域}| spring.cloud.nacos.discovery.server-addr=<br>nacos-uat{-%zone%}.nepxion.com |
| PRO | {组件名}-pro-{可选的区域名}.{根域} | spring.cloud.nacos.discovery.server-addr=<br>nacos-pro{-%zone%}.nepxion.com |

区域（zone）名表示用来区别多活或者多云的域名后缀或者前缀
- 域名表达式为{组件名}-{环境号}-{可选的区域名}.{根域}。使用者可以改变前缀或者后缀的组装形式和顺序，前缀中的“-”可以用其它符号来代替
- 实现通配处理，通配格式为{-%zone%}，如果区域（zone）名不设置，那么变成{组件名}-{环境号}.{根域}的简单格式
- 通过运维侧来实现环境号和区域名的指定
- 没有条件实现多环境的域名支持，那么采用IP地址也支持

使用者需要根据企业的实际情况，把组件的四个环境域名和IP地址一一做更改

### 注解切换
当配置中心组件切换到Apollo的时候，需要激活Apollo注解@EnableApolloConfig
- @EnablePolarisGateway
- @EnablePolarisZuul
- @EnablePolarisService
- @EnablePolarisConsole

## 使用步骤

### 环境和域名配置

Server.properties或者-D，或者System Property，或者System Env

### Agent使用和配置

- Skywalking Agent使用和配置

- 跨线程异步调用Agent使用和配置

## Star走势图

[![Stargazers over time](https://starchart.cc/Nepxion/Polaris.svg)](https://starchart.cc/Nepxion/Polaris)