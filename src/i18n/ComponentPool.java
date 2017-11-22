package i18n;

import java.util.HashMap;
import java.util.Map;

/**
 * UI控件池，用于保存当前所有的UI控件
 */
public class ComponentPool {

    //button池
    private static final Map<String, GenericButton> buttonPool = new HashMap<>();

    //label池
    private static final Map<String, GenericLabel> labelPool = new HashMap<>();

    /**
     * 注册button
     */
    public static void addButton(GenericButton button) {
        if (button == null) {
            throw new IllegalArgumentException("注册button不能为空!");
        }
        if (button.getName() == null) {
            throw new IllegalArgumentException("注册button的名字不能为空!");
        }
        buttonPool.put(button.getName(), button);
    }

    /**
     * 注册button
     */
    public static void addLabel(GenericLabel label) {
        if (label == null) {
            throw new IllegalArgumentException("注册label不能为空!");
        }
        if (label.getName() == null) {
            throw new IllegalArgumentException("注册label的名字不能为空!");
        }
        labelPool.put(label.getName(), label);
    }

    /**
     * 获取button
     */
    public static GenericButton getButton(String buttonName) {
        return buttonPool.get(buttonName);
    }

    /**
     * 获取label
     */
    public static GenericLabel getLabel(String labelName) {
        return labelPool.get(labelName);
    }

    /**
     * 获取所有的button
     */
    public static Map<String, GenericButton> getAllButtons() {
        return buttonPool;
    }

    /**
     * 获取所有label
     */
    public static Map<String, GenericLabel> getAllLabels() {
        return labelPool;
    }
}
