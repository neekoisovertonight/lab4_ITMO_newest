package people.body.head;

import enums.*;


public class Head {

    public Hair getHairColor() {
        return hairColor;
    }

    public void setHairColor(Hair hairColor) {
        this.hairColor = hairColor;
    }

    private Hair hairColor;

    public void setEyeColor(Eyes eyeColor) {
        this.eyeColor = eyeColor;
    }

    private Eyes eyeColor;

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    private double angle;

    public Head(Hair hairColor, Eyes eyeColor) {
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.angle = 0.0;
    }

    public void tilt(int degrees) {
        if (degrees > 90.0 || degrees < -90.0) {
            throw new IllegalArgumentException("Нельзя наклонить голову на такой градус.");
        }

        this.angle = degrees;
        System.out.println("Наклоняет голову на  " + degrees + " градусов.");

        if (shouldNeckCrack()) {
            System.out.println("Хрустит шея!");
        }
    }

    private boolean shouldNeckCrack() {
        return Math.abs(angle) > 80.0;
    }
}

