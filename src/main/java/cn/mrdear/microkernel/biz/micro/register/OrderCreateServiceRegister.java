package cn.mrdear.microkernel.biz.micro.register;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cn.mrdear.microkernel.biz.micro.PluginType;
import cn.mrdear.microkernel.biz.micro.exception.PluginKeyRepeatException;
import cn.mrdear.microkernel.biz.order.OrderCreateService;
import cn.mrdear.microkernel.biz.order.OrderType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Quding Ding
 * @since 2020/2/21
 */
@Component
public class OrderCreateServiceRegister extends AbstractSpringRegister<OrderCreateService> {

    private static Map<OrderType, OrderCreateService> CACHE_MAP;

    @Override
    public PluginType support() {
        return PluginType.ORDER_CREATE_PLUGIN;
    }

    @Override
    public OrderCreateService getPlugin(String key) {
        return CACHE_MAP.get(OrderType.valueOf(key));
    }

    @Override
    protected void initPlugin(ApplicationContext context) {
        Map<String, OrderCreateService> iocBeanMap = BeanFactoryUtils.beansOfTypeIncludingAncestors(context,
            OrderCreateService.class, false, true);

        ConcurrentHashMap<OrderType, OrderCreateService> temp = new ConcurrentHashMap<>(3);
        iocBeanMap.forEach((k,v) -> {
            for (OrderType orderType : v.support()) {
                if (temp.containsKey(orderType)) {
                    throw new PluginKeyRepeatException(String.format("OrderCreateService plugin type=%s repeat", orderType));
                }
                temp.put(orderType, v);
            }
        });

        CACHE_MAP = temp;

        LOGGER.info("OrderCreateService register success={}", CACHE_MAP);
    }

}
