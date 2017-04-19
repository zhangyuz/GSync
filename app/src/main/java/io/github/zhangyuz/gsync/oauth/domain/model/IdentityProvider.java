/*
 * Copyright 2015 The AppAuth for Android Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.zhangyuz.gsync.oauth.domain.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.AuthorizationServiceConfiguration.RetrieveConfigurationCallback;

/**
 * An abstraction of identity providers, containing all necessary info for the demo app.
 */
public class IdentityProvider {

    /*
    public static final IdentityProvider GOOGLE = new IdentityProvider(
            "Google",
            R.bool.google_enabled,
            R.string.google_discovery_uri,
            NOT_SPECIFIED, // auth endpoint is discovered
            NOT_SPECIFIED, // token endpoint is discovered
            NOT_SPECIFIED, // dynamic registration not supported
            R.string.google_client_id,
            R.string.google_auth_redirect_uri,
            R.string.google_scope_string,
            R.drawable.btn_google,
            R.string.google_name,
            android.R.color.white);
    public static final List<IdentityProvider> PROVIDERS = Arrays.asList(GOOGLE);

    public static List<IdentityProvider> getEnabledProviders(Context context) {
        ArrayList<IdentityProvider> providers = new ArrayList<>();
        for (IdentityProvider provider : PROVIDERS) {
            provider.readConfiguration(context);
            if (provider.isEnabled()) {
                providers.add(provider);
            }
        }
        return providers;
    }
*/

    @NonNull
    public final String name;

    private boolean mEnabled;
    private Uri mDiscoveryEndpoint;
    private Uri mAuthEndpoint;
    private Uri mTokenEndpoint;
    private Uri mRegistrationEndpoint;
    private String mClientId;
    private Uri mRedirectUri;
    private String mScope;

    public IdentityProvider(
            @NonNull String name,
            boolean enabled,
            String discoveryEndpointRes,
            String authEndpointRes,
            String tokenEndpointRes,
            String registrationEndpointRes,
            String clientIdRes,
            String redirectUriRes,
            String scopeRes) {

        this.name = name;
        this.mEnabled = enabled;
        if (!TextUtils.isEmpty(discoveryEndpointRes))
            this.mDiscoveryEndpoint = Uri.parse(discoveryEndpointRes);
        if (!TextUtils.isEmpty(authEndpointRes))
            this.mAuthEndpoint = Uri.parse(authEndpointRes);
        if (!TextUtils.isEmpty(tokenEndpointRes))
            this.mTokenEndpoint = Uri.parse(tokenEndpointRes);
        if (!TextUtils.isEmpty(registrationEndpointRes))
            this.mRegistrationEndpoint = Uri.parse(registrationEndpointRes);
        this.mClientId = clientIdRes;
        if (!TextUtils.isEmpty(redirectUriRes))
            this.mRedirectUri = Uri.parse(redirectUriRes);
        this.mScope = scopeRes;
    }

    /**
     * This must be called before any of the getters will function.
     */
    public boolean isEnabled() {
        return mEnabled;
    }

    @Nullable
    public Uri getDiscoveryEndpoint() {
        return mDiscoveryEndpoint;
    }

    @Nullable
    public Uri getAuthEndpoint() {
        return mAuthEndpoint;
    }

    @Nullable
    public Uri getTokenEndpoint() {
        return mTokenEndpoint;
    }

    public String getClientId() {
        return mClientId;
    }


    public void setClientId(String clientId) {
        mClientId = clientId;
    }

    @NonNull
    public Uri getRedirectUri() {
        return mRedirectUri;
    }

    @NonNull
    public String getScope() {
        return mScope;
    }

    public void retrieveConfig(RetrieveConfigurationCallback callback) {
        if (getDiscoveryEndpoint() != null) {
            AuthorizationServiceConfiguration.fetchFromUrl(mDiscoveryEndpoint, callback);
        } else {
            AuthorizationServiceConfiguration config =
                    new AuthorizationServiceConfiguration(mAuthEndpoint, mTokenEndpoint,
                            mRegistrationEndpoint);
            callback.onFetchConfigurationCompleted(config, null);
        }
    }
}
