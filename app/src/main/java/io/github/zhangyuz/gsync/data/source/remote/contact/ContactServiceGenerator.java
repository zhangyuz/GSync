package io.github.zhangyuz.gsync.data.source.remote.contact;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ContactServiceGenerator {
    private static ContactServiceGenerator sGenerator;

    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;
    private ContactHeaderInterceptor mContactHeaderInterceptor;

    private ContactServiceGenerator() {
        mContactHeaderInterceptor = new ContactHeaderInterceptor();
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(mContactHeaderInterceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://www.google.com/").build();
    }

    public static ContactServiceGenerator getInstance() {
        if (sGenerator == null) {
            synchronized (ContactServiceGenerator.class) {
                if (sGenerator == null) {
                    sGenerator = new ContactServiceGenerator();
                }
            }
        }
        return sGenerator;
    }

    public void updateAccessToken(final String token) {
        mContactHeaderInterceptor.setAuthorization(token);
    }

    public <S> S createService(Class<S> service) {
        return mRetrofit.create(service);
    }

}
