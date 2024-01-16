package objects;

import people.Human;
import places.Place;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Bench extends LocationObject {
    private List<Human> occupants;

    public Bench(String name, Point location) {
        super(name, location);
        occupants = new ArrayList<>();
    }

    public void addOccupant(Human person) throws Exception {
        if (occupants.size() < 6) {
            occupants.add(person);
        } else {
            throw new Exception("На скамье могут сидеть только 6 человек.");
        }
    }

    @Override
    public void occupySpace() {
        System.out.println("Скамья занята.");
    }

    @Override
    public void freeSpace() {
        System.out.println("Скамья свободна.");
        occupants.clear();
    }

    @Override
    public void occupySpace(Place location) {
        location.addObject(this);
        System.out.println("Скамья создана в " + location.getName() + ".");
    }

    @Override
    public void freeSpace(Place location) {
        location.removeObject(this);
        System.out.println("Скамья очищена в " + location.getName() + ".");
        occupants.clear();
    }
}
