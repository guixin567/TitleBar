package zx.zw.titlebar.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zx.zw.titlebar.R;

/**
 * @author zxKueen 2018/1/29 1:40
 *         email 4994766@qq.com
 */
public class ScrollAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public ScrollAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
       helper.setText(R.id.tv_scroll,item);
    }
}
