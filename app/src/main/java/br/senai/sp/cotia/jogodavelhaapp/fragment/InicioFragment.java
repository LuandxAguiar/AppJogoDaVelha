package br.senai.sp.cotia.jogodavelhaapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.senai.sp.cotia.jogodavelhaapp.R;
import br.senai.sp.cotia.jogodavelhaapp.databinding.ActivityMainBinding;
import br.senai.sp.cotia.jogodavelhaapp.databinding.FragmentInicioBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private @NonNull FragmentInicioBinding binding;
    public InicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment inicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    // "inflando" o binding
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInicioBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    //metodo para  tirar a navegaçao do inicio
    @Override
    public void onStart() {
        super.onStart();
        //referencia para activity
        AppCompatActivity minhaActovity = (AppCompatActivity) getActivity();
        //ocultar a action bar agr
        minhaActovity.getSupportActionBar().hide();
    }

    // criando conexão entre o fragment inicial com o jogo
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(InicioFragment.this).navigate(R.id.action_inicioFragment_to_jogoFragment);
            }
        });
    }
}