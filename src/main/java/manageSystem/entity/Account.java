package manageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 账号实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 6452765982034021878L;

    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
}
