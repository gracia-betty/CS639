package com.example.midtermproj;// ConversionActivity.java
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConversionActivity extends AppCompatActivity {

    private EditText metersInput;
    private TextView millimetersOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        metersInput = findViewById(R.id.metersInput);
        Button convertButton = findViewById(R.id.convertButton);
        millimetersOutput = findViewById(R.id.millimetersOutput);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertMetersToMillimeters();
            }
        });
    }

    private void convertMetersToMillimeters() {
        String metersText = metersInput.getText().toString();
        if (!metersText.isEmpty()) {
            try {
                double meters = Double.parseDouble(metersText);
                double millimeters = meters * 1000;
                millimetersOutput.setText("Millimeters: " + millimeters);
            } catch (NumberFormatException e) {
                millimetersOutput.setText("Invalid input");
            }
        } else {
            millimetersOutput.setText("Please enter a value");
        }
    }
}
