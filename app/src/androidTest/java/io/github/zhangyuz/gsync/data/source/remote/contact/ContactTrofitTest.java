package io.github.zhangyuz.gsync.data.source.remote.contact;

import org.junit.Test;

public class ContactTrofitTest {
    @Test
    public void getContactList() throws Exception {
        final ContactTrofit retrofit = ContactTrofit.getInstance();
        retrofit.updateAccessToken("ya29.GlszBHu5ORyzAsEOsSP2go4WmUO4zBajU5tJD_rVLb7al9gXNLTFRtVTmit3_DdN6ZuTN0adqS83QsVAIkEGofz376ac06d5kCaTZLWeFGrIH5vOnl7DKmholGTB");
        retrofit.getContactList();
        try {
            Thread.sleep(60 * 1000);
        } catch (Exception e) {

        }

    }

    String tag;
}