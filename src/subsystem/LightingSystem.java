package subsystem;

public class LightingSystem {
    public void turnOffMainLight() {
        System.out.println("Lighting: Main ceiling light turned OFF.");
    }

    public void turnOnMainLight() {
        System.out.println("Lighting: Main ceiling light turned ON.");
    }

    public void enableAmbientLight(String colorTemp, int brightness) {
        System.out.println("Lighting: Soft ambient light enabled (" + colorTemp + ", brightness: " + brightness + "%).");
    }

    public void disableAmbientLight() {
        System.out.println("Lighting: Soft ambient light disabled.");
    }
}