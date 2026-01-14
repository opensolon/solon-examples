package demo1001.demo5_2;


import org.noear.solon.annotation.Around;

import java.lang.annotation.*;

//绑定能力的方式（不需要另外的注册了）//这是与3号示例的区别
@Around(LogInterceptor.class)
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log{

}