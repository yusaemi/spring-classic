package idv.module.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * * LordWeapon. 2020/3/16 12:22 上午
 * *
 * * @author sero
 * * @version 1.0.0
 **/
@Data
// 自動載入類別bean名稱為lordWeapon，不寫就是class名稱的小寫
// @Component("lordWeapon")
// 拿掉Component使用自定義Spring類別設定(SpringConfig.java)
public class LordWeapon implements Serializable {

    private static final long serialVersionUID = 1L;

    //SpEL給初值
    @Value("#{'Brynhild'}")
    private String name;
    @Value("#{'Gun'}")
    private String type;
    @Value("#{'black'}")
    private String color;
    private BigDecimal price;
}
