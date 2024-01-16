package people;

import enums.BodySide;
import enums.Gender;
import people.body.Body;
import people.body.JudeBody;
import people.body.arm.Arm;
import people.body.arm.Hand;
import people.body.arm.Shoulder;
import people.body.head.Head;
import people.body.head.JudeHead;

import java.awt.*;
import java.util.Random;


public class Jude extends Human {
    public Jude() {
        super(new JudeHead(), new Arm(new Hand(BodySide.LEFT)), new Arm(new Hand(BodySide.RIGHT)), new Shoulder(), new Shoulder(), new JudeBody(), Gender.MALE, "Джуд", 40, new Point(4, 5));
        displayCreationInfo();
    }

}
