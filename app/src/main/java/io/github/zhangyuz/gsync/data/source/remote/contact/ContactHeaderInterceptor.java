package io.github.zhangyuz.gsync.data.source.remote.contact;

import java.io.IOException;

import io.github.zhangyuz.gsync.utils.L;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Add Google Contact header "GData-Version: 3.0" and "Authorization: ACCESS_TOKEN"
 */
final class ContactHeaderInterceptor implements Interceptor {

    private static final String TAG = "ContactHeaderInterceptor";

    private static final String AUTH_BEARER = "Bearer";
    private String mAuthorization;

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (mAuthorization != null && mAuthorization.length() > 7) {
            Request original = chain.request();
            Request.Builder builder = original.newBuilder()
                    .header("GData-Version", "3.0")
                    .header("Authorization", mAuthorization)
                    .method(original.method(), original.body());
            return chain.proceed(builder.build());
        } else {
            throw new IOException("Access token not set:" + mAuthorization);
        }
    }

    public void setAuthorization(final String accessToken) {
        mAuthorization = String.format("%s %s", AUTH_BEARER, accessToken);
        L.d(TAG, "setAuthorization:" + mAuthorization);
    }

    public String getAuthorization() {
        return mAuthorization;
    }
}
