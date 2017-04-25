package io.github.zhangyuz.gsync.data.source.remote.contact;

import org.junit.Test;

public class ContactTrofitTest {
    @Test
    public void getContactList() throws Exception {
        final ContactTrofit retrofit = ContactTrofit.getInstance();
        retrofit.updateAccessToken("ya29.Gls3BAv2EpfytbWP4I7IUayX8a9NtGhETei171pF5LEqhS0vZP9xZS7bC6ilt9-ZyN7yqqZAgrzBg7GlCRHS-tAmx_EtetofcqFCy6Qdv6KZ85GsEO-oWc6qyxBq");
        retrofit.getContactList();
        try {
            Thread.sleep(60 * 1000);
        } catch (Exception e) {

        }

    }
}