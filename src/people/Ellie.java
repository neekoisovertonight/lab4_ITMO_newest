package people;

import enums.BodySide;
import enums.Gender;
import people.body.Body;
import people.body.EllieBody;
import people.body.arm.Arm;
import people.body.arm.Hand;
import people.body.arm.Shoulder;
import people.body.head.EllieHead;
import people.body.head.Head;

import java.awt.*;

public class Ellie extends Human {
    public Ellie() {
        super(new EllieHead(), new Arm(new Hand(BodySide.LEFT)), new Arm(new Hand(BodySide.RIGHT)), new Shoulder(), new Shoulder(), new EllieBody(), Gender.FEMALE, "Элли", 30, new Point(0, 0));
        displayCreationInfo();
    }
}
