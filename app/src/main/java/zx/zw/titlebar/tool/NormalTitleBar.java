package zx.zw.titlebar.tool;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import zx.zw.titlebar.R;

/**
 * @author zxKueen 2018/1/27 1:07
 *         email 4994766@qq.com
 */
public class NormalTitleBar extends BaseTitleBar{

    public NormalTitleBar(Builder builder) {
        super(builder);
    }

    @Override
    protected int bindLayout() {
        return R.layout.item_normal_toolbar;
    }

    @Override
    protected void bindView() {
        setText(R.id.tv_title,mBuilder.mTitle);
        setText(R.id.tv_left,mBuilder.mLeftText);
        setText(R.id.tv_right,mBuilder.mRightText);

        setIcon(R.id.iv_left,mBuilder.mLeftIcon);
        setIcon(R.id.iv_right,mBuilder.mRightIcon);

        setClickListener(R.id.iv_left);
        setClickListener(R.id.iv_right);
        setClickListener(R.id.tv_right);
        setClickListener(R.id.tv_left);
    }

    /**
     * 控件添加点击事件
     * @param id
     */
    private void setClickListener(int id) {

        mBuilder.mParent.findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.tv_left:
                        if(mBuilder.mListener!=null){
                            mBuilder.mListener.onLeftText();
                        }
                        break;
                    case R.id.tv_right:
                        if(mBuilder.mListener!=null) {
                            mBuilder.mListener.onRightText();
                        }
                        break;
                    case R.id.iv_left:
                        if(mBuilder.mListener!=null) {
                            mBuilder.mListener.onLeftIcon();
                        } else{
                            //默认是返回
                            ((Activity)mBuilder.mContext).finish();
                        }
                        break;
                    case R.id.iv_right:
                        if(mBuilder.mListener!=null) {
                            mBuilder.mListener.onRightIcon();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public static class Builder extends BaseTitleBar.Builder{

        public Builder(Context context) {
            super(context,null);
        }

        public Builder(Context context, ViewGroup parent) {
            super(context,parent);
        }

        @Override
        public BaseTitleBar build() {
            return new NormalTitleBar(this);
        }
    }
}
