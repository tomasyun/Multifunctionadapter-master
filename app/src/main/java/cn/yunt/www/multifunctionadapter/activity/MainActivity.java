package cn.yunt.www.multifunctionadapter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.yunt.www.multifunctionadapter.R;


public class MainActivity extends AppCompatActivity {
    private List<String> mDatas = new ArrayList<>(Arrays.asList("测试1", "测试2", "测试3"));
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.id_listview_list);
        listView.setAdapter(new CommonAdapter<String>(this, R.layout.item_list, mDatas) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.id_item_list_title, s);
            }
        });
    }
}
