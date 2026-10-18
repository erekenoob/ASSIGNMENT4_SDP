import subsystem.*;
import facade.SmartWorkspaceFacade;

public class Main {
    public static void main(String[] args) {
        SmartCurtains curtains = new SmartCurtains();
        LightingSystem lighting = new LightingSystem();
        SpotifyPlayer spotify = new SpotifyPlayer();
        ErgonomicDesk desk = new ErgonomicDesk();
        WorkstationPC pc = new WorkstationPC();
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        SmartWorkspaceFacade workspace = new SmartWorkspaceFacade(
                curtains, lighting, spotify, desk, pc, coffeeMachine
        );

        workspace.startWorkSession();
        workspace.endWorkSession();
    }
}