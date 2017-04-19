package io.github.zhangyuz.gsync.data.source;

public interface GsyncDataSource {

    /**
     * Get OAuth state in json string.
     *
     * @return The json oauth state.
     */
    String getAuthState();

    /**
     * Save OAuth state in json string.
     *
     * @param state json state  to save.
     */
    void saveAuthState(String state);
}
