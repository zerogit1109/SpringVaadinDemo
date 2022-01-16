package com.blaze.springvaadindemo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleGui extends VerticalLayout {

    private RectangleRepo rectangleRepo;

    private TextField textFieldHeight;
    private TextField textFieldWidth;
    private Button button;

    @Autowired
    public RectangleGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        textFieldHeight = new TextField("Insert height");
        textFieldWidth = new TextField("Insert width");
        button = new Button("Add");

        button.addClickListener(clickEvent -> addRectangle());

        add(textFieldHeight);
        add(textFieldWidth);
        add(button);
    }

    private void addRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(Integer.parseInt(textFieldHeight.getValue()));
        rectangle.setWidth(Integer.parseInt(textFieldWidth.getValue()));

        rectangleRepo.save(rectangle);
    }
}
