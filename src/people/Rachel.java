package people;

import enums.BodySide;
import enums.Gender;
import people.body.Body;
import people.body.RachelBody;
import people.body.arm.Arm;
import people.body.arm.Hand;
import people.body.arm.Shoulder;
import people.body.head.Head;
import people.body.head.RachelHead;

import java.awt.*;

public class Rachel extends Human{
    public Rachel() {
        super(new RachelHead(), new Arm(new Hand(BodySide.LEFT)), new Arm(new Hand(BodySide.RIGHT)), new Shoulder(), new Shoulder(), new RachelBody(), Gender.FEMALE, "Рачел", 50, new Point(1, 2));
        displayCreationInfo();
    }
}
