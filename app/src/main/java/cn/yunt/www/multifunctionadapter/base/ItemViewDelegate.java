package cn.yunt.www.multifunctionadapter.base;


public interface ItemViewDelegate<T> {
    int getItemViewLayoutId();

    boolean isForViewType(T t, int position);

    void convert(ViewHolder holder, T t, int position);
}
