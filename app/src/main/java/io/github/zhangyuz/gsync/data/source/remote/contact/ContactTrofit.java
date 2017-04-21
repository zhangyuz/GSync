package io.github.zhangyuz.gsync.data.source.remote.contact;

import org.w3._2005.atom.Feed;

import io.github.zhangyuz.gsync.utils.L;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ContactTrofit {

    private static final String TAG = "ContractTrofit";

    private static ContactTrofit sTrofit;
    private ContactService mContactService;
    private ContactServiceGenerator mServiceGenerator;

    public ContactTrofit() {
        mServiceGenerator = ContactServiceGenerator.getInstance();
        mContactService = mServiceGenerator.createService(ContactService.class);
    }

    public static ContactTrofit getInstance() {
        if (sTrofit == null) {
            synchronized (ContactTrofit.class) {
                if (sTrofit == null) {
                    sTrofit = new ContactTrofit();
                }
            }
        }
        return sTrofit;
    }

    public void updateAccessToken(final String accessToken) {
        /*
        if (TextUtils.isEmpty(accessToken)) {
            throw new IllegalArgumentException("Invalid access token");
        }*/
        mServiceGenerator.updateAccessToken(accessToken);
    }

    public void getContactList() {
        final Observable<Feed> feed = mContactService.getContactList("default");
        feed.subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread()).subscribe(
                new Consumer<Feed>() {
                    @Override
                    public void accept(Feed feed) throws Exception {
                        System.out.println(feed.toString());
                    }
                },
                new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.w(TAG, throwable.toString());
                        throw new RuntimeException(throwable);
                    }
                },
                new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("Complete");
                    }
                }
        );
    }
}
