package com.incture.mysqljpamapping.properties;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public interface DatabaseProperties {
    String getUrl();
    String getDriver();
    int getConnectionPoolInitialSize();
    int getMaxActiveConnection();
    int getConnectionTimeOut();
    int getMaxLifeTime();
    int getIdleTimeOut();
}
