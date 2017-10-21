package saim.com.ocrreader;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PhoneDetail extends AppCompatActivity {



    TextView textViewName, textViewRad1, textViewRad2;
    String name, rad1, rad2;
    Button btnSearchAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_detail);

        Splash.searchCount++;

        name = Build.MANUFACTURER + " " + Build.MODEL;
        rad1 = "1.6";
        rad2 = "2.0";
        init();
    }

    public void init(){
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewRad1 = (TextView) findViewById(R.id.textViewRad1);
        textViewRad2 = (TextView) findViewById(R.id.textViewRad2);
        btnSearchAgain = (Button) findViewById(R.id.btnSearchAgain);

        int s = 0;
        for (int i=0; i<name.length();i++){
            s = s + (int)name.charAt(i);
        }

        String mainVal = "0." + s;
        double mainValue = Double.parseDouble(mainVal);

        Random r = new Random();
        double random1 = 0.01 + r.nextDouble() * (0.09 - 0.01);
        double random2 = 0.01 + r.nextDouble() * (0.09 - 0.01);

        Double value1 = Double.parseDouble(rad1) - (mainValue + random1);
        Double value2 = Double.parseDouble(rad2) - (.2 + mainValue + random2);

        textViewName.setText(name);
        textViewRad1.setText(value1 + "");
        textViewRad2.setText(value2 + "");


        String reqString = Build.MANUFACTURER
                + "\n" + Build.MODEL + "\n" + Build.VERSION.RELEASE
                + "\n" + Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();


        btnSearchAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Splash.searchCount>=3){
                    finish();
                    Toast.makeText(getApplicationContext(), "Search limit exists", Toast.LENGTH_LONG).show();
                }else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }

            }
        });
    }
}
