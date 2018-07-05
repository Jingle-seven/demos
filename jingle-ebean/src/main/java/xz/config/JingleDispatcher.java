package xz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class JingleDispatcher extends WebMvcConfigurerAdapter {
    /**
     * 配置静态访问资源,不知为何配置无效...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/jingle/**").addResourceLocations("classpath:/");
        //甚至可以暴露服务器上的其他目录文件
        registry.addResourceHandler("/computer/**").addResourceLocations("file:E:/doc/Desktop/temp/");
        super.addResourceHandlers(registry);
    }
    /**
     * 以前要访问一个页面需要先创建个Controller控制类，再写方法跳转到页面
     * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/user-book就跳转到setViewName页面了
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/user-book").setViewName("/api/book/user/121542330");
        registry.addViewController("/user-book").setViewName("/page/user-book.html");
        super.addViewControllers(registry);
    }
}
