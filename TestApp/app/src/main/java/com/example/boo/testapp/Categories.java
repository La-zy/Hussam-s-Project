package com.example.boo.testapp;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Categories extends AppCompatActivity {

    int[] IMAGES = {R.drawable.restaurants, R.drawable.hotel};
    String[] TITLES = {"Restaurants", "Hotels"};
    String[] DESCRIPTIONS = {"Fast Food, Arabic Food, Italian Food. Find offers in your favourite restaurant now!",
                            "Book a room in one of Qatar Hotels at the perfect time with the perfect offer!"};

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ListView listview = (ListView) findViewById(R.id.ListView);

        CustomAdapter customAdapter = new CustomAdapter();
        listview.setAdapter(customAdapter);

        ///////

        mDrawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textViewTitle = (TextView) view.findViewById(R.id.textView_title);
            TextView textViewDesc = (TextView) view.findViewById(R.id.textView_description);

            imageView.setImageResource(IMAGES[i]);
            textViewTitle.setText(TITLES[i]);
            textViewDesc.setText(DESCRIPTIONS[i]);

            return view;
        }
    }
}
