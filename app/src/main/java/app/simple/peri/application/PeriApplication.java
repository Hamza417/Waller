package app.simple.peri.application;

import android.app.Application;

import com.google.android.material.color.DynamicColors;

public class PeriApplication extends Application {
    
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}
