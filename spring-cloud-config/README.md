启动config-service后访问

http://localhost:8080/javashitang/dev

结果如下
``` json
{
    "name": "javashitang",
    "profiles": [
        "dev"
    ],
    "label": null,
    "version": "402acfd10b4c0ae3901a392a454f7afbb1cb78e1",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/erlieStar/spring-cloud-learning/config-repo/javashitang-dev.properties",
            "source": {
                "from": "git-dev"
            }
        }
    ]
}
```

启动consumer-config后访问

http://localhost:8090/from

结果如下
``` json
git-dev
```

需要注意的有如下几点
1.server端的依赖是
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```
client端的依赖是

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```
2.server端的配置文件名是application.yaml，client端的配置文件名是bootstrap.yaml
3.config-repo中的配置要写对，不然client会注入失败