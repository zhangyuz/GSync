package io.github.zhangyuz.gsync.data.source.local;

import android.content.Context;

import io.github.zhangyuz.gsync.data.source.GsyncDataSource;

public final class LocalDataSource implements GsyncDataSource {

    private static final String sAuthStateKey  = "auth_state";

    final SqlHelper mSqlHelper;

    public LocalDataSource(Context context) {
        mSqlHelper = new SqlHelper(context.getApplicationContext());
    }

    @Override
    public String getAuthState() {
        return mSqlHelper.get(sAuthStateKey);
    }

    @Override
    public void saveAuthState(String state) {
        mSqlHelper.save(sAuthStateKey, state);
    }
}
