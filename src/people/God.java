package people;

import java.util.Objects;

public class God {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String name;

    public God(String name){
        this.name = name;
        System.out.println("Бог создан.");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof God god)) return false;
        return Objects.equals(getName(), god.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "God{" +
                "name='" + name + '\'' +
                "} ";
    }
}
