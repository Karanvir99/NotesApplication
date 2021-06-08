package notes;

import java.io.IOException;
import java.util.ArrayList;

public class AllNotes extends CommonCode {

    private ArrayList<Note> allNotes = new ArrayList<>();
    private String crse = "";
    private int maxID = 0;

    AllNotes() {
        readAllNotes();
    }

    public final int getMaxID() {  
        maxID++;
        return maxID;
    }

    protected void readAllNotes() {
        ArrayList<String> readNotes = new ArrayList<>();

        readNotes = readTextFile(appDir + fileSeparator + "Notes.txt");
     
        System.out.println(readNotes.get(0));

        if (!"File not found".equals(readNotes.get(0))) {
            allNotes.clear();
            for (String str : readNotes) {
                String[] tmp = str.split("\t");
               if (tmp.length==1)
                {
                    continue; 
                }
                int nid = Integer.parseInt(tmp[0]);
                Note n = new Note(nid, tmp[1], tmp[2], tmp[3]);
               
                
                allNotes.add(n);

                if (nid > maxID) {
                    maxID = nid;
                }
            }
        }
        if (maxID != 0)
        {
            
            maxID++;
        
        }
    }                                                        
    
    public void addNote(int noteID, String course, String note) 
    {
      
        Note myNote = new Note(maxID, course, note);
        myNote.setNoteID(maxID);
        myNote.setCourse(course);
        myNote.setDayte();
        myNote.setNote(note + maxID);
        allNotes.add(myNote);
        writeAllNotes();
                                                       
    }
       
   public void EditNote(int noteID, String course, String note) 
   {      
        Note myNote = new Note(noteID, course, note);
        myNote.setNoteID(noteID);
        myNote.setCourse(course);
        myNote.setDayte();
        myNote.setNote(note);
        allNotes.set(noteID-1, myNote);
        writeAllNotes();                                                
    }
   
    public ArrayList<Note> getAllNotes() {
        return allNotes;
    }

    private void writeAllNotes() {
    
       // String path = appDir + "\\Notes" + maxID + ".txt";
       String path = appDir + "\\Notes.txt";
        ArrayList<String> writeNote = new ArrayList<>();

        for (Note n : allNotes) {
            String tmp = n.getNoteID()+"\t";
            tmp += n.getCourse() + "\t";
            tmp += n.getDayte() + "\t";
            tmp += n.getNote()  ;
          
            writeNote.add(tmp);
        }
        try {
            writeTextFile(path, writeNote);
        } catch (IOException ex) {
            System.out.println("Problem! " + path);
        }
    }
     
    public String searchAllNotesByKeyword(String noteList, int i, String s) {
        if (i == allNotes.size()) {
            return noteList;
        }
        if (allNotes.get(i).getNote().contains(s)) {
            noteList += allNotes.get(i).getNote() + "\n";
        }
        return searchAllNotesByKeyword(noteList, i + 1, s);
    }
    
       public String searchDropDownNotes(String noteList, int i, String s) {
        if (i == allNotes.size()) {
            return noteList;
        }
        if (allNotes.get(i).getCourse().contains(s)) {
            noteList += allNotes.get(i).getNote() + "\n";
        }
        return searchDropDownNotes(noteList, i + 1, s);
    }
     
       public int searchDropDownID(int noteList, int i, String s) {
        if (i == allNotes.size()) {
            return noteList;
        }
        if (allNotes.get(i).getCourse().contains(s)) {
            noteList = allNotes.get(i).getNoteID();   
        }
        return searchDropDownID(noteList, i + 1, s);
    }
}
