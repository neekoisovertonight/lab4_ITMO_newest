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

    public void checkCarriers(Human carrier1, Human carrier2, Human carrier3) {
        if (carrier1.areAdjacentTo(this) && carrier2.areAdjacentTo(this) && carrier3.areAdjacentTo(this)) {
            System.out.println("Все носильщики подошли к Джуду.");
        } else {
            System.out.println("Кто-то из носильщиков не подошел к Джуду.");
            updateCarriersLocations(carrier1, carrier2, carrier3);
            checkCarriers(carrier1, carrier2, carrier3);
        }
    }

    private void updateCarriersLocations(Human carrier1, Human carrier2, Human carrier3) {
        Random random = new Random();
        int randomShift = random.nextInt(3) + 1;
        int judahX = (int) getLocation().getX();
        int judahY = (int) getLocation().getY();

        carrier1.getLocation().setLocation(judahX, carrier1.getLocation().getY() + randomShift);
        carrier2.getLocation().setLocation(judahX, carrier2.getLocation().getY() + randomShift);
        carrier3.getLocation().setLocation(judahX, carrier3.getLocation().getY() + randomShift);


        System.out.println("Носильщики переставлены. Новые координаты:");
        System.out.println(carrier1.getName() + ": " + carrier1.getLocation());
        System.out.println(carrier2.getName() + ": " + carrier2.getLocation());
        System.out.println(carrier3.getName() + ": " + carrier3.getLocation());
    }
}
