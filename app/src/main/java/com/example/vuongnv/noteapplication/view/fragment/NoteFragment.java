package com.example.vuongnv.noteapplication.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.vuongnv.noteapplication.R;
import com.example.vuongnv.noteapplication.model.Note;
import com.example.vuongnv.noteapplication.view.NoteAdapter;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class NoteFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String TAG = NoteFragment.class.getSimpleName();

    //view
    private GridView mGridView;
    private ImageView mIvAdd;
    private NoteAdapter mNoteAdapter;
    private ArrayList<Note> mArrNote;

    //
    CallBackNoteFragment mCallBackNoteFragment;


    @SuppressLint("ValidFragment")
    public NoteFragment(CallBackNoteFragment callBackNoteFragment) {
        this.mCallBackNoteFragment = callBackNoteFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        initView(view);
        initData();
        setOnclick();
        return view;
    }

    private void initView(View view) {
        mGridView = view.findViewById(R.id.gv_note);
        mIvAdd = view.findViewById(R.id.iv_addnote_add);
    }

    private void setOnclick() {
        mIvAdd.setOnClickListener(this);
        mGridView.setOnItemClickListener(this);

    }

    private void initData() {
        mArrNote = new ArrayList<>();
        mArrNote.add(new Note("dsdf", "sdf", "sdf", "sdf"));
        mArrNote.add(new Note("dsdf", "sdf", "sdf", "sdf"));
        mArrNote.add(new Note("dsdf", "sdf", "sdf", "sdf"));
        mArrNote.add(new Note("dsdf", "sdf", "sdf", "sdf"));
        mArrNote.add(new Note("dsdf", "sdf", "sdf", "sdf"));
        mNoteAdapter = new NoteAdapter(getContext(), mArrNote);
        mGridView.setAdapter(mNoteAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_addnote_add:
                mCallBackNoteFragment.clickButtonAdd();
                break;
            default:
                Log.d(TAG, "onClick: ");
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mCallBackNoteFragment.clickItemGridView(mArrNote.get(position));
    }

    public interface CallBackNoteFragment{
        void clickButtonAdd();
        void clickItemGridView(Note note);
    }

}
