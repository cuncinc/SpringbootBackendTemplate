一个SpringBoot后端模板

### 使用
1. 修改`application.yml`中的数据库配置
2. 修改`pom.xml`中的`groupId`和`artifactId`
3. 修改`src`中的包名
4. 修改`src/main/resources`中的`mapper`中的包名
5. 修改`src/main/package/config`中的`CodeGenerator.java`中数据库的配置
6. 运行`src/main/package/config`中的`CodeGenerator.java`生成代码

### 特性
1. 使用`Mybatis-Plus`自动生成代码模板
2. 使用`sa-token`管理登录状态，https://github.com/dromara/sa-token