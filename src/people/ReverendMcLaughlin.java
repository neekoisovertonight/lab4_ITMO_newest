package people;

import enums.BodySide;
import enums.Gender;
import people.body.Body;
import people.body.LouisBody;
import people.body.arm.Arm;
import people.body.arm.Hand;
import people.body.arm.Shoulder;
import people.body.head.Head;
import people.body.head.ReverendHead;

import java.awt.*;

public class ReverendMcLaughlin extends Human {
    public ReverendMcLaughlin() {
        super(new ReverendHead(), new Arm(new Hand(BodySide.LEFT)), new Arm(new Hand(BodySide.RIGHT)), new Shoulder(), new Shoulder(), new LouisBody(), Gender.MALE, "Преподобный Лафлин", 45, new Point(4, 5));
        isBeliever = true;
        displayCreationInfo();
    }
}

