package objects;

import people.Human;
import places.Place;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Bed extends LocationObject {
    private List<Human> occupants;

    public Bed(String name, Point location) {
        super(name, location);
        occupants = new ArrayList<>();
    }

    public void addOccupant(Human person) throws Exception {
        if (occupants.size() < 2) {
            occupants.add(person);
        } else {
            throw new Exception("На кровати могут находиться только 2 человека.");
        }
    }

    @Override
    public void occupySpace() {
        System.out.println("Кровать занята.");
    }

    @Override
    public void freeSpace() {
        System.out.println("Кровать свободна.");
        occupants.clear();
    }

    @Override
    public void occupySpace(Place location) {
        location.addObject(this);
        System.out.println("Кровать создана в " + location.getName() + ".");
    }

    @Override
    public void freeSpace(Place location) {
        location.removeObject(this);
        System.out.println("Кровать в " + location.getName() + " очищена.");
        occupants.clear();
    }
}

