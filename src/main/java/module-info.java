module net.ramgames.ramgfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.ramgames.ramgfx to javafx.fxml;
    exports net.ramgames.ramgfx;
    exports net.ramgames.ramgfx.objects;
    exports net.ramgames.ramgfx.utilities;
    opens net.ramgames.ramgfx.objects to javafx.fxml;
}