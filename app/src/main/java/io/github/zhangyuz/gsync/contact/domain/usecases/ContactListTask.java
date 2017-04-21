package io.github.zhangyuz.gsync.contact.domain.usecases;

import io.github.zhangyuz.gsync.UseCase;

/**
 * Task for getting the whole contact list.
 */

public class ContactListTask extends UseCase<ContactListTask.RequestValues,
        ContactListTask.ResponseValues> {
    @Override
    protected void executeUseCase(RequestValues requestValues) {

    }

    public static class RequestValues implements UseCase.RequestValues {

    }

    public static class ResponseValues implements UseCase.ResponseValues {

    }
}
