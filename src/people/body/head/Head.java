package people.body.head;

import actions.Tearable;
import enums.*;
import people.Human;


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
    private final Mouth mouth;
    private final Eye eyes;
    private final Cheeks cheeks;
    private final Brows brows;

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
        this.mouth = new Mouth();
        this.eyes = new Eye();
        this.cheeks = new Cheeks();
        this.brows = new Brows();
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

    class Mouth {

        private boolean isOpen;

        public void open() {
            isOpen = true;
        }

        public void close() {
            isOpen = false;
        }

    }
    class Eye {

        private boolean isOpen;

        public void open() {
            isOpen = true;
        }

        public void close() {
            isOpen = false;
        }
    }

    class Cheeks {
        private boolean blushed;

        public void blush() {
            blushed = true;
        }

        public void unblush() {
            blushed = false;
        }
    }

    class Brows {
        private boolean raised;

        public void raise() {
            raised = true;
        }

        public void lower() {
            raised = false;
        }
    }

