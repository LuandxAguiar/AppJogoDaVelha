package br.senai.sp.cotia.jogodavelhaapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefsUtil {
    public static String getSimboloJog1(Context context){
        //buscar a preferencias
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences( context);

        return preferences.getString("simb_jog_1","X");
    }
    public static String getSimboloJog2(Context context){
        //buscar a preferencias
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences( context);

        return preferences.getString("simb_jog_2","O");
    }

    public static String getNomeJog1(Context context){
        //buscar a preferencias
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences( context);

        return preferences.getString("nome_jog_1","jogador_1");
    }
    public static String getNomeJog2(Context context){
        //buscar a preferencias
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences( context);

        return preferences.getString("nome_jog_2","jogador_2");
    }
    public  static void setSimboloJog1(String simbolo, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences( context);
        //editor, serve para editar a preference
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("simb_jog_1", simbolo);
        //efetivar a mudança
        editor.commit();

    }

    public  static void setNomeJog1(String nome, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences( context);
        //editor, serve para editar a preference
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nome_jog_1", nome);
        //efetivar a mudança
        editor.commit();

    }

}
