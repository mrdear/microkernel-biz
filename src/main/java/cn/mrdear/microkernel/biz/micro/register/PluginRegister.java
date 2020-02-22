package cn.mrdear.microkernel.biz.micro.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.mrdear.microkernel.biz.micro.PluginType;

/**
 * 插件注册管理器
 * @author Quding Ding
 * @since 2020/2/21
 */
public interface PluginRegister<T> {

    Logger LOGGER = LoggerFactory.getLogger("PLUGIN");

    /**
     * 支持管理的插件类型
     * @return 插件类型
     */
    PluginType support();

    /**
     * 根据指定key获取对应插件
     * @param key 插件key
     * @return 获取结果
     */
    T getPlugin(String key);

}
