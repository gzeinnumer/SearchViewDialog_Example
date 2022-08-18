package com.gzeinnumer.searchviewdialog_example;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ajithvgiri.searchdialog.SearchListItem;
import com.ajithvgiri.searchdialog.SearchableDialog;
import com.gzeinnumer.svd.dialog.searchViewDialogNew.SearchViewDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_example_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //https://github.com/naseemakhtar994/Search-Dialog-1
                List<SearchListItem> searchListItems = new ArrayList<>();
                SearchableDialog searchableDialog = new SearchableDialog(MainActivity.this, searchListItems, "Title");
                searchableDialog.show();
//                searchableDialog.setOnItemSelected(new OnSearchItemSelected() {
//                    @Override
//                    public void onClick(int position, SearchListItem searchListItem) {
//                        // searchListItem.getId(); returns id
//                        // searchListItem.getTitle(); returns title
//                    }
//                });
            }
        });

        findViewById(R.id.btn_example_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list = new ArrayList<>();
                list.add("Lorem ipsum dolor");
                list.add("sit amet, consectetur");
                list.add("adipiscing elit sed do");

                new SearchViewDialog<String>(getSupportFragmentManager())
                        .setItems(list)
                        .setTitle("ini title")
                        .setContent("ini content")
                        .enableFilter(false)
                        .onOkPressedCallBackSingle((SearchViewDialog.OnOkPressedSingle<String>) data -> {
                            String temp = "Single Select : \n"+data.toString();
                            Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_SHORT).show();
                        })
                        .onCancelPressedCallBack(() -> {
                            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                        })
                        .show();
            }
        });
    }

    
}