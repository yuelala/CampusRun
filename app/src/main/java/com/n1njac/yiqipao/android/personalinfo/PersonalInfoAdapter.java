package com.n1njac.yiqipao.android.personalinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.n1njac.yiqipao.android.R;

import java.util.List;

/**
 * Created by huanglei on 2017/2/7.
 */

public class PersonalInfoAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    private Context mContext;
    private List<PersonalItemBean> mPersonalItemBeen;


    public PersonalInfoAdapter(Context context, List<PersonalItemBean> personalItemBeen) {
        this.mContext = context;
        this.mPersonalItemBeen = personalItemBeen;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mPersonalItemBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return mPersonalItemBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.personal_info_item, null);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description_tx);
            viewHolder.content = (TextView) convertView.findViewById(R.id.content_tx);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PersonalItemBean itemBean = mPersonalItemBeen.get(position);
        viewHolder.description.setText(itemBean.getDescription());
        //默认值
        viewHolder.content.setText(itemBean.getContent());

        SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(mContext);
        switch (position){
            case 0:
                String content1 = sf.getString("user_nickname","user");
                viewHolder.content.setText(content1);
                break;
            case 1:
                String content2 = sf.getString("sex","男");
                viewHolder.content.setText(content2);
                break;
            case 2:

                break;


        }


        return convertView;
    }

    class ViewHolder {

        TextView description;
        TextView content;

    }
}