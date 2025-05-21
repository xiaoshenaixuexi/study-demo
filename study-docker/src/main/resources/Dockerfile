# 基础镜像
FROM openjdk:8
# 作者
MAINTAINER qys
# 设置工作目录
WORKDIR /app
# 复制 jar 包到容器中
COPY study-docker.jar app.jar
# 暴露应用程序端口
EXPOSE 20210
# 设置容器启动时执行的命令，启动 SpringBoot 应用
ENTRYPOINT ["java", "-jar", "app.jar"]