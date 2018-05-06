package e.raju.timestable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.KeyStore;


public class MainActivity extends AppCompatActivity {

    EditText of, till;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout_input();
    }

    public void layout_input(){
        final EditText of = findViewById(R.id.et1);
        final EditText till = findViewById(R.id.et2);
         Button go = (Button)findViewById(R.id.btn1);
         go.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if (valid()) {
                            float a = Float.parseFloat(of.getText().toString());
                            int b = Integer.parseInt(till.getText().toString());
                            Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putFloat("OF", a);
                            bundle.putInt("TILL", b);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    }
                }
        );
         Button clr = findViewById(R.id.clr);
         clr.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 of.getText().clear();
                 till.getText().clear();
             }
         });

    }

    private boolean valid() {
        EditText of = findViewById(R.id.et1);
        EditText till = findViewById(R.id.et2);

        return !(TextUtils.isEmpty(of.getText())) && !(TextUtils.isEmpty(till.getText())) && (TextUtils.isDigitsOnly(till.getText()));
    }


}
