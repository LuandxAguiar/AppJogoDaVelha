package br.senai.sp.cotia.jogodavelhaapp.fragment;



import android.os.Bundle;


import androidx.preference.PreferenceFragmentCompat;

import br.senai.sp.cotia.jogodavelhaapp.R;


public class PrefFragment extends PreferenceFragmentCompat {
 @Override
 public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
  //metod que vai inflar o layout
  addPreferencesFromResource(R.xml.preferences);

  //tratamos a escolha de preferencias
 }
}