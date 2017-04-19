package io.github.zhangyuz.gsync.data.source;

import android.content.Context;

import io.github.zhangyuz.gsync.data.source.local.LocalDataSource;

public final class GsyncDataRepository implements GsyncDataSource {

    private LocalDataSource mLocalDataSource;

    public GsyncDataRepository(Context context) {
        mLocalDataSource = new LocalDataSource(context);
    }

    @Override
    public String getAuthState() {
        return mLocalDataSource.getAuthState();
    }

    @Override
    public void saveAuthState(String state) {
        mLocalDataSource.saveAuthState(state);
    }
}
