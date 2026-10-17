package subsystem;

public class SpotifyPlayer {
    public void connect() {
        System.out.println("Spotify: Connecting to audio system...");
    }

    public void selectPlaylist(String playlistName) {
        System.out.println("Spotify: Selected playlist \"" + playlistName + "\".");
    }

    public void setVolume(int level) {
        System.out.println("Spotify: Volume set to " + level + "%.");
    }

    public void play() {
        System.out.println("Spotify: Playing jazz focus session.");
    }

    public void pause() {
        System.out.println("Spotify: Music paused.");
    }

    public void disconnect() {
        System.out.println("Spotify: Session disconnected.");
    }
}