package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private LineView mLineView;
    BuildingDemo bldg;
    private int floor = 0;
    String destText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView = findViewById(R.id.floorImage);
        mLineView = findViewById(R.id.lineView);
        TextView textView = findViewById(R.id.textView9);
        Button button = findViewById(R.id.button2);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y - 160;

        // Here there should be an if depending on what map you want
        // -->
        bldg = new BuildingDemo();

        // <--

        Bundle mainData = getIntent().getExtras();
        destText = mainData.getString("destination");
        floor = mainData.getInt("floor");

        if (floor == 0) {
            imageView.setImageResource(R.drawable.groundfloor_test2);
        } else {
            imageView.setImageResource(R.drawable.test_2);
        }

        int src = bldg.startPoint[floor];
        int dest;

        if (floor == bldg.Floor.get(destText)) {
            LineView.paint.setColor(Color.parseColor("#ffff00"));
            button.setText("Finish");
            textView.setText("Path to " + destText);
            dest = bldg.Rooms.get(destText);
        } else {
            LineView.paint.setColor(Color.parseColor("#8627c3"));
            button.setText("Next");
            textView.setText("Take elevator to " + bldg.Floor.get(destText).toString() + " floor");
            dest = bldg.Rooms.get("elevator");
        }

        GRH.solve(bldg.graph, src, dest, mLineView, height, width, bldg.nodes);
    }

    public void onClick (View view) {
        if (floor == bldg.Floor.get(destText)) {
            this.finish();
            return;
        }

        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("destination", destText);
        i.putExtra("floor", bldg.Floor.get(destText));
        startActivity(i);
        this.finish();
    }
}
