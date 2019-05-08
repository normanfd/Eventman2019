package com.example.eventman2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView logistik, konsumsi, konveksi;
    private Button AdminlogoutBtn, checkOrderBtn, maintainProductBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);


        logistik = (ImageView) findViewById(R.id.logistik);
        konsumsi = (ImageView) findViewById(R.id.konsumsi);
        konveksi = (ImageView) findViewById(R.id.konveksi);

        AdminlogoutBtn = (Button) findViewById(R.id.admin_logout_btn);
        checkOrderBtn = (Button) findViewById(R.id.admin_check_order_btn);
        maintainProductBtn = (Button) findViewById(R.id.maintain_btn);

        AdminlogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        checkOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminNewOrderActivity.class);
                startActivity(intent);
            }
        });

        maintainProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, HomeActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);
            }
        });

        logistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddLogistikActivity.class);
                intent.putExtra("category", "logistik");
                startActivity(intent);
            }
        });

        konveksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AdminCategoryActivity.this, AddKonveksiActivity.class);
                intent.putExtra("category", "konveksi");
                startActivity(intent);
            }
        });

        konsumsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AdminCategoryActivity.this, AddKonsumsiActivity.class);
                intent.putExtra("category", "konsumsi");
                startActivity(intent);
            }
        });

    }
}
