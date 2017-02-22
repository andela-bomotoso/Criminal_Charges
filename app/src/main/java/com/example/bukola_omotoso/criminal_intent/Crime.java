package com.example.bukola_omotoso.criminal_intent;

import java.util.UUID;

/**
 * Created by bukola_omotoso on 22/02/2017.
 */

public class Crime {

    private UUID crimeId;
    private String crimeTitle;

    public Crime()  {
        crimeId = UUID.randomUUID();
    }

    public UUID getCrimeId() {
        return crimeId;
    }

    public String getCrimeTitle() {
        return crimeTitle;
    }

    public void setCrimeTitle(String crimeTitle) {
        this.crimeTitle = crimeTitle;
    }
}
