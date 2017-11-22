package i18n;

import javax.swing.*;

/**
 * 所有按钮的基类，可统一处理国际化通用事件, 统一将name设置为国际化文件中的key值
 */
public class GenericButton extends JButton {

    public GenericButton(String name) {
        super();
        this.setName(name);
        ComponentPool.addButton(this);
    }

    /**
     * 设置名字,同时设置显示值
     */
    public void setName(String name) {
        super.setName(name);
        setText(ResourceBundleLoader.getValue(name));
    }

    /**
     * 在国际化位置发生改变时执行
     */
    public void onLocaleChange() {
        this.setText(ResourceBundleLoader.getValue(this.getName()));
        beforeTextChange();
        afterTextChange();
    }

    /**
     * 在国际化位置发生改变时执行，用于子类复写其特有操作。在文本刷新前执行
     */
    protected void beforeTextChange() {

    }

    /**
     * 在国际化位置发生改变时执行，用于子类复写其特有操作。在文本刷新后执行
     */
    protected void afterTextChange() {

    }

}
