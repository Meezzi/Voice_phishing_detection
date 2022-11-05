package com.example.YourVoice;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YourVoice.R;
import com.example.YourVoice.ui.List.AddressListViewItem;

import java.util.ArrayList;

public class AddressListViewAdapter extends BaseAdapter {

    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<AddressListViewItem> addressListViewItems = new ArrayList<AddressListViewItem>();

    private ArrayList<String> tel;

    public AddressListViewAdapter(){
    }

    @Override
    public int getCount() {
        return addressListViewItems.size();
    }

    //지정된(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴.
    @Override
    public Object getItem(int position) {
        return addressListViewItems.get(position);
    }

    //지정된 위치에 있는 데이터 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setAddressOnClick(ArrayList tel){
        this.tel = tel;
    }
    //아이템 데이터를 추가를 위한 함수.
    public void addItem(Drawable icon, String name, String number, Drawable addressCalling) {
        AddressListViewItem item = new AddressListViewItem();

        item.setIcon(icon);
        item.setName(name);
        item.setNumber(number);
        item.setAddressCalling(addressCalling);

        addressListViewItems.add(item);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "fragment_address"의 Layout을 inflate하여 convertView 참조 획득?
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fragment_address,parent,false);
        }

        // 화면에 표시될 View(Layout이 inflate 된)으로부터 위젯에 대한 참조 획득
        ImageView profileImageView = convertView.findViewById(R.id.profileImage);
        TextView nameView = convertView.findViewById(R.id.addressName);
        TextView numberView = convertView.findViewById(R.id.addressNum);
        ImageView addressCallingImageView = convertView.findViewById(R.id.addressCalling);

        //Data Set(AddresslistViewItem)에서 position에 위치한 데이터 참조 획득
        AddressListViewItem listViewItem = addressListViewItems.get(position);

        //아이템 내 각 위젯에 데이터 반영
        profileImageView.setImageDrawable(listViewItem.getIcon());
        nameView.setText(listViewItem.getName());
        numberView.setText(listViewItem.getNumber());
        addressCallingImageView.setImageDrawable(listViewItem.getAddressCalling());

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, pos + " 번째 이미지 선택", Toast.LENGTH_SHORT).show();
            }
        });

        // 전화기능
        addressCallingImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, pos + tel.get(pos), Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent("android.intent.action.CALL", Uri.parse(tel.get(pos))));
            }
        });

        return convertView;
    }

}

