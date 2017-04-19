package io.github.zhangyuz.gsync;

public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
}
