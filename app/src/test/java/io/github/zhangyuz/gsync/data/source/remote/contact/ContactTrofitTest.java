package io.github.zhangyuz.gsync.data.source.remote.contact;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ContactTrofitTest {

    @Test
    public void updateAccessToken() throws Exception {
        ContactHeaderInterceptor interceptor = new ContactHeaderInterceptor();
        interceptor.setAuthorization("1st");
        ArrayList<ContactHeaderInterceptor> list = new ArrayList<>(4);
        list.add(interceptor);
        List<ContactHeaderInterceptor> unmodifiableList = Collections.unmodifiableList(list);
        interceptor.setAuthorization("2nd");
        for (ContactHeaderInterceptor c :
                unmodifiableList) {
            assertTrue("Bearer 2nd".equals(c.getAuthorization()));
        }
    }

    @Test
    public void getContactList() throws Exception {
        final ContactTrofit retrofit = ContactTrofit.getInstance();
        retrofit.updateAccessToken("ya29.GlszBHQHFNCOutV8UyKOU6uIRq0ZSNhF4BrianuyQoy15GXx7nS8JozpV1mmoAGf3OkdPqSoBzSTPIcguPhQcW_jLXW7VNhor861zfD9j7lx1H3OKXt8pLl0XJNt");
        retrofit.getContactList();
        try {
            Thread.sleep(60 * 1000);
        } catch (Exception e) {

        }
    }
}