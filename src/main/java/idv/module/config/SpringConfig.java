package idv.module.config;

import idv.module.vo.LordBean;
import idv.module.vo.LordWeapon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Date;

/**
 * * SpringConfig. 2020/3/16 12:08 上午
 * *
 * * @author sero
 * * @version 1.0.0
 **/
// Configuration表示這個類別是用來做為 spring 設定
@Configuration
public class SpringConfig {

    @Bean
    public LordWeapon lordWeapon() {
        LordWeapon lordWeapon = new LordWeapon();
        // 若類別裡有給初值，這個set不會起作用。
        lordWeapon.setPrice(new BigDecimal("99999999"));
        return lordWeapon;
    }

    @Bean(name = "lordBeanConfig")
    public LordBean lordBean() {
        LordBean lordBean = new LordBean();
        lordBean.setName("AinzOoalGown");
        lordBean.setTreasury(new BigDecimal("500000000"));
        lordBean.setCreateTime(new Date());
        return lordBean;
    }

}
