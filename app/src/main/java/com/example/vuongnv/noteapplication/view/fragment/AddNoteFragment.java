package com.example.vuongnv.noteapplication.view.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.vuongnv.noteapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@SuppressLint("ValidFragment")
public class AddNoteFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = AddNoteFragment.class.getSimpleName();

    //view
    ImageView mIvBack;
    EditText mEtDate;

    //interface
    private CallBackAddNote mCallBackAddNote;

    //
    Calendar myCalendar = Calendar.getInstance();

    @SuppressLint("ValidFragment")
    public AddNoteFragment(CallBackAddNote callBackAddNote) {
        this.mCallBackAddNote = callBackAddNote;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addnote, container, false);
        initView(view);
        setOnClick();
        return view;
    }

    private void initView(View view) {
        mIvBack = view.findViewById(R.id.iv_addnote_back);
    }

    private void setOnClick() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_addnote_back:
                mCallBackAddNote.clickButtonBack();
                break;
            default:
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                break;
        }
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }



    };

    public interface CallBackAddNote {
        void clickButtonBack();
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

    }
}
