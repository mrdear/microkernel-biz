package cn.mrdear.microkernel.biz.order;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Quding Ding
 * @since 2020/2/22
 */
@Service
public class PhysicalOrderCreateService implements OrderCreateService {
    @Override
    public OrderType[] support() {
        return new OrderType[]{OrderType.PHYSICAL};
    }

    @Override
    public Order create(Set<Long> invIds, Set<Long> couponIds) {
        Order order = new Order();
        order.setType(OrderType.PHYSICAL);
        return order;
    }
}
