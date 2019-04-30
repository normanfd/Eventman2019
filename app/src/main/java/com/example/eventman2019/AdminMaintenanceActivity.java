package com.example.eventman2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AdminMaintenanceActivity extends AppCompatActivity {

    private Button applyChangesBtn;
    private EditText name, price, desc;
    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_maintenance);

        applyChangesBtn = findViewById(R.id.apply_chg_btn);
        name = findViewById(R.id.product_name_maintain);
        price = findViewById(R.id.product_price_maintain);
        desc = findViewById(R.id.product_desc_maintain);
        imageView = findViewById(R.id.product_image_maintain);

    }
}
