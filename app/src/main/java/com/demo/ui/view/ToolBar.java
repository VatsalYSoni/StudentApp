package com.demo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.demo.R;
import com.demo.ui.base.BaseView;
import com.tooltip.Tooltip;


public class ToolBar extends Toolbar {

    public static final int MAIN = 0;
    public static final int REGISTER = 1;
    public static final int FORGOT_PASSWORD = 2;
    public static final int DASHBOARD = 3;
    public static final int OTHER_FRAGMENT = 4;
    public static final int MY_MESSAGE = 5;

    private String title;
    private int visibility;
    private ToolTipClickListener toolTipClickListener;
    private Tooltip tooltip;


    public ToolBar(Context context) {
        super(context);
        setView(context);
    }

    public ToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setView(context);
    }

    public ToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setView(context);
    }

    public void setView(Context context) {
        removeAllViews();
        setPadding(0, 0, 0, 0);
        setContentInsetsAbsolute(0, 0);
        View toolView = LayoutInflater.from(context).inflate(R.layout.custom_toolbar, null);
        addView(toolView);
    }

    public void setToolBarType(int type) {
        View view = getRootView();
        TextView tvBack = view.findViewById(R.id.action_back);
        TextView tvMenu = view.findViewById(R.id.action_menu);
        TextView tvTitle = view.findViewById(R.id.action_title);
        TextView tvNotificationBadge = view.findViewById(R.id.action_notification_badge);
        TextView tvNotification = view.findViewById(R.id.action_notification);
        ImageView ivProfile = view.findViewById(R.id.action_Profile);
        switch (type) {
            case MAIN:
                tvBack.setVisibility(GONE);
                tvTitle.setVisibility(VISIBLE);
                tvTitle.setText(title);
                tvMenu.setVisibility(GONE);
                tvNotificationBadge.setVisibility(GONE);
                tvNotification.setVisibility(View.INVISIBLE);
                ivProfile.setVisibility(View.INVISIBLE);
                break;
            case REGISTER:
                tvMenu.setVisibility(GONE);
                tvBack.setVisibility(VISIBLE);
                tvNotificationBadge.setVisibility(GONE);
                tvBack.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.back_arrow, 0, 0, 0);
                tvTitle.setVisibility(VISIBLE);
                tvTitle.setText(title);
                tvNotification.setVisibility(View.INVISIBLE);
                ivProfile.setVisibility(View.INVISIBLE);
                break;
            case FORGOT_PASSWORD:
                tvMenu.setVisibility(GONE);
                tvBack.setVisibility(VISIBLE);
                tvNotificationBadge.setVisibility(GONE);
                tvBack.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.back_arrow, 0, 0, 0);
                tvTitle.setVisibility(VISIBLE);
                tvTitle.setText(title);
                tvNotification.setVisibility(View.INVISIBLE);
                ivProfile.setVisibility(View.INVISIBLE);
                break;
            case DASHBOARD:
                tvMenu.setVisibility(VISIBLE);
                tvBack.setVisibility(GONE);
                tvNotificationBadge.setVisibility(GONE);
                tvBack.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.menu, 0, 0, 0);
                tvTitle.setVisibility(VISIBLE);
                tvTitle.setText(title);
                tvNotification.setVisibility(View.INVISIBLE);
                ivProfile.setVisibility(View.INVISIBLE);
                break;
            case OTHER_FRAGMENT:
                tvMenu.setVisibility(GONE);
                tvBack.setVisibility(VISIBLE);
                tvNotificationBadge.setVisibility(GONE);
                tvBack.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.back_arrow, 0, 0, 0);
                tvTitle.setVisibility(VISIBLE);
                tvTitle.setText(title);
                tvNotification.setVisibility(View.INVISIBLE);
                ivProfile.setVisibility(View.INVISIBLE);
                break;
            case MY_MESSAGE:
                tvMenu.setVisibility(GONE);
                tvBack.setVisibility(VISIBLE);
                tvNotificationBadge.setVisibility(GONE);
                tvBack.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.back_arrow, 0, 0, 0);
                tvTitle.setVisibility(VISIBLE);
                tvTitle.setText(title);
                tvNotification.setVisibility(View.GONE);
                ivProfile.setVisibility(View.GONE);
                break;
        }
    }

    public void setListener(BaseView mView) {
        View view = getRootView();
        view.findViewById(R.id.action_back).setOnClickListener(view1 -> mView.onBack());
        view.findViewById(R.id.action_Profile).setOnClickListener(view1 -> mView.onProfile());
        view.findViewById(R.id.action_notification).setOnClickListener(view1 -> mView.onNotification());

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNavigationBadgeVisibility(int visibility) {
        View view = getRootView();
        TextView tvNotificationBadge = view.findViewById(R.id.action_notification_badge);
        tvNotificationBadge.setVisibility(visibility);
    }

    public void setToolTip() {

//        View view = getRootView();
//        TextView tvNotification = view.findViewById(R.id.action_notification);
//        tooltip = new Tooltip.Builder(tvNotification)
//                .setDismissOnClick(false)
//                .setCancelable(false)
//                .setText("You are selected for \"Los Angeles to Sun Francisco\" Load. Accept from here.")
//                .setGravity(Gravity.BOTTOM)
//                .setBackgroundColor(getResources().getColor(R.color.white))
//                .setTextColor(getResources().getColor(R.color.black))
//                .setTextStyle(R.style.tooltipText)
//                .setTextSize(18f)
//                .setOnClickListener(new com.tooltip.OnClickListener() {
//                    @Override
//                    public void onClick(Tooltip tooltip) {
//                        toolTipClickListener.onClick();
//                        tooltip.dismiss();
//                    }
//                })
//                .show();
    }

    public void setToolTipClickListener(ToolTipClickListener toolTipClickListener) {
        this.toolTipClickListener = toolTipClickListener;
    }

    public interface ToolTipClickListener {
        void onClick();
    }

    public void setTooltipDismiss() {
        tooltip.dismiss();
    }
}
