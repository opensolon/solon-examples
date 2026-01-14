package demo1001.demo5_3;


import java.lang.annotation.*;

//不绑定能力（通过注册实现）
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log{

}