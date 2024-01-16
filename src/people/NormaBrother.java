package people;

import enums.BodySide;
import enums.Gender;
import people.body.Body;
import people.body.LouisBody;
import people.body.arm.Arm;
import people.body.arm.Hand;
import people.body.arm.Shoulder;
import people.body.head.Head;
import people.body.head.NormaBrotherHead;

import java.awt.*;

public class NormaBrother extends Human{
    public NormaBrother() {
        super(new NormaBrotherHead(), new Arm(new Hand(BodySide.LEFT)), new Arm(new Hand(BodySide.RIGHT)), new Shoulder(), new Shoulder(), new LouisBody(), Gender.MALE, "Брат Нормы", 50, new Point(5, 5));
    }
}
