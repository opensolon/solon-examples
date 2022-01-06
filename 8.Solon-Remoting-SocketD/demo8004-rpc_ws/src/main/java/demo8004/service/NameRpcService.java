package demo8004.service;


import org.noear.nami.annotation.NamiClient;

@NamiClient(name = "localrpc", path = "/demoe/rpc/name")
public interface NameRpcService {
    String name(String name);
}
