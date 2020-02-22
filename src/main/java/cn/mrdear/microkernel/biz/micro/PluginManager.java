package cn.mrdear.microkernel.biz.micro;

/**
 * 插件适配服务
 * @author Quding Ding
 * @since 2020/2/21
 */
public interface PluginManager {


    /**
     * 根据插件类型以及插件key获取插件
     * @param type 插件类型
     * @param key 插件key
     * @param <T> 插件类型
     * @return 插件示例
     */
    <T> T getPlugin(PluginType type, String key);

}
