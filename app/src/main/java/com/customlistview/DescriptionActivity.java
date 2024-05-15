package com.customlistview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_layout);

        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        int imageResId = getIntent().getIntExtra("image", -1);

        TextView characterName = findViewById(R.id.characterName);
        TextView characterDescription = findViewById(R.id.characDescript);
        ImageView characterImage = findViewById(R.id.characterImage);

        characterName.setText(name.toUpperCase());
        characterDescription.setText(description);
        if (imageResId != -1) {
            characterImage.setImageResource(imageResId);
        }

        findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());
    }
}
