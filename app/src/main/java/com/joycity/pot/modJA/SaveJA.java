package com.joycity.pot.modJA;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class SaveJA {

    private String saveRec;
   public static Activity activity;

    public Activity getActivity() {
        return activity;
    }



    public String getSaveRec() {
        Log.d("weq",kkl());
        return kkl();

    }

    public void setSaveRec(String saveRec) {
        this.saveRec = saveRec;
        llk();
        Log.d("weq",saveRec);
    }

    public String kkl(){
      return activity.getSharedPreferences(activity.getPackageName(), Context.MODE_PRIVATE).getString("oo","0");
    }

    public void llk(){
        activity.getSharedPreferences(activity.getPackageName(), Context.MODE_PRIVATE).edit().putString("oo", saveRec).apply();
    }
}
