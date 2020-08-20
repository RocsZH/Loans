<img src="http://nepxion.gitee.io/docs/polaris-doc/Banner.png">

# Polaris【北极星】企业级云原生微服务框架
[![Total lines](https://tokei.rs/b1/github/Nepxion/Polaris?category=lines)](https://tokei.rs/b1/github/Nepxion/Polaris?category=lines)  [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?label=license)](https://github.com/Nepxion/Polaris/blob/master/LICENSE)  [![Build Status](https://travis-ci.org/Nepxion/Discovery.svg?branch=master)](https://travis-ci.org/Nepxion/Discovery)  [![Codacy Badge](https://api.codacy.com/project/badge/Grade/8e39a24e1be740c58b83fb81763ba317)](https://www.codacy.com/project/HaojunRen/Discovery/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Nepxion/Discovery&amp;utm_campaign=Badge_Grade_Dashboard)

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 如果本文档由于Github网速原因无法完整阅读，请访问
- [Polaris【北极星】企业级云原生微服务框架(PDF版)](http://nepxion.gitee.io/docs/link-doc/polaris-framework-pdf.html)
- [Polaris【北极星】企业级云原生微服务框架(HTML版)](http://nepxion.gitee.io/docs/link-doc/polaris-framework.html)

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 如果本代码由于Github网速原因无法快速阅读，请访问
- [源码Gitee同步镜像](https://gitee.com/Nepxion/Polaris)
- [源码Github原镜像](https://github.com/Nepxion/Polaris)

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 如果指南示例的代码和文档由于Github网速原因无法快速阅读，请访问
- [指南Gitee同步镜像](https://gitee.com/Nepxion/PolarisGuide)
- [指南Github原镜像](https://github.com/Nepxion/PolarisGuide)

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 指南示例包含两个版本，请访问
- 普遍适用版本，参考[指南示例极简版](https://github.com/Nepxion/DiscoveryGuide/tree/master)获取，分支为master
- 基于Spring Boot 2.3.x特性制作的Docker版本，参考[指南示例高级版](https://github.com/Nepxion/DiscoveryGuide/tree/premium)获取，分支为premium

## 前言

① 云原生（Cloud Native）定义

英文版定义
> Cloud native technologies empower organizations to build and run scalable applications in modern, dynamic environments such as public, private, and hybrid clouds. Containers, service meshes, microservices, immutable infrastructure, and declarative APIs exemplify this approach.

> These techniques enable loosely coupled systems that are resilient, manageable, and observable. Combined with robust automation, they allow engineers to make high-impact changes frequently and predictably with minimal toil.

> The Cloud Native Computing Foundation seeks to drive adoption of this paradigm by fostering and sustaining an ecosystem of open source, vendor-neutral projects. We democratize state-of-the-art patterns to make these innovations accessible for everyone.

中文版定义
> 云原生技术有利于各组织在公有云、私有云和混合云等新型动态环境中，构建和运行可弹性扩展的应用。云原生的代表技术包括容器、服务网格、微服务、不可变基础设施和声明式API。

> 这些技术能够构建容错性好、易于管理和便于观察的松耦合系统。结合可靠的自动化手段，云原生技术使工程师能够轻松地对系统作出频繁和可预测的重大变更。

> 云原生计算基金会（CNCF）致力于培育和维护一个厂商中立的开源生态系统，来推广云原生技术。我们通过将最前沿的模式民主化，让这些创新为大众所用。

-- 摘自Github CNCF官网[CNCF Cloud Native Definition v1.0](https://github.com/cncf/toc/blob/master/DEFINITION.md)

② 云原生（Cloud Native）要素

![](http://nepxion.gitee.io/docs/icon-doc/tip.png) Pivotal官网对云原生概括为4个要素，如下

| 要素 | 描述 |
| --- | --- |
| Micro Service | 微服务 |
| Container | 容器 |
| DevOps | 开发运维一体化，包含CI（Continuous Integration）持续集成 |
| CD（Continuous Delivery） | 持续交付 |


③ 云原生（Cloud Native）所需能力与特征

![](http://nepxion.gitee.io/docs/polaris-doc/CloudNative.jpg)

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 下文着重刻画`MicroService`的架构，描述`DevOps`的边界，展现`Container`的落地，但不涉及`CD（Continuous Delivery）`的层面

## 简介
Polaris【北极星】企业级云原生微服务基础架构脚手架，围绕Discovery【探索】框架打造，基于Spring Cloud Discovery服务注册发现、Ribbon负载均衡、Feign和RestTemplate调用等组件全方位增强的企业级云原生微服务开源解决方案，面向企业级生产需求精雕细琢，赋能和助力企业快速搭建基础架构的底层云原生微服务框架。整个架构体系打造，遵循最严格的Maven对称结构和规范，最严格的命名格式，给予使用者最舒适的使用体验

支持如下中间件的集成和封装
- 支持阿里巴巴Nacos、Eureka、Consul和Zookeeper四个服务注册发现中心
- 支持阿里巴巴Nacos、携程Apollo两个远程配置中心
- 支持阿里巴巴Sentinel和Hystrix两个熔断限流降级权限中间件
- 支持Uber Jaeger、Apache Skywalking两个符合OpenTracing规范的调用链中间件
- 支持Prometheus Micrometer和Spring Boot Admin两个指标中间件
- 支持Java Agent解决异步跨线程ThreadLocal上下文传递
- 支持Spring Cloud Gateway、Zuul网关、微服务、控制台、自动化测试五个独立的应用模块
- 支持和兼容Spring Cloud Finchley版、Greenwich版和Hoxton版。默认集成Hoxton版，如果需要，请使用者自行修改成其它两个版本

支持如下应用型的功能
- 支持灰度蓝绿发布、灰度路由过滤、流量权重、限流、熔断、降级、隔离、监控、追踪等企业生产级功能
- 支持动态域名、双云双活和SET单元化的配置，支持跨云的服务注册和配置读取（例如，阿里云上的微服务想要注册到华为云上的Nacos注册中心，或者跨云读取Apollo配置中心的配置，通过DevOps修改相关配置驱动即可）。一套SDK体系可以同时适配和运行在不同的云上
- 支持在核心的pom.xml上实现同类型的组件的快速切换（例如，Eureka注册中心切换到Consul，Apollo配置中心切换到Nacos等），但同类型组件不可并存使用（例如，Eureka和Consul注册中心不可同时并存，Apollo和Nacos配置中心不可同时并存等）
- 支持框架层面实现每个组件对四个环境（DEV | FAT | UAT | PRO）的内置最佳配置，遵循全局公共配置和局部环境配置相结合的方式，遵循“约定大于配置”的策略，业务层面实现微量配置甚至零配置。框架集成人员可以内置定制化的配置，业务开发人员在业务层可以把内置的配置覆盖掉，达到扩展性强、灵活使用的目的
- 支持业务开发人员使用该框架的时候，对其尽最大可能屏蔽一切跟Spring Cloud和中间件有关的代码书写、配置参数、环境地址等，零Spring Cloud经验的业务开发人员也可以快速上手研发基于Spring Cloud微服务技术栈的业务服务，最大程度上减轻业务人员的压力

## 目录
- [前言](#前言)
- [简介](#简介)
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
        - [调用链组件切换](#调用链组件切换)
        - [指标组件切换](#指标组件切换)
        - [防护组件切换](#防护组件切换)
    - [域名和环境切换](#域名和环境切换)
        - [域名和环境解析](#域名和环境解析)
        - [域名和环境设置](#域名和环境设置)
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
    - [新增组件](#新增组件)
        - [组件结构创建](#组件结构创建)
        - [核心模块聚合](#核心模块聚合)
    - [容器化部署](#容器化部署)
- [回馈社区](#回馈社区)
- [Star走势图](#Star走势图)

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
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-zookeeper | Polaris Zookeeper组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-zookeeper-starter-discovery | Polaris Zookeeper注册发现组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-jaeger | Polaris Jaeger组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-jaeger-starter | Polaris Jaeger调用链组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-jaeger-starter-sentinel | Polaris Jaeger调用链组件集成Sentinel的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-skywalking | Polaris Skywalking组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-skywalking-starter | Polaris Skywalking调用链组件的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-skywalking-starter-sentinel | Polaris Skywalking调用链组件集成Sentinel的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-prometheus | Polaris Prometheus组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-prometheus-starter-micrometer | Polaris Prometheus指标组件集成Micrometer的封装 |
| &nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_south.png"> polaris-component-spring-boot-admin | Polaris Spring Boot Admin组件目录 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-spring-boot-admin-starter | Polaris Polaris Spring Boot Admin指标组件的封装 |
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
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-tracing | Polaris调用链组件的组装 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://nepxion.gitee.io/docs/icon-doc/direction_west.png"> polaris-component-core-starter-metrics | Polaris指标组件的组装 |
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

        <!-- 调用链核心组件 -->
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>polaris-component-core-starter-tracing</artifactId>
            <version>${project.version}</version>
        </dependency>

        <!-- 指标核心组件 -->
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>polaris-component-core-starter-metrics</artifactId>
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
- 调用链组件：Skywalking
- 指标组件：未激活
- 防护组件：Sentinel
- 灰度蓝绿组件：Nepxion Discovery

#### 注册发现组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```xml
You can select one of following polaris discovery components, such as Nacos
```
把搜索出来的`2`个pom.xml换成使用者想要的组件

#### 配置组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```xml
You can select one of following polaris config components, such as Apollo
```
把搜索出来的`4`个pom.xml换成使用者想要的组件

#### 调用链组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```xml
You can select one of following polaris tracing components, such as Skywalking
```
把搜索出来的`1`个pom.xml换成使用者想要的组件

#### 指标组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```xml
You can select one of following polaris metrics components, such as Micrometer
```
把搜索出来的`1`个pom.xml换成使用者想要的组件

#### 防护组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```xml
You can select one of following polaris protector components, such as Sentinel
```
把搜索出来的`3`个pom.xml换成使用者想要的组件

### 域名和环境切换

#### 域名和环境解析
所有的组件都支持四个环境（DEV | FAT | UAT | PRO），分别对应开发环境、测试环境、准生产环境、生产环境。框架支持在环境配置文件里动态解析和创建多活、多云和SET单元化模式的域名

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 框架组件环境配置规范（表格中以Nacos注册为示例），如下

| 环境 | 域名或者IP地址 | 配置文件 | 示例 |
| --- | --- | --- | --- |
| DEV | 默认为127.0.0.1:port | `组件名`-dev<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>127.0.0.1:8848 |
| FAT | `组件名`-fat-`可选的区域名`.`根域` | `组件名`-fat<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>nacos-fat${zone}.${root.domain} |
| UAT | `组件名`-uat-`可选的区域名`.`根域` | `组件名`-uat<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>nacos-uat${zone}.${root.domain} |
| PRO | `组件名`-pro-`可选的区域名`.`根域` | `组件名`-pro<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>nacos-pro${zone}.${root.domain} |
| COMMON | 无需配置 | `组件名`-common<br>.properties | 无需配置 |

① 环境（env）号
- 定义为用来区别不同环境的标识
- 四个环境的配置文件除了定义域名或者IP地址外，也支持根据环境不同设置不同的配置值或者开关（例如，Swagger功能需要在生产环境关闭，需要在PRO配置文件里关闭）
- 除了四个环境的配置文件外，还存在一个公共配置文件，其作用是设置全局的不会随环境改变的默认配置，共享给四个环境，避免重复冗余配置。公共配置和环境配置，其关系是全局配置和局部配置的关系，如果同一个配置在公共配置文件和环境配置文件里都存在，环境配置文件优先
- 所有配置文件的位置在各个组件的src/main/resources/META-INF目录下

② 区域（zone）名
- 定义为用来区别多活、多云和SET单元化的域名的后缀或者前缀标识
- 域名表达式为`组件名`-`环境号`-`可选的区域名`.`根域`。使用者可以改变前缀或者后缀的组装形式和顺序，前缀中的“-”可以用其它符号来代替
- 实现占位处理，占位格式为${zone}。如果区域（zone）名不设置，那么变成“组件名-环境号.根域”的简单格式
- 通过DevOps来实现环境号和区域名的指定（下文“域名和环境设置”会讲到）
- 如果使用者没有条件实现多环境的域名支持，那么采用IP地址也可以

③ 根域（root domain）名
- 定义为不同环境域名的根域后缀
- 实现占位处理，占位格式为${root.domain}

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 使用者需要根据企业的实际情况，把组件的四个环境域名或者IP地址一一做更改

#### 域名和环境设置
① 通过DevOps进行环境（env）号设置
- 通过System Property或者-Denv=`环境号`，进行设置
- 通过server.properties进行设置
```xml
env=dev
```
- 通过System Env环境变量方式进行设置
- 上述设置都未执行，则缺省为dev

② 通过DevOps进行区域（zone）名设置
- 通过System Property或者-Dzone=`区域名`，进行设置。例如，-Denv=SET-sha，SET表示单元名，sha表示双活或者多活的机房名，两者可以独立配置其中之一，也可以同时并存
- 通过server.properties进行设置
```xml
zone=SET-sha
```
- 通过System Env环境变量方式进行设置
- 上述设置都未执行，则缺省为空，即非多活或者多云的环境

③ 通过DevOps进行根域（root domain）名设置
- 通过System Property或者-Droot.domain=`根域名`，进行设置
- 通过server.properties进行设置
```xml
root.domain=nepxion.com
```
- 通过System Env环境变量方式进行设置
- 上述设置都未执行，则缺省为PolarisEnvConstant类里的ROOT_DOMAIN_VALUE静态变量

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 读取优先级由高到低，如下
- System.getProperty
- System.getenv
- server.properties。Windows环境下该文件路径为C:/opt/settings/server.properties，Linux环境下该文件路径为/opt/settings/server.properties

⑤ 通过PolarisEnvConstant类进行设置。请参考里面的中文注释
```java
public class PolarisEnvConstant {
    // 根域名相关定义。包含三种传值方式，优先级至上而下。使用者需要把根域值改掉
    // 1. 通过-Droot.domain=nepxion.com或者System.setProperty("root.domain", "nepxion.com")方式进行传入
    // 2. 通过大写的ROOT.DOMAIN，其值为nepxion.com的System ENV方式进行传入
    // 3. 通过DevOps在server.properties定义root.domain=nepxion.com方式进行传入
    public static final String ROOT_DOMAIN_NAME = "root.domain";
    public static final String ROOT_DOMAIN_VALUE = "nepxion.com";

    // 区域名相关定义。包含三种传值方式，优先级至上而下
    // 1. 通过-Dzone=sha或者System.setProperty("zone", "sha")方式进行传入
    // 2. 通过大写的ZONE，其值为sha的System ENV方式进行传入
    // 3. 通过DevOps在server.properties定义zone=sha方式进行传入

    // 区域名分隔符相关定义
    // ZONE_SEPARATE表示区域在域名中的分隔符
    // ZONE_SEPARATE_PREFIX表示区域在域名中的分隔符是否在前面还是后面
    // 包含两种表现形式。特别注意：zone占位符前后切记不要出现分隔符，因为框架会自动去适配
    // 1. 例如，原始格式为nacos-fat${zone}.${root.domain}
    //    1.1 在zone存在的情况下，会解析成nacos-fat-sha.nepxion.com
    //    1.2 在zone缺失的情况下，会解析成nacos-fat.nepxion.com
    // 2. 例如，原始格式为${zone}fat-nacos.${root.domain}
    //    2.1 在zone存在的情况下，会解析成sha-fat-nacos.nepxion.com
    //    2.2 在zone缺失的情况下，会解析成fat-nacos.nepxion.com
    public static final String ZONE_NAME = "zone";
    public static final String ZONE_SEPARATE = "-";
    public static final boolean ZONE_SEPARATE_PREFIX = true;

    // 环境名相关定义。包含三种传值方式，优先级至上而下。以开发环境为例
    // 1. 通过-Denv=dev或者System.setProperty("env", "dev")方式进行传入
    // 2. 通过大写的ENV，其值为dev的System ENV方式进行传入
    // 3. 通过DevOps在server.properties定义env=dev方式进行传入
    public static final String ENV_NAME = "env";

    // server.properties文件的存放位置
    public static final String SERVER_PROPERTIES_PATH_WINDOWS = "C:/opt/settings/server.properties";
    public static final String SERVER_PROPERTIES_PATH_LINUX = "/opt/settings/server.properties";

    // 日志文件的存放位置
    public static final String LOG_PATH_WINDOWS = "C:/opt/logs/";
    public static final String LOG_PATH_LINUX = "/opt/logs/";

    public static final String META_INF_PATH = "classpath:/META-INF/";
}
```

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 特别注意：zone占位符前后切记不要出现分隔符

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

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 参考[Polaris指南主页](https://github.com/Nepxion/PolarisGuide)的源码

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
由于大量配置已经内置到框架里，除了服务名和端口号之外，业务层原则上不需要再添加Spring Cloud和中间件其它配置，当然也可以覆盖掉默认内置的配置。内置配置文件支持Spring标准占位符用法

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 小诀窍：为了避免引起业务层的配置无法覆盖掉默认内置的配置，请在bootstrap.properties定义想要覆盖的配置

### 应用启动

#### 中间件服务启动
![](http://nepxion.gitee.io/docs/icon-doc/information.png) Polaris依赖Nacos Server（必选）和Skywalking Server（可选），请实现准备搭建好对应的Server

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
Polaris应用完整启动参数如下
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
灰度蓝绿发布和子环境隔离路由的元数据注册的启动参数如下，分别对应灰度蓝绿版本号，区域号，子环境号，最后一项是启动的时候是否显示旗标为彩色，可以忽略
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

### 新增组件

以创建一个调用链模块Pinpoint为例，请尽量严格遵守Polaris集成方式，保持风格统一

#### 组件结构创建

① 按照如下结构进行目录创建，并编写相应的pom.xml
- polaris-component
    - polaris-component-pinpoint
        - polaris-component-pinpoint-starter

② 在resource/META-INF下创建如下5个环境文件，并分别写入相应的配置。如何写入，请参照上文“域名和环境切换”章节
- pinpoint-common.properties
- pinpoint-dev.properties
- pinpoint-fat.properties
- pinpoint-pro.properties
- pinpoint-uat.properties

③ 新建com.nepxion.polaris.component.pinpoint.context.PinpointEnvProcessor类
```java
public class PinpointEnvProcessor extends PolarisEnvPostProcessor {
    // 如果初始化环境的时候，如果还需要做其它处理，请继承process方法
    @Override
    public void process(ConfigurableEnvironment environment) throws Exception {
        // DO SOMETHING

        super.process(environment);

        // DO SOMETHING
    }

    // 如果初始化环境的时候，如果还需要做每条值做特殊处理，请继承processValue方法
    @Override
    protected String processValue(ConfigurableEnvironment environment, String key, String value) {
        // DO SOMETHING
        String newValue = doSomething(key, value);

        return super.processValue(environment, key, newValue);
    }

    // 返回环境的名称，其值对应为环境文件的前缀
    @Override
    public String getName() {
        return PolarisConstant.PINPOINT_NAME;
    }
}
```

④ 配置resource/META-INF/spring.factories
```xml
org.springframework.boot.env.EnvironmentPostProcessor=\
com.nepxion.polaris.component.pinpoint.context.PinpointEnvProcessor
```

#### 核心模块聚合

① 在polaris-component-core目录下找到polaris-component-core-starter-tracing模块下的pom.xml，把polaris-component-pinpoint-starter加入，进行组件层面聚合。使用者也可以自行按照规范新建一个核心模块组件

② 在polaris-framework下5个框架顶级模块，按需引入polaris-component-core-starter-tracing进行框架层面聚合

③ 如果该核心模块不希望被绑死在框架层，也可以暴露给业务层，由业务开发自行引入

### 容器化部署

## 回馈社区
- 使用者可以添加更多的中间件到框架里，并希望能回馈给社区
- 使用者可以根据企业实际情况，添加更多的配置到框架层并优化内置的参数，并希望能回馈给社区

## Star走势图

[![Stargazers over time](https://starchart.cc/Nepxion/Polaris.svg)](https://starchart.cc/Nepxion/Polaris)