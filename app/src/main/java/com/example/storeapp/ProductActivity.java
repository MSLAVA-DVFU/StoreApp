package com.example.storeapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import android.graphics.Color;
import android.widget.Button;
import android.view.View;

public class ProductActivity extends AppCompatActivity {
    private Button selectedSizeButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        ImageView image = findViewById(R.id.detailImage);
        TextView title = findViewById(R.id.detailTitle);
        TextView description = findViewById(R.id.detailDescription);

        Button addToCart = findViewById(R.id.addToCart);

        int[] sizeButtonIds = {
                R.id.sizeXXS,
                R.id.sizeXS,
                R.id.sizeS,
                R.id.sizeM,
                R.id.sizeL,
                R.id.sizeXL
        };

        for (int id : sizeButtonIds) {
            Button sizeButton = findViewById(id);


            sizeButton.setOnClickListener(v -> {

                // Сброс предыдущей кнопки
                if (selectedSizeButton != null) {
                    selectedSizeButton.setBackgroundTintList(
                            android.content.res.ColorStateList.valueOf(Color.parseColor("#E5E5E5")));
                    selectedSizeButton.setTextColor(Color.BLACK);
                }

                // Установка новой выбранной
                sizeButton.setBackgroundTintList(
                        android.content.res.ColorStateList.valueOf(Color.parseColor("#8B5E3C")));
                sizeButton.setTextColor(Color.WHITE);

                selectedSizeButton = sizeButton;
            });
        }

        title.setText(getIntent().getStringExtra("title"));

        int priceValue = getIntent().getIntExtra("price", 0);

        addToCart.setText("В корзину · " + priceValue + " ₽");

        description.setText(getIntent().getStringExtra("description"));

        int imageRes = getIntent().getIntExtra("image", 0);

        image.setImageResource(imageRes);
    }
}
