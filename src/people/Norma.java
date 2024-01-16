package people;

import enums.BodySide;
import enums.Gender;
import people.body.Body;
import people.body.NormaBody;
import people.body.arm.Arm;
import people.body.arm.Hand;
import people.body.arm.Shoulder;
import people.body.head.Head;
import people.body.head.NormaHead;

import java.awt.*;

public class Norma extends Human{
    public Norma() {
        super(new NormaHead(), new Arm(new Hand(BodySide.LEFT)), new Arm(new Hand(BodySide.RIGHT)), new Shoulder(), new Shoulder(), new NormaBody(), Gender.FEMALE, "Норма", 0, new Point(0, 0));
        isDead = true;
        displayCreationInfo();
    }
}
