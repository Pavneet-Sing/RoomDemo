package com.example.pavneet_singh.roomdemo.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavneet_singh.roomdemo.R;
import com.example.pavneet_singh.roomdemo.notedb.model.Note;

import java.util.List;

/**
 * Created by Pavneet_Singh on 12/20/17.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.BeanHolder> {

    private List<Note> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private OnNoteItemClick onNoteItemClick;

    public NotesAdapter(List<Note> list,Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
        this.onNoteItemClick = (OnNoteItemClick) context;
    }


        @Override
    public BeanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.note_list_item,parent,false);
        return new BeanHolder(view);
    }

    @Override
    public void onBindViewHolder(BeanHolder holder, int position) {
        Log.e("bind", "onBindViewHolder: "+ list.get(position));
        holder.textViewTitle.setText(list.get(position).getTitle());
        holder.textViewContent.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BeanHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewContent;
        TextView textViewTitle;
        public BeanHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewContent = itemView.findViewById(R.id.item_text);
            textViewTitle = itemView.findViewById(R.id.tv_title);
        }

        @Override
        public void onClick(View view) {
            onNoteItemClick.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteItemClick{
        void onNoteClick(int pos);
    }
}