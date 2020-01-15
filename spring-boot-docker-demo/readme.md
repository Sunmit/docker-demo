# Spring-boot-docker-demo

参照[spring-boot-docker](https://spring.io/guides/topicals/spring-boot-docker)文档制作一个简单通过redis统计访问次数程序。  
为方便后续cicd dockerfile中没有本地编译，并增添依赖的缓存大幅减少非首次build时间
---
## docker build
docker build 命令：
DOCKER_BUILDKIT=1 docker build -t myorg/myapp .

## docker compose build
为spring boot 程序顺利访问redis容器，使用docker compose   
命令如下：   
export COMPOSE_DOCKER_CLI_BUILD=1   
export DOCKER_BUILDKIT=1   
docker-compose up --build   
关闭容器命令：   
docker-compose down   
---
踩过的坑：
支持experimental功能要保证docker版本号大于18，docker-compose版本大于1.25，但是docker for mac 只会保证docker为最新版本 docker-compose版本要自己手动升级[docker-compose install docs](https://docs.docker.com/compose/install/)
