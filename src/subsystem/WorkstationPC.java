package subsystem;

public class WorkstationPC {
    public void powerOn() {
        System.out.println("Workstation PC: Powering on, initializing OS");
    }

    public void loadWorkspaceProfile(String profileName) {
        System.out.println("Workstation PC: Loading profile \"" + profileName + "\" IDEs and tools are active");
    }

    public void sleep() {
        System.out.println("Workstation PC: Entering sleep mode");
    }
}