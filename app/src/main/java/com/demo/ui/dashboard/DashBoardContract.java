package com.demo.ui.dashboard;


import com.demo.ui.base.BasePresenter;
import com.demo.ui.base.BaseView;

public class DashBoardContract {

    public interface DView extends BaseView {
        void showMessage(String message);
    }

    public interface Presenter<V extends DView> extends BasePresenter<V> {
        void setToolbar();

        void openDrawer();

        void closeDrawer();
    }
}
