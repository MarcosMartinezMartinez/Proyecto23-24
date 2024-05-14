package com.example.proyectocliente2324.activities.preferencias;

import android.os.Bundle;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import java.util.Arrays;
import java.util.List;

import es.ieslavereda.miravereda.R;


public class PreferenciasFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.preferencias, rootKey);





        ListPreference idiomPreference = getPreferenceManager().findPreference("lenguaje");
        final List<String> idiom_entries = Arrays.asList(getResources().getStringArray(R.array.idiom_entries));
        final List<String> idiom_values = Arrays.asList(getResources().getStringArray(R.array.idiom_values));
        int position  = idiom_values.indexOf(GestionPreferencias.getInstance().getIdiom(getContext()));

        if (idiomPreference.getValue() == null) {
            idiomPreference.setValue(IdiomSetUp.Idiom.ESPANYOL.name());
        }

        idiomPreference.setSummary(idiom_entries.get(position));
        idiomPreference.setOnPreferenceChangeListener((preference, newValue) -> {

            int pos1 = idiom_values.indexOf(newValue);
            idiomPreference.setSummary(idiom_entries.get(pos1));

            return true;
        });




        // Theme preferences with ListPreference
        ListPreference themePreference = getPreferenceManager().findPreference(getString(R.string.settings_theme_key));
        if (themePreference.getValue() == null) {
            themePreference.setValue(ThemeSetup.Mode.DEFAULT.name());
        }
        themePreference.setOnPreferenceChangeListener((preference, newValue) -> {
            ThemeSetup.applyTheme(ThemeSetup.Mode.valueOf((String) newValue));
            return true;
        });



    }
}