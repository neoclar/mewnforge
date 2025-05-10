package com.neoclar.mewnforge.java;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.neoclar.jbi.java.CustomClassLoader;

public class GameLoader {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
        CustomClassLoader classLoader = new CustomClassLoader(GameLoader.class.getClassLoader());
        // DesktopLauncher.main(args);
        classLoader.loadClass("com.cairn4.moonbase.desktop.DesktopLauncher").getMethod("main", String[].class).invoke(null, (Object) args);
    }
}