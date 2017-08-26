package com.devman.neo.realcatch;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.devman.neo.realcatch.common.DML;
import com.devman.neo.realcatch.common.DataBaseManager;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    EditText mainSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.confirmPermission();//confirm permission

        //database
        DataBaseManager dataBaseManager = DataBaseManager.getInstance(this);
        database = dataBaseManager.getWritableDatabase();

        mainSender = (EditText)findViewById(R.id.mainSender);

        /**
         * 필터링 목록 조회
         */
        findViewById(R.id.mainListBt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /**
         * 입력한 발신번호 필터링으로 추가
         */
        findViewById(R.id.mainAddBt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sSender = mainSender.getText().toString();
                Log.d("MYLOG", "sSender : " + sSender);
                if ("".equals(sSender)) {
                    Toast.makeText(getApplicationContext(), "발신번호를 입력 하세요.", Toast.LENGTH_SHORT).show();
                    mainSender.setFocusable(true);
                } else {
                    database.execSQL(DML.insertFilterNumber(), new Object[]{sSender});
                    Toast.makeText(getApplicationContext(), sSender + " 번호가 추가 되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Permission
     */
    private void confirmPermission(){
        //SMS Confirm
        int receiveSms = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);

        if (!(receiveSms == PackageManager.PERMISSION_GRANTED)) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS)) {
                //Toast.makeText(this, "SMS 수신권한 설명 필요함.", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, 1);
            }
        }
    }
}
