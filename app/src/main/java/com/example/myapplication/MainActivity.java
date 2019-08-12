package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    String destText;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Indoor Navigation");

        searchView = findViewById(R.id.destinationSearch);

        int id = searchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);
        TextView textView = searchView.findViewById(id);
        textView.setTextColor(Color.WHITE);
        searchView.setQueryHint(Html.fromHtml("<font color = #ffffff>" +
                getResources().getString(R.string.searchText) + "</font>"));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                destText = query;
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                return false;
            }
        });
    }

    public void onClickBack (View view) {
        this.finish();
    }

    public void onClick (View view) {
        Intent i = new Intent(this, Main2Activity.class);

        i.putExtra("destination", destText);
        i.putExtra("floor", 0);

        startActivity(i);
    }
}
