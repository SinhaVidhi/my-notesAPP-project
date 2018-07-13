package index1.developer.vidhi.com.mynotesapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.*;
import java.util.ArrayList;



public class Utilities {

    public static final String EXTRAS_NOTE_FILENAME = "EXTRAS_NOTE_FILENAME";
    public static final String FILE_EXTENSION = ".bin";

    public static boolean saveNote(Context context, Note note) {
        String filename = String.valueOf(note.getDt()) + FILE_EXTENSION;

        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = context.openFileOutput(filename, context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(note);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Note> getAllSavedNotes(Context context) {
        ArrayList<Note> notes = new ArrayList<>();

        File filesDir = context.getFilesDir();
        ArrayList<String> noteFiles = new ArrayList<>();

        for (String file : filesDir.list()) {
            if (file.endsWith(FILE_EXTENSION)) {
                noteFiles.add(file);
            }
        }

        FileInputStream f1;
        ObjectInputStream o1;

        for (int i = 0; i < noteFiles.size(); i++) {
            try {
                f1 = context.openFileInput(noteFiles.get(i));
                o1 = new ObjectInputStream(f1);

                notes.add((Note) o1.readObject());
                f1.close();
                o1.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return notes;
    }
public void display(){
  //  Toast.makeText(getActivity(),"Show",Toast.LENGTH_SHORT).show();


}
    public static Note getNoteByFileName(Context context, String fileName) {

        File file = new File(context.getFilesDir(), fileName);
        if (file.exists() && !file.isDirectory()) { //check if file actually exist

            Log.v("UTILITIES", "File exist = " + fileName);

            FileInputStream f1;
            ObjectInputStream o1;

            try { 
                f1 = context.openFileInput(fileName);
                o1 = new ObjectInputStream(f1);
                Note note = (Note) o1.readObject();
                f1.close();
                o1.close();

                return note;

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }

        } else {
            return null;
        }

    }
public void onStartMethod(){



}
    public static void deleteNote(Context context, String filename) {
        File dir = context.getFilesDir();
        File f = new File(dir, filename);

        if(f.exists())
        {
            f.delete();
        }

    }
}
