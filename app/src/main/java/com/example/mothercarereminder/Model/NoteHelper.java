package com.example.mothercarereminder.Model;

public class NoteHelper {
    public String date;
    public String noteTittle;
    public String noteBoddy;

    public NoteHelper() {
    }

    public NoteHelper(String date, String noteTittle, String noteBoddy) {
        this.date = date;
        this.noteTittle = noteTittle;
        this.noteBoddy = noteBoddy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNoteTittle() {
        return noteTittle;
    }

    public void setNoteTittle(String noteTittle) {
        this.noteTittle = noteTittle;
    }

    public String getNoteBoddy() {
        return noteBoddy;
    }

    public void setNoteBoddy(String noteBoddy) {
        this.noteBoddy = noteBoddy;
    }
}
