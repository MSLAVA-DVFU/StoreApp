package com.example.storeapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Product> products = new ArrayList<>();

        products.add(new Product(
                "Кожаные лоферы",
                "Лоферы из натуральной кожи. Фигурная союзка с фактурным швом.",
                14999,
                R.drawable.shoes
        ));

        products.add(new Product(
                "Блейзер прямого кроя",
                "Двубортный блейзер на основе лиоцелла и вискозы.",
                2970,
                R.drawable.jacket
        ));

        products.add(new Product(
                "Кардиган из хлопка",
                "Короткие рукава. Застежка на пуговицы.",
                14999,
                R.drawable.t_shirt
        ));

        ProductAdapter adapter = new ProductAdapter(this, products);
        recyclerView.setAdapter(adapter);
    }
}
