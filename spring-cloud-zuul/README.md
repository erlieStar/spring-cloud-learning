filterType，代表拦截器的类型，zuul中有4种类型的过滤器

| 类型 | 解释 |
|:--:|:--:|
|pre|路由之前|
|routing|路由时|
|post|路由之后|
|error|发送错误调用|

filterOrder:过滤的顺序
shouldFilter:可以写逻辑，判断是否过滤。本文为true，永远过滤
run:过滤的具体逻辑，比如判断用户是否登陆，是否有相应的权限