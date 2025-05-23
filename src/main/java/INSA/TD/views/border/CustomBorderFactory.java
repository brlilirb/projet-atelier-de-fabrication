package INSA.TD.views.border;

import javafx.scene.layout.Border;

public class CustomBorderFactory {

    private final static double DEFAULT_BORDER_SIZE = 2;

    public static Border getTopBorder() {
        return getBorder(DEFAULT_BORDER_SIZE, 0, 0, 0);
    }

    public static Border getBottomBorder() {
        return getBorder(0, 0, DEFAULT_BORDER_SIZE, 0);
    }

    public static Border getLeftBorder() {
        return getBorder(0, 0, 0, DEFAULT_BORDER_SIZE);
    }

    public static Border getRightBorder() {
        return getBorder(0, DEFAULT_BORDER_SIZE, 0, 0);
    }

    public static Border getBorder(double top, double right, double bottom, double left) {
        return new Border(getCustomBorderStroke(top, right, bottom, left));
    }

    private static CustomBorderStroke getCustomBorderStroke(double top, double right, double bottom, double left) {
        return new CustomBorderStroke(top, right, bottom, left);
    }
}
