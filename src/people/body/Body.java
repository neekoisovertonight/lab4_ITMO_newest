package people.body;

import enums.Gender;
import people.clothing.*;

public class Body {
    private double temperature;
    private Gender gender;

    public Body(double initialTemperature, Gender gender) {
        this.temperature = initialTemperature;
        this.gender = gender;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double newTemperature) {
        this.temperature = newTemperature;
        System.out.println("Температура: " + temperature);
    }
    public void increaseTemperatureByGender() {
        if (gender == Gender.FEMALE) {
            temperature += 0.5;
            System.out.println("Температура тела женщины повышается. Новая температура: " + temperature);
        } else { temperature += 0.3;
            System.out.println("Температура тела мужчины повышается. Новая температура: " + temperature);
        }
    }
    public void minusTemperatureByGender() {
        if (gender == Gender.FEMALE) {
            temperature -= 0.5;
            System.out.println("Температура тела женщины понижается. Новая температура: " + temperature);
        } else { temperature -= 0.3;
            System.out.println("Температура тела мужчины понижается. Новая температура: " + temperature);
        }
    }
    public void wearClothing(Clothing clothing) {
        System.out.println("Надевает " + clothing.getType() + ". Температура: " + temperature);
        increaseTemperatureByGender();
    }

    @Override
    public String toString() {
        return "Body{temperature=" + temperature + ", gender=" + gender + '}';
    }
}

