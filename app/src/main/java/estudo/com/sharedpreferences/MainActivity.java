package estudo.com.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "App aulaSp";
    private static final String PREF_NOME = "App_aulaSp_pref";
    SharedPreferences  sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"onCreate: Rodando");
        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);

        Log.i(TAG,"pasta shared criada");
        dados = sharedPreferences.edit();
        nomeProduto = "Notebook";
        codigoProduto = 12345;
        precoProduto = 997.97f;
        estoque = true;

        Log.i(TAG,"dados serem salvos ");
        Log.i(TAG,"Produto " +nomeProduto);
        Log.i(TAG,"Codigo " +codigoProduto);
        Log.i(TAG,"Preço " +precoProduto );
        Log.i(TAG,"Estoque " +estoque);


        dados.putString("nomeProduto",nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("proçoProduto", precoProduto);
        dados.putBoolean("estoque", estoque);
        //dados salvos
        dados.apply();
        //Modo debug

       // dados a serem limpos

        Log.i(TAG,"dados serem salvos ");
        Log.i(TAG,"Produto " +nomeProduto);
        Log.i(TAG,"Codigo " +codigoProduto);
        Log.i(TAG,"Preço " +precoProduto );
        Log.i(TAG,"Estoque " +estoque);

        //dados.clear();
        //dados.apply();

        //dados.remove("estoque");
        //dados.apply();

        //recuperar dados

        Log.i(TAG,"dados serem salvos ");
        Log.i(TAG,"Produto " +sharedPreferences.getString("nomeProduto", "fora de estoque"));
        Log.i(TAG,"Codigo " +sharedPreferences.getInt("codigoProduto", -1));
        Log.i(TAG,"Preço " +sharedPreferences.getFloat("precoProduto", -1.0f));
        Log.i(TAG,"Estoque " +sharedPreferences.getBoolean("estoque",false));

    }
}