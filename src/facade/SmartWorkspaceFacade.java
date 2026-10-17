package facade;

import subsystem.*;
import exception.SubsystemException;

public class SmartWorkspaceFacade {
    private final SmartCurtains curtains;
    private final LightingSystem lighting;
    private final SpotifyPlayer spotify;
    private final ErgonomicDesk desk;
    private final WorkstationPC pc;
    private final CoffeeMachine coffeeMachine;

    public SmartWorkspaceFacade(SmartCurtains curtains, LightingSystem lighting,
                                SpotifyPlayer spotify, ErgonomicDesk desk,
                                WorkstationPC pc, CoffeeMachine coffeeMachine) {
        this.curtains = curtains;
        this.lighting = lighting;
        this.spotify = spotify;
        this.desk = desk;
        this.pc = pc;
        this.coffeeMachine = coffeeMachine;
    }

    public void startWorkSession() {
        System.out.println("FACADE :     Activating Smart Workspace Routine");
        try {
            coffeeMachine.checkAndPrepare(300, 19);

            curtains.close();
            lighting.turnOffMainLight();
            lighting.enableAmbientLight("Warm Soft", 30);

            desk.unlockMotor();
            desk.adjustHeight(75);
            desk.lockMotor();

            pc.powerOn();
            pc.loadWorkspaceProfile("Development & Code");

            spotify.connect();
            spotify.selectPlaylist("Jazz Focus");
            spotify.setVolume(25);
            spotify.play();

            coffeeMachine.powerOn();
            coffeeMachine.brewBatch(300);

            System.out.println("FACADE :     Workspace is fully ready!\n");
        } catch (SubsystemException e) {
            System.err.println("SUBSYSTEM ERROR: " + e.getMessage() + "\n");
        }
    }


}