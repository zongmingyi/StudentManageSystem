package manageSystem.manage;

import manageSystem.entity.Score;

import java.io.*;

/**
 * 添加信息 教师使用
 */
public class Add implements Serializable {
    private static final long serialVersionUID = -3536074296088134682L;

    public void add(Score score){
        String file = "information/scores";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(score.toString());
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
