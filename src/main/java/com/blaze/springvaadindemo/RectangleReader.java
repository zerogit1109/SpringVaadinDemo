package com.blaze.springvaadindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class RectangleReader {

    private RectangleRepo rectangleRepo;

    @Value("${sideA1}")
    private int sideA1;
    @Value("${sideB1}")
    private int sideB1;

    @Value("${sideA2}")
    private int sideA2;
    @Value("${sideB2}")
    private int sideB2;

    @Value("${sideA3}")
    private int sideA3;
    @Value("${sideB3}")
    private int sideB3;

    @Value("${sideA4}")
    private int sideA4;
    @Value("${sideB4}")
    private int sideB4;

    @Autowired
    public RectangleReader(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
    }

    // Save demo rectangles on application start
    @EventListener(ApplicationReadyEvent.class)
    public void addRectangles() {
        Rectangle rectangle1 = new Rectangle(sideA1, sideB1);
        Rectangle rectangle2 = new Rectangle(sideA2, sideB2);
        Rectangle rectangle3 = new Rectangle(sideA3, sideB3);
        Rectangle rectangle4 = new Rectangle(sideA4, sideB4);
        rectangleRepo.save(rectangle1);
        rectangleRepo.save(rectangle2);
        rectangleRepo.save(rectangle3);
        rectangleRepo.save(rectangle4);
    }
}
