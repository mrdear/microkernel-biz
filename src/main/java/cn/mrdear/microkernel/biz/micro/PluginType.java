package cn.mrdear.microkernel.biz.micro;

/**
 * @author Quding Ding
 * @since 2020/2/21
 */
public enum PluginType {

    /**
     * 订单创建插件
     */
    ORDER_CREATE_PLUGIN,

    /**
     * 优惠券校验插件
     * 只是举例,不实现
     */
    COUPON_VALIDATE_PLUGIN,

    /**
     * 支付网关插件
     * 只是举例,不实现
     */
    PAY_GATEWAY_PLUGIN
    ;

}
