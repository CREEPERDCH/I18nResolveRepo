package i18n;

import java.io.UnsupportedEncodingException;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

/**
 * 国际化文件读取类,提供静态方法和静态引用
 */
public class ResourceBundleLoader implements Observer {

    private static final String RESOURCE_CLASSLOADER_PROFILE = "lagu";
    private static ResourceBundle resourceBundle;

    /**
     * 读取国际化文件中定义的值
     */
    public static String getValue(String key) {
        try {
            return new String(resourceBundle.getString(key).getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    /**
     * 当Locale环境变量改变时更改resourceBundle实例加载的国际化文件
     */
    @Override
    public void update(Observable o, Object arg) {
        refreshBundle();
    }

    /**
     * 刷新读取的bundle信息
     */
    private static void refreshBundle() {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_CLASSLOADER_PROFILE, LocaleHandler.getLocale());
    }
}
