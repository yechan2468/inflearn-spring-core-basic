package yechan2468.inflearn_spring_core_basic.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class DummyNetworkClient {

    private String url;

    public DummyNetworkClient() {
        System.out.println("Constructor: url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void send(String message) {
        System.out.println("send: " + url + " msg: " + message);
    }

    public void disconnect() {
        System.out.println("disconnect: " + url);
    }

    @PostConstruct
    public void init() {
        connect();
        send("초기 연결");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }
}
