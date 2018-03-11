## 前后端分离项目用maven整合spring-boot和webpack  
```
demo
|---- server
|	|
|	|---- src			//源码
|	|---- target		//构建输出目录
|	|---- pom.xml		//maven配置文件
|
|---- ui
|	|---- src				//源码
|	|---- target			//构建输出目录
|	|---- pom.xml			//maven配置文件
|	|---- static				//静态资源
|	|---- webpack.config.js	//webpack配置文件
|	|---- package.json		//webpack说明文件,类似pom.xml
|
|---- pom.xml
```
因为对前端不熟, 所以只能说个大概思路.
server依赖于ui, 编译时maven使用插件将webpack输出的内容封装为jar包, server再使用spring-boot插件将ui jar包打包到自己的jar包中, 最终运行时按普通spring-boot程序运行即可. 当然, 在代码中也要做相关设置将发送给spring-boot的请求转发到ui.

ui的pom.xml插件配置如下, 这里定义了编译时要调用的node(webpack)命令 npm run build:
```
<build>
    <plugins>
      <plugin>
        <groupId>com.github.eirslett</groupId>
        <artifactId>frontend-maven-plugin</artifactId>
        <version>${frontend-maven-plugin.version}</version>
        <configuration>
          <installDirectory>target</installDirectory>
        </configuration>
        <executions>
          <execution>
            <id>install node and npm</id>
            <goals>
              <goal>install-node-and-npm</goal>
            </goals>
            <configuration>
              <nodeVersion>v5.5.0</nodeVersion>
              <npmVersion>3.6.0</npmVersion>
            </configuration>
          </execution>
          <execution>
            <id>npm install</id>
            <goals>
              <goal>npm</goal>
            </goals>
            <configuration>
              <arguments>install</arguments>
            </configuration>
          </execution>
          <execution>
            <id>npm run build</id>
            <goals>
              <goal>npm</goal>
            </goals>
            <phase>compile</phase>
            <configuration>
              <arguments>run build</arguments>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
```


对应的package.json文件中的命令:
```
{
  "name": "xxxxx",
  "version": "0.0.0",
  "description": "The frontend UI for ",
  "main": "index.js",
  "scripts": {
    "dev": "node node_modules/webpack-dev-server/bin/webpack-dev-server.js --hot --inline",
    "test": "node node_modules/karma/bin/karma start --single-run",
    "test-watch": "node node_modules/karma/bin/karma start",
    "lint": "node node_modules/eslint/bin/eslint js test",
    "build": "node node_modules/webpack/bin/webpack.js --bail"
  },
......
......
```


build命令应该是调用webpack.config.js来将资源打包到target/classes/ui文件夹下.

之后在server端要进行相关URL设置:

```
@Configuration
@RestController
public class UiConfig2 extends WebMvcConfigurerAdapter {

  @Value("classpath:/maid-ui/index.html")
  Resource indexHtml;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/maid-ui/")
        .setCachePeriod((int) TimeUnit.DAYS.toSeconds(365));
  }

  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  public CharacterEncodingFilter characterEncodingFilter() {
    CharacterEncodingFilter filter = new CharacterEncodingFilter() {
      @Override
      protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().endsWith(".png");
      }
    };
    filter.setEncoding("UTF-8");
    filter.setForceEncoding(true);
    return filter;
  }

  @RequestMapping(value = "/index.html", method = GET)
  public ResponseEntity<Resource> serveIndex() {
    return ResponseEntity.ok()
        .cacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES))
        .body(indexHtml);
  }

  @RequestMapping(value = {"/", "/index"}, method = GET)
  public ModelAndView forwardUiEndpoints(ModelMap model) {
    return new ModelAndView("forward:/index.html", model);
  }
}
```
前端要加页面时必须在最后一个方法的注解中增加路径, 有没有什么解决办法?

大概就是这样了
