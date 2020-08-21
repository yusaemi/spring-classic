package idv.module.vo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Required;

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
    @Required
    public void setName(String name) {
        this.name = name;
    }

    @Required
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Required
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Required
    public void setSalary(Integer salary) {
        this.salary = salary;
    }


}
