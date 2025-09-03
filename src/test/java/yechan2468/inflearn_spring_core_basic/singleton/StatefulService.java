package yechan2468.inflearn_spring_core_basic.singleton;

public class StatefulService {

    private int price = 0;  // stateful

    public void setPrice(int newPrice) {
        price = newPrice;
    }

    public int getPrice() {
        return price;
    }
}
