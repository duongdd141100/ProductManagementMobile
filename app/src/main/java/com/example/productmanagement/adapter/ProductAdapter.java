package com.example.productmanagement.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productmanagement.ProductDetail;
import com.example.productmanagement.R;
import com.example.productmanagement.entity.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> products;
    private Context context;

    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.productName.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    protected class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView productName;

        private ProductAdapter productAdapter;
        public ProductViewHolder(@NonNull View itemView, ProductAdapter productAdapter) {
            super(itemView);
            this.productName = itemView.findViewById(R.id.productName);
            this.productAdapter = productAdapter;
            productName.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Product product = productAdapter.products.get(getAdapterPosition());
            Intent intent = new Intent(context, ProductDetail.class);
            intent.putExtra("product", product);
            context.startActivity(intent);
        }
    }
}
