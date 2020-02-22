package cn.mrdear.microkernel.biz.micro.register;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Quding Ding
 * @since 2020/2/21
 */
public abstract class AbstractSpringRegister<T> implements PluginRegister<T>, ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initPlugin(event.getApplicationContext());
    }

    /**
     * 初始化插件
     * @param context ioc容器
     */
    protected abstract void initPlugin(ApplicationContext context);

}
