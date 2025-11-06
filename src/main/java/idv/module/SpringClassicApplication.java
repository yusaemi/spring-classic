package idv.module;

import idv.module.config.SpringConfig;
import idv.module.vo.AdventurerBean;
import idv.module.vo.CivilianBean;
import idv.module.vo.CivilianBeans;
import idv.module.vo.Duchy;
import idv.module.vo.KnightBean;
import idv.module.vo.LordBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * * Application. 2020/3/15 9:48 下午
 * *
 * * @author sero
 * * @version 1.0.0
 **/
public class SpringClassicApplication {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    void main() throws InterruptedException {

        // 讀取xml檔案設定，也可使用new ClassPathXmlApplicationContext("file:檔案的絕對路徑")
        ClassPathResource classPathResource = new ClassPathResource("/spring-config.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext(classPathResource.getPath());

        // 取得bean物件
        AdventurerBean adventurerBean = (AdventurerBean) context.getBean("adventurerBean");
        Duchy duchy = (Duchy) context.getBean("duchy");
        KnightBean knightBean = (KnightBean) context.getBean("knightBean");
        CivilianBean civilianBean = (CivilianBean) context.getBean("civilianBean");
        CivilianBeans civilianBeans = (CivilianBeans) context.getBean("civilianBeans");

        LOGGER.info("==============AdventurerBean use SpEL==============");
        // 使用SpEL的話就不需定義屬性，建立即有初值
        LOGGER.log(Level.INFO, "(AdventurerBean) Name: {0}, Weapon: {1}, Level: {2}, Sex: {3}", new Object[]{adventurerBean.getName(), adventurerBean.getWeapon(), adventurerBean.getLevel(), adventurerBean.isGender() ? "M" : "F"});
        Thread.sleep(50);

        LOGGER.info("==============Duchy use Autowired==============");
        LOGGER.log(Level.INFO, "(Duchy) Lord Name: {0}, Knight salary: {1}", new Object[]{duchy.getLord().getName(), duchy.getKnight().getSalary()});
        Thread.sleep(50);

        LOGGER.info("==============KnightBean use Required==============");
        LOGGER.log(Level.INFO, "(KnightBean) Name: {0}, weapon: {1}, salary: {2}, Sex: {3}", new Object[]{knightBean.getName(), knightBean.getWeapon(), knightBean.getSalary(), knightBean.isGender() ? "M" : "F"});
        Thread.sleep(50);

        LOGGER.info("==============CivilianBean use Parent setting==============");
        // 配置屬性只定義了name，因為有繼承virtualCivilianBean，deposit也會有值
        LOGGER.log(Level.INFO, "(CivilianBean) Name: {0}, deposit: {1}", new Object[]{civilianBean.getName(), civilianBean.getDeposit().intValue()});
        Thread.sleep(50);

        LOGGER.info("==============CivilianBeans use Reference==============");
        // 傳回三種集合結果
        CivilianBean[] civilianBeanArray = civilianBeans.getCivilianBeanArray();
        List<CivilianBean> civilianBeanList = civilianBeans.getCivilianBeanList();
        Map<String, CivilianBean> civilianBeanMap = civilianBeans.getCivilianBeanMap();
        Arrays.stream(civilianBeanArray).forEach(cb -> LOGGER.log(Level.INFO, "(CivilianBeanArray) name: {0}, deposit: {1}", new Object[]{cb.getName(), cb.getDeposit().intValue()}));
        civilianBeanList.forEach(cb -> LOGGER.log(Level.INFO, "(CivilianBeanList) name: {0}, deposit: {1}", new Object[]{cb.getName(), cb.getDeposit().intValue()}));
        for (Map.Entry<String, CivilianBean> cbEntry : civilianBeanMap.entrySet()) {
            String key = String.valueOf(cbEntry.getKey());
            LOGGER.log(Level.INFO, "(CivilianBeanMap) name: {0}, deposit: {1}", new Object[]{civilianBeanMap.get(key).getName(), civilianBeanMap.get(key).getDeposit().intValue()});
        }
        Thread.sleep(50);

        LOGGER.info("==============LordBeanConfig use SpringConfig==============");
        // 改成以下方法，可以register好幾個類別
        AnnotationConfigApplicationContext annoContext = new AnnotationConfigApplicationContext();
        annoContext.register(SpringConfig.class);
        annoContext.refresh();
        // LordWeapon用Component建立，然後LordBean使用Autowired把LordWeapon注入
        LordBean lordBeanConfig = (LordBean) annoContext.getBean("lordBeanConfig");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LOGGER.log(Level.INFO, "(LordBeanConfig) name: {0}, treasury: {1}, createTime: {2}, lordWeapon: {3}", new Object[]{lordBeanConfig.getName(), lordBeanConfig.getTreasury().intValue(), sdf.format(lordBeanConfig.getCreateTime()), lordBeanConfig.getLordWeapon().toString()});
        LordBean lordBean = (LordBean) context.getBean("lordBean");
        LOGGER.log(Level.INFO, "(LordBean) name: {0}, treasury: {1}, createTime: {2}, lordWeapon: {3}", new Object[]{lordBean.getName(), lordBean.getTreasury().intValue(), sdf.format(lordBean.getCreateTime()), lordBean.getLordWeapon().toString()});
        Thread.sleep(50);

        LOGGER.info("==============LordFactoryBean use Factory==============");
        /*
         * 當bean設定檔中的class是實作FactoryBean的類別時，通過getBean()取得的不是 FactoryBean本身，而是
         * FactoryBean.getObject()傳回的物件，等同getObject()代理getBean()。
         * 此時LordFactoryBean中，即使lordWeapon加了Autowired還是得去setLordWeapon，否則會不存在。
         */
        LordBean lordFactoryBean = (LordBean) context.getBean("lordFactoryBean");
        LOGGER.log(Level.INFO, "(LordFactoryBean) name: name: {0}, treasury: {1}, createTime: {2}, lordWeapon: {3}", new Object[]{lordFactoryBean.getName(), lordFactoryBean.getTreasury().intValue(), sdf.format(lordFactoryBean.getCreateTime()), lordFactoryBean.getLordWeapon() == null ? "物件不存在" : lordFactoryBean.getLordWeapon().toString()});

    }

}
