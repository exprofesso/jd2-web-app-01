package by.it.webapp.controller.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleManager {

    private final static LocaleManager instance = new LocaleManager();

    private static final ResourceBundle resourceBundleRU = ResourceBundle.getBundle(
            "local", new Locale("ru"));
    private static final ResourceBundle resourceBundleEN = ResourceBundle.getBundle(
            "local", new Locale("en"));

    public static LocaleManager getInstance() {
        return instance;
    }

    public ResourceBundle getResourceBundleRU() {
        return resourceBundleRU;
    }

    public ResourceBundle getResourceBundleEN() {
        return resourceBundleEN;
    }
}
