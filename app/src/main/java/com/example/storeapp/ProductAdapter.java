package com.example.storeapp;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<Product> products;
    private Button selectedSizeButton = null;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = products.get(position);

        holder.title.setText(product.title);
        holder.description.setText(product.description);
        holder.priceButton.setText(product.price + " ₽");

        holder.priceButton.setVisibility(View.VISIBLE);
        holder.quantityLayout.setVisibility(View.GONE);

        final int[] quantity = {1};

        holder.priceButton.setOnClickListener(v -> {

            holder.priceButton.setVisibility(View.GONE);
            holder.quantityLayout.setVisibility(View.VISIBLE);

            quantity[0] = 1;
            holder.quantityText.setText("1");
        });

        holder.plusBtn.setOnClickListener(v -> {

            quantity[0]++;
            holder.quantityText.setText(String.valueOf(quantity[0]));
        });

        holder.minusBtn.setOnClickListener(v -> {

            if (quantity[0] > 1) {
                quantity[0]--;
                holder.quantityText.setText(String.valueOf(quantity[0]));
            } else {
                holder.quantityLayout.setVisibility(View.GONE);
                holder.priceButton.setVisibility(View.VISIBLE);
            }

        });

        holder.image.setImageResource(product.getImageRes());

        holder.itemView.setOnClickListener(v -> {

            BottomSheetDialog dialog = new BottomSheetDialog(
                    context,
                    com.google.android.material.R.style.Theme_Design_BottomSheetDialog
            );

            View view = LayoutInflater.from(context)
                    .inflate(R.layout.bottom_sheet_product, null);

            dialog.setContentView(view);

            ImageView image = view.findViewById(R.id.detailImage);
            TextView title = view.findViewById(R.id.detailTitle);
            TextView description = view.findViewById(R.id.detailDescription);

            Button addToCart = view.findViewById(R.id.addToCart);

            int[] sizeButtonIds = {
                    R.id.sizeXXS,
                    R.id.sizeXS,
                    R.id.sizeS,
                    R.id.sizeM,
                    R.id.sizeL,
                    R.id.sizeXL
            };

            for (int id : sizeButtonIds) {
                Button sizeButton = view.findViewById(id);


                sizeButton.setOnClickListener(g -> {

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

            image.setImageResource(product.getImageRes());
            title.setText(product.title);
            description.setText(product.detailed_description);

            int priceValue = product.getPrice();
            addToCart.setText("В корзину · " + priceValue + " ₽");


            dialog.show();

            View bottomSheet = dialog.findViewById(
                    com.google.android.material.R.id.design_bottom_sheet);

            if (bottomSheet != null) {

                bottomSheet.setBackground(null);

                BottomSheetBehavior<View> behavior =
                        BottomSheetBehavior.from(bottomSheet);

                int height = context.getResources()
                        .getDisplayMetrics().heightPixels;

                bottomSheet.getLayoutParams().height = (int)(height * 0.9);

                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, description;

        Button priceButton;
        Button plusBtn;
        Button minusBtn;
        TextView quantityText;

        LinearLayout quantityLayout;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.productImage);
            title = itemView.findViewById(R.id.productTitle);
            description = itemView.findViewById(R.id.productDescription);
            priceButton = itemView.findViewById(R.id.priceButton);

            plusBtn = itemView.findViewById(R.id.plusBtn);
            minusBtn = itemView.findViewById(R.id.minusBtn);

            quantityText = itemView.findViewById(R.id.quantityText);

            quantityLayout = itemView.findViewById(R.id.quantityLayout);
        }
    }
}
