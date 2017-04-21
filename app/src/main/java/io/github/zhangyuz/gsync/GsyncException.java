package io.github.zhangyuz.gsync;

/**
 * Generic exception thrown within the app
 */
public final class GsyncException extends RuntimeException {
    public GsyncException() {
    }

    public GsyncException(String message) {
        super(message);
    }

    public GsyncException(String message, Throwable cause) {
        super(message, cause);
    }

    public GsyncException(Throwable cause) {
        super(cause);
    }
}
