package io.github.zhangyuz.gsync.contact;

import io.github.zhangyuz.gsync.BasePresenter;
import io.github.zhangyuz.gsync.BaseView;

interface ContactContract {
    interface View extends BaseView<ContactContract.Presenter> {
        void showContactList();
    }

    interface Presenter extends BasePresenter {
        void loadContactList();
    }
}
