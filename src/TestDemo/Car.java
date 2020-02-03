package TestDemo;

/**
 * @author Weichen Wang
 * @date 2019/10/25 - 9:21 AM
 * @description: ${description}
 *
 * 
 */
public class Car {

    private String registractionNumber;
    private String colour;
    private int seatsNumber;

    public Car() {
    }

    public Car(String registractionNumber, String colour, int seatsNumber) {
        this.registractionNumber = registractionNumber;
        this.colour = colour;
        this.seatsNumber = seatsNumber;
    }

    public String getRegistractionNumber() {
        return registractionNumber;
    }

    public void setRegistractionNumber(String registractionNumber) {
        this.registractionNumber = registractionNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registractionNumber='" + registractionNumber + '\'' +
                ", colour='" + colour + '\'' +
                ", seatsNumber=" + seatsNumber +
                '}';
    }
}
