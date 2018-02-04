package com.example.user.kakaotalk;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.user.kakaotalk.Adapter.ListViewAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2,btn3;

    private ListView listView;
    private ListViewAdapter adapter;
    private int[] img = {R.drawable.profile, R.drawable.cho, R.drawable.park,R.drawable.sooji,
    R.drawable.lee,R.drawable.shin};
    private String[] Title = {"손덕현","조성윤","박보검","수지","혜리","신민아"};
    private String[] Context = {"잘생김", "잘생김", "잘생김","이쁨","이쁨","이쁨"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ListViewAdapter();
        listView = (ListView) findViewById(R.id.List_View);

        listView.setAdapter(adapter);
        for (int i = 0; i < img.length; i++) {
            adapter.addVO(ContextCompat.getDrawable(this, img[i]), Title[i], Context[i]);
        }
        btn1 = findViewById(R.id.listButton);
        btn2 = findViewById(R.id.chatButton);
        btn3 = findViewById(R.id.settingButton);

        btn1.setOnClickListener(this.onClick);
        btn2.setOnClickListener(this.onClick);
        btn3.setOnClickListener(this.onClick);
    }

    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment1 fragment1 = new Fragment1();
            Fragment2 fragment2 = new Fragment2();
            Fragment3 fragment3 = new Fragment3();

            switch (view.getId()) {
                case R.id.listButton:
                    fragmentTransaction.replace(R.id.fragment, fragment1);
                    break;
                case R.id.chatButton:
                    fragmentTransaction.replace(R.id.fragment, fragment2);
                    break;
                case R.id.settingButton:
                    fragmentTransaction.replace(R.id.fragment,fragment3);
            }

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    };
}
