package places;

import exceptions.InvalidLocationException;

public class Church extends Place {

    public Church(int width, int height, String name) throws InvalidLocationException {
        super(width, height, name);
        displayCreationInfo(name);
    }

    @Override
    public String toString() {
        return "Church{" +
                "name='" + getName() + '\'' +
                ", " + super.toString() +
                '}';
    }
}
