package com.boris;

import com.boris.bean.Pet;
import com.boris.bean.User;
import com.boris.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liyong
 * 主程序类
 * @SpringBootApplication 等同于
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan("com.boris")
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.boris") // 指定包扫描路径，还可以容器中创建组件
public class MainApplication {
    public static void main(String[] args) {
        // 1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        // 获取配置类MyConfig中通过bean注入到容器
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        // 注册的组件默认为单实例
        System.out.println("配置类中组件：" + (tom01 == tom02));

        // 容器中获取配置类
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        // 如果@Configuration(proxyBeanMethods = true) 代理对象调用方法，SpringBoot总会检查这个组件是否在容器中
        // 保持组件单实例
        User user01 = bean.user01();
        User user02 = bean.user01();
        System.out.println(user01 == user02);

        // 测试组件依赖
        // user01组件中的Pet与tomcatPat的组件是否一致，依赖于proxyBeanMethods的值
        User user010 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);

        System.out.println("用户的宠物：" + (user010.getPet() == tom));

        // 获取同一类的组件
        System.out.println("+++++++++");
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }


        // 获取beans.xml中配置的对象，使用@ImportResource("classpath:beans.xml")引入文件
        boolean user1 = run.containsBean("haha");
        System.out.println("haha组件:"+user1);

    }
}
