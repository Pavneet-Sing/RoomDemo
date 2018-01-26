package com.example.pavneet_singh.roomdemo.notedb.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pavneet_singh.roomdemo.notedb.model.Note;
import com.example.pavneet_singh.roomdemo.util.Constants;

import java.util.List;

/**
 * Created by Pavneet_Singh on 12/31/17.
 */

@Dao
public interface NoteDao {

    @Query("SELECT * FROM "+ Constants.TABLE_NAME_NOTE)
    List<Note> getNotes();

    /*
    * Insert the object in database
    * @param note, object to be inserted
    */
    @Insert
    long insertNote(Note note);

    /*
    * update the object in database
    * @param note, object to be updated
    */
    @Update
    void updateNote(Note repos);

    /*
    * delete the object from database
    * @param note, object to be deleted
    */
    @Delete
    void deleteNote(Note note);

    // Note... is varargs, here note is an array
    /*
    * delete list of objects from database
    * @param note, array of oject to be deleted
    */
    @Delete
    void deleteNotes(Note... note);

}
