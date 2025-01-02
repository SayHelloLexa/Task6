package ru.vsu.cs.graphics;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ru.vsu.cs.logic.SelfQueue;

public class QueueController {
    private SelfQueue<String> selfQueue = new SelfQueue();

    @FXML
    private TextField queue;

    @FXML
    private TextField offerField;

    @FXML
    private TextField removeField;

    @FXML
    private TextField pollField;

    @FXML
    private TextField elementField;

    @FXML
    private TextField peekField;

    @FXML
    protected void offerAction() {
        selfQueue.offer(offerField.getText());
        updateQueue();
    }

    @FXML
    protected void removeAction() {
        try {
            removeField.setText(selfQueue.remove());
        } catch (Exception e) {
            removeField.setText("Ошибка: " + e.getMessage());
        }
        updateQueue();
    }

    @FXML
    protected void pollAction() {
        String el = selfQueue.poll();
        if (el == null) {
            pollField.setText("null");
        } else {
            pollField.setText(el);
        }
        updateQueue();
    }

    @FXML
    protected void elementAction() {
        try {
            elementField.setText(selfQueue.element());
        } catch (Exception e) {
            elementField.setText("Ошибка: " + e.getMessage());
        }
        updateQueue();
    }

    @FXML
    protected void peekAction() {
        String el = selfQueue.peek();
        if (el == null) {
            peekField.setText("null");
        } else {
            peekField.setText(el);
        }
        updateQueue();
    }

    @FXML
    protected void cleanAction() {
        offerField.clear();
        removeField.clear();
        pollField.clear();
        peekField.clear();
        elementField.clear();
    }

    private void updateQueue() {
        queue.setText(selfQueue.toString());
    }
}