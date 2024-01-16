package enums;

public enum Gender {
    FEMALE("женщина"),
    MALE("мужчина");
    private String name;

    Gender(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
