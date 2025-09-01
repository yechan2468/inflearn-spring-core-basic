package yechan2468.inflearn_spring_core_basic.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
