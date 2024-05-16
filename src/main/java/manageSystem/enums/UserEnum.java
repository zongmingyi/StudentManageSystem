package manageSystem.enums;

import lombok.AllArgsConstructor;



@AllArgsConstructor
public enum UserEnum {

    TEACHER("教师", 0),
    STUDENT("学生", 1),
    ;

    private final String role;

    private final int category;

    public String getRole() {
        return role;
    }

    public int getCategory() {
        return category;
    }

    public static UserEnum getRole(int category){
        UserEnum[] values = UserEnum.values();
        for (UserEnum value : values) {
            if(value.getCategory() == category){
                return value;
            }
        }

        return null;
    }

}
