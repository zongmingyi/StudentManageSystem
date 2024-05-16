package manageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 成绩实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score implements Serializable {
    private static final long serialVersionUID = -5599547304870209331L;

    /**
     * 学号
     */
    private String id;
    /**
     * 总成绩
     */
    private String totalScore;
    /**
     * 语文
     */
    private String chinese;

    /**
     * 数学
     */
    private String math;
    /**
     * 英语
     */
    private String english;


}
