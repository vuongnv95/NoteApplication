package com.example.vuongnv.noteapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vuongnv.noteapplication.model.Note;
import com.example.vuongnv.noteapplication.view.fragment.AddNoteFragment;
import com.example.vuongnv.noteapplication.view.fragment.EditNoteFragment;
import com.example.vuongnv.noteapplication.view.fragment.NoteFragment;

public class MainActivity extends AppCompatActivity implements NoteFragment.CallBackNoteFragment, EditNoteFragment.CallBackEditNote, AddNoteFragment.CallBackAddNote {

    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.fl_main,new NoteFragment(this)).commit();
    }

    @Override
    public void clickButtonAdd() {
        mFragmentManager.beginTransaction().replace(R.id.fl_main,new AddNoteFragment(this)).addToBackStack("add").commit();
    }

    @Override
    public void clickItemGridView(Note note) {
        mFragmentManager.beginTransaction().replace(R.id.fl_main,new EditNoteFragment(this,note)).addToBackStack("edit").commit();
    }

    @Override
    public void clickButtonBack() {
        mFragmentManager.popBackStack();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        mFragmentManager.popBackStack();
    }
}
