package com.kartik.japamala;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    Button buttonAdd, buttonSave, buttonReset;
    private int count;
    private int mala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvView);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSave = findViewById(R.id.buttonSave);
        buttonReset = findViewById(R.id.buttonReset);

        count = SharePref.TotalLoadSharePreference(this);
        tvResult.setText("আপনি জপ করেছেন : "+count+" / "+mala+ " মালা");

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                mala = count/108;
                tvResult.setText("আপনি জপ করেছেন : "+count+" / "+mala+ " মালা");
                //SharePref.TotalSaveSharePreference(getApplicationContext(),count);
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //count--;
                SharePref.TotalSaveSharePreference(getApplicationContext(),count);
                tvResult.setText("আপনি জপ করেছেন : "+count+" / "+ mala + " মালা");
            }
        });


      /*buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharePref.TotalRemoveSharePreference(getApplication());
                /*  PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,1000,getIntent(),PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC,System.currentTimeMillis() +2000,pendingIntent);
                System.exit(0);
            }
        });
        */


    }


   public void resetPreference(View view){
       SharePref.TotalRemoveSharePreference(this);
       Toast.makeText(MainActivity.this, "Reset Done", Toast.LENGTH_SHORT).show();
       tvResult.clearComposingText();
       count = 0;
       tvResult.setText("আপনি জপ করেছেন : "+count+" / "+mala+ " মালা");
   }
   /* private static final char[] BngDigits = {'০','১','২','৩','৪','৫','৬','৭','৮','৯'};
    private static final char[] EngDigits = {'0','1','2','3','4','5','6','7','8','9'};

    public  static final String  getDigitBNGFromENG(String number){
        if(number==null)
            return new String("");
        StringBuilder builder = new StringBuilder();
        try{
            for(int i =0;i<number.length();i++){
                if(Character.isDigit(number.charAt(i))){
                    if(((int)(number.charAt(i))-48)<=9){
                        builder.append(BngDigits[(int)(number.charAt(i))-48]);
                    }else{
                        builder.append(number.charAt(i));
                    }
                }else{
                    builder.append(number.charAt(i));
                }
            }
        }catch(Exception e){
            //logger.debug("getDigitBNGFromENG: ",e);
            return new String("");
        }
        return builder.toString();
    }

    */

}