package com.example.bukola_omotoso.criminal_intent;

import android.icu.text.SimpleDateFormat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by bukola_omotoso on 23/02/2017.
 */

public class CrimeFragment extends Fragment {
    private EditText crime_title_text;
    private Crime crime;
    private Button dateButton;
    private CheckBox solvedCheckbox;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy.");

    @Override
    public void onCreate(Bundle saveInstanceState)  {
        super.onCreate(saveInstanceState);
        crime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)    {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);
        crime_title_text = (EditText)view.findViewById(R.id.crime_title);
        dateButton = (Button)view.findViewById(R.id.crime_date);
        solvedCheckbox = (CheckBox)view.findViewById(R.id.crime_solved);
        crime_title_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                crime.setCrimeTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dateButton.setText(simpleDateFormat.format(Date.parse(crime.getCrimeDate().toString())));
        dateButton.setEnabled(false);
        solvedCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                solvedCheckbox.setChecked(isChecked);
            }
        });
        return view;
    }
}
