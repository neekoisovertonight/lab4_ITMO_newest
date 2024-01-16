package objects;

import places.Place;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class LocationObject {
    private String name;
    private Point location;

    public LocationObject(String name, Point location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public abstract void occupySpace();

    public abstract void freeSpace();
    public abstract void occupySpace(Place location);

    public abstract void freeSpace(Place location);

}
