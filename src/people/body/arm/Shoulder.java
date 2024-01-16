package people.body.arm;


import people.body.arm.Arm;

public class Shoulder {
    private Arm arm;


    public void placeArm(Arm arm) {
        if (this.arm == null) {
            this.arm = arm;
            System.out.println("Placed arm on the shoulder.");
        } else {
            System.out.println("Shoulder is already occupied.");
        }
    }

    public Arm takeArm() {
        Arm takenArm = this.arm;
        this.arm = null;
        System.out.println("Took arm from the shoulder.");
        return takenArm;
    }
}

