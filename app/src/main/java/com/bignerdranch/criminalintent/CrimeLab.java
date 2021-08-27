package com.bignerdranch.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> sCrimes;

    public CrimeLab(Context context) {
        sCrimes = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("범죄 #" + i);
            crime.setSolved(i % 2 == 0);
            sCrimes.add(crime);
        }
    }

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public List<Crime> getCrimes() {
        return sCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime crime : sCrimes){
            if(crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
