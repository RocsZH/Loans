package com.nepxion.polaris.component.common.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.CodeSource;
import java.util.jar.Attributes;
import java.util.jar.JarFile;

public final class PolarisVersion {
    private PolarisVersion() {

    }

    public static String getNacosVersion() {
        String className = "com.alibaba.nacos.common.utils.VersionUtils";

        try {
            Class<?> clazz = Class.forName(className);
            Field field = clazz.getField("VERSION");

            return field.get("VERSION").toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getVersion(String className) {
        try {
            Class<?> clazz = Class.forName(className);

            return getVersion(clazz);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getVersion(Class<?> clazz) {
        String implementationVersion = clazz.getPackage().getImplementationVersion();
        if (implementationVersion != null) {
            return implementationVersion;
        }

        CodeSource codeSource = clazz.getProtectionDomain().getCodeSource();
        if (codeSource == null) {
            return null;
        }

        URL codeSourceLocation = codeSource.getLocation();
        try {
            URLConnection connection = codeSourceLocation.openConnection();
            if (connection instanceof JarURLConnection) {
                return getImplementationVersion(((JarURLConnection) connection).getJarFile());
            }
            try (JarFile jarFile = new JarFile(new File(codeSourceLocation.toURI()))) {
                return getImplementationVersion(jarFile);
            }
        } catch (Exception ex) {
            return null;
        }
    }

    private static String getImplementationVersion(JarFile jarFile) throws IOException {
        return jarFile.getManifest().getMainAttributes().getValue(Attributes.Name.IMPLEMENTATION_VERSION);
    }
}