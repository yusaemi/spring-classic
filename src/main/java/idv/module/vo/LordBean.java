package idv.module.vo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

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

    private static final long serialVersionUID = 1L;

    private String name;
    private BigDecimal treasury;
    private Date createTime;

    @Autowired
    private LordWeapon lordWeapon;

    public void setName(String name) {
        this.name = name;
    }

    public void setTreasury(BigDecimal treasury) {
        this.treasury = treasury;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
