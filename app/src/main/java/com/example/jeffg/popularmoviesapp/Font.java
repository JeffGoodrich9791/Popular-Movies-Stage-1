package com.example.jeffg.fonts;

import android.app.Application;
import com.example.jeffg.popularmoviesapp.R;


import uk.co.chrisjenx.calligraphy.CalligraphyConfig;



public class Font extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/uberlin.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
