package objects;

import exceptions.DeadPersonException;
import people.Human;
import places.Place;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Coffin extends LocationObject {
    private Human occupant;

    public Coffin(String name, Point location) {
        super(name, location);
        occupant = null;
    }

    public void setOccupant(Human person) {
        if (person.isDead()) {
            occupant = person;
            System.out.println("В гробу находится тело " + person.getName());
        } else {
            throw new DeadPersonException("Живой человек не может находиться в гробу.");
        }
    }

    @Override
    public void occupySpace() {
        System.out.println("Гроб теперь занят.");
    }

    @Override
    public void freeSpace() {
        System.out.println("Гроб свободен.");
        occupant = null;
    }

    @Override
    public void occupySpace(Place location) {
        location.addObject(this);
        System.out.println("Гроб создан в " + location.getName() + ".");
    }

    @Override
    public void freeSpace(Place location) {
        location.removeObject(this);
        System.out.println("Гроб очищен в " + location.getName() + ".");
        occupant = null;
    }
}
