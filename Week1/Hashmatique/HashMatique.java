import java.util.HashMap;

public class HashMatique {
    public void songMap(){
        HashMap<String, String> trackList=new HashMap<String,String>();
        trackList.put("Gota en el Mar", "Trato encontrarme y voy perdiendo la fe");
        trackList.put("Skeletons", "Naked side by side we lie");
        trackList.put("Despiertate", "Se van las horas como arena");
        trackList.put("Lejos", "It seems like all you do is change");

        //Getting opening lyrics by song title:
        System.out.println(trackList.get("Lejos"));

        //Printing entire tracklist: 
        System.out.println(trackList);

        //Printing out as a sentence, using a "for each" loop. 
        for (String key : trackList.keySet()){
            System.out.printf("The opening line to the song %s is: %s\n", key, trackList.get(key));
        }
    }
}
