package manageSystem.manage;


import manageSystem.entity.Account;
import manageSystem.enums.UserEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 登录功能，根据不同的角色来读取不同文件，进而验证
 */
public class Login implements Serializable {
    private static final long serialVersionUID = 8733831155889904841L;

    public Boolean login(String account, String password, int category) {
        List<Account> accountList = new ArrayList<>();
        UserEnum role = UserEnum.getRole(category);
        if (Objects.isNull(role)){
            System.out.println("登录身份不合法");
            return false;
        }
        String file;
        switch (role){
            case TEACHER:
                file = "src/main/resources/account/teacher";
                break;
            case STUDENT:
                file = "src/main/resources/account/student";
                break;
            default:
                file = "";
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    accountList.add(new Account(parts[0], parts[1]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Account result = accountList.stream().filter(Objects::nonNull)
                .filter(account1 -> account1.getAccount().equals(account)).findFirst().orElse(null);
        if (result != null) {
            return result.getPassword().equals(password);
        }
        return false;
    }
}
