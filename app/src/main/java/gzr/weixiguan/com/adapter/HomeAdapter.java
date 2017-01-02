package gzr.weixiguan.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gzr.weixiguan.com.model.Habit;
import gzr.weixiguan.com.weixiguan.R;

/**
 * Created by guoziren on 2017/1/2.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private List<Habit> mHabitList;
    private Context mContext;
    public HomeAdapter(List<Habit> habits,Context c){
        this.mHabitList = habits;
        mContext = c;
    }
    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(mContext).inflate(R.layout.habit_item,parent,false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.MyViewHolder holder, int position) {
            holder.tv1.setText(mHabitList.get(position).getHabit());
            holder.tv2.setText("已坚持" +mHabitList.get(position).getDays() + "天");
    }

    @Override
    public int getItemCount() {
        return mHabitList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv1;
        TextView tv2;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv_habit);
            tv2 = (TextView) itemView.findViewById(R.id.tv_days);
        }
    }
}
