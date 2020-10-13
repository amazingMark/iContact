package com.amazing.icontact;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.permission_notify) TextView viewNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        prepare();
    }

    private void prepare() {
        //申请权限
        final RxPermissions rxPermissions = new RxPermissions(this);

        rxPermissions
                .request(
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.READ_SMS,
                        Manifest.permission.CALL_PHONE)
                .subscribe(granted -> {
                    if (granted) {
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    }
//                    else if (permission.shouldShowRequestPermissionRationale){
//
//                    }
                    else {
                        //文字提示需要权限才能运行
                        setNotifyPermission();
                    }
                });

    }

    private void setNotifyPermission() {
        viewNotify.setText(R.string.need_permission);
    }
}