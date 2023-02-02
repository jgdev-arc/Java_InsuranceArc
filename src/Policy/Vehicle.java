package Policy;

import java.io.Serializable;

public class Vehicle implements Serializable {
    int plateNum;
    int modelYear;
    String manufacture;
    int estimatedValue;
    int carDamage;

    public Vehicle(int plateNum, int modelYear, String manufacture, int estimatedValue, int carDamage) {
        this.plateNum = plateNum;
        this.modelYear = modelYear;
        this.manufacture = manufacture;
        this.estimatedValue = estimatedValue;
        this.carDamage = carDamage;
    }

    public int getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(int plateNum) {
        this.plateNum = plateNum;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(int estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public int getCarDamage() {
        return carDamage;
    }

    public void setCarDamage(int carDamage) {
        this.carDamage = carDamage;
    }

    @Override
    public String toString() {
        return  "Plate Nb: " + plateNum +
                "\nModel Year: " + modelYear +
                "\nManufacture: " + manufacture +
                "\nEstimated Value: " + estimatedValue +
                "\nCar Damage Level: " + carDamage;
    }
}
