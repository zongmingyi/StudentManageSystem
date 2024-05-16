package manageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {
    private static final long serialVersionUID = -5407893901501306476L;

    /**
     * 年龄
     */
    private int age;
    /**
     * 性别：1：男性 0：女性
     */
    private int sex;

    /**
     * 教师工号
     */
    private String tID;

    /**
     * 学院
     */

    private String academy;

    /**
     * 密码
     */
    private String password;

    /**
     * 类别
     */
    private int category;
}
