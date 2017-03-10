package com.example.bukola_omotoso.criminal_intent;

import android.support.v4.app.Fragment;

/**
 * Created by bukola_omotoso on 23/02/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
