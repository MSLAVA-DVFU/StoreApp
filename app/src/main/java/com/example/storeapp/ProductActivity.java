package com.example.storeapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.widget.Button;


public class ProductActivity extends AppCompatActivity {
    private Button selectedSizeButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_product);

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


                if (selectedSizeButton != null) {
                    selectedSizeButton.setBackgroundTintList(
                            android.content.res.ColorStateList.valueOf(Color.parseColor("#F6F6F6")));
                    selectedSizeButton.setTextColor(Color.BLACK);
                }


                sizeButton.setBackgroundTintList(
                        android.content.res.ColorStateList.valueOf(Color.parseColor("#623A29")));
                sizeButton.setTextColor(Color.WHITE);

                selectedSizeButton = sizeButton;
            });
        }

        title.setText(getIntent().getStringExtra("title"));

        int priceValue = getIntent().getIntExtra("price", 0);

        addToCart.setText("В корзину · " + priceValue + " ₽");

        description.setText(getIntent().getStringExtra("detailed_description"));

        int imageRes = getIntent().getIntExtra("image", 0);

        image.setImageResource(imageRes);
    }
}
