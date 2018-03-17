package br.sp.fair.fredericoalves.skipthedishes.app;

import com.hazelcast.config.ListConfig;

/**
 * Hazelcast Local Config
 * 
 * @author frederico.alves
 *
 */
public class LocalListConfig extends ListConfig {

    private int timeToLiveSeconds = 0;

    public LocalListConfig() {
    }

    public LocalListConfig(LocalListConfig config) {
        this.timeToLiveSeconds = config.getTimeToLiveSeconds();
    }

    public int getTimeToLiveSeconds() {
        return timeToLiveSeconds;
    }

    public LocalListConfig setTimeToLiveSeconds(int timeToLiveSeconds) {
        this.timeToLiveSeconds = timeToLiveSeconds;
        return this;
    }

}
