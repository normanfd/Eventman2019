package com.example.eventman2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class AdminMaintenanceActivity extends AppCompatActivity {

    private Button applyChangesBtn, delProductBtn;
    private EditText name, price, desc;
    private ImageView imageView;

    private String productID = "";
    private DatabaseReference productRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_maintenance);

        productID =getIntent().getStringExtra("pid");
        productRef = FirebaseDatabase.getInstance().getReference().child("Products").child(productID);

        applyChangesBtn = findViewById(R.id.apply_chg_btn);
        name = findViewById(R.id.product_name_maintain);
        price = findViewById(R.id.product_price_maintain);
        desc = findViewById(R.id.product_desc_maintain);
        imageView = findViewById(R.id.product_image_maintain);
        delProductBtn = findViewById(R.id.delete_product_btn);
        
        displaySpesificProductInfo();

        applyChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyChanges();
            }
        });

        delProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteThisProduct();
            }
        });

    }

    private void deleteThisProduct() {
        productRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(AdminMaintenanceActivity.this,"Product deleted succesfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void applyChanges() {
        String pNname = name.getText().toString();
        String pPrice = price.getText().toString();
        String pDesc = desc.getText().toString();

        if (pNname.equals("")){
            Toast.makeText(this,"Write down product name", Toast.LENGTH_SHORT).show();
        }
        else if (pPrice.equals("")){
            Toast.makeText(this,"Write down product price", Toast.LENGTH_SHORT).show();

        }
        else if (pDesc.equals("")){
            Toast.makeText(this,"Write down product description", Toast.LENGTH_SHORT).show();

        }
        else {
            HashMap<String, Object> ProductMap = new HashMap<>();
            ProductMap.put("pid", productID);
            ProductMap.put("description", pDesc);
            ProductMap.put("price",pPrice);
            ProductMap.put("productname", pNname);

            productRef.updateChildren(ProductMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(AdminMaintenanceActivity.this, "Change succesfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(AdminMaintenanceActivity.this,AdminCategoryActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }

    private void displaySpesificProductInfo() {
        productRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String pName = dataSnapshot.child("productname").getValue().toString();
                    String pPrice = dataSnapshot.child("price").getValue().toString();
                    String pDesc = dataSnapshot.child("description").getValue().toString();
                    String pImage = dataSnapshot.child("image").getValue().toString();

                    name.setText(pName);
                    price.setText(pPrice);
                    desc.setText(pDesc);
                    Picasso.get().load(pImage).into(imageView);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
