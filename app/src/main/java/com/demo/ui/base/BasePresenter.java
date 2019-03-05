package com.demo.ui.base;



public interface BasePresenter<V extends BaseView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(Error error);

    void setUserAsLoggedOut();

    void onStart();

    void onDestroyView();

}
