package com.example.exampractice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    TextView usernameTv,passwordTv;
    Toolbar toolbar;
    public ArrayList<ListData> listData;
    private ListAdapter mAdapter;
    public ListView listView;
    RecyclerView revListData;
    private RecyclerAdapter mRevAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        Intent loginIntent = getIntent();
        usernameTv = findViewById(R.id.home_username);
        passwordTv = findViewById(R.id.home_password);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        usernameTv.setText(loginIntent.getStringExtra(LoginActivity.USERNAME));
        passwordTv.setText(loginIntent.getStringExtra(LoginActivity.PASSWORD));
        listView = findViewById(R.id.listView);
        revListData = findViewById(R.id.recycler_layout);
        listData = new ArrayList<>();

        listData.add(new ListData("Ram","KTM"));
        listData.add(new ListData("Shyam","LTP"));
        mAdapter = new ListAdapter(this,listData);
        listView.setAdapter(mAdapter);

        mRevAdapter = new RecyclerAdapter(this,listData);
        revListData.setLayoutManager(new LinearLayoutManager(this));
        revListData.setAdapter(mRevAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(HomeActivity.this,"Item selected" + (position+1),Toast.LENGTH_SHORT);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this).setTitle("Warring")
                        .setMessage("Do Something")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                               listData.remove(position);
                                mAdapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_res,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_bar:
                listData.add(new ListData("New","address"));
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.always_menu:
                finish();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);

    }
}
