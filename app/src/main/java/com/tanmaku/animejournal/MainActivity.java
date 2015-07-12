package com.tanmaku.animejournal;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends ActionBarActivity {
    int a=0;
    ListView mainListView;

    public void addItem(){
        Intent addItemIntent=new Intent(this,AddItemActivity.class);
        startActivity(addItemIntent);
    }

    public void refresh(){
        //mainListView.addHeaderView((TextView)findViewById(R.id.text),true);
        mainListView.setAdapter(mainListAdapter);
    }

//==================================================================================================
    private BaseAdapter mainListAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position + 1;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_main_list, container, false);
            }

            // Because the list item contains multiple touch targets, you should not override
            // onListItemClick. Instead, set a click listener for each target individually.

            convertView.findViewById(R.id.detailArea).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this,
                                    "A",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

            convertView.findViewById(R.id.itemImage).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this,
                                    "B",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
            return convertView;
        }
    };
//==================================================================================================



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainListView=(ListView)findViewById(R.id.main_list);
    }

    @Override
    protected void onResume(){
        super.onResume();

            refresh();
            a++;
            TextView t=(TextView) findViewById(R.id.test);
            t.setText("第"+a+"次被唤醒");



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.action_add_item:
                addItem();
                return true;
            case R.id.action_show_about:
                Intent aboutIntent=new Intent(this,AboutActivity.class);
                startActivity(aboutIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
