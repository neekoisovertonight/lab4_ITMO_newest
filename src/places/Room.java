package places;

import exceptions.InvalidLocationException;

public class Room extends Place {

    public Room(int width, int height, String name) throws InvalidLocationException {
        super(width, height, name);
        displayCreationInfo(name);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + getName() + '\'' +
                ", " + super.toString() +
                '}';
    }
}
