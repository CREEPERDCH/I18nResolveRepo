package i18n;

import java.util.Observable;

/**
 * 观察者中心,用于统一通知发送更新信号
 */
public class ObserverCenter extends Observable {
    private static ObserverCenter observerCenter;

    private ObserverCenter() {
    }

    public static ObserverCenter getSingleton() {
        if (observerCenter == null) {
            observerCenter = new ObserverCenter();
        }
        return observerCenter;
    }

    /**
     * 发送变更信息
     */
    public void notifyChange() {
        notifyChange(null);
    }

    public void notifyChange(Object object) {
        setChanged();
        notifyObservers(object);
    }
}
