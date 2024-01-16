package people.body.arm;


import people.body.arm.Arm;

public class Shoulder {
    private Arm arm;


    public void placeArm(Arm arm) {
        if (this.arm == null) {
            this.arm = arm;
            System.out.println("Рука на плече.");
        } else {
            System.out.println("Плечо уже занято.");
        }
    }

    public Arm takeArm() {
        Arm takenArm = this.arm;
        this.arm = null;
        System.out.println("Рука убрана с плеча.");
        return takenArm;
    }
}

