package com.example.demo;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

@SolonMain
public class App {
    public static void main(String[] args) {
        //指定配置，避免影响测试
        Solon.start(App.class, args);
    }
}