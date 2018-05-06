package e.raju.timestable;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class ScrollingActivity extends AppCompatActivity {

    float a;
    int b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            a = bundle.getFloat("OF");
            b = bundle.getInt("TILL");
        }
        display_set(a,b);
    }



    private void display_append(float a, int b) {
        TextView d = (TextView)findViewById(R.id.display);
        String answer;
        for(int i = 1; i <= b; i++){
            float c = a * i;
            answer = String.format(getResources().getString(R.string.ans), a, i, c);
            d.append(answer);
        }
    }


    @SuppressLint("StringFormatMatches")
    private void display_set(float a, int b) {
        TextView d = (TextView)findViewById(R.id.display);
        String answer;
        answer = String.format(getResources().getString(R.string.ds), a);
        d.setText(answer);
        display_append(a, b);

    }
}
