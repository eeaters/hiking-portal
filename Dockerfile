FROM oraclelinux:9-slim

# 设置工作目录
WORKDIR /app

# 复制构建的JAR文件到容器中
COPY target/hiking-portal.jar /app/app.jar

# 暴露应用的端口
EXPOSE 8080

# 启动应用
ENTRYPOINT ["java", "-jar", "/app/app.jar"]