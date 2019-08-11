package com.example.myergedd.fragment.chosen;

public interface Chosen {
    public interface ChosenView {
        void onSuccess();

        void onFailed(String error);
    }
    public interface ChosenModel {
        void onSuccess();

        void onFailed(String error);
    }
    public interface ChosenPresenter {

    }
}
