package io.github.zhangyuz.gsync.oauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;

import org.json.JSONException;

import io.github.zhangyuz.gsync.Injection;
import io.github.zhangyuz.gsync.R;
import io.github.zhangyuz.gsync.utils.ActivityUtils;

public class OAuthActivity extends AppCompatActivity {

    private static final String TAG = "OAuthActivity";

    public static final String EXTRA_AUTH_STATE = "auth_state";

    public static final String EXTRA_REQUEST_TYPE = "auth_request_type";
    public static final int EXTRA_REQURST_TYPE_AUTH = 0;
    public static final int EXTRA_REQURST_TYPE_REFRESH = 1;

    private AuthState mAuthState;

    private OAuthPresenter mOAuthPresenter;

    static AuthState getAuthStateFromIntent(Intent intent) {
        if (!intent.hasExtra(EXTRA_AUTH_STATE)) {
            return null;
        }
        try {
            return AuthState.jsonDeserialize(intent.getStringExtra(EXTRA_AUTH_STATE));
        } catch (JSONException ex) {
            Log.e(TAG, "Malformed AuthState JSON saved", ex);
            throw new IllegalArgumentException("The AuthState instance is missing in the intent.");
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.w(TAG, "onCreate(" + savedInstanceState + ")");
        setContentView(R.layout.activity_oauth);

        OAuthFragment oAuthFragment = (OAuthFragment) getSupportFragmentManager().findFragmentById(R.id.oauth_fragment);
        if (oAuthFragment == null) {
            oAuthFragment = OAuthFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    oAuthFragment, R.id.oauth_fragment);
        }

        if (mOAuthPresenter == null) {
            mOAuthPresenter = new OAuthPresenter(oAuthFragment, Injection.provideAuthCodeTask(this),
                    Injection.provideAccessCodeTask(this), Injection.provideUseCaseHandler());
        }

    }

    @Override
    protected void onNewIntent(Intent i) {
        super.onNewIntent(i);
        Log.d(TAG, "onNewIntent:" + i);
        setIntent(i);
        if (mAuthState == null) {
            final Intent intent = getIntent();
            mAuthState = getAuthStateFromIntent(intent);
            AuthorizationResponse response = AuthorizationResponse.fromIntent(intent);
            AuthorizationException exception = AuthorizationException.fromIntent(intent);
            if (mAuthState != null && response != null) {
                mOAuthPresenter.authenticationFinished(mAuthState, response, exception);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
