package br.com.caminhoneiro.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spi;
    ArrayAdapter<String> adapter;
    String categoria;
    EditText km;
    float strKM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        List<Mes> m = Mes.listAll(Mes.class);
        if (m.size()== 0){
            for (int i = 1;i <= 12;i++){
                Mes mes = new Mes();
                switch (i){
                    case (1):
                        mes.setNome("janeiro");
                        break;
                    case (2):
                        mes.setNome("fevereiro");
                        break;
                    case (3):
                        mes.setNome("marco");
                        break;
                    case (4):
                        mes.setNome("abril");
                        break;
                    case (5):
                        mes.setNome("maio");
                        break;
                    case (6):
                        mes.setNome("junho");
                        break;
                    case (7):
                        mes.setNome("julho");
                        break;
                    case (8):
                        mes.setNome("agosto");
                        break;
                    case (9):
                        mes.setNome("setembro");
                        break;
                    case (10):
                        mes.setNome("outubro");
                        break;
                    case (11):
                        mes.setNome("novembro");
                        break;
                    case (12):
                        mes.setNome("dezembro");
                        break;
                }
                mes.save();
            }
        }




        spi = (Spinner) findViewById(R.id.spinner);

        List<Mes> meses = Mes.listAll(Mes.class);
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < meses.size(); i++){
            Mes Mes;
            Mes = meses.get(i);
            list.add(Mes.getNome());
        }


        adapter  = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        spi.setAdapter(adapter);


        //Método do Spinner para capturar o item selecionado
        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                //pega nome pela posição
                categoria =  adapter.getItem(posicao);
                //imprime um Toast na tela com o nome que foi selecionado
                Toast.makeText(MainActivity.this,categoria, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.visualizar) {
            startActivity(new Intent(this,Visualizar.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public void inserir(View view) {

        km = (EditText) findViewById(R.id.km);
        strKM = Float.parseFloat(km.getText().toString());


        /*if (strKM.isEmpty())return;*/

        //Criando o obj Quilometragem
        Quilometragem q = new Quilometragem(strKM,categoria);

        //adicionando no banco
        q.save();

    }
}
