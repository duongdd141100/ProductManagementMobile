package com.example.productmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.productmanagement.entity.Product;

public class ProductDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Intent intent = getIntent();
        if (intent != null) {
            Product product = (Product) intent.getSerializableExtra("product");
            TextView idVal = findViewById(R.id.idVal);
            TextView namVal = findViewById(R.id.nameVal);
            idVal.setText(product.getId().toString());
            namVal.setText(product.getName());
        }
    }
}