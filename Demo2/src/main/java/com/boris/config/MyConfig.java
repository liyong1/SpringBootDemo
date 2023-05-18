package com.boris.config;

import com.boris.bean.Pet;
import com.boris.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author liyong
 * 1、配置类里边使用@Bean标注在方法上给容器注册组件，默认是单实例的。
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *     Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *     Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *     组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *
 * 4、@Import({User.class, DBHelper.class})
 *     给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 *
 */
@Import({User.class})
@Configuration(proxyBeanMethods = true) // 告诉SpringBoot这是个配置类 == 配置文件
@ConditionalOnMissingBean(name="tom")
@ImportResource("classpath:beans.xml")
public class MyConfig {

    @Bean //给容器中添加组件，以方法名作为组件的id。返回类型就是组件类型。返回的值就是组件在容器中的实例
    public User user01() {
        User user = new User("user01",18);
        user.setPet(tomcatPet());
        return user;
    }

    @Bean("tom") //组件名不为方法，改为了自定义的名字"tom"
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}