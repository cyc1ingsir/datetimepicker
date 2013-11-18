package com.fourmob.datetimepicker.sample;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;

import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.fourmob.datetimepicker.date.DatePickerDialog.OnDateSetListener;
import com.sleepbot.datetimepicker.time.RadialPickerLayout;
import com.sleepbot.datetimepicker.time.TimePickerDialog;

public class MainActivity extends Activity implements OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(this, 2007, 10, 1, isVibrate());

        final TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(this, 0 ,0, false);

        findViewById(R.id.dateButton).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                datePickerDialog.setVibrate(isVibrate());
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.show(getFragmentManager(), "datepicker");
            }
        });

        findViewById(R.id.timeButton).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show(getFragmentManager(), "time picker");
            }
        });
    }

    private boolean isVibrate() {
        return ((CheckBox) findViewById(R.id.checkBoxVibrate)).isChecked();
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        Toast.makeText(MainActivity.this, "new date:" + year + "-" + month + "-" + day, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {

    }
}
