package net.ramgames.ramgfx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Display extends Application {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    private final Canvas canvas = new Canvas();
    private Dimension2D size;
    private final double updateRate;
    private final String title;
    private final String iconAddress;
    private final Color backgroundColor;

    public Display(String title, Dimension2D size, Color backgroundColor, int ups, String iconAddress) {
        this.size = size;
        this.canvas.setHeight(size.getHeight());
        this.canvas.setWidth(size.getWidth());
        this.updateRate = ups;
        this.title = title;
        this.iconAddress = iconAddress;
        this.backgroundColor = backgroundColor;
        launch();
    }


    @Override
    public void start(Stage stage) {
        stage.setTitle(title);
        InputStream stream = getClass().getResourceAsStream(iconAddress);
        if(stream != null) stage.getIcons().add(new Image(stream));
        stage.setScene(new Scene(new Group(canvas)));
        stage.setHeight(size.getHeight());
        stage.setWidth(size.getWidth());
        stage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                timedProcess(canvas, stage);
                try {
                    Thread.sleep(0L, (int) (1000/updateRate));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        };
        timer.start();
    }

    public Dimension2D getSize() {
        return new Dimension2D(this.canvas.getWidth(), this.canvas.getHeight());
    }

    private void timedProcess(Canvas canvas, Stage stage) {
        if(stage.getHeight() != canvas.getHeight()) canvas.setHeight(stage.getHeight());
        if(stage.getWidth() != canvas.getWidth()) canvas.setWidth(stage.getWidth());
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(backgroundColor.get());
        graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }
    public void print(PrintType type, Object message) {
        print(type,"RamRender", message);
    }

    public void print(PrintType type, String senderId, Object message) {
        System.out.printf("%s{%s} [%s] %s - %s\u001B[0m\n", type.getCode(), type.getName(), formatter.format(new Date()), senderId,message.toString());
    }
}