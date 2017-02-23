package com.example.bukola_omotoso.criminal_intent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by bukola_omotoso on 22/02/2017.
 */

public class Crime {

    private UUID crimeId;
    private String crimeTitle;
    private Date crimeDate;
    private boolean crimeSolved;

    public Crime()  {
        crimeId = UUID.randomUUID();
        crimeDate = new Date();
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

    public boolean isCrimeSolved() {
        return crimeSolved;
    }

    public void setCrimeSolved(boolean crimeSolved) {
        this.crimeSolved = crimeSolved;
    }

    public Date getCrimeDate() {
        return crimeDate;
    }

    public void setCrimeDate(Date crimeDate) {
        this.crimeDate = crimeDate;
    }
}
