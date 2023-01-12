package idv.module.vo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * * KnightBean. 2020/3/15 10:34 下午
 * *
 * * @author sero
 * * @version 1.0.0
 *
 **/
@Getter
@ToString
public class KnightBean {

    private String name;
    private boolean gender;
    private String weapon;
    private Integer salary;

    // 必填欄位由spring預先檢查，xml要設定annotation.RequiredAnnotationBeanPostProcessor
    @Autowired
    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Autowired
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Autowired
    public void setSalary(Integer salary) {
        this.salary = salary;
    }


}
