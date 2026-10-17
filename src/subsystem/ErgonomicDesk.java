package subsystem;

public class ErgonomicDesk {
    public void unlockMotor() {
        System.out.println("Ergonomic Desk: Motor unlocked");
    }

    public void adjustHeight(int heightCm) {
        System.out.println("Ergonomic Desk: Adjusting height to " + heightCm + " cm");
    }

    public void lockMotor() {
        System.out.println("Ergonomic Desk: Motor locked in standing position");
    }
}