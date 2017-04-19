package io.github.zhangyuz.gsync.oauth;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.zhangyuz.gsync.R;

public class OAuthFragment extends Fragment implements OAuthContract.View {

    private static final String TAG = "OAuthFragment";

    private static final int MSG_SET_STATUS_TXT = 1;

    private OAuthContract.Presenter mPresenter;
    private AppCompatTextView mAuthStatusTxt;
    private Handler mHandler;
    private boolean firstRun = false;

    public OAuthFragment() {
    }

    public static OAuthFragment newInstance() {
        return new OAuthFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        firstRun = true;
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case MSG_SET_STATUS_TXT:
                        mAuthStatusTxt.setText(msg.arg1);
                        break;
                    default:
                        Log.w(TAG, "Unknown msg " + msg.what);
                }
            }
        };

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        final View view = inflater.inflate(R.layout.fragment_oauth, container, false);
        mAuthStatusTxt = (AppCompatTextView) view.findViewById(R.id.oauth_status_txt);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStar");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        if (firstRun) {
            mPresenter.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        firstRun = false;
    }

    @Override
    public void setPresenter(OAuthContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showAuthenticatingUi() {
        setAuthStatus(R.string.oauth_status_authing_str);
    }

    @Override
    public void showAuthenticationResult(boolean success) {
        setAuthStatus(success ? R.string.oauth_status_done_success_str : R.string.oauth_status_done_failure_str);
    }

    @Override
    public void showExchangingUi() {
        setAuthStatus(R.string.oauth_status_refreshing_str);
    }

    @Override
    public void showExchangingResult(boolean success) {
        setAuthStatus(success ? R.string.oauth_status_done_success_str : R.string.oauth_status_done_failure_str);
    }

    private void setAuthStatus(@StringRes int resId) {
        mHandler.obtainMessage(MSG_SET_STATUS_TXT, resId, 0).sendToTarget();
    }

}
