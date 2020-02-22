package cn.mrdear.microkernel.biz.micro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cn.mrdear.microkernel.biz.micro.exception.PluginKeyRepeatException;
import cn.mrdear.microkernel.biz.micro.register.PluginRegister;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Quding Ding
 * @since 2020/2/21
 */
@Component
public class PluginManagerImpl implements PluginManager, ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger("PLUGIN");

    private static Map<PluginType, PluginRegister<?>> CACHE_MAP;

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getPlugin(PluginType type, String key) {
        PluginRegister<?> register = CACHE_MAP.get(type);
        return (T) register.getPlugin(key);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, PluginRegister> iocBeanMap =
            BeanFactoryUtils.beansOfTypeIncludingAncestors(event.getApplicationContext(),
            PluginRegister.class, false, true);

        Map<PluginType, PluginRegister<?>> temp = new ConcurrentHashMap<>();

        iocBeanMap.forEach((k,v) -> {
            if (temp.containsKey(v.support())) {
                throw new PluginKeyRepeatException(String.format("PluginRegister plugin type=%s repeat",
                    v.support()));
            }
            temp.put(v.support(), v);
        });
        CACHE_MAP = temp;

        logger.info("PluginRegister register success={}", CACHE_MAP);
    }

}
