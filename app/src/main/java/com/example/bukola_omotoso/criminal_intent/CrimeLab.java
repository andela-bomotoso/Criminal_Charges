package com.example.bukola_omotoso.criminal_intent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by bukola_omotoso on 23/02/2017.
 */

public class CrimeLab {

    private static CrimeLab crimeLab;

    private List<Crime> crimes;

    public static CrimeLab get(Context context) {
        if (crimeLab == null )  {
            crimeLab = new CrimeLab(context);
        }
        return crimeLab;
    }

    private CrimeLab(Context context)   {
        crimes = new ArrayList<>();
        for (int i = 0; i < 100; i++)   {
            Crime crime = new Crime();
            crime.setCrimeTitle("Crime #"+i);
            crime.setCrimeSolved( i % 2 == 0);
            crimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : crimes)  {
            if (crime.getCrimeId() == id)   {
                return crime;
            }
        }
        return null;
    }
}
