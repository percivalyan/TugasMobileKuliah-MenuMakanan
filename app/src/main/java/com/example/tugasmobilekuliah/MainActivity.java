package com.example.tugasmobilekuliah;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int quantityNasi = 0;
    private int quantityBakso = 0;
    private int quantityMie = 0;

    private TextView tvQuantityNasi, tvQuantityBakso, tvQuantityMie;

    // Define prices for each menu item
    private final int priceNasi = 20000; // Price for Nasi Goreng
    private final int priceBakso = 15000; // Price for Bakso
    private final int priceMie = 18000; // Price for Mie Ayam

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuantityNasi = findViewById(R.id.tv_quantity_nasi);
        tvQuantityBakso = findViewById(R.id.tv_quantity_bakso);
        tvQuantityMie = findViewById(R.id.tv_quantity_mie);

        Button btnIncreaseNasi = findViewById(R.id.btn_increase_nasi);
        Button btnDecreaseNasi = findViewById(R.id.btn_decrease_nasi);
        Button btnIncreaseBakso = findViewById(R.id.btn_increase_bakso);
        Button btnDecreaseBakso = findViewById(R.id.btn_decrease_bakso);
        Button btnIncreaseMie = findViewById(R.id.btn_increase_mie);
        Button btnDecreaseMie = findViewById(R.id.btn_decrease_mie);
        Button btnBeli = findViewById(R.id.btn_beli);

        btnIncreaseNasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityNasi++;
                tvQuantityNasi.setText(String.valueOf(quantityNasi));
            }
        });

        btnDecreaseNasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantityNasi > 0) {
                    quantityNasi--;
                    tvQuantityNasi.setText(String.valueOf(quantityNasi));
                }
            }
        });

        btnIncreaseBakso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityBakso++;
                tvQuantityBakso.setText(String.valueOf(quantityBakso));
            }
        });

        btnDecreaseBakso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantityBakso > 0) {
                    quantityBakso--;
                    tvQuantityBakso.setText(String.valueOf(quantityBakso));
                }
            }
        });

        btnIncreaseMie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityMie++;
                tvQuantityMie.setText(String.valueOf(quantityMie));
            }
        });

        btnDecreaseMie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantityMie > 0) {
                    quantityMie--;
                    tvQuantityMie.setText(String.valueOf(quantityMie));
                }
            }
        });

        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calculate the total price
                int totalPrice = (quantityNasi * priceNasi) + (quantityBakso * priceBakso) + (quantityMie * priceMie);

                // Create a dialog to show the order details
                String message = "Pesanan:\n";
                message += "Nasi Goreng: " + quantityNasi + " x " + priceNasi + " = " + (quantityNasi * priceNasi) + "\n";
                message += "Bakso: " + quantityBakso + " x " + priceBakso + " = " + (quantityBakso * priceBakso) + "\n";
                message += "Mie Ayam: " + quantityMie + " x " + priceMie + " = " + (quantityMie * priceMie) + "\n";
                message += "Total: " + totalPrice + "\n";

                // Create an AlertDialog
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Rincian Pembelian")
                        .setMessage(message)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}
