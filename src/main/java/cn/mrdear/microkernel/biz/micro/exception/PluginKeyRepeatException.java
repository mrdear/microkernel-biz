package cn.mrdear.microkernel.biz.micro.exception;

/**
 * @author Quding Ding
 * @since 2020/2/21
 */
public class PluginKeyRepeatException extends RuntimeException {

    public PluginKeyRepeatException(String message) {
        super(message);
    }
}
