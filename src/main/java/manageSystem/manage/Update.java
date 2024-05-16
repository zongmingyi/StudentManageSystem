package manageSystem.manage;

import manageSystem.entity.Score;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Update implements Serializable {
    private static final long serialVersionUID = 5352208951938813593L;

    public void update(Score score){
        String file = "information/scores";
        List<Score> context = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null){
                String[] split = line.split(" ");
                Score scores = new Score(split[0], split[1], split[2], split[3], split[4]);
                context.add(scores);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Score> collect = context.stream().filter(Objects::nonNull).map(score1 -> {
            if (score1.getId().equals(score.getId())) {
                if (Objects.nonNull(score.getChinese())) {
                    score1.setChinese(score.getChinese());
                }

                if (Objects.nonNull(score.getTotalScore())) {
                    score1.setTotalScore(score.getTotalScore());
                }

                if (Objects.nonNull(score.getEnglish())) {
                    score1.setEnglish(score.getEnglish());
                }

                if (Objects.nonNull(score.getMath())) {
                    score1.setMath(score.getMath());
                }
            }
            return score1;
        }).collect(Collectors.toList());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Score value : collect) {
                writer.write(value.toString());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
