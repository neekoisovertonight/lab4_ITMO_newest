package people.body.arm;

import enums.BodySide;

public class Arm {
    private Hand hand;
    private BodySide side;
    private boolean isOccupied;
    private boolean isShaking;

    public Arm(Hand hand) {
        this.hand = hand;
        this.side = side;
        this.isOccupied = false;
        this.isShaking = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void holdHands() {
        isOccupied = true;
    }

    public void releaseHands() {
        isOccupied = false;
    }
    public void shakeHands() {
        isShaking = true;
        System.out.println("Рука трясется.");
    }

}
