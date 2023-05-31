package com.example.productmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.productmanagement.adapter.ProductAdapter;
import com.example.productmanagement.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addProducts();

        RecyclerView recyclerView = findViewById(R.id.products);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductAdapter adapter = new ProductAdapter(products, this);
        recyclerView.setAdapter(adapter);

    }

    private void addProducts() {
        for (int i = 0; i < 5; i++) {
            Product product = new Product(i + 1, "Product " + (i + 1));
            products.add(product);
        }
    }
}