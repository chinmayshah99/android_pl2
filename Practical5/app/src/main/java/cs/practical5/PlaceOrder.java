package cs.practical5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlaceOrder extends AppCompatActivity {

    TextView t1;
    TextView t2;
    TextView t3;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        Bundle bundle = getIntent().getExtras();
        t1 = (TextView)findViewById(R.id.textView4);
        t2 = (TextView)findViewById(R.id.textView5);
        t3 = (TextView)findViewById(R.id.textView6);
        confirm = (Button)findViewById(R.id.button2);

        if(bundle!=null)
        {
            t1.setText(bundle.getString("size_key").toString());
            t2.setText(bundle.getString("crust_key").toString());
            t3.setText(bundle.getString("type_key").toString());
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlaceOrder.this,"YOUR ORDER IS CONFIRMED!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
