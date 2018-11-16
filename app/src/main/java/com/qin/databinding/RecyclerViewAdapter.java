package com.qin.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qin.databinding.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by qindl
 * on 2018/11/7
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private static final int ON = 0;
    private static final int OFF = 1;
    private List<Person> mPersonList = new ArrayList<>();

    private Context mContext;
    private final LayoutInflater mLayoutInflater;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return i == ON ?
                new BindingViewHolder<>(DataBindingUtil.inflate(mLayoutInflater, R.layout.item_on, viewGroup, false)) :
                new BindingViewHolder<>(DataBindingUtil.inflate(mLayoutInflater, R.layout.item_off, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder viewHolder, int i) {
        viewHolder.getBinding().setVariable(BR.person, mPersonList.get(i));
        viewHolder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ON : OFF;
    }

    public void setData(List<Person> list) {
        mPersonList.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(Person person) {
        mPersonList.add(0,person);
        notifyItemInserted(0);
    }

    public void deleteItem() {
        if (mPersonList.size() == 0)
            return;
        mPersonList.remove(0);
        notifyItemRemoved(0);
    }
}
