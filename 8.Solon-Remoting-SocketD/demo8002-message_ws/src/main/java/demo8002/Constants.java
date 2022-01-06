package demo8002;

public class Constants {
    /***
     * false ：走的是 websocket 基础协议（数据会摸拟转换为 SocketD message）（flag,key,header,会丢失）
     * true :  是基于 websocket 发送 SocketD message 完整功能包（可实现双向RPC模式）
     *
     * 开起或关闭，client server 要一起开头
     * */
    public static final boolean enableWebSocketD = true;
}
