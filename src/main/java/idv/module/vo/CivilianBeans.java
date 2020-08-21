package idv.module.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * * CivilianBeans. 2020/3/15 11:49 下午
 * *
 * * @author sero
 * * @version 1.0.0
 *
 **/
@Data
public class CivilianBeans {
    private CivilianBean[] civilianBeanArray;
    private List<CivilianBean> civilianBeanList;
    private Map<String, CivilianBean> civilianBeanMap;
}
