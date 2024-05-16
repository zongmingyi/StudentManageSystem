package manageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 学生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -890820486296353031L;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别：1：男性 0：女性
     */
    private int sex;

    /**
     * 学号
     */
    private String sID;

    /**
     * 学院
     */

    private String academy;

    /**
     * 密码
     */
    private String password;

    /**
     * 班级
     */
    private String banji;

    /**
     * 类别
     */
    private int category;
}
