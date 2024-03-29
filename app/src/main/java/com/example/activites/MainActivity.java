package com.example.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    Button btnsent;
    TextView edttxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views after setting the content view
        btnsent = findViewById(R.id.btnsent);
        edttxt = findViewById(R.id.edttxt);

        EdgeToEdge.enable(this);

        btnsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = edttxt.getText().toString();
                if (msg.isEmpty()) {
                    return;
                }
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("Data", msg);
                startActivity(intent);
            }
        });

        // Setting padding for the main layout if it exists
        View mainLayout = findViewById(R.id.main);
        if (mainLayout != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }
}

