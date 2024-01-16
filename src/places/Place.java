package places;

import exceptions.InvalidLocationException;
import objects.*;
import people.Human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.awt.*;


public abstract class Place {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int height;
    private List<LocationObject> objects;

    public boolean[][] getOccupied() {
        return occupied;
    }

    public void setOccupied(boolean[][] occupied) {
        this.occupied = occupied;
    }

    private boolean[][] occupied;
    private List<Human> people;

    public Place(int width, int height, String name) throws InvalidLocationException {
        if (width <= 0 || height <= 0) {
            throw new InvalidLocationException("Ширина и длина локации должны быть положительными числами.");
        }

        if (width > 50 || height > 50) {
            throw new InvalidLocationException("Ширина и длина локации не должны превышать 50.");
        }
        this.width = width;
        this.height = height;
        this.name = name;
        this.occupied = new boolean[width][height];
        this.people = new ArrayList<>();
        this.objects = new ArrayList<>();
    }

    public void addPerson(Human person) {
        if (isPointFree(person.getLocation())) {
            people.add(person);
            occupyPoint(person.getLocation());
            System.out.println(person.getName() + " добавлен в " + name);
        } else {
            System.out.println("Точка с координатами " + person.getLocation() + " уже занята.");
        }
    }

    public void removePerson(Human person) {
        people.remove(person);
        freePoint(person.getLocation());
        System.out.println(person + " убран из текущей локации.");
    }


    private boolean isPointFree(Point point) {
        int x = (int) point.getX();
        int y = (int) point.getY();
        return x >= 0 && x < width && y >= 0 && y < height && !occupied[x][y];
    }

    private void occupyPoint(Point point) {
        int x = (int) point.getX();
        int y = (int) point.getY();
        if (x >= 0 && x < width && y >= 0 && y < height) {
            occupied[x][y] = true;
        }
    }

    private void freePoint(Point point) {
        int x = (int) point.getX();
        int y = (int) point.getY();
        if (x >= 0 && x < width && y >= 0 && y < height) {
            occupied[x][y] = false;
        }
    }

    public void displayCreationInfo(String locationName) {
        System.out.println("Локация " + locationName + " создана.");
    }

    public void addObject(LocationObject object) {
        objects.add(object);
    }

    public void removeObject(LocationObject object) {
        objects.remove(object);
    }

    public List<LocationObject> getObjects() {
        return objects;
    }

    public void clearLocation() {
        this.width = 0;
        this.height = 0;
        this.occupied = null;

        System.out.println("Локация очищена.");
    }

    @Override
    public String toString() {
        return name +
                "width=" + width +
                ", height=" + height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place location = (Place) o;
        return width == location.width &&
                height == location.height;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(width, height);
        result = 31 * result + Arrays.deepHashCode(occupied);
        return result;
    }
}

