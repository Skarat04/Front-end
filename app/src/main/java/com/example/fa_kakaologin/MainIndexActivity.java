package com.example.fa_kakaologin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fa_kakaologin.databinding.ActivityMainIndexBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainIndexActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FileAdapter fileAdapter;
    ActivityMainIndexBinding binding;
    BottomNavigationView tab;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 바인딩
        binding = ActivityMainIndexBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        tab = binding.tab;
        menu = tab.getMenu();
        recyclerView = binding.recyclerView;
        List<String> fileList = getFileData();
        fileAdapter = new FileAdapter(fileList);
        recyclerView.setAdapter(fileAdapter);

        tab.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.Contents) {
                    item.setIcon(R.drawable.icon_contents_fill);
                    menu.findItem(R.id.Interest).setIcon(R.drawable.icon_interest_list);
                    menu.findItem(R.id.Search).setIcon(R.drawable.icon_search);
                    menu.findItem(R.id.Copy).setIcon(R.drawable.icon_copy);

                } else if (item.getItemId() == R.id.Interest) {
                    menu.findItem(R.id.Contents).setIcon(R.drawable.icon_contents);
                    item.setIcon(R.drawable.icon_interest_list_fill);
                    menu.findItem(R.id.Search).setIcon(R.drawable.icon_search);
                    menu.findItem(R.id.Copy).setIcon(R.drawable.icon_copy);

                } else if (item.getItemId() == R.id.Search) {
                    menu.findItem(R.id.Contents).setIcon(R.drawable.icon_contents);
                    menu.findItem(R.id.Interest).setIcon(R.drawable.icon_interest_list);
                    item.setIcon(R.drawable.icon_search_fill);
                    menu.findItem(R.id.Copy).setIcon(R.drawable.icon_copy);

                } else if (item.getItemId() == R.id.Copy) {
                    menu.findItem(R.id.Contents).setIcon(R.drawable.icon_contents);
                    menu.findItem(R.id.Interest).setIcon(R.drawable.icon_interest_list);
                    menu.findItem(R.id.Search).setIcon(R.drawable.icon_search);
                    item.setIcon(R.drawable.icon_copy_fill);
                }

                return true;
            }
        });

        // 기본으로 선택할 메뉴 ID를 전달하여 설정
        tab.setSelectedItemId(R.id.Contents);
    }

    private List<String> getFileData() {
        // 실제 데이터를 가져오는 로직
        // + 가상의 데이터가 있다고 가정
        List<String> fileList = new ArrayList<>();
        for (int i=1; i<=20; i++) {
            String string = "파일" + i;
            fileList.add(string);
        }
        return fileList;
    }

}