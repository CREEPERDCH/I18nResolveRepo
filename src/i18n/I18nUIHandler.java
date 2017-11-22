package i18n;

import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * UI界面国际化管理类
 */
public class I18nUIHandler implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        //刷新button
        refreshButton();
        //刷新label
        refreshLabel();
    }

    /**
     * 刷新button
     */
    private void refreshButton() {
        Map<String, GenericButton> buttons = ComponentPool.getAllButtons();
        Iterator<Map.Entry<String, GenericButton>> btnEntryIt = buttons.entrySet().iterator();
        while (btnEntryIt.hasNext()) {
            Map.Entry<String, GenericButton> entry = btnEntryIt.next();
            GenericButton button = entry.getValue();
            button.onLocaleChange();
        }
    }

    /**
     * 刷新label
     */
    private void refreshLabel() {
        Map<String, GenericLabel> labels = ComponentPool.getAllLabels();
        Iterator<Map.Entry<String, GenericLabel>> labEntryIt = labels.entrySet().iterator();
        while (labEntryIt.hasNext()) {
            Map.Entry<String, GenericLabel> entry = labEntryIt.next();
            GenericLabel label = entry.getValue();
            label.onLocaleChange();
        }
    }
}
