package zx.zw.titlebar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import zx.zw.titlebar.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvNormal;
    private TextView mTvScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvNormal = (TextView) findViewById(R.id.tv_normal);
        mTvScroll = (TextView) findViewById(R.id.tv_scroll);

        mTvNormal.setOnClickListener(this);
        mTvScroll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_normal:
                startActivity(new Intent(this,NormalActivity.class));
                break;
            case R.id.tv_scroll:
                startActivity(new Intent(this,ScrollActivity.class));
                break;
        }
    }
}
