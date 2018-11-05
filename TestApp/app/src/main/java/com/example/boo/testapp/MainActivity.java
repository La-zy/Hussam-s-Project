package com.example.boo.testapp;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    int[] IMAGES = {R.drawable.applebees, R.drawable.pullbear, R.drawable.paul};
    String[] OFFERS = {"BUY ONE GET ONE!", "UP TO 50% OFF!" , "SALES UPTO 70%"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        ListView listview = (ListView) findViewById(R.id.Offers_ListView);

        CustomAdapter customAdapter = new MainActivity.CustomAdapter();
        listview.setAdapter(customAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickButton(View v){
        Intent i = new Intent(this, Categories.class);
        startActivity(i);
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
            view = getLayoutInflater().inflate(R.layout.offers_layout, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.Offers_imageView);
            TextView textViewTitle = (TextView) view.findViewById(R.id.Offers_TextView);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.Offers_imageView2);
            TextView textViewTitle2 = (TextView) view.findViewById(R.id.Offers_TextView2);

            imageView.setImageResource(IMAGES[i]);
            textViewTitle.setText(OFFERS[i]);
            imageView2.setImageResource(IMAGES[i]);
            textViewTitle2.setText(OFFERS[i]);
            return view;
        }
    }
}
