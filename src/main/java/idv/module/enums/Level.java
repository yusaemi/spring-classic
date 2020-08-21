package idv.module.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * * Level. 2020/3/15 7:20 下午
 * *
 * * @author sero
 * * @version 1.0.0
 *
 **/
@AllArgsConstructor
@Getter
public enum Level {

    ADAMANTIUM("SS"),
    ORICHALCUM("S"),
    MITHRIL("A"),
    PLATINUM("B"),
    GOLD("C"),
    SILVER("D"),
    IRON("E"),
    COPPER("novice");

    private String code;
}
