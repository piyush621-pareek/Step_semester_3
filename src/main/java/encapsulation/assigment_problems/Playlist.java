
import java.util.Arrays;

public class Playlist {

    private final String[] songs;
    private int count;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String title) {
        if (count < songs.length) {
            songs[count] = title;
            count++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Songs: " + Arrays.toString(copy));  // [Song A, Song B]

        copy[0] = "Hacked";
        System.out.println("After tampering, playlist still: " + Arrays.toString(p.getSongs()));
        System.out.println("Count = " + p.getSongCount());       // 2
    }
}
