package com.nepxion.polaris.component.env.entity;

public enum PolarisEnv {
    DEV("dev"), 
    FAT("fat"), 
    UAT("uat"), 
    PRO("pro");

    private String env;

    private PolarisEnv(String env) {
        this.env = env;
    }

    public String getEnv() {
        return env;
    }

    public static PolarisEnv fromString(String value) {
        for (PolarisEnv polarisEnv : PolarisEnv.values()) {
            if (polarisEnv.getEnv().equalsIgnoreCase(value)) {
                return polarisEnv;
            }
        }

        throw new IllegalArgumentException("No matched type with value=" + value);
    }

    @Override
    public String toString() {
        return env;
    }
}