package cvdb.api.domain;


public enum Grade {

    NONE("No experience","No experience at all"),
    BEGINNER("Beginner","Have some theoretical knowledge but no or little practical experience"),
    PROFICIENT("Proficient","Can comfortable apply the tool in practical and real life problems"),
    EXPERIENCED("Experienced","At least three years of pratical and real life experience"),
    AUTHORITY("Authority","Very experienced. Can teach others");

    private final String description;
    private final String name;

    Grade(String name, String description) {
        this.description = description;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }


    public static Grade valueOfName(String gradeName) {
        for (Grade e : values()) {
            if (e.name.equals(gradeName)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Invalid grade name: " + gradeName);
    }
}
