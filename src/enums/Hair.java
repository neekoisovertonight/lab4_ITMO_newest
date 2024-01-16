package enums;

public enum Hair {
    BROWN("каштановые"),
    BLONDE("светлые"),
    BLACK("черные"),
    RED("рыжие");
    private String name;

    Hair(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
