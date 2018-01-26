package com.example.pavneet_singh.roomdemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pavneet_singh.roomdemo.adapter.NotesAdapter;
import com.example.pavneet_singh.roomdemo.notedb.NoteDatabase;
import com.example.pavneet_singh.roomdemo.notedb.model.Note;

import java.lang.ref.WeakReference;
import java.util.List;

public class AddNoteActivity extends AppCompatActivity {

    private TextInputEditText et_title,et_content;
    private NoteDatabase noteDatabase;
    private Note note;
    private boolean update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);
        noteDatabase = NoteDatabase.getInstance(AddNoteActivity.this);
        Button button = findViewById(R.id.but_save);
        if ( (note = (Note) getIntent().getSerializableExtra("note"))!=null ){
            getSupportActionBar().setTitle("Update Note");
            update = true;
            button.setText("Update");
            et_title.setText(note.getTitle());
            et_content.setText(note.getContent());
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (update){
                    note.setContent(et_content.getText().toString());
                    note.setTitle(et_title.getText().toString());
                    noteDatabase.getNoteDao().updateNote(note);
                    setResult(note,2);
                }else {
                    note = new Note(et_content.getText().toString(), et_title.getText().toString());
                    new InsertTask(AddNoteActivity.this,note).execute();
                }
            }
        });
    }

    private void setResult(Note note, int flag){
        setResult(flag,new Intent().putExtra("note",note));
        finish();
    }

    private static class InsertTask extends AsyncTask<Void,Void,Boolean> {

        private WeakReference<AddNoteActivity> activityReference;
        private Note note;

        // only retain a weak reference to the activity
        InsertTask(AddNoteActivity context, Note note) {
            activityReference = new WeakReference<>(context);
            this.note = note;
        }

        // doInBackground methods runs on a worker thread
        @Override
        protected Boolean doInBackground(Void... objs) {
            // retrieve auto incremented note id
            long j = activityReference.get().noteDatabase.getNoteDao().insertNote(note);
            note.setNote_id(j);
            Log.e("ID ", "doInBackground: "+j );
            return true;
        }

        // onPostExecute runs on main thread
        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool){
                activityReference.get().setResult(note,1);
                activityReference.get().finish();
            }
        }
    }


}
