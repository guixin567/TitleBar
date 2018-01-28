package zx.zw.titlebar.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import zx.zw.titlebar.R;
import zx.zw.titlebar.adapter.ScrollAdapter;
import zx.zw.titlebar.tool.ScrollTitleBar;

public class ScrollActivity extends AppCompatActivity {

    private RecyclerView mRvScroll;
    private CoordinatorLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        initView();
        initToolbar();
        initAdater();
    }

    private void initView() {
        mRvScroll = findViewById(R.id.rv);
        mContainer = findViewById(R.id.container);
    }

    private void initAdater() {
        ArrayList<String> mDatas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mDatas.add("滚动标记，滚动行为"+i);
        }
        ScrollAdapter scrollAdapter = new ScrollAdapter(R.layout.item_scroll, mDatas);
        mRvScroll.setLayoutManager(new LinearLayoutManager(this));
        mRvScroll.setAdapter(scrollAdapter);
    }

    private void initToolbar() {
        //
        new ScrollTitleBar.Builder(this,mContainer)
                .setTitle("可折叠的Toolbar")
                .setLeftIcon(R.mipmap.ic_back)
                .build();
    }
}
