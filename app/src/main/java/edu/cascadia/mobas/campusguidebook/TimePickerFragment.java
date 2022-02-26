package edu.cascadia.mobas.campusguidebook;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.time.ZonedDateTime;
import java.util.Calendar;

import edu.cascadia.mobas.campusguidebook.data.typeconverter.ZonedDateTimeConverter;

public class TimePickerFragment extends DialogFragment {

    private Bundle mBundle;

    public TimePickerFragment(Bundle savedInstanceState) {
        super();
        mBundle = savedInstanceState;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        ZonedDateTime zonedDateTime = ZonedDateTimeConverter.toZonedDateTime(mBundle.getString("datetime"));

        return new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getTargetFragment(),
                zonedDateTime.getHour(), zonedDateTime.getMinute(), false);
    }
}
