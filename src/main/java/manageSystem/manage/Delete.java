package manageSystem.manage;

import manageSystem.entity.Score;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Delete implements Serializable {
    private static final long serialVersionUID = -8972359586288947347L;

    public void delete(String id) {
        String file = "information/scores";
        List<Score> context = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null){
                String[] split = line.split(" ");
                if(split[0].equals(id)){
                    continue;
                }
                Score scores = new Score(split[0], split[1], split[2], split[3], split[4]);
                context.add(scores);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Score score : context) {
                writer.write(score.toString());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
