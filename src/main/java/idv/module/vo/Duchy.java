package idv.module.vo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * * Duchy. 2020/3/15 7:02 下午
 * *
 * * @author sero
 * * @version 1.0.0
 *
 **/
@Getter
@ToString
public class Duchy {
    // 自動注入，無需setter，xml設定annotation.AutowiredAnnotationBeanPostProcessor
    // required = false: spring 在找不到匹配的 bean 時也不要拋出 exception
    @Autowired(required = false)
    private Lord lord;
    @Autowired
    private Knight knight;
    private Adventurer adventurer;
    private Civilian civilian;
}
