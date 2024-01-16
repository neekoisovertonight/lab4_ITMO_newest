package enums;

public enum Eyes {
    BLUE("голубые"),
    GREEN("зеленые"),
    BROWN("карие"),
    GRAY("серые");
    private String name;


    Eyes(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    }

