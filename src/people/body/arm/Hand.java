package people.body.arm;

import enums.BodySide;
import people.body.head.Head;

public class Hand {
    private BodySide side;

    public Hand(BodySide side) {
        this.side = side;
    }

    public void pat(Head personToPat) {
        System.out.println("Patting " + personToPat + "'s head with " + side + " hand.");
    }

    public void holdHands(Head personToHold) {
        System.out.println("Holding hands with " + personToHold + " using " + side + " hand.");
    }

    public void jerk() {
        System.out.println(side + " hand jerks.");
    }

    public void hug(Head personToHug) {
        bothHandsAction(personToHug, "hugging");

    }

    public void grab(Head personToGrab) {
        bothHandsAction(personToGrab, "grabbing");
    }

    public void putOnShoulder(Head personToPutOnShoulder) {
        bothHandsAction(personToPutOnShoulder, "putting hand on shoulder of");
    }

    private void bothHandsAction(Head person, String action) {
        System.out.println(action + " " + person + " with both hands.");
    }
}
