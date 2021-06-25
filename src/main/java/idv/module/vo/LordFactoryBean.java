package idv.module.vo;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * * LordFactoryBean. 2020/3/16 1:15 上午
 * *
 * * @author sero
 * * @version 1.0.0
 *
 **/
@Data
public class LordFactoryBean implements FactoryBean<LordBean> {

    private String name;
    private BigDecimal treasury;
    private Date createTime;
    @Autowired
    private LordWeapon lordWeapon;

    @Override
    public LordBean getObject() throws Exception {
        LordBean lordBean = new LordBean();
        lordBean.setName(getName());
        lordBean.setTreasury(getTreasury());
        lordBean.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        return lordBean;
    }

    @Override
    public Class<LordBean> getObjectType() {
        return LordBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
