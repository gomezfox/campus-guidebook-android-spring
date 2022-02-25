package edu.cascadia.mobas.campusguidebook;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import edu.cascadia.mobas.campusguidebook.data.database.AppDatabase;
//import java.text.DateFormat;


public class AddEventFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, View.OnClickListener {

    private AppDatabase mAppDatabase;
    private AppExecutors mAppExecutors;
    private EditText mEditTextEventName;
    private EditText mEditTextEventDescription;
    private EditText mEditTextEventLocation;
    private Button mBtnPickDate;
    private Button mBtnPickTime;
    private Button mAddNewEventBtn;
    private TextView mTextViewDateTime;
    int hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;

    public AddEventFragment() {
        // Required empty public constructor
    }


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_add_event, container, false);
        mEditTextEventName = root.findViewById(R.id.editTextEventName);
        mEditTextEventDescription = root.findViewById(R.id.editTextEventDescription);
        mEditTextEventLocation = root.findViewById(R.id.editTextEventLocation);
        mBtnPickDate = root.findViewById(R.id.btnPickDate);
        mBtnPickTime = root.findViewById(R.id.btnPickTime);
        mAddNewEventBtn = root.findViewById(R.id.addNewEventBtn);
        mTextViewDateTime = root.findViewById(R.id.textViewDateTime);

        mBtnPickDate.setOnClickListener(this);
        mBtnPickTime.setOnClickListener(this);
        mAddNewEventBtn.setOnClickListener(this);


        return root;
    }

    @Override
    public void onClick (View v) {
        switch (v.getId()){
            case R.id.btnPickDate: {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.setTargetFragment(AddEventFragment.this, 0);
                dialogFragment.show(getFragmentManager(), "date picker");
                break;
            }
            case R.id.btnPickTime: {
                Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR);
                minute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(), hour, minute, DateFormat.is24HourFormat(getActivity()));
                timePickerDialog.show();
                break;
            }
            case R.id.addNewEventBtn: {
//                mAppDatabase = AppDatabase.getInstance(getActivity().getApplication(), mAppExecutors.diskIO().execute( () -> mAppDatabase.runInTransaction( () -> {
//
//                })));
                break;
            }
        }

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        myYear = year;
        myday = dayOfMonth;
        myMonth = month;
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        DialogFragment dialogTimeFragment = new TimePickerFragment();
        dialogTimeFragment.setTargetFragment(AddEventFragment.this, 0);
        dialogTimeFragment.show(getFragmentManager(), "time picker");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        myHour = hourOfDay;
        myMinute = minute;
        mTextViewDateTime.setText("Year: " + myYear + "\n" +
                "Month: " + myMonth + "\n" +
                "Day: " + myday + "\n" +
                "Hour: " + myHour + "\n" +
                "Minute: " + myMinute);
    }



}