package yechan2468.inflearn_spring_core_basic.lifecycle;

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

    public void init() {
        connect();
        send("초기 연결");
    }

    public void close() {
        disconnect();
    }
}
