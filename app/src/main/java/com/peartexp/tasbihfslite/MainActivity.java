package com.peartexp.tasbihfslite;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView marque;
    Button sub, reset, count;
    TextView view;

    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        marque = findViewById(R.id.marqueeText);
        view = findViewById(R.id.view);
        sub = findViewById(R.id.sub01);
        reset = findViewById(R.id.reset01);
        count = findViewById(R.id.count01);

        // Enable marquee effect
        marque.setSelected(true);

        // Set OnClickListener for sub button
        sub.setOnClickListener(v -> {
            x=x-1;
            view.setText(String.valueOf(x));
        });

        // Set OnClickListener for reset button
        reset.setOnClickListener(v -> {
            x = 0;
            view.setText(String.valueOf(x));
            Toast.makeText(MainActivity.this, "Counter reset to 0", Toast.LENGTH_SHORT).show();
        });

        // Set OnClickListener for count button
        count.setOnClickListener(v -> {
            x=x+1;
            view.setText(String.valueOf(x));
        });
    }
}
