package gzr.weixiguan.com.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import gzr.weixiguan.com.adapter.HomeAdapter;
import gzr.weixiguan.com.model.Habit;
import gzr.weixiguan.com.weixiguan.R;

/**
 * Created by guoziren on 2017/1/2.
 */

public class ThinkingFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<Habit> mHabitList;
    private HomeAdapter mHomeAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("onCreate: ");
        initDatas();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.d("onCreateView: ");
        View v = inflater.inflate(R.layout.habit_fragment_layout,container,false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.app_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mHomeAdapter
        );
        return v;
    }
    private void initDatas(){
        mHabitList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Habit habit = new Habit();
            habit.setDays(i);
            habit.setHabit("每天坚持30分钟跑步");
            mHabitList.add(habit);
        }
        mHomeAdapter = new HomeAdapter(mHabitList,getActivity());
    }
}
