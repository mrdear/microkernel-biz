package cn.mrdear.microkernel.biz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mrdear.microkernel.biz.micro.PluginManager;
import cn.mrdear.microkernel.biz.micro.PluginType;
import cn.mrdear.microkernel.biz.order.Order;
import cn.mrdear.microkernel.biz.order.OrderCreateService;
import cn.mrdear.microkernel.biz.order.OrderType;

import java.util.Collections;

import javax.annotation.Resource;

/**
 * @author Quding Ding
 * @since 2020/2/22
 */
@RestController
public class OrderController {

    @Resource
    private PluginManager pluginManager;

    @GetMapping(value = "order")
    public Order order(OrderType type) {
        OrderCreateService createService = pluginManager.getPlugin(PluginType.ORDER_CREATE_PLUGIN,
            type.name());

        return createService.create(Collections.singleton(1L), Collections.singleton(1L));
    }

}
