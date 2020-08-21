package idv.module.vo;

import idv.module.enums.Level;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * * AdventurerBean. 2020/3/15 9:32 下午
 * *
 * * @author sero
 * * @version 1.0.0
 *
 **/
// 直接注入，不用寫在xml
/*
 * 	上層的Beans也要新增參照
 *  xmlns:context="http://www.springframework.org/schema/context"
 *  xsi:http://www.springframework.org/schema/context
 *	xsi:http://www.springframework.org/schema/context/spring-context.xsd
 *	之後在下方設定<context:component-scan base-package="idv.module"/>即可
 */
@Component
@Data
public class AdventurerBean {

    // 如果沒有配置xml又希望在類別初始化時即有初始值，可以使用 SpEL (Spring 表達式語言)
    @Value("#{'Ryue'}")
    private String name;
    @Value("#{false}")
    private boolean gender;
    @Value("#{'sword'}")
    private String weapon;
    @Value("#{T(idv.module.enums.Level).ADAMANTIUM.getCode()}")
    private String level;

}
