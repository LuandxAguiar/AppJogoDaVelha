package br.senai.sp.cotia.jogodavelhaapp.fragment;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

import br.senai.sp.cotia.jogodavelhaapp.R;
import br.senai.sp.cotia.jogodavelhaapp.databinding.FragmentJogoBinding;

public class JogoFragment extends Fragment {
    //variavel para acessar o elements da view PrefFragment
    private FragmentJogoBinding binding;
    //vetor
    private Button[] botoes;
    //Matrix de String = representa o Tabuleiro
    private String[][] tabuleiro;
    //variaveis para o simbolos
    private String simboloJg1, simboloJg2, simbolo;
    //variavel random para quem inicia
    private Random random;
    //variavel para controlar numero de jgoadas
    private int numJogada = 0;

    private int venceJog1 = 0;
    private int venceJog2 = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //intanciando o  vetor
        botoes = new Button[9];
        //instanciando o binding
        binding = FragmentJogoBinding.inflate(inflater, container, false);
        //binding = FragmentJogoBinding.inflate(inflater, container,false);

        botoes[0] = binding.bt00;
        botoes[1] = binding.bt01;
        botoes[2] = binding.bt02;
        botoes[3] = binding.bt10;
        botoes[4] = binding.bt11;
        botoes[5] = binding.bt12;
        botoes[6] = binding.bt20;
        botoes[7] = binding.bt21;
        botoes[8] = binding.bt22;

        //for para ele correr entre os 9 botoes
        for (Button bt : botoes) {
            bt.setOnClickListener(listenerBotoes);
        }
        //instanciar o tabuleiro
        tabuleiro = new String[3][3];

        //prencher a matriz com "" para para a Nullpointer
        for(int i = 0; i <3 ; i++){
            for(int j = 0 ; j <3 ; j++){
                tabuleiro[i][j] = "";
            }
        }
                //outra forma de fazer para a NUllPointer ------------------
        /*
        for(String[] vetor : tabuleiro){
            Arrays.fill(vetor, "");
        }
        */

        //definir os simbolos do jogadores e do Jogador 2
        simboloJg1 = "x";
        simboloJg2 = "0";

        //instaciando o randonw

        random = new Random();

        //sorteio de que iniciara o jogo
        sorteia();
        atualizaVez();


        //retorno da view
        return binding.getRoot();

    }

    //metodo que sorteia quem começa jogando

    private void sorteia() {

        //se gerar o valor true jog1 começa
        //caso contrario jog2 começa
        //next boolean valor verdadeiro ou falso
        if (random.nextBoolean()) {
            simbolo = simboloJg1;
        } else {
            simbolo = simboloJg2;
        }

    }

    private void atualizaVez() {
        if (simbolo.equals(simboloJg1)) {
            binding.textView.setBackgroundColor(getResources().getColor(R.color.azuzi));
            binding.textViewDois.setBackgroundColor(getResources().getColor(R.color.rosa));

            binding.placarOne.setBackgroundColor(getResources().getColor(R.color.azuzi));
            binding.placarTwo.setBackgroundColor(getResources().getColor(R.color.rosa));
        } else {
            binding.textViewDois.setBackgroundColor(getResources().getColor(R.color.azuzi));
            binding.textView.setBackgroundColor(getResources().getColor(R.color.rosa));

            binding.placarTwo.setBackgroundColor(getResources().getColor(R.color.azuzi));
            binding.placarOne.setBackgroundColor(getResources().getColor(R.color.rosa));

        }
    }

    //metodo para verificar quem venceu
    private boolean venceu() {
        //for para verifiar se venceu nas linhas
        for (int li = 0; li < 3; li++) {
            if (tabuleiro[li][0].equals(simbolo) && tabuleiro[li][1].equals(simbolo) && tabuleiro[li][2].equals(simbolo))
                ;
            return true;

        }

        for (int col = 0; col < 3; col++) {
            if (tabuleiro[0][col].equals(simbolo) && tabuleiro[1][col].equals(simbolo) && tabuleiro[2][col].equals(simbolo))
                ;
            return true;


        }
        //verifica do lado
        if (tabuleiro[0][0].equals(simbolo) && tabuleiro[1][1].equals(simbolo) && tabuleiro[2][2].equals(simbolo)) {
            reseta();
        }
        if (tabuleiro[0][2].equals(simbolo) && tabuleiro[1][1].equals(simbolo) && tabuleiro[2][0].equals(simbolo)) {
            reseta();
        }
        return false;
    }

    private void reseta() {

            //limpando usando o vetor de botoes om background inicail e clicavel
         for(Button botao : botoes){
             botao.setClickable(true);
             botao.setText("");
             botao.setBackgroundColor(getResources().getColor(R.color.rosa));
         }
            //limpar a matrix
        for(String[] vetor : tabuleiro){
            Arrays.fill(vetor, "");
        }
        //zerar numero de jogadas
        numJogada=0;

            }





    //listerner para os botoes

    //colocar botões para funcionar.
    private View.OnClickListener listenerBotoes = btPress -> {

        //incrmenta o nume de jogadas
        numJogada++;

        Log.w("BOTAO", getContext().getResources().getResourceName(btPress.getId()));
        //Obtem o nome do botao
        String nomeBotao = getContext().getResources().getResourceName(btPress.getId());
        //extrair posiçao do atraves do botao
        String posicao = nomeBotao.substring(nomeBotao.length() - 2);
        //extraindo a linha e coluna da string posicao
        //character para o voltar o numero do ID
        int linha = Character.getNumericValue(posicao.charAt(0));
        int coluna = Character.getNumericValue(posicao.charAt(1));
        Log.w("BOTAO", linha + "");
        Log.w("BOTAO", coluna + "");

        //preencher a posição da Matrix com o simbolo gerado
        tabuleiro[linha][coluna] = simbolo;
        // faz um casting de view pra Button
        Button botao = (Button) btPress;
        //setar o simbolo no botão pressionado
        botao.setText(simbolo);
        //trocar o background para mostrar que foi clicado
        botao.setBackgroundColor(Color.WHITE);
        //desabilitar o botao que ja foi pressionado
        botao.setClickable(false);
        //verifica se venceu
        if (numJogada >= 5 && venceu()) {
            //avisar que houve um vencendor
            Toast.makeText(getContext(), R.string.vencedor, Toast.LENGTH_SHORT).show();
            reseta();
        } else if(numJogada == 9) {
        Toast.makeText(getContext(),R.string.velha, Toast.LENGTH_LONG).show();
        }

            //inverter os simbolos

            //fazendo com if
        /*
        if(simbolo.equals(simboloJg1)){
            simbolo = simboloJg2;
        }else{
            simbolo = simboloJg1;
        };
        */
            //fazendo com operador ternario
            simbolo = simbolo.equals(simboloJg1) ? simboloJg2 : simboloJg1;


            //atualiza vez
            atualizaVez();



    };

    }
