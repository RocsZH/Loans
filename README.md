<img src="http://nepxion.gitee.io/docs/polaris-doc/Logo.png">

# Polaris【北极星】企业级微服务框架
[![Total lines](https://tokei.rs/b1/github/Nepxion/Polaris?category=lines)](https://tokei.rs/b1/github/Nepxion/Polaris?category=lines)  [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?label=license)](https://github.com/Nepxion/Polaris/blob/master/LICENSE)  [![Build Status](https://travis-ci.org/Nepxion/Polaris.svg?branch=master)](https://travis-ci.org/Nepxion/Polaris)  [![Codacy Badge](https://api.codacy.com/project/badge/Grade/8e39a24e1be740c58b83fb81763ba317)](https://www.codacy.com/project/HaojunRen/Polaris/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Nepxion/Polaris&amp;utm_campaign=Badge_Grade_Dashboard)

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



## Star走势图

[![Stargazers over time](https://starchart.cc/Nepxion/Polaris.svg)](https://starchart.cc/Nepxion/Polaris)