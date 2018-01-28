package zx.zw.titlebar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import zx.zw.titlebar.R;
import zx.zw.titlebar.toolbar.NormalTitleBar;
import zx.zw.titlebar.toolbar.base.OnTitleLisenter;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initNormalToolbar();
    }

    private void initNormalToolbar() {
        /**
         * 控件赋值
         *      一般使用左边或者右边只设置文字和图标的一个，不然会重叠
         *  控件点击事件
         *      左边图标一般是返回，所以默认不需要设置点击事件已经有返回的效果
         *      addLisenter添加ClickLis
         */
        new NormalTitleBar.Builder(this)
                .setTitle("普通的Toolbar封装")
                .setLeftIcon(R.mipmap.ic_back)
                .setRightText("右边文字")
                .addListener(new OnTitleLisenter() {
                    @Override
                    public void onRightText() {
                        super.onRightText();
                        Toast.makeText(NormalActivity.this, "右边文字", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
    }
}
