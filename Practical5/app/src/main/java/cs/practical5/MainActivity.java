package cs.practical5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String strsize, strcrust, strtype;
    Spinner spinner1;
    RadioGroup rg;
    RadioButton rb;
    ListView lv;
    Button btn;

    ArrayAdapter adapter1, adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButton();
    }

    public void OnClickButton()
    {
        btn = (Button)findViewById(R.id.button);
        spinner1 = (Spinner)findViewById(R.id.spinner);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        lv = (ListView)findViewById(R.id.listView);

        adapter1 = ArrayAdapter.createFromResource(this,R.array.sizeofpizza,android.R.layout.simple_spinner_item);
        adapter2 = ArrayAdapter.createFromResource(this,R.array.typeofpizza,android.R.layout.simple_list_item_1);
        adapter1.setDropDownViewResource(android.R.layout.select_dialog_item);

        spinner1.setAdapter(adapter1);
        lv.setAdapter(adapter2);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                strtype = new String();
                strtype = lv.getItemAtPosition(position).toString();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strsize = new String();
                strsize = spinner1.getSelectedItem().toString();
                rg  = (RadioGroup)findViewById(R.id.radioGroup);
                int selected_id = rg.getCheckedRadioButtonId();
                rb = (RadioButton)findViewById(selected_id);
                strcrust = new String();
                strcrust = rb.getText().toString();

                Intent intent = new Intent(MainActivity.this,PlaceOrder.class);
                intent.putExtra("size_key",strsize);
                intent.putExtra("crust_key",strcrust);
                intent.putExtra("type_key",strtype);
                startActivity(intent);
            }
        });
    }
}

