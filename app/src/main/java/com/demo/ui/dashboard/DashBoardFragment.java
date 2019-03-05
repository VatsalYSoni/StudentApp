package com.demo.ui.dashboard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.demo.R;
import com.demo.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

//import com.google.android.gms.location.LocationServices;


public class DashBoardFragment extends BaseFragment implements DashBoardContract.DView {

    private Context context;
    private LinearLayout llHome;
    private ArrayList<String> arrayList;
    int col = 3;
    int colsize = 170;
    int rowSize = 170;

    public String[] mThumbIds = {"About Institute", "Contact", "Returnable", "Issue", "Result", "Assignment", "Notice", "Notification"};

    @Inject
    public DashBoardContract.Presenter<DashBoardContract.DView> mPresenter;

    @Override
    protected int layoutResId() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected String name() {
        return "DashBoard";
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mPresenter.onStart();
        setUpUIControl(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.setToolbar();
    }


    public void setUpUIControl(View view) {

//        GridView gridView = view.findViewById(R.id.gridView);
//        gridView.setAdapter(new DashBoardTestAdapter(getContext()));

        llHome = (LinearLayout) view.findViewById(R.id.llHome);
        design();
    }

    @Override
    public void onBack() {
        mPresenter.openDrawer();
    }

    @Override
    public void onProfile() {

    }

    @Override
    public void onNotification() {
    }

    private void design() {
        arrayList = new ArrayList<String>(Arrays.asList(mThumbIds));
        int count = arrayList.size();
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        Drawable d = ResourcesCompat.getDrawable(getResources(), R.mipmap.ic_launcher, null);
        int w = d.getIntrinsicWidth();

        colsize = (w + w + w);
        col = width / colsize;

        int k = 0;
        int row = arrayList.size() / col;

        if (arrayList.size() > 0) {
            if (count > 0)
                llHome.removeAllViews();

            for (int i = 0; i < row; i++) {
                LinearLayout llrow1 = new LinearLayout(getContext());
                llrow1.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) (height / 4.5));

                for (int j = 1; j <= col; j++) {
                    LinearLayout.LayoutParams LLbcard = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
                    LLbcard.setMargins(10, 10, 10, 10);
                    final CardView card = new CardView(getContext());
                    card.setCardBackgroundColor(Color.TRANSPARENT);
                    card.setRadius(5f);

                    final TextView b1 = new TextView(getContext());
                    b1.setGravity(Gravity.CENTER);
                    b1.setPadding(10, 10, 15, 10);
                    b1.setBackgroundResource(R.color.halfTrans);
                    b1.setText(arrayList.get(k));
                    b1.setTextSize(26);
                    b1.setTextColor(Color.WHITE);
                    b1.setTypeface(b1.getTypeface(), Typeface.BOLD);
                    b1.setId(k);
                    k++;
                    card.addView(b1);
                    llrow1.addView(card, LLbcard);
                }
                llHome.addView(llrow1, LLParams);
            }
        } else {
            if (count > 0)
                llHome.removeAllViews();
        }
    }
}