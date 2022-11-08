package com.example.YourVoice.ui.MyPage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.YourVoice.R;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.CustomViewHolder> {

    private ArrayList<PersonalData> mList = null;
    private Activity context = null;


    public UsersAdapter(Activity context, ArrayList<PersonalData> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView user_name;
        protected TextView user_email;
        protected TextView user_phone;
        protected TextView user_area;


        public CustomViewHolder(View view) {
            super(view);
            this.user_name = (TextView) view.findViewById(R.id.textView_list_name);
            this.user_email = (TextView) view.findViewById(R.id.textView_list_email);
            this.user_phone = (TextView) view.findViewById(R.id.textView_list_phone);
            this.user_area = (TextView) view.findViewById(R.id.textView_list_area);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.user_name.setText(mList.get(position).getuser_name());
        viewholder.user_email.setText(mList.get(position).getuser_email());
        viewholder.user_phone.setText(mList.get(position).getuser_phone());
        viewholder.user_area.setText(mList.get(position).getuser_area());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}

