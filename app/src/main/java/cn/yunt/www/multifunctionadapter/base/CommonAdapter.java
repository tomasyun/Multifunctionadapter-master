package cn.yunt.www.multifunctionadapter.base;


import android.content.Context;
import android.view.LayoutInflater;

import java.util.List;

public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {
    private Context mContext;
    private List<T> mDatas;
    private int mLayoutId;
    private LayoutInflater mInflater;

    public CommonAdapter(Context context, final int layoutId, final List<T> data) {
        super(context, data);
        this.mContext = context;
        mLayoutId = layoutId;
        mDatas = data;
        mInflater = LayoutInflater.from(context);
        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T t, int position) {
                return false;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);
}
