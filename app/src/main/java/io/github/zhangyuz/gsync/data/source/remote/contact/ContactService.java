package io.github.zhangyuz.gsync.data.source.remote.contact;

import org.w3._2005.atom.Feed;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ContactService {

    /**
     * @param userEmail Get contact list of userEmail, default means the authenticated user.
     * @return Contact Feed.
     */
    @GET("m8/feeds/contacts/{useremail}/full/")
    Observable<Feed> getContactList(@Path("useremail") String userEmail);
}
