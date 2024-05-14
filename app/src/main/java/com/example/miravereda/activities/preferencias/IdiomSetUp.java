package com.example.miravereda.activities.preferencias;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;


public final class IdiomSetUp {

    private IdiomSetUp() {
    }

    public enum Idiom {
        ESPANYOL, INGLES
    }

    public static void applyIdiom(Idiom idiom, Context context) {
        switch (idiom) {
            case INGLES:
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = context.getResources().getConfiguration();
                config.locale = locale;
                context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
                break;
        }
    }

    public static void applyPreferenceIdiom(Context context) {
        applyIdiom(Idiom.valueOf(GestionPreferencias.getInstance().getIdiom(context)), context);
    }
}
