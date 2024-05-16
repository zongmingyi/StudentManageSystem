package manageSystem.manage;

import manageSystem.entity.Score;
import manageSystem.enums.CourseEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 查询操作
 */
public class Search implements Serializable {
    private static final long serialVersionUID = -7456895357464584438L;

    public Score search(String ID, int category) {
        String file = "src/main/resources/information/scores";
        List<Score> scoreList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                Score scores = new Score(split[0], split[1], split[2], split[3], split[4]);
                scoreList.add(scores);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Score result = scoreList.stream().filter(Objects::nonNull).filter(score -> score.getId().equals(ID))
                .findFirst().orElse(null);
        if(Objects.isNull(result)){
            System.out.println("学生信息为空");
            return null;
        }
        CourseEnum course = CourseEnum.getCourse(category);
        if(Objects.isNull(course)){
            System.out.println("查询课程类型错误");
            return null;
        }

        Score score = new Score();
        score.setId(ID);
        switch(course){
            case TOTAL:
                score.setTotalScore(result.getTotalScore());
            case CHINESE:
                score.setChinese(result.getChinese());
                break;
            case MATH:
                score.setMath(result.getMath());
                break;
            case ENGLISH:
                score.setEnglish(result.getEnglish());
                break;
            default:
        }
        return score;
    }
}
