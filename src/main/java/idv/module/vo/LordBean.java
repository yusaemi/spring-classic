package idv.module.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * * LordBean. 2020/3/15 11:22 下午
 * *
 * * @author sero
 * * @version 1.0.0
 *
 **/
@Getter
public class LordBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Setter
    private String name;
    @Setter
    private BigDecimal treasury;
    @Setter
    private Date createTime;

    @Autowired
    private LordWeapon lordWeapon;

}
