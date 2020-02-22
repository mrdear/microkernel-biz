package cn.mrdear.microkernel.biz.order;

import java.util.Set;

/**
 * @author Quding Ding
 * @since 2020/2/21
 */
public interface OrderCreateService {

    /**
     * 支持的订单类型
     *
     * @return 返回支持订单类型结果
     */
    OrderType[] support();

    /**
     * 订单创建服务
     * @param invIds 商品id
     * @param couponIds 优惠券
     * @return 创建结果
     */
    Order create(Set<Long> invIds, Set<Long> couponIds);

}
