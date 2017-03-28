package cn.yunt.www.multifunctionadapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;

    public ViewHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        this.mConvertView = itemView;
        mViews = new SparseArray<>();
    }

    public static ViewHolder createViewHolder(Context context, View itemView) {
        ViewHolder viewHolder = new ViewHolder(context, itemView);
        return viewHolder;
    }

    public static ViewHolder createViewHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        ViewHolder viewHolder = new ViewHolder(context, itemView);
        return viewHolder;
    }

    /**
     * 根据viewId得到view
     *
     * @param viewTd
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewTd) {
        View view = mViews.get(viewTd);
        if (view == null) {
            view = mConvertView.findViewById(viewTd);
            mViews.put(viewTd, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;

    }
    /****以下为辅助方法*****/

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text)
    {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }
}
