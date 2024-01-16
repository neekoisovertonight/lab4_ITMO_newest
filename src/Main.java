import enums.Hair;
import exceptions.InvalidLocationException;
import objects.*;
import people.*;
import people.clothing.BlackSuit;
import people.clothing.BlueDress;
import people.clothing.Clothing;
import places.Church;
import places.Room;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Room room = new Room(5, 4, "Комната");
        Bed bed = new Bed("Кровать", new Point(3, 2));
        Louis louis = new Louis();
        room.addPerson(louis);
        Rachel rachel = new Rachel();
        room.addPerson(rachel);
        louis.interactWith(bed);
        rachel.interactWith(bed);
        rachel.speak("И не обижайся, если я заболею, когда будут хоронить Норму.");
        louis.speak("Нет, дорогая, не обижусь");
        louis.holdHands(rachel);
        louis.speak("А можно мне взять Элли?");
        rachel.shakeHand();
        rachel.speak("О, Луис, я даже не знаю. Она еще маленькая...");
        louis.speak("Но она уже год знает, откуда берутся дети");
        rachel.stareAtCeiling();
        louis.speak("Давай спать.");
        louis.releaseHands(rachel);
        louis.sleep();
        rachel.sleep();
        louis.hug(rachel);
        room.clearLocation();
        System.out.println();
        Church church = new Church(10, 10, "Церковь");
        Bench bench = new Bench("Скамья", new Point(4, 4));
        bench.occupySpace(church);
        Coffin coffin = new Coffin("Гроб", new Point(5, 10));
        coffin.occupySpace(church);
        Norma norma = new Norma();
        coffin.setOccupant(norma);
        Ellie ellie = new Ellie();
        ellie.interactWith(bench);
        BlueDress blueDress = new BlueDress();
        ellie.getBody().wearClothing(blueDress);
        ellie.getHead().tilt(-90);
        louis.interactWith(bench);
        louis.lookFromTheSide(ellie);
        Jude jude = new Jude();
        BlackSuit blackSuit = new BlackSuit();
        jude.getBody().wearClothing(blackSuit);
        jude.tilt(60, ellie);
        jude.speak("Молодец, что пришла, малышка. Думаю, Норма тоже рада.");
        ellie.lookAt(jude);
        God god = new God("Бог");
        ReverendMcLaughlin reverendMcLaughlin = new ReverendMcLaughlin();
        reverendMcLaughlin.prayWithFaith(god, norma);
        class Hairdresser {
            public void newHairColor(Human person, Hair hair) {
                person.newHairColor(hair);
            }
        }
        (new Hairdresser()).newHairColor(norma, Hair.BLONDE);
        reverendMcLaughlin.speak("Готовы ли носильщики?");
        louis.standUp(ellie);
        ellie.whisper("Папа! Ты куда?");
        louis.whisper("Я один из носильщиков, дорогая");
        ellie.releaseHands(louis);
        louis.sitDown(ellie);
        louis.speak("Мы должны вынести Норму. Вчетвером — я, двое племянников Джуда и брат Нормы.");
        ellie.speak("А как я тебя найду?");
        louis.lookAt(jude);
        NormaBrother normaBrother = new NormaBrother();
        FirstJudeNephew firstJudeNephew = new FirstJudeNephew();
        SecondJudeNephew secondJudeNephew = new SecondJudeNephew();
        jude.checkCarriers(normaBrother, firstJudeNephew, secondJudeNephew);
        louis.speak("Сойдешь со ступенек, и я буду там.");
        ellie.speak("Ну хорошо. Только не потеряйся.");
        louis.speak("Нет-нет.");
        ellie.getLeftShoulder().takeArm();
        louis.standUp(ellie);
        ellie.speak("Папа?");
        louis.speak("Что, малышка?");
        ellie.whisper("Смотри не урони ее.");
        church.clearLocation();
    }
}