package com.example.demo;

import org.apache.thrift.solon.annotation.EnableThrift;
import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

@EnableThrift
@SolonMain
public class DemoApp {
    public static void main(String[] args) {
        Solon.start(DemoApp.class, args);
    }
}