package br.com.caminhoneiro.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.orm.SugarRecord.findById;

public class Visualizar extends AppCompatActivity {

    ListView list_view;
    List<Quilometragem> lstQuil;
    QuilometragemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

            list_view = (ListView) findViewById(R.id.lst_view);
            lstQuil = Quilometragem.listAll(Quilometragem.class);


            adapter = new QuilometragemAdapter(this, lstQuil);


            list_view.setAdapter(adapter);


    }


    //Classe do Adapter
    private class QuilometragemAdapter extends ArrayAdapter<Quilometragem> {

        public QuilometragemAdapter(Context context, List<Quilometragem> items)
        {
            super(context, 0, items);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View v = convertView;

            if (v == null){
                v = LayoutInflater.from(getContext()).inflate(R.layout.list_view,null);
            }

            Quilometragem item = getItem(position);

            TextView Mes = v.findViewById(R.id.Mes);
            TextView Quil = v.findViewById(R.id.Quilometragem);

            Quil.setText("KM :"+String.valueOf(item.getKm()));
            Mes.setText(item.getMes());

            return v;
        }
    }

}
