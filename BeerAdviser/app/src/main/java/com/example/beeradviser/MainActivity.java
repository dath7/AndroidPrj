package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
        Spinner color = (Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());
        TextView brands = (TextView) findViewById(R.id.brand);
        ArrayList<String> brandList = expert.getBrands(beerType);
        StringBuilder result = new StringBuilder();
        for (String brand:brandList) {
            result.append(brand).append("\n");
        }
        brands.setText(result);


    }
}