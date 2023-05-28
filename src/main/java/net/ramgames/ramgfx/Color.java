package net.ramgames.ramgfx;

public record Color(int red, int green, int blue) {
    public javafx.scene.paint.Color get() {
        return javafx.scene.paint.Color.color(red/255d,green/255d,blue/255d);
    }
}
