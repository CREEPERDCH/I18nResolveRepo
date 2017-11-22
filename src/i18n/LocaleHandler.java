package i18n;

import java.util.Locale;

/**
 * 当前位置管理类
 */
public class LocaleHandler {

    public static final Locale DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;

    private static Locale locale = DEFAULT_LOCALE;

    static {
        ObserverCenter.getSingleton().notifyChange(new I18nUIHandler());
        ObserverCenter.getSingleton().notifyChange(new ResourceBundleLoader());
    }

    /**
     * 获取国家化区域信息
     */
    public static Locale getLocale() {
        return locale;
    }

    /**
     * 设置国际化区域信息
     */
    public static void setLocale(Locale locale) {
        LocaleHandler.locale = locale == null ? DEFAULT_LOCALE : locale;
        refresh();
    }

    public static void setLocale() {
        setLocale(DEFAULT_LOCALE);
    }

    /**
     * 刷新国际化信息
     */
    private static void refresh() {
        ObserverCenter.getSingleton().notifyChange();
    }
}
