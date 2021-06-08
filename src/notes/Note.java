/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notes;

/**
 *
 * @author Karan
 */
public class Note extends CommonCode {
    int noteID = 0;
    private String course = "";
    private String dayte = "";
    private String note = "";

        public Note() {
         
        }
        
    public Note(int max, String crs, String nt) {
        setNoteID(max);
        setCourse(crs);
        setDayte();
        setNote(nt);
    }

    public Note(int nid, String crs, String dt, String nt) {
        setNoteID(nid);
        setCourse(crs);
        setDayte(dt);
        setNote(nt);
    }
        
  public final void setNoteID(int n) {
        int nid = n;
// Any validation goes here.
        noteID = nid;
    }

    public final void setCourse(String c) {
        String crse = c;
// Any validation goes here.
        course = crse;
    }

    public int getNoteID() {
// Any checking goes here.
        return noteID;
    }

    public String getCourse() {
// Any checking goes here.
        return course;
    }

    public final void setDayte() {
        dayte = orderedDate;
    }

    public final void setDayte(String d) {
        dayte = d;
    }

    public String getDayte() {
        return dayte;
    }

    public final void setNote(String n) {
// Any validation goes here.
        note = n;
    }

    public String getNote() {
// Any checking goes here.
        return note;
    }
}


