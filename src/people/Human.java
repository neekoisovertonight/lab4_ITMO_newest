package people;

import actions.Tearable;
import enums.Gender;
import objects.Bed;
import objects.Bench;
import objects.LocationObject;
import people.body.*;
import people.body.arm.Arm;
import people.body.arm.Shoulder;
import people.body.head.Head;

import java.awt.*;


public abstract class Human {
    private ShiveringEffect shiveringEffect;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected boolean isCrying;

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    protected boolean isDead;
    protected String name;
    protected Head head;
    protected Arm leftArm;
    protected Arm rightArm;
    protected Shoulder leftShoulder;
    protected Shoulder rightShoulder;
    protected Body body;
    protected Gender gender;
    protected int speed;

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    private int mood;
    protected Point location;

    public Human(Head head, Arm leftArm, Arm rightArm, Shoulder leftShoulder, Shoulder rightShoulder, Body body, Gender gender, String name, int speed, Point location) {
        this.head = head;
        this.leftArm = leftArm;
        this.rightArm = rightArm;
        this.leftShoulder = leftShoulder;
        this.rightShoulder = rightShoulder;
        this.body = body;
        this.gender = gender;
        this.name = name;
        this.speed = speed;
        this.location = location;
        this.mood = 0;
        this.shiveringEffect = new ShiveringEffect();
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }


    public Head getHead() {
        return head;
    }

    public Arm getLeftArm() {
        return leftArm;
    }

    public Arm getRightArm() {
        return rightArm;
    }

    public Shoulder getLeftShoulder() {
        return leftShoulder;
    }

    public Shoulder getRightShoulder() {
        return rightShoulder;
    }

    public Body getBody() {
        return body;
    }

    public Gender getGender() {
        return gender;
    }

    public void improveMood(int amount) {
        mood += amount;
        System.out.println(name + " чувствует себя лучше на " + amount + ". Самочувствие: " + mood);
    }

    public void worsenMood(int amount) {
        mood -= amount;
        System.out.println(name + " чувствует себя хуже на " + amount + ". Самочувствие: " + mood);
    }

    public void think(String thought) {
        printWithSpeed(name + " думает: " + thought);
    }

    public void speak(String message) {
        printWithSpeed(name + " говорит: " + message);
    }

    public void whisper(String whisper) {
        printWithSpeed(name + " шепчет: " + whisper);
    }

    private void printWithSpeed(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public void displayCreationInfo() {
        System.out.println("Человек " + name + " создан.");
    }

    public void interactWith(LocationObject object) {
        if (object instanceof Bed) {
            lieOnBed((Bed) object);
        } else if (object instanceof Bench) {
            sitOnBench((Bench) object);
        } else {
            System.out.println(name + " взаимодействует с " + object.getName());
        }
    }

    private void lieOnBed(Bed bed) {
        try {
            bed.addOccupant(this);
            setLocation(bed.getLocation());
            System.out.println(name + " ложится на кровать, координаты: " + bed.getLocation());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void sitOnBench(Bench bench) {
        try {
            bench.addOccupant(this);
            setLocation(bench.getLocation());
            System.out.println(name + " садится на скамью, координаты: " + bench.getLocation());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void holdHands(Human otherPerson) {
        if (!leftArm.isOccupied() && !otherPerson.leftArm.isOccupied()) {
            leftArm.holdHands();
            otherPerson.leftArm.holdHands();
            System.out.println(name + " держит за руку " + otherPerson.getName());
            otherPerson.improveMood(5);
        } else if (!rightArm.isOccupied() && !otherPerson.rightArm.isOccupied()) {
            rightArm.holdHands();
            otherPerson.rightArm.holdHands();
            System.out.println(name + " держит за руку " + otherPerson.getName());
            otherPerson.improveMood(5);
        } else {
            System.out.println("Все руки заняты.");
        }
    }

    public void releaseHands(Human otherPerson) {
        leftArm.releaseHands();
        otherPerson.leftArm.releaseHands();
        rightArm.releaseHands();
        otherPerson.rightArm.releaseHands();
        System.out.println(name + " отпускает руку " + otherPerson.getName());
    }

    public void shakeHand() {
        if (!leftArm.isOccupied()) {
            leftArm.shakeHands();
            mood--;
            System.out.println(name + " трясет рукой. Самочувствие: " + mood);
        } else {
            System.out.println("Рука занята.");
        }
    }

    public void cry() {
        class Tear implements Tearable {
            @Override
            public void shedTear() {
                System.out.print("Слеза катится по щеке. ");
            }
        }
        Tear tear = new Tear();
        tear.shedTear();
        worsenMood(10);
    }

    public void stareAtCeiling() {
        head.tilt(90);
        System.out.println(name + " смотрит в потолок.");
        think("Что делать?");
        speak("Если тебе кажется, что так нужно, можешь ее взять.");
    }

    public void hug(Human other) {
        other.shiveringEffect.addShivering();
        mood += 5;
        other.mood += 10;
        System.out.println(name + " обнимает " + other.name +
                ". Самочувствие улучшено: " + name + " (" + mood + "), " + other.name + " (" + other.mood + ")");
        body.increaseTemperatureByGender();
        other.body.increaseTemperatureByGender();
        other.shiveringEffect.removeShivering();
    }

    private class ShiveringEffect {
        private boolean isShivering;

        public void addShivering() {
            isShivering = true;
            System.out.println(name + " начинает дрожать.");
        }

        public void removeShivering() {
            if (isShivering) {
                isShivering = false;
                System.out.println(name + " прекращает дрожать.");
            }
        }
    }
    public void sleep() {
        mood = 0;
        System.out.println(name + " спит. Самочувствие обнулено.");
    }

    public void lookFromTheSide(Human human){
        System.out.println(name + " смотрит на " + human.getName() + ". Направление: " + human.getLocation());
        think("Передо мной классический пример ребенка, переживающего важный переходный этап своей жизни и еще не понимающего, что происходит с ним");
        human.transitionLive();
    }

    private void transitionLive(){
        System.out.println(name + " переживает важный переходный этап своей жизни и не понимает что происходит с ней.");
        worsenMood(5);
        body.minusTemperatureByGender();
        shiveringEffect.addShivering();
    }
    public void tilt(int degrees, Human human) {
        System.out.println(name + " наклонился на " + degrees + " градусов.");
        kiss(human);
    }

    public void kiss(Human otherPerson) {
        if (areAdjacent(this, otherPerson)) {
            System.out.println(name + " поцеловал " + otherPerson.getName());
        } else {
            System.out.println("Чтобы поцеловать, они должны стоять на соседних точках.");
        }
    }

    private boolean areAdjacent(Human person1, Human person2) {
        return Math.abs(person1.getLocation().getY() - person2.getLocation().getY()) == 1;
    }

    public void lookAt(Human human){
        System.out.println(name + " смотрит на " + human.getName() + ". Направление: " + human.getLocation());
        think("Я должна сохранять спокойствие.");
        mood = 0;
        System.out.println("Самочувствие обнулено.");
    }
}
