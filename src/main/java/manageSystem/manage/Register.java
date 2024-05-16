package manageSystem.manage;

import manageSystem.enums.UserEnum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import static manageSystem.enums.UserEnum.STUDENT;
import static manageSystem.enums.UserEnum.TEACHER;

/**
 * 注册功能
 */
public class Register implements Serializable {
    private static final long serialVersionUID = -1800043792123002706L;
    public Boolean register(String account, String password, int role){
        UserEnum userRole = UserEnum.getRole(role);

        if(Objects.isNull(userRole)){
            System.out.println("用户注册类型错误");
            return false;
        }
        String file;
        switch(userRole){
            case TEACHER:
                file = "src/main/resources/account/teacher";
                break;
            case STUDENT:
                file = "src/main/resources/account/teacher.txt";
                break;
            default:
                file = "";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(account + " " + password);
            writer.newLine();
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
