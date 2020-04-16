package com.example.signozodiacal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.signozodiacal.model.User;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    private TextView edFirstName,edLastName1,edLastName2;
    private Button btnSend,btnBirthDay;
    //TextView tvBirthDay;
    User usuario;
    int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edFirstName= findViewById(R.id.edFirstName);
        edLastName1= findViewById(R.id.edLastName1);
        edLastName2= findViewById(R.id.edLastName2);
        btnSend= findViewById(R.id.btnSend);
        btnBirthDay=findViewById(R.id.btnBirthDay);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   usuario.getDay();
                   usuario.getFirstName();
                   usuario.getLastName1();
                   usuario.getLastName2();
                }catch (Exception e)
                {
                    Log.d(getResources().getString(R.string.MainActivity),getResources().getString(R.string.incomplete));
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.incomplete),Toast.LENGTH_SHORT).show();
                }
                if(Validar())
                {
                    usuario.setFirstName(edFirstName.getText().toString());
                    usuario.setLastName1(edLastName1.getText().toString());
                    usuario.setLastName2(edLastName2.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putSerializable(getResources().getString(R.string.user),usuario);
                    bundle.putString(getResources().getString(R.string.greeting),getResources().getString(R.string.greeting_user));

                    Intent intento = new Intent(MainActivity.this,MainActivity_user_info.class);
                    intento.putExtras(bundle);
                    startActivity(intento);

                    Log.d(getResources().getString(R.string.MainActivity),getResources().getString(R.string.correct));
                }
                else
                {
                    //Log.d(getResources().getString(R.string.MainActivity),getResources().getString(R.string.date_error));
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.incorrectData),Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnBirthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal =Calendar.getInstance();
                year=cal.get(Calendar.YEAR);
                month=cal.get(Calendar.MONTH);
                day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,MainActivity.this,year,month,day);
                datePickerDialog.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            if(year >=2020){
                Log.d(getResources().getString(R.string.MainActivity),getResources().getString(R.string.date_error));
                Toast.makeText(MainActivity.this,getResources().getString(R.string.incorrectData),Toast.LENGTH_SHORT).show();

            }
            else{
                month=month+1;
                usuario=new User(dayOfMonth,month,year);
                btnBirthDay.setText(dayOfMonth+"/"+month+"/"+year);
            }


    }

    private boolean Validar()
    {
        if (edFirstName.getText().length()!=0 & edLastName1.getText().length()!=0 & edLastName2.getText().length()!=0)
        {
            try{
                edFirstName.getText().toString();
                edLastName2.getText().toString();
                edLastName1.getText().toString();
            }
            catch (Exception e)
            {
                return false;
            }
        }
        else
        {
            return  false;
        }
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
