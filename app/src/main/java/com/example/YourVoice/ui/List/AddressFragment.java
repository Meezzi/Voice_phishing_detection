package com.example.YourVoice.ui.List;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.YourVoice.MainActivity;
import com.example.YourVoice.R;

import java.util.ArrayList;

public class AddressFragment extends ListFragment {

    com.example.YourVoice.AddressListViewAdapter adapter;

    private ArrayList phoneNameList;
    private ArrayList<String> phoneNumberList;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }

    public AddressFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Adapter 생성 및 Adapter 지정
        adapter = new com.example.YourVoice.AddressListViewAdapter();
        setListAdapter(adapter);//어뎁터 연결

        phoneNameList = ((MainActivity)getActivity()).getNames();
        phoneNumberList = ((MainActivity)getActivity()).getNumbers();

        ArrayList<String> tel = new ArrayList();
        for(int i = 0; i<phoneNumberList.size();i++) {
            tel.add("tel:" + phoneNumberList.get(i));
        }

        // 아이템 추가
        for(int i = 0; i<phoneNumberList.size();i++){
            adapter.setAddressOnClick(tel);

            adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_profile),
                    phoneNameList.get(i).toString(),
                    phoneNumberList.get(i),
                    ContextCompat.getDrawable(getActivity(), R.drawable.dial_calling_black));
        }


        //return inflater.inflate(R.layout.fragment_address, container, false);
        return super.onCreateView(inflater, container,savedInstanceState);
    }




}
