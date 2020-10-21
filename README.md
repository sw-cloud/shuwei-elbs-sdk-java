# 数位ELBS SDK

### 引用方式
pom.xml中增加以下配置：

``` xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.github.sw-cloud</groupId>
            <artifactId>shuwei-elbs-sdk-java</artifactId>
            <version>1.3.0</version>
        </dependency>
    </dependencies>
```

### 使用示例
以下是调用数位ELBS定位接口的三个主要步骤：
1. 创建ELBSProfile实例并进行初始化
2. 创建一个ELBSRequest对象并设置值，ELBSRequest中标识了NecessaryField注解的字段为必传字段
3. 通过elbsClient.location(ELBSRequest request)方法调用定位接口并接受定位结果

简单代码示例如下：

``` java
ELBSProfile elbsProfile = new ELBSProfile(
        "<your appId>",
        "<your appkey>",
        "<your url>"
);

ELBSRequest elbsRequest = new ELBSRequest();
// elbsRequest.set... elbsRequest设置值
ELBSClient elbsClient = new ELBSClient(elbsProfile);
ELBSResponse elbsResponse = elbsClient.location(elbsRequest);
// ... 定位结果处理及异常处理
```

