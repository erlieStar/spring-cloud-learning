## 创建服务注册中心


## 创建高可用服务注册中心

记得在host文件中配置

```
127.0.0.1 eureka1
127.0.0.1 eureka2
127.0.0.1 eureka3
```

```shell
#打包
mvn clean package
# 指定相应的配置文件启动eureka
java -jar eureka-cluster-1.0.jar --spring.profiles.active=peer1
java -jar eureka-cluster-1.0.jar --spring.profiles.active=peer2
java -jar eureka-cluster-1.0.jar --spring.profiles.active=peer3
```