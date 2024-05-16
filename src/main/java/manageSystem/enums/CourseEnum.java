package manageSystem.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CourseEnum {
    TOTAL("总成绩", 0),
    CHINESE("语文", 1),
    MATH("数学", 2),
    ENGLISH("英语", 3),

    ;

    /**
     * 课程名称
     */
    private final String name;
    /**
     * 课程类别
     */
    private final int category;

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    public static CourseEnum getCourse(int category) {
        CourseEnum[] values = CourseEnum.values();
        for (CourseEnum value : values) {
            if (value.getCategory() == category){
                return value;
            }
        }
        return null;
    }
}
