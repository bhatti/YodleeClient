package com.plexobject.yodlee.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class stores connection configuration
 * 
 * @author shahzad bhatti
 *
 */
public class Configuration {
    private static final Logger log = LoggerFactory
            .getLogger(Configuration.class);

    private final Properties properties = new Properties();

    public Configuration(String propertyFile) throws IOException {
        this(getInputStream(propertyFile));
    }

    public Configuration(InputStream in) throws IOException {
        properties.putAll(System.getProperties());
        properties.load(in);
    }

    public Configuration(Properties props) {
        properties.putAll(props);
    }

    public String getProperty(final String key) {
        return getProperty(key, null);
    }

    public String getProperty(final String key, final String def) {
        String val = properties.getProperty(key, def);
        if (val != null) {
            val = val.trim();
        }
        return val;
    }

    public int getInteger(final String key) {
        return getInteger(key, 0);
    }

    public int getInteger(final String key, final int def) {
        return Integer.parseInt(getProperty(key, String.valueOf(def)));
    }

    public double getDouble(final String key) {
        return getDouble(key, 0);
    }

    public double getDouble(final String key, final double def) {
        return Double.valueOf(getProperty(key, String.valueOf(def)))
                .doubleValue();
    }

    public boolean getBoolean(final String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean(final String key, final boolean def) {
        return Boolean.valueOf(getProperty(key, String.valueOf(def)))
                .booleanValue();
    }

    public long getLong(final String key) {
        return getLong(key, 0);
    }

    public long getLong(final String key, long def) {
        return Long.valueOf(getProperty(key, String.valueOf(def)));
    }

    private static InputStream getInputStream(String propertyFile)
            throws IOException {
        log.info("Loading configuration from " + propertyFile);
        if (new File(propertyFile).exists()) {
            return new BufferedInputStream(new FileInputStream(propertyFile));
        }
        InputStream in = Configuration.class.getClassLoader()
                .getResourceAsStream(propertyFile);
        if (in == null) {
            in = new FileInputStream(propertyFile);
        }
        return in;
    }
}