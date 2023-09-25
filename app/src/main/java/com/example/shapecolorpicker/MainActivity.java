package com.example.shapecolorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner shapeSpinner;
    private ImageView shapeView;
    private TextView rgbText;
    private SeekBar rPicker;
    private SeekBar gPicker;
    private SeekBar bPicker;

    private String changeTxt;

    private void changeColor(){
        shapeView = findViewById(R.id.shapeView);
        rgbText = findViewById(R.id.rgbText);
        rPicker = findViewById(R.id.rPicker);
        gPicker = findViewById(R.id.gPicker);
        bPicker = findViewById(R.id.bPicker);

        changeTxt = "RGB(" + rPicker.getProgress() + "," + gPicker.getProgress() + "," + bPicker.getProgress() + ")";

        rgbText.setText(changeTxt);

        shapeView.setColorFilter(Color.rgb(rPicker.getProgress(), gPicker.getProgress(), bPicker.getProgress()));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shapeSpinner = findViewById(R.id.shapeSpinner);
        shapeView = findViewById(R.id.shapeView);
        rgbText = findViewById(R.id.rgbText);
        rPicker = findViewById(R.id.rPicker);
        gPicker = findViewById(R.id.gPicker);
        bPicker = findViewById(R.id.bPicker);

        changeTxt = "RGB(255,255,255)";

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.shapes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shapeSpinner.setAdapter(adapter);

        shapeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(((String)shapeSpinner.getSelectedItem()).equals("square")){
                    shapeView.setImageResource(R.drawable.square);
                }
                else if (((String)shapeSpinner.getSelectedItem()).equals("triangle")) {
                    shapeView.setImageResource(R.drawable.triangle);
                }
                else{
                    shapeView.setImageResource(R.drawable.circle);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                shapeView.setImageResource(R.drawable.circle);
            }
        });

        rPicker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        gPicker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        bPicker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}