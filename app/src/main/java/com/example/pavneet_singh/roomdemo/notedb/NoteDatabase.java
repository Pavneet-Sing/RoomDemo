package com.example.pavneet_singh.roomdemo.notedb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.pavneet_singh.roomdemo.notedb.dao.NoteDao;
import com.example.pavneet_singh.roomdemo.notedb.model.Note;
import com.example.pavneet_singh.roomdemo.util.Constants;
import com.example.pavneet_singh.roomdemo.util.DateRoomConverter;

/**
 * Created by Pavneet_Singh on 12/31/17.
 */

@Database(entities = { Note.class }, version = 1)
@TypeConverters({DateRoomConverter.class})
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDao getNoteDao();


    private static NoteDatabase noteDB;

    // synchronized is use to avoid concurrent access in multithred environment
    public static /*synchronized*/ NoteDatabase getInstance(Context context) {
        if (null == noteDB) {
            noteDB = buildDatabaseInstance(context);
        }
        return noteDB;
    }

    private static NoteDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                NoteDatabase.class,
                Constants.DB_NAME).allowMainThreadQueries().build();
    }

    public  void cleanUp(){
        noteDB = null;
    }
}