package manageSystem;

import manageSystem.entity.Score;
import manageSystem.enums.CourseEnum;
import manageSystem.enums.UserEnum;
import manageSystem.manage.*;

import java.io.Serializable;
import java.util.Scanner;

public class Entrance implements Serializable {
    private static final long serialVersionUID = 1444644996876187336L;
    static String account;
    public static void main(String[] args) {
        Boolean resLogin;
        Boolean resRegister;
        int role;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("**************学生成绩管理系统**************");
            System.out.println("请选择：1:登录 2：注册");
            int choice = scanner.nextInt();
            System.out.println("请选择您的身份： 0：教师 1：学生");
            role = scanner.nextInt();
            if (choice == 1) {
                resLogin = login(role);
                if(resLogin){
                    break;
                }
            } else if (choice == 2) {
                Boolean res = register(role);
                if (!res) {
                    System.out.println("注册失败，请重新注册");
                    continue;
                }

                if(res){
                    System.out.println("注册系统成功");
                }
                resRegister = login(role);
                if(resRegister){
                    break;
                }
            }
        }

        if(role == UserEnum.STUDENT.getCategory()){
            while(true){
                search(account);
                System.out.println("是否退出系统，0：退出系统，1：继续查询成绩");
                int action = scanner.nextInt();
                if(action == 0){
                    break;
                }
            }
        }else if(role == UserEnum.TEACHER.getCategory()){
            while(true){
                System.out.println("请输入您的操作：0：添加 1：删除 2: 更新 3：查询");
                int action = scanner.nextInt();
                switch(action){
                    case 0:
                        add(account);
                        break;
                    case 1:
                        delete(account);
                        break;
                    case 2:
                        update(account);
                        break;
                    case 3:
                        search(account);
                        break;
                    default:
                }
                System.out.println("是否退出系统，0：退出系统");
                int action1 = scanner.nextInt();
                if(action1 == 0){
                    break;
                }
            }
        }
    }

    public static Boolean login(int role) {
        System.out.println("请登录系统");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号");
        account = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        Login login = new Login();
        return login.login(account, password, role);
    }

    public static Boolean register(int role) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号");
        String account = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        Register register = new Register();
        return register.register(account, password, role);
    }

    public static void search(String account){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的课程，0：总成绩，1：语文，2：数学，3：英语");
        int course = scanner.nextInt();
        CourseEnum courseEnum = CourseEnum.getCourse(course);
        Search search = new Search();
        Score score = search.search(account, course);
        System.out.println(score.getId() + " " +score.toString());
    }

    public static void add(String account){
        Add addAction = new Add();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入语文成绩");
        int chinese = scanner.nextInt();
        System.out.print("请输入数学成绩");
        int math = scanner.nextInt();
        System.out.print("请输入英语成绩");
        int english = scanner.nextInt();
        int total = chinese + math + english;
        Score score = new Score();
        score.setId(account);
        score.setTotalScore(String.valueOf(total));
        score.setMath(String.valueOf(math));
        score.setChinese(String.valueOf(chinese));
        score.setEnglish(String.valueOf(english));
        addAction.add(score);
    }

    public static void delete(String account){
        Delete deleteAction = new Delete();
        deleteAction.delete(account);
    }

    public static void update(String account){
        Scanner scanner = new Scanner(System.in);
        Update updateAction = new Update();
        //不修改的成绩，写成-1
        System.out.print("请输入要修改的语文成绩：");
        int chinese = scanner.nextInt();
        System.out.print("请输入要修改的数学成绩：");
        int math = scanner.nextInt();
        System.out.print("请输入要修改的英语成绩：");
        int english = scanner.nextInt();
        Score score = new Score();
        score.setId(account);
        if(chinese != -1){
            score.setChinese(String.valueOf(chinese));
        }
        if(math != -1){
            score.setMath(String.valueOf(math));
        }
        if(english != -1){
            score.setEnglish(String.valueOf(english));
        }
        updateAction.update(score);
    }
}
