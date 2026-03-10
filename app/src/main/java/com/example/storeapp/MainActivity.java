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
                "Лоферы из мягкой натуральной кожи. Модель с фигурной союзкой и декоративным фактурным швом. Удобная колодка и нескользящая подошва делают их идеальными для повседневной носки.",
                14999,
                R.drawable.shoes
        ));

        products.add(new Product(
                "Блейзер прямого кроя",
                "Двубортный блейзер на основе лиоцелла и вискозы.",
                "Элегантный двубортный блейзер прямого кроя. Выполнен на основе благородного лиоцелла и вискозы, благодаря чему ткань идеально драпируется и «дышит». Классические лацканы и притачной рукав создают безупречный силуэт.",
                2970,
                R.drawable.jacket
        ));

        products.add(new Product(
                "Брюки из лиоцелла",
                "Брюки прямого кроя из ткани.",
                "Прямые брюки из премиального лиоцелла — идеальный выбор для комфорта и стиля. Ткань приятна к телу, обладает высокой воздухопроницаемостью и практически не мнется. Модель на поясе с шлевками, застежка на молнию.",
                6999,
                R.drawable.pants
        ));

        products.add(new Product(
                "Кардиган из хлопка",
                "Короткие рукава. Застежка на пуговицы.",
                "Легкий хлопковый кардиган с коротким рукавом. Удлиненная модель на удобной застежке на пуговицы. Мягкая фактура вязаного полотна и мягкий край делают его идеальным вариантом для прохладных вечеров или офиса с кондиционированием.",
                14999,
                R.drawable.t_shirt
        ));

        products.add(new Product(
                "Джинсы straight fit",
                "Пять карманов.",
                "Классические джинсы прямого кроя (straight fit). Посадка по фигуре, традиционная конструкция с пятью карманами. Универсальная модель из плотного хлопка, которая подчеркнет достоинства любой фигуры.",
                6999,
                R.drawable.jeans
        ));

        ProductAdapter adapter = new ProductAdapter(this, products);
        recyclerView.setAdapter(adapter);
    }
}
