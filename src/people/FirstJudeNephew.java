package people;

import enums.BodySide;
import enums.Gender;
import people.body.Body;
import people.body.JudeBody;
import people.body.arm.Arm;
import people.body.arm.Hand;
import people.body.arm.Shoulder;
import people.body.head.Head;
import people.body.head.JudeNephewHead;

import java.awt.*;

public class FirstJudeNephew extends Human {
    public FirstJudeNephew() {
        super(new JudeNephewHead(), new Arm(new Hand(BodySide.LEFT)), new Arm(new Hand(BodySide.RIGHT)), new Shoulder(), new Shoulder(), new JudeBody(), Gender.MALE, "Первый племянник Джуда", 30, new Point(2, 3));
        displayCreationInfo();
    }
}
