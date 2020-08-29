<img src="http://nepxion.gitee.io/docs/polaris-doc/Banner.png">

# Polaris【北极星】企业级云原生微服务框架
[![Total lines](https://tokei.rs/b1/github/Nepxion/Polaris?category=lines)](https://tokei.rs/b1/github/Nepxion/Polaris?category=lines)  [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?label=license)](https://github.com/Nepxion/Polaris/blob/master/LICENSE)  [![Build Status](https://travis-ci.org/Nepxion/Discovery.svg?branch=master)](https://travis-ci.org/Nepxion/Discovery)  [![Codacy Badge](https://api.codacy.com/project/badge/Grade/8e39a24e1be740c58b83fb81763ba317)](https://www.codacy.com/project/HaojunRen/Discovery/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Nepxion/Discovery&amp;utm_campaign=Badge_Grade_Dashboard)

![](http://nepxion.gitee.io/docs/polaris-doc/Logo64.png) Polaris【北极星】企业级云原生微服务框架

① Polaris【北极星】企业级云原生微服务框架文档
- [Polaris【北极星】企业级云原生微服务框架(PDF版)](http://nepxion.gitee.io/docs/link-doc/polaris-pdf.html)
- [Polaris【北极星】企业级云原生微服务框架(HTML版)](http://nepxion.gitee.io/docs/link-doc/polaris-html.html)

② Polaris【北极星】企业级云原生微服务框架源码。请访问Gitee镜像获得最佳体验
- [源码Gitee同步镜像](https://gitee.com/Nepxion/Polaris)
- [源码Github原镜像](https://github.com/Nepxion/Polaris)

③ Polaris【北极星】企业级云原生微服务框架指南示例源码。请访问Gitee镜像获得最佳体验
- [指南Gitee同步镜像](https://gitee.com/Nepxion/PolarisGuide)
- [指南Github原镜像](https://github.com/Nepxion/PolarisGuide)

![](http://nepxion.gitee.io/docs/discovery-doc/Logo64.png) Discovery【探索】微服务企业级解决方案

① Discovery【探索】微服务企业级解决方案文档
- [Discovery【探索】微服务企业级解决方案(PPT版)](http://nepxion.gitee.io/docs/link-doc/discovery-ppt.html)
- [Discovery【探索】微服务企业级解决方案(PDF版)](http://nepxion.gitee.io/docs/link-doc/discovery-pdf.html)
- [Discovery【探索】微服务企业级解决方案(HTML版)](http://nepxion.gitee.io/docs/link-doc/discovery-html.html)

② Discovery【探索】微服务企业级解决方案源码。请访问Gitee镜像获得最佳体验
- [源码Gitee同步镜像](https://gitee.com/Nepxion/Discovery)
- [源码Github原镜像](https://github.com/Nepxion/Discovery)

③ Discovery【探索】微服务企业级解决方案指南示例源码。请访问Gitee镜像获得最佳体验
- [指南Gitee同步镜像](https://gitee.com/Nepxion/DiscoveryGuide)
- [指南Github原镜像](https://github.com/Nepxion/DiscoveryGuide)

④ Discovery【探索】微服务框架指南示例说明
- 对于入门级玩家，参考[指南示例极简版](https://github.com/Nepxion/DiscoveryGuide/tree/simple)，分支为simple。涉及到指南篇里的灰度路由和发布的基本功能
- 对于熟练级玩家，参考[指南示例精进版](https://github.com/Nepxion/DiscoveryGuide/tree/master)，分支为master。除上述《极简版》功能外，涉及到指南篇里的绝大多数高级功能
- 对于骨灰级玩家，参考[指南示例高级版](https://github.com/Nepxion/DiscoveryGuide/tree/premium)，分支为premium。除上述《精进版》功能外，涉及到指南篇里的ActiveMQ、MongoDB、RabbitMQ、Redis、RocketMQ、MySQL等高级调用链和灰度调用链的整合

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 联合架构图

![](http://nepxion.gitee.io/docs/polaris-doc/Architecture.jpg)

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
| CD | 持续交付（Continuous Delivery） |

③ 云原生（Cloud Native）所需能力与特征

![](http://nepxion.gitee.io/docs/polaris-doc/CloudNative.jpg)

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 下文着重刻画`Micro Service`的架构，阐述`DevOps`的边界，展现`Container`的落地，但不涉及`CD`的层面

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
- [工程架构](#工程架构)
    - [工程清单](#工程清单)
    - [架构核心](#架构核心)
- [集成步骤](#集成步骤)
    - [Parent切换](#Parent切换)
    - [GroupId切换](#GroupId切换)
    - [组织命名切换](#组织命名切换)
    - [版本切换](#版本切换)
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
- [Nepxion-Discovery核心功能](#Nepxion-Discovery核心功能)
    - [核心功能概括](#核心功能概括)
    - [灰度发布和路由的实现方式](#灰度发布和路由的实现方式)
    - [灰度发布和路由的订阅格式](#灰度发布和路由的订阅格式)
- [Spring-Boot-2-3-x新特性](#Spring-Boot-2-3-x新特性)
    - [容器化部署](#容器化部署)
        - [部署Polaris框架包](#部署Polaris框架包)
        - [添加Spring-Boot打包插件](#添加Spring-Boot打包插件)
        - [执行Docker容器和镜像的制作和运行](#执行Docker容器和镜像的制作和运行)
    - [优雅停机](#优雅停机)
- [回馈社区](#回馈社区)
- [Star走势图](#Star走势图)

## 请联系我
微信、公众号和文档

![](http://nepxion.gitee.io/docs/zxing-doc/微信-1.jpg)![](http://nepxion.gitee.io/docs/zxing-doc/公众号-1.jpg)![](http://nepxion.gitee.io/docs/zxing-doc/文档-1.jpg)

## 相关链接

### 源码主页
[Polaris源码主页](https://github.com/Nepxion/Polaris)

[Discovery源码主页](https://github.com/Nepxion/Discovery)

### 指南主页
[Polaris指南主页](https://github.com/Nepxion/PolarisGuide)

[Discovery指南主页](https://github.com/Nepxion/DiscoveryGuide)

### 文档主页
[文档主页](https://gitee.com/Nepxion/Docs/tree/master/web-doc)

## 工程架构

### 工程清单
工程集成了众多的中间件，清单如下

① 简略清单

- 核心组件

| 核心组件名 | 组件类型 |
| --- | --- |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 旗标组件 | Nepxion Discovery |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 注册发现组件 | Nacos & Eureka & Consul & Zookeeper |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 配置组件 | Apollo & Nacos |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 调用链组件 | Skywalking + OpenTracing & Jaeger + OpenTracing |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 指标组件 | Prometheus Micrometer & Spring Boot Admin |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 防护组件 | Sentinel & Hystrix |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 灰度蓝绿组件 | Nepxion Discovery |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> Agent组件 | Nepxion Discovery |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 环境组件 | Nepxion Polaris内置 |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 控制台组件 | Nepxion Discovery |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 自动化测试组件 | Nepxion Discovery |

- 框架分层

| 框架分层名 | 分层类型 |
| --- | --- |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> Gateway网关层 | Spring Cloud Gateway + Nepxion Discovery |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> Zuul网关层 | Spring Cloud Netfilx Zuul + Nepxion Discovery  |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 微服务层 | Spring Cloud Service + Nepxion Discovery  |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 控制台层 | Spring Cloud Service + Nepxion Discovery |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 测试层 | Spring Boot + Nepxion Discovery |

② 详细清单

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

### 架构核心
架构核心位于polaris-framework模块下，包括如下五个核心模块
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
        <groupId>com.nepxion.polaris</groupId>
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

## 集成步骤

### Parent切换
- 框架提供Polaris Parent，定义了Spring Cloud、Spring Cloud Alibaba和Spring Boot版本号，同时在Polaris SDK上也进行了这些版本的相同定义，目的是让业务开发人员可以接入Polaris的时候可以选择Polaris Parent，也可以选择业务自己的Parent，只接入Polaris SDK
- 当接入Polaris Parent的时候，版本号以Polaris Parent定义为优先，否则以Polaris SDK定义为准

### 组织命名切换
使用者可以把Polaris改造成自己企业名义上的框架。假设，企业名称为alibaba

① 全局替换Pom GroupId和src/main/resources/META-INF/spring.factories。在根目录下，搜索全部文件，关键字
```
com.nepxion.polaris
```
替换成
```
com.alibaba.polaris
```

② 手工替换src/main/java/下的Java包目录名
```
com.nepxion.polaris
```
替换成
```
com.alibaba.polaris
```

### 版本切换
- Polaris Parent定义

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 使用者可以自行对Polaris Parent层和Polaris SDK层中三个中间件的版本号进行升级或者降级，也可以自定义更多的第三方中间件版本
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <groupId>com.nepxion.polaris</groupId>
    <artifactId>polaris-parent</artifactId>
    <name>Nepxion Polaris Parent</name>
    <packaging>pom</packaging>
    <modelVersion>4.0.0</modelVersion>
    <version>1.0.0</version>
    <description>Nepxion Polaris is an enterprise-level platform</description>
    <url>http://www.nepxion.com</url>

    <properties>
        <polaris.version>1.0.0</polaris.version>
        <discovery.version>6.0.7</discovery.version>

        <!-- Spring Cloud Hoxton compatible versions -->
        <spring.cloud.version>Hoxton.SR7</spring.cloud.version>
        <spring.cloud.alibaba.version>2.2.1.RELEASE</spring.cloud.alibaba.version>
        <spring.boot.version>2.3.3.RELEASE</spring.boot.version>
        <spring.boot.admin.version>2.3.0</spring.boot.admin.version>

        <!-- Spring Cloud Greenwich compatible versions -->
        <!-- <spring.cloud.version>Greenwich.SR6</spring.cloud.version>
        <spring.cloud.alibaba.version>2.1.1.RELEASE</spring.cloud.alibaba.version>
        <spring.boot.version>2.1.16.RELEASE</spring.boot.version>
        <spring.boot.admin.version>2.1.6</spring.boot.admin.version> -->

        <!-- Spring Cloud Finchley compatible versions -->
        <!-- <spring.cloud.version>Finchley.SR4</spring.cloud.version>
        <spring.cloud.alibaba.version>2.0.1.RELEASE</spring.cloud.alibaba.version>
        <spring.boot.version>2.0.9.RELEASE</spring.boot.version>
        <spring.boot.admin.version>2.0.6</spring.boot.admin.version> -->

        <!-- OpenTracing for Spring Cloud & Jaeger compatible versions -->
        <!-- Select low OpenTracing versions while executing failed in low Spring Cloud versions -->
        <opentracing.spring.cloud.version>0.5.5</opentracing.spring.cloud.version>
        <opentracing.spring.jaeger.version>3.1.2</opentracing.spring.jaeger.version>
        <opentracing.concurrent.version>0.4.0</opentracing.concurrent.version>

        <!-- <opentracing.spring.cloud.version>0.3.12</opentracing.spring.cloud.version>
        <opentracing.spring.jaeger.version>2.0.3</opentracing.spring.jaeger.version>
        <opentracing.concurrent.version>0.3.0</opentracing.concurrent.version> -->

        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring.cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${spring.cloud.alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring.boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>de.codecentric</groupId>
                <artifactId>spring-boot-admin-dependencies</artifactId>
                <version>${spring.boot.admin.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>com.nepxion</groupId>
                <artifactId>discovery</artifactId>
                <version>${discovery.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 注意：OpenTracing在Polaris Parent的版本定义如果低版本Spring Cloud运行时存在问题，请自行把OpenTracing也切换到低版本。目前测试下来都是兼容的

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 注意：OpenTracing对Finchley版的Spring Cloud Gateway的reactor-core包存在版本兼容性问题，如果使用者希望Finchley版的Spring Cloud Gateway上使用OpenTracing，需要做如下改造
```xml
<dependency>
    <groupId>com.nepxion</groupId>
    <artifactId>discovery-plugin-strategy-starter-gateway</artifactId>
    <version>${discovery.version}</version>
    <exclusions>
        <exclusion>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-core</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<dependency>
    <groupId>io.projectreactor</groupId>
    <artifactId>reactor-core</artifactId>
    <version>3.2.3.RELEASE</version>
</dependency>
```
上述方式也适用于其它引入了低版本reactor-core包版本兼容性的场景

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 注意：“策略下内置Header来决策蓝绿和灰度，可以代替外部传入Header”，这块功能Spring Cloud Gateway在Finchley版不支持

### 组件切换
![](http://nepxion.gitee.io/docs/icon-doc/information.png) 框架默认生效的组件，如下
| 核心组件名 | 默认生效的组件 |
| --- | --- |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 旗标核心组件 | Nepxion Discovery |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 注册发现核心组件 | Nacos |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 配置核心组件 | Nacos |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 调用链核心组件 | Skywalking |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 指标核心组件 | 未激活 |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 防护核心组件 | Sentinel |
| <img src="http://nepxion.gitee.io/docs/icon-doc/question_message.png"> 灰度蓝绿核心组件 | Nepxion Discovery |

#### 注册发现组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```
You can select one of following polaris discovery components, such as Nacos
```
把搜索出来的`2`个pom.xml换成使用者想要的组件

#### 配置组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```
You can select one of following polaris config components, such as Apollo
```
把搜索出来的`4`个pom.xml换成使用者想要的组件

#### 调用链组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```
You can select one of following polaris tracing components, such as Skywalking
```
把搜索出来的`1`个pom.xml换成使用者想要的组件

#### 指标组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```
You can select one of following polaris metrics components, such as Micrometer
```
把搜索出来的`1`个pom.xml换成使用者想要的组件

#### 防护组件切换
在polaris-component-core目录下，搜索全部pom.xml，关键字
```
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
| FAT | `组件名`-fat-`可选的区域名`.`根域` | `组件名`-fat<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>nacos-fat`${region}`.`${domain}` |
| UAT | `组件名`-uat-`可选的区域名`.`根域` | `组件名`-uat<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>nacos-uat`${region}`.`${domain}` |
| PRO | `组件名`-pro-`可选的区域名`.`根域` | `组件名`-pro<br>.properties | spring.cloud.nacos.discovery.server-addr=<br>nacos-pro`${region}`.`${domain}` |
| COMMON | 无需配置 | `组件名`-common<br>.properties | 无需配置 |

① 环境（env）号
- 定义为用来区别不同环境的标识
- 四个环境的配置文件除了定义域名或者IP地址外，也支持根据环境不同设置不同的配置值或者开关（例如，Swagger功能需要在生产环境关闭，需要在PRO配置文件里关闭）
- 除了四个环境的配置文件外，还存在一个公共配置文件，其作用是设置全局的不会随环境改变的默认配置，共享给四个环境，避免重复冗余配置。公共配置和环境配置，其关系是全局配置和局部配置的关系，如果同一个配置在公共配置文件和环境配置文件里都存在，环境配置文件优先
- 所有配置文件的位置在各个组件的src/main/resources/META-INF目录下，其中COMMON配置文件可以缺失，其它四个环境的配置文件不可缺失

② 区域（region）名
- 定义为用来区别多活、多云和SET单元化的域名的后缀或者前缀标识
- 域名表达式为`组件名`-`环境号`-`可选的区域名`.`根域`。使用者可以改变前缀或者后缀的组装形式和顺序，前缀中的“-”可以用其它符号来代替
- 实现占位处理，占位格式为`${region}`。如果区域（region）名不设置，那么变成“组件名-环境号.根域”的简单格式
- 通过DevOps来实现环境号和区域名的指定（下文“域名和环境设置”会讲到）
- 如果使用者没有条件实现多环境的域名支持，那么采用IP地址也可以

③ 根域（domain）名
- 定义为不同环境域名的根域后缀
- 实现占位处理，占位格式为`${domain}`

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 使用者需要根据企业的实际情况，把组件的四个环境域名或者IP地址一一做更改

#### 域名和环境设置
① 通过DevOps进行环境（env）号设置
- 通过System Property或者-Denv=`环境号`，进行设置
- 通过server.properties进行设置
```
env=dev
```
- 通过System Env环境变量方式进行设置
- 上述设置都未执行，则缺省为dev

② 通过DevOps进行区域（region）名设置
- 通过System Property或者-Dregion=`区域名`，进行设置。例如，-Dregion=sh-pd，sh-pd表示双活或者多活的机房名（上海浦东机房），两者可以独立配置其中之一，也可以同时并存
- 通过server.properties进行设置
```
region=sh-pd
```
- 通过System Env环境变量方式进行设置
- 上述设置都未执行，则缺省为空，即非多活或者多云的环境

③ 通过DevOps进行根域（domain）名设置
- 通过System Property或者-Ddomain=`根域名`，进行设置
- 通过server.properties进行设置
```
domain=aliyun.com
```
- 通过System Env环境变量方式进行设置
- 上述设置都未执行，则缺省为PolarisEnvConstant类里的DOMAIN_VALUE静态变量

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 读取优先级由高到低，如下
- System.getProperty
- System.getenv
- server.properties。Windows环境下该文件路径为C:/opt/settings/server.properties，Linux环境下该文件路径为/opt/settings/server.properties。示例内容如下
```
domain=aliyun.com
region=sh-pd
env=pro
```

④ 通过PolarisEnvConstant类进行设置。请参考里面的中文注释
```java
public class PolarisEnvConstant {
    // 根域名相关定义。包含三种传值方式，优先级至上而下。使用者需要把根域值改掉
    // 1. 通过-Ddomain=nepxion.com或者System.setProperty("domain", "nepxion.com")方式进行传入
    // 2. 通过大写的DOMAIN，其值为nepxion.com的System ENV方式进行传入
    // 3. 通过DevOps在server.properties定义domain=nepxion.com方式进行传入
    public static final String DOMAIN_NAME = "domain";
    public static final String DOMAIN_VALUE = "nepxion.com";

    // 区域名相关定义。包含三种传值方式，优先级至上而下
    // 1. 通过-Dregion=sh-pd或者System.setProperty("region", "sh-pd")方式进行传入
    // 2. 通过大写的REGION，其值为sh-pd的System ENV方式进行传入
    // 3. 通过DevOps在server.properties定义region=sh-pd方式进行传入

    // 区域名分隔符相关定义
    // REGION_SEPARATE表示区域在域名中的分隔符
    // REGION_SEPARATE_PREFIX表示区域在域名中的分隔符是否在前面还是后面
    // 包含两种表现形式。特别注意：region占位符前后切记不要出现分隔符，因为框架会自动去适配
    // 1. 例如，原始格式为nacos-fat${region}.${domain}
    //    1.1 在region存在的情况下，会解析成nacos-fat-sh-pd.nepxion.com
    //    1.2 在region缺失的情况下，会解析成nacos-fat.nepxion.com
    // 2. 例如，原始格式为${region}fat-nacos.${domain}
    //    2.1 在region存在的情况下，会解析成sh-pd-fat-nacos.nepxion.com
    //    2.2 在region缺失的情况下，会解析成fat-nacos.nepxion.com
    public static final String REGION_NAME = "region";
    public static final String REGION_SEPARATE = "-";
    public static final boolean REGION_SEPARATE_PREFIX = true;

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

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 特别注意：region占位符前后切记不要出现分隔符

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
    <groupId>com.nepxion.polaris</groupId>
    <artifactId>polaris-parent</artifactId>
    <version>${polaris.version}</version>
</parent>
```

#### 引入Jar
① 微服务引入
```xml
<dependency>
    <groupId>com.nepxion.polaris</groupId>
    <artifactId>polaris-framework-starter-service</artifactId>
    <version>${polaris.version}</version>
</dependency>
```

② Spring Cloud Gateway网关引入
```xml
<dependency>
    <groupId>com.nepxion.polaris</groupId>
    <artifactId>polaris-framework-starter-gateway</artifactId>
    <version>${polaris.version}</version>
</dependency>
```

③ Zuul网关引入
```xml
<dependency>
    <groupId>com.nepxion.polaris</groupId>
    <artifactId>polaris-framework-starter-zuul</artifactId>
    <version>${polaris.version}</version>
</dependency>
```

④ 控制台引入
```xml
<dependency>
    <groupId>com.nepxion.polaris</groupId>
    <artifactId>polaris-framework-starter-console</artifactId>
    <version>${polaris.version}</version>
</dependency>
```

⑤ 测试端引入
```xml
<dependency>
    <groupId>com.nepxion.polaris</groupId>
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

| 类名 | 微服务 | 服务端口 | 版本 | 区域 | 环境 |
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
```
polaris-platform\polaris-component\polaris-component-agent\polaris-component-agent-starter-cross-thread\agent
```

① 插件使用
- polaris-agent.jar为Agent引导启动程序，JVM启动时进行加载；agent/plugin目录包含polaris-agent-plugin.jar为Polaris/Discovery框架自带的实现方案，业务系统可以自定义plugin，解决业务自己定义的上下文跨线程传递
- 通过如下-javaagent启动
```
-javaagent:/agent/polaris-agent.jar -Dthread.scan.packages=com.abc;com.xyz -Dthread.request.decorator.enabled=true
```

参数说明
- /agent：Agent所在的目录，需要对应到实际的目录上
- thread.scan.packages：Runnable，Callable对象所在的扫描目录，该目录下的Runnable，Callable对象都会被装饰。该目录最好精细和准确，这样可以减少被装饰的对象数，提高性能，目录如果有多个，用“;”分隔
- thread.request.decorator.enabled：异步调用场景下在服务端的Request请求的装饰，当主线程先于子线程执行完的时候，Request会被Destory，导致Header仍旧拿不到，开启装饰，就可以确保拿到。默认为关闭，根据实践经验，大多数场景下，需要开启这个开关
```
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
```
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
灰度蓝绿发布和环境隔离路由的元数据注册的启动参数如下，分别对应灰度蓝绿版本号，区域号，环境号，最后一项是启动的时候是否显示旗标为彩色，可以忽略
```
-Dmetadata.version=20200818-001 -Dmetadata.region=region1 -Dmetadata.env=env1 -Dnepxion.banner.shown.ansi.mode=true
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
```
org.springframework.boot.env.EnvironmentPostProcessor=\
com.nepxion.polaris.component.pinpoint.context.PinpointEnvProcessor
```

#### 核心模块聚合
① 在polaris-component-core目录下找到polaris-component-core-starter-tracing模块下的pom.xml，把polaris-component-pinpoint-starter加入，进行组件层面聚合。使用者也可以自行按照规范新建一个核心模块组件

② 在polaris-framework下5个框架顶级模块，按需引入polaris-component-core-starter-tracing进行框架层面聚合

③ 如果该核心模块不希望被绑死在框架层，也可以暴露给业务层，由业务开发自行引入

## Nepxion-Discovery核心功能

### 核心功能概括
- 灰度蓝绿发布
    - 版本匹配灰度发布
    - 版本权重灰度发布
- 多区域路由
    - 区域匹配灰度路由
    - 区域权重灰度路由
- 多IP和端口灰度路由
- 环境隔离
    - 环境隔离
    - 环境路由
- 基于Sentinel-LimitApp扩展的防护机制
- 基于组的服务调用隔离

### 灰度发布和路由的实现方式
![](http://nepxion.gitee.io/docs/discovery-doc/Difference.jpg)

① 基于网关为触点的Header传递的全链路灰度路由，适用于网关前置部署方式的企业。域网关部署模式下，最适用于该方式；非域网关部署模式下，开启并行灰度路由下的版本优选策略

② 基于全局订阅方式的全链路灰度发布，适用于网关部署方式比较弱化的企业

③ 基于全局订阅和Header传递组合式全链路灰度路由，上述两种方式的结合体，是比较理想和节省成本的落地方式

### 灰度发布和路由的订阅格式
![](http://nepxion.gitee.io/docs/discovery-doc/Apollo1.jpg)
![](http://nepxion.gitee.io/docs/discovery-doc/Nacos2.jpg)

## Spring-Boot-2-3-x新特性

### 容器化部署
基于Spring Boot 2.3.x新特性制作的Docker容器化部署

#### 部署Polaris框架包
![](http://nepxion.gitee.io/docs/icon-doc/tip.png) 重要提醒，由于`Polaris框架包`未推送到Maven中央仓库，需要使用者自行编译部署。在`Polaris源码`的polaris-parent和polaris-platform工程目录下，分别执行如下命令，把Polaris框架相关包部署到本地仓库
```
mvn clean install -U -DskipTests
```

#### 添加Spring-Boot打包插件
以`Polaris指南`的polaris-guide-service-a工程为例，下同

在polaris-guide-service-a工程目录下的pom.xml，执行如下操作
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>2.3.3.RELEASE</version>
    <configuration>
        <mainClass>com.nepxion.polaris.guide.service.PolarisServiceA1</mainClass>
        <layout>JAR</layout>
        <layers>
            <enabled>true</enabled>
        </layers>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>repackage</goal>
            </goals>
            <configuration>
                <attach>false</attach>
            </configuration>
        </execution>
    </executions>
</plugin>
```
![](http://nepxion.gitee.io/docs/icon-doc/information.png) 严重提醒，相对旧版本的spring-boot-maven-plugin，新版本增加了如下配置参数，用来支持镜像Layer分层，加快打包部署的速度
```xml
<layers>
    <enabled>true</enabled>
</layers>
```

![](http://nepxion.gitee.io/docs/icon-doc/error.png) 严重提醒，旧版的如下参数必须删除！否则无法创建镜像分层
```xml
<configuration>
    <executable>true</executable>
</configuration>
```

#### 执行Docker容器和镜像的制作和运行
![](http://nepxion.gitee.io/docs/icon-doc/information.png) 如果是Windows操作系统，需要在环境变量里配置DOCKER_HOST=tcp://localhost:2375

在polaris-guide-service-a工程目录下，执行如下操作

① 执行如下命令，编译Jar包
```
mvn clean package -U -DskipTests
```

② 验证镜像Layer分层(*非必须执行的步骤)

执行如下命令，查看Layer分层
```
java -Djarmode=layertools -jar target/polaris-guide-service-a-0.0.1.jar list
```
控制台输出如下四个分层，则表示有效
```
dependencies
spring-boot-loader
snapshot-dependencies
application
```

③ 创建Dockerfile

application.jar包同级目录下，将会输出四个分层的目录和文件

制作Dockerfile放在polaris-guide-service-a工程目录下。内置解压命令，根据jar构建生成清单layers.idx解压提取每个Layer要写入镜像的内容。内容如下
```
# 指定基础镜像，这是分阶段构建的前期阶段
FROM openjdk:8-jre-alpine as builder
# 执行工作目录
WORKDIR application
# 配置参数
ARG JAR_FILE=target/*.jar
# 将编译构建得到的jar文件复制到镜像空间中
COPY ${JAR_FILE} application.jar
# 通过工具spring-boot-jarmode-layertools从application.jar中提取拆分后的构建结果
RUN java -Djarmode=layertools -jar application.jar extract

# 正式构建镜像
FROM openjdk:8-jre-alpine
WORKDIR application
# 前一阶段从jar中提取除了多个文件，这里分别执行COPY命令复制到镜像空间中，每次COPY都是一个layer
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
# -Djava.security.egd=file:/dev/./urandom 内核随机种子，防止启动很慢
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom org.springframework.boot.loader.JarLauncher"]
```

④ 创建镜像和容器

执行如下命令创建镜像和容器
```
docker build . --tag polaris-guide-service-a
```

⑤ 运行容器

执行如下命令运行容器
```
docker run -i -t -e JAVA_OPTS="-Dnepxion.banner.shown.ansi.mode=true -Dmetadata.version=my-version -Dmetadata.region=my-region -Dmetadata.env=my-env" -e TZ="Asia/Shanghai" -p 3001:3001 -h polaris-guide-service-a --name polaris-guide-service-a polaris-guide-service-a:latest
```

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 在DEV（本地）环境下，配置Docker容器不能通过127.0.0.1的IP地址连接容器外中间件服务器，故需要把启动命令改成如下形式。域名方式则不需要这么做
```
set NACOS_SERVER=10.0.75.1:8848

docker run %RUN_MODE% -e JAVA_OPTS="-Dspring.cloud.nacos.discovery.server-addr=%NACOS_SERVER% -Dspring.cloud.nacos.config.server-addr=%NACOS_SERVER% -Dspring.cloud.sentinel.datasource.nacos.server-addr=%NACOS_SERVER% -Dnacos.server-addr=%NACOS_SERVER% -Dnepxion.banner.shown.ansi.mode=%SHOWN_ANSI_MODE% -Dmetadata.version=%METADATA_VERSION% -Dmetadata.region=%METADATA_REGION% -Dmetadata.env=%METADATA_ENV%" -e TZ="Asia/Shanghai" -p %MACHINE_PORT%:%CONTAINER_PORT% -h %IMAGE_NAME% --name %IMAGE_NAME% %IMAGE_NAME%:latest
```

![](http://nepxion.gitee.io/docs/icon-doc/information.png) 上述所有的命令组装成一键启动方式的脚本：install-docker.bat和install-docker.sh，请参考polaris-guide-service-a工程目录下的相应脚本

⑥  Docker运行效果

- Docker Desktop
![](http://nepxion.gitee.io/docs/polaris-doc/DockerDesktop.jpg)

- Docker Windows
![](http://nepxion.gitee.io/docs/polaris-doc/DockerWindows.jpg)

- Docker Linux
![](http://nepxion.gitee.io/docs/polaris-doc/DockerLinux.jpg)

⑦ 官方部署Docker文档

![](http://nepxion.gitee.io/docs/icon-doc/warning.png) 参考[Spring Boot 2.3.x官方部署Docker文档](https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1)获取更多用法，但请谨慎使用，有不少错误的地方，可能是来不及更新

### 优雅停机
```
# 开启Spring Boot 2.3.x优雅停机
server.shutdown=graceful

# 优雅停机缓冲时间
spring.lifecycle.timeout-per-shutdown-phase=20s
```

## 回馈社区
- 使用者可以添加更多的中间件到框架里，并希望能回馈给社区
- 使用者可以根据企业实际情况，添加更多的配置到框架层并优化内置的参数，并希望能回馈给社区

## Star走势图

[![Stargazers over time](https://starchart.cc/Nepxion/Polaris.svg)](https://starchart.cc/Nepxion/Polaris)