package zx.zw.titlebar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import zx.zw.titlebar.R;
import zx.zw.titlebar.tool.NormalTitleBar;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initNormalToolbar();
    }

    private void initNormalToolbar() {
        new NormalTitleBar.Builder(this)
                .setTitle("普通的Toolbar封装")
                .setLeftIcon(R.mipmap.ic_back)
                .build();
    }
}
