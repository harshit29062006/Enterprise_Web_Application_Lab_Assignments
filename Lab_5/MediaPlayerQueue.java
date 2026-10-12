import java.util.*;

class Song{
    int id;
    String title;

    public Song(int id, String title){
        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Song)) return false;
        Song song = (Song) o;
        return id == song.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return title + " (ID: " + id + ")";
    }
}

public class MediaPlayerQueue{
    private LinkedList<Song> playlist = new LinkedList<>();

    public void addSong(Song song){
        playlist.addLast(song);
    }

    public void playNext(Song song){
        playlist.addFirst(song);
    }

    public void insertAt(int index, Song song){
        if (index >= 0 && index <= playlist.size()){
            playlist.add(index, song);
        }
    }

    public void removeDuplicates(){
        HashSet<Song> seen = new HashSet<>();
        Iterator<Song> it = playlist.iterator();
        while(it.hasNext()) {
            Song song = it.next();
            if(seen.contains(song)){
                it.remove();
            } 
            else{
                seen.add(song);
            }
        }
    }

    public void printQueue(){
        System.out.println("Current Queue: " + playlist);
    }

    public static void main(String[] args){
        MediaPlayerQueue player = new MediaPlayerQueue();

        Song s1 = new Song(1, "Blinding Lights");
        Song s2 = new Song(2, "Shape of You");
        Song s3 = new Song(3, "Levitating");

        player.addSong(s1);
        player.addSong(s2);
        player.addSong(s1); 

        player.playNext(s3);

        System.out.println("Before removing duplicates:");
        player.printQueue();

        player.removeDuplicates();

        System.out.println("\nAfter removing duplicates:");
        player.printQueue();

        System.out.println("\n--- Forward Traversal ---");
        ListIterator<Song> iterator = player.playlist.listIterator();
        while(iterator.hasNext()){
            System.out.println("Playing forward: " + iterator.next());
        }

        System.out.println("\n--- Backward Traversal ---");
        while(iterator.hasPrevious()){
            System.out.println("Playing backward: " + iterator.previous());
        }
    }
}