package com.droidsonroids.bootcamp.zadanie1;

/**
 * Created by noiser on 17.07.15.
 */
public class ClickEvent {
    public enum Action {
        INCREMENT, DECREMENT
    }

    public Action type;

    public ClickEvent(Action type) {
        this.type = type;
    }
}
