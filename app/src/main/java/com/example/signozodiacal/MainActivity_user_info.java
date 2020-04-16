package com.example.signozodiacal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.signozodiacal.model.User;

public class MainActivity_user_info extends AppCompatActivity {

    private TextView tvGreeting,
            tvName,
            tvFname,
            tvLname1,
            tvLname2,
            tvUserBD,
            tvUserAge,
            tvRFC,
            tvZodiac,
            tvHoroscopeC;
    public ImageButton ibtnInfo,ibtnZodiac,ibtnChineseH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_info);

        tvGreeting = findViewById(R.id.tvGreeting);
        tvName =findViewById(R.id.tvName);
        tvFname = findViewById(R.id.tvFname);
        tvLname1 = findViewById(R.id.tvLname1);
        tvLname2 = findViewById(R.id.tvLname2);
        tvUserBD = findViewById(R.id.tvUserBD);
        tvUserAge = findViewById(R.id.tvUserAge);
        tvRFC = findViewById(R.id.tvRFC);
        tvZodiac = findViewById(R.id.tvZodiac);
        tvHoroscopeC=findViewById(R.id.tvHoroscopeC);
        ibtnInfo = findViewById(R.id.ibtnInfo);
        ibtnZodiac = findViewById(R.id.ibtnZodiac);
        ibtnChineseH = findViewById(R.id.ibtnChineseH);

        Bundle bundle =new Bundle();
        bundle= getIntent().getExtras();
        final User usuario = (User) bundle.getSerializable(getResources().getString(R.string.user));
        String greeting = bundle.getString(getResources().getString(R.string.greeting));

        usuario.computeAge();
        usuario.computeRFC();
        computeZodiacSign(usuario);
        computeHoroscopeChinese(usuario);


        Toast.makeText(MainActivity_user_info.this,
                getResources().getString(R.string.correct),Toast.LENGTH_SHORT).show();
        Log.d(getResources().getString(R.string.MA_user_info),
                getResources().getString(R.string.UserInf));

        tvGreeting.setText(greeting+usuario.getFirstName());
        tvName.setText(getResources().getString(R.string.name));
        tvFname.setText(usuario.getFirstName());
        tvLname1.setText(usuario.getLastName1());
        tvLname2.setText(usuario.getLastName2());
        tvUserBD.setText(getResources().getString(R.string.your_bd)+usuario.getDay()+
                getResources().getString(R.string.bar)+
                usuario.getMonth()+getResources().getString(R.string.bar)+
                usuario.getYear());
        tvUserAge.setText(getResources().getString(R.string.user_age)+
                usuario.getUser_age()+
                getResources().getString(R.string.years));
        tvRFC.setText(getResources().getString(R.string.rfc)+usuario.getRfc());
        tvZodiac.setText(getResources().getString(R.string.zodiac_s)+usuario.getZodiac());
        tvHoroscopeC.setText(getResources().getString(R.string.s_horoscope_chin)+usuario.getHoroscope_chin());
        //Log.d(getResources().getString(R.string.MA_user_info), usuario.getRfc());

        ibtnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_user_info.this,getResources().getString(R.string.info),Toast.LENGTH_SHORT).show();
            }
        });

        ibtnZodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_user_info.this,getResources().getString(R.string.characteristic)+usuario.getCharacteristic(),Toast.LENGTH_SHORT).show();
            }
        });

        ibtnChineseH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_user_info.this,getResources().getString(R.string.characteristic)+usuario.getCharacteristic_ch(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void computeZodiacSign(User usuario)
    {
        if((usuario.getMonth()==3 && usuario.getDay()>22)||(usuario.getMonth()==4 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.aries));
            ibtnZodiac.setImageResource(R.drawable.aries);
            usuario.setCharacteristic(getResources().getString(R.string.ariesv));
        }
        if((usuario.getMonth()==4 && usuario.getDay()>22)||(usuario.getMonth()==5 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.taurus));
            ibtnZodiac.setImageResource(R.drawable.tauro);
            usuario.setCharacteristic(getResources().getString(R.string.taurusv));
        }
        if((usuario.getMonth()==5 && usuario.getDay()>22)||(usuario.getMonth()==6 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.gemini));
            ibtnZodiac.setImageResource(R.drawable.geminis);
            usuario.setCharacteristic(getResources().getString(R.string.geminiv));
        }
        if((usuario.getMonth()==6 && usuario.getDay()>22)||(usuario.getMonth()==7 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.cancer));
            ibtnZodiac.setImageResource(R.drawable.cancer);
            usuario.setCharacteristic(getResources().getString(R.string.cancerv));
        }
        if((usuario.getMonth()==7 && usuario.getDay()>22)||(usuario.getMonth()==8 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.leo));
            ibtnZodiac.setImageResource(R.drawable.leo);
            usuario.setCharacteristic(getResources().getString(R.string.leov));
        }
        if((usuario.getMonth()==8 && usuario.getDay()>22)||(usuario.getMonth()==9 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.virgo));
            ibtnZodiac.setImageResource(R.drawable.virgo);
            usuario.setCharacteristic(getResources().getString(R.string.virgov));
        }
        if((usuario.getMonth()==9 && usuario.getDay()>22)||(usuario.getMonth()==10 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.libra));
            ibtnZodiac.setImageResource(R.drawable.libra);
            usuario.setCharacteristic(getResources().getString(R.string.librav));
        }
        if((usuario.getMonth()==10 && usuario.getDay()>22)||(usuario.getMonth()==11 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.scorpio));
            ibtnZodiac.setImageResource(R.drawable.escorpio);
            usuario.setCharacteristic(getResources().getString(R.string.scorpiov));
        }
        if((usuario.getMonth()==11 && usuario.getDay()>22)||(usuario.getMonth()==12 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.sagittarius));
            ibtnZodiac.setImageResource(R.drawable.sagitario);
            usuario.setCharacteristic(getResources().getString(R.string.sagittariusv));
        }
        if((usuario.getMonth()==12 && usuario.getDay()>22)||(usuario.getMonth()==1 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.capricorn));
            ibtnZodiac.setImageResource(R.drawable.capricornio);
            usuario.setCharacteristic(getResources().getString(R.string.capricornv));
        }
        if((usuario.getMonth()==1 && usuario.getDay()>22)||(usuario.getMonth()==2 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.aquiarius));
            ibtnZodiac.setImageResource(R.drawable.acuario);
            usuario.setCharacteristic(getResources().getString(R.string.aquiariusv));
        }
        if((usuario.getMonth()==2 && usuario.getDay()>22)||(usuario.getMonth()==3 && usuario.getDay()<21))
        {
            usuario.setZodiac(getResources().getString(R.string.pisces));
            ibtnZodiac.setImageResource(R.drawable.picis);
            usuario.setCharacteristic(getResources().getString(R.string.piscesv));
        }

    }

    public void computeHoroscopeChinese(User usuario){

        int y,mod;
        y=usuario.getYear();
        mod=y%12;
        switch (mod)
        {
            case 0:
                usuario.setHoroscope_chin(getResources().getString(R.string.monkey));
                ibtnChineseH.setImageResource(R.drawable.monkey);
                usuario.setCharacteristic_ch(getResources().getString(R.string.monkeyv));
                break;
            case 1:
                usuario.setHoroscope_chin(getResources().getString(R.string.rooster));
                ibtnChineseH.setImageResource(R.drawable.rooster);
                usuario.setCharacteristic_ch(getResources().getString(R.string.roosterv));
                break;
            case 2:
                usuario.setHoroscope_chin(getResources().getString(R.string.dog));
                ibtnChineseH.setImageResource(R.drawable.dog);
                usuario.setCharacteristic_ch(getResources().getString(R.string.dogv));
                break;
            case 3:
                usuario.setHoroscope_chin(getResources().getString(R.string.pig));
                ibtnChineseH.setImageResource(R.drawable.pig);
                usuario.setCharacteristic_ch(getResources().getString(R.string.pigv));
                break;
            case 4:
                usuario.setHoroscope_chin(getResources().getString(R.string.rat));
                ibtnChineseH.setImageResource(R.drawable.rat);
                usuario.setCharacteristic_ch(getResources().getString(R.string.ratv));
                break;
            case 5:
                usuario.setHoroscope_chin(getResources().getString(R.string.ox));
                ibtnChineseH.setImageResource(R.drawable.ox);
                usuario.setCharacteristic_ch(getResources().getString(R.string.oxv));
                break;
            case 6:
                usuario.setHoroscope_chin(getResources().getString(R.string.tigger));
                ibtnChineseH.setImageResource(R.drawable.tigger);
                usuario.setCharacteristic_ch(getResources().getString(R.string.tiggerv));
                break;
            case 7:
                usuario.setHoroscope_chin(getResources().getString(R.string.rabbit));
                ibtnChineseH.setImageResource(R.drawable.rabbit);
                usuario.setCharacteristic_ch(getResources().getString(R.string.rabbitv));
                break;
            case 8:
                usuario.setHoroscope_chin(getResources().getString(R.string.dragon));
                ibtnChineseH.setImageResource(R.drawable.dragon);
                usuario.setCharacteristic_ch(getResources().getString(R.string.dragonv));
                break;
            case 9:
                usuario.setHoroscope_chin(getResources().getString(R.string.snake));
                ibtnChineseH.setImageResource(R.drawable.snake);
                usuario.setCharacteristic_ch(getResources().getString(R.string.snakev));
                break;
            case 10:
                usuario.setHoroscope_chin(getResources().getString(R.string.horse));
                ibtnChineseH.setImageResource(R.drawable.horse);
                usuario.setCharacteristic_ch(getResources().getString(R.string.horsev));
                break;
            case 11:
                usuario.setHoroscope_chin(getResources().getString(R.string.goat));
                ibtnChineseH.setImageResource(R.drawable.goat);
                usuario.setCharacteristic_ch(getResources().getString(R.string.goatv));
                break;
            default:
                break;
        }

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
