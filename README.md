# 设备管理系统

这是一个 Java 后端练手项目，使用 Java 17、Maven、Spring Boot 和 MyBatis。默认连接 H2 内存数据库，无需安装 MySQL 即可运行。

## 本地启动

```powershell
mvn spring-boot:run
```

如果已经通过 `mvn verify` 打包，也可以直接运行 `java -jar target/device-management-0.0.1-SNAPSHOT.jar`。

启动后访问 `http://localhost:8933/api/devices` 查看两条示例设备。H2 数据不会持久化，重启后会重新加载示例数据。

| 请求 | 用途 |mv
| --- | --- |
| `GET /api/devices` | 查询设备列表 |
| `GET /api/devices/1` | 查询单台设备；不存在时返回 HTTP 404 |

运行测试：`mvn test`。

## 切换到 MySQL

在 MySQL 中创建 `device_management` 数据库（建议使用 `utf8mb4`），在该库中执行 `src/main/resources/db/schema.sql` 建表。需要示例数据时，可再手动执行 `src/main/resources/db/sample-data.sql`。`mysql` 配置不会自动建表或导入数据。

在 PowerShell 中设置连接信息并启动：

```powershell
$env:DEVICE_DB_URL = "jdbc:mysql://localhost:3306/device_management"
$env:DEVICE_DB_USER = "你的数据库用户名"
$env:DEVICE_DB_PASSWORD = "你的数据库密码"
$env:SPRING_PROFILES_ACTIVE = "mysql"
mvn spring-boot:run
```

设备模块中，`DeviceController` 接收 HTTP 请求，`DeviceService` 承接业务逻辑，`DeviceMapper` 执行 SQL。目前提供只读查询，下一步可以从新增设备、校验资产编号和分页查询入手。
