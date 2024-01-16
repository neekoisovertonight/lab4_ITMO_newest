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

public class SecondJudeNephew extends Human{
    public SecondJudeNephew() {
        super(new JudeNephewHead(), new Arm(new Hand(BodySide.LEFT)), new Arm(new Hand(BodySide.RIGHT)), new Shoulder(), new Shoulder(), new JudeBody(), Gender.MALE, "Второй племянник Джуда", 30, new Point(3, 2));
        displayCreationInfo();
    }
}
