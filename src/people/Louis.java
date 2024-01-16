package people;

import enums.BodySide;
import enums.Gender;
import people.body.*;
import people.body.arm.Arm;
import people.body.arm.Hand;
import people.body.arm.Shoulder;
import people.body.head.LouisHead;

import java.awt.*;

public class Louis extends Human{
    public Louis() {
        super(new LouisHead(), new Arm(new Hand(BodySide.LEFT)), new Arm(new Hand(BodySide.RIGHT)), new Shoulder(), new Shoulder(), new LouisBody(), Gender.MALE, "Луис", 40, new Point(1, 1));
        displayCreationInfo();
    }
}
