## 环境搭建

### 应用程序

1. 把 jar 包和 Dockerfile 放在同一个包下 `/app/docker`
2. 构建镜像：`docker build -t study-docker:1.0 .`
3. 运行镜像: `docker run -d -p 20210:20210 --name study-docker -v /app/app/logs:/app/log/logs study-docker:1.0`
    - -p 20210:20210      容器的 20210 映射到主机的 20210
    - --name study-docker     容器启动后的名称
    - -v /app/docker/logs:/app/log/logs      将 /app/docker/logs 挂载到容器的 /app/log/logs 下
4. 测试运行情况: `docker ps`

### RabbitMQ

1. 拉取镜像

   ```sh
   docker pull rabbitmq:management
   ```

2. 运行

   ```sh
   docker run -id --name=rabbitmq -v /app/rabbitmq:/var/lib/rabbitmq -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=123 rabbitmq:management
   ```

    - -id : 以交互模式启动容器并在后台运行
    - `-e RABBITMQ_DEFAULT_USER=admin` : 设置默认用户名
    - `-e RABBITMQ_DEFAULT_PASS=123` : 设置默认密码

### Redis

1. 拉取镜像

   ```sh
   docker pull redis
   ```

2. 运行

   ```sh
   docker run --name redis -p 6379:6379 \
   --restart unless-stopped \
   -v /app/redis/data:/data \
   -v /app/redis/redis.conf:/etc/redis/redis.conf \
   -d redis:latest redis-server /etc/redis/redis.conf
   ```

    - -d : 在后台运行容器
    - `redis-server /etc/redis/redis.conf` : 容器执行此命令运行 redis

### MySQL

1. 拉取镜像

   ```sh
   docker pull mysql:5.7
   ```

2. 运行

   ```sh
   docker run -p 3306:3306 --name mysql \
   -v /app/mysql/log:/var/log/mysql \
   -v /app/mysql/data:/var/lib/mysql \
   -v /app/mysql/conf:/etc/mysql/conf.d \
   -e MYSQL_ROOT_PASSWORD=123456 \
   -d mysql:5.7
   ```

3. 进入容器

   ```sh
   docker exec -it mysql bash
   ```

### 使用 Docker-compose 统一管理

1. 下载 docker-compose

    1. 下载路径：`https://github.com/docker/compose/releases`

    2. 上传到 Linux

    3. 配置可执行路径

       ```sh
       mv /app/docker/docker-compose-linux-x86_64 /usr/local/bin/docker-compose
       chmod +x /usr/local/bin/docker-compose
       ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
       ```

2. 清除旧容器

   ```sh
   docker stop redis
   docker stop rabbitmq
   docker stop mysql
   docker stop study-docker
   docker rm study-docker
   docker rm mysql
   docker rm redis
   docker rm rabbitmq
   ```

3. 编写 docker-compose.yml

   ```yml
   version: '3.8'
   
   services:
     study-docker:
       image: study-docker:1.0
       container_name: study-docker
       ports:
         - "20210:20210"
       volumes:
         - /app/app/logs:/app/log/logs
       restart: always
       depends_on:
         - redis
         - mysql
         - rabbitmq
   
     rabbitmq:
       image: rabbitmq:management
       container_name: rabbitmq
       environment:
         - RABBITMQ_DEFAULT_USER=admin
         - RABBITMQ_DEFAULT_PASS=123
       ports:
         - "15672:15672"
         - "5672:5672"
       volumes:
         - /app/rabbitmq:/var/lib/rabbitmq
       restart: always
   
     redis:
       image: redis:latest
       container_name: redis
       ports:
         - "6379:6379"
       volumes:
         - /app/redis/data:/data
         - /app/redis/redis.conf:/etc/redis/redis.conf
       command: ["redis-server", "/etc/redis/redis.conf"]
       restart: always
   
     mysql:
       image: mysql:5.7
       container_name: mysql
       environment:
         MYSQL_ROOT_PASSWORD: 123456
       ports:
         - "3306:3306"
       volumes:
         - /app/mysql/log:/var/log/mysql
         - /app/mysql/data:/var/lib/mysql
         - /app/mysql/conf:/etc/mysql/conf.d
       restart: always
   ```

4. 运行 docker-compose.yml

    - 将文件上传在当前目录

    - 执行命令启动所有服务

      ```sh
      docker-compose up -d
      ```

5. 测试运行

6. 管理所有服务

   ```sh
   # 启动
   docker-compose up -d
   # 停止
   docker-compose down
   # 查看日志
   docker-compose logs
   ```

   