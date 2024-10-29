package vn.edu.fpt.learningquizapp.chaptertopics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import vn.edu.fpt.learningquizapp.R;

public class TopicActivity extends AppCompatActivity {

    Toolbar toolbar;
    GridView gridView;
    ImageView topicImageView;

    String topicName [] = {"Slot 1", "Slot 2","Slot 3", "Slot 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);



        toolbar = findViewById(R.id.toolbar);
        gridView = findViewById(R.id.topics_name);
        topicImageView = findViewById(R.id.topic_image_view);

        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Get data from intent
        String title = getIntent().getStringExtra("TITLE");
        int imageResId = getIntent().getIntExtra("IMAGE_RES_ID", R.drawable.nodeexpress);

        // Set the title and image
        if (title != null) {
            getSupportActionBar().setTitle(title);
        }
        topicImageView.setImageResource(imageResId);

        TopicAdapter adapter = new TopicAdapter(topicName, TopicActivity.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(TopicActivity.this, topicName[i], Toast.LENGTH_SHORT).show();
            }
        });

    }
}