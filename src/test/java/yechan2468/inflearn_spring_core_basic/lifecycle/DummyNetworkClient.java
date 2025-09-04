package yechan2468.inflearn_spring_core_basic.lifecycle;

public class DummyNetworkClient {

    private String url;

    public DummyNetworkClient() {
        System.out.println("Constructor: url = " + url);
        connect();
        send("초기화");
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
}
