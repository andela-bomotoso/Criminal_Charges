package com.example.bukola_omotoso.criminal_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by bukola_omotoso on 23/02/2017.
 */

public class CrimeListFragment extends Fragment {
    private RecyclerView crimeRecycleView;
    private CrimeAdapter crimeAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)   {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        crimeRecycleView = (RecyclerView)view.findViewById(R.id.crime_recycler_view);
        crimeRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onResume()  {
        super.onResume();
        updateUI();
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener   {
        private Crime crime;
        private TextView titleTextView;
        private TextView dateTextView;
        private CheckBox crimesolvedCheckbox;

        public CrimeHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title);
            dateTextView = (TextView) itemView.findViewById(R.id.list_item_crime_date);
            crimesolvedCheckbox = (CheckBox) itemView.findViewById(R.id.list_item_crime_solved);
        }

        @Override
        public void onClick(View view) {
//            Toast.makeText(getActivity(),crime.getCrimeTitle() + " clicked!", Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(getActivity(),CrimeActivity.class);
            Intent intent = CrimeActivity.newIntent(getActivity(),crime.getCrimeId());
            startActivity(intent);

        }

        private void bindView(Crime crime)  {
            this.crime = crime;
            titleTextView.setText(crime.getCrimeTitle());
            dateTextView.setText(crime.getCrimeDate().toString());
            crimesolvedCheckbox.setChecked(crime.isCrimeSolved());
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>    {

        private List<Crime> crimes;

        public CrimeAdapter(List<Crime> crimes) {
            this.crimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_crime, parent,false);
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = crimes.get(position);
            holder.bindView(crime);
        }

        @Override
        public int getItemCount() {
            return crimes.size();
        }

    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        if(crimeAdapter == null) {
            crimeAdapter = new CrimeAdapter(crimes);
            crimeRecycleView.setAdapter(crimeAdapter);
        }   else    {
            crimeAdapter.notifyDataSetChanged();
        }
    }

}
