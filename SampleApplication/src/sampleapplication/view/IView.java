package sampleapplication.view;

import sampleapplication.controller.Controller;

public interface IView {

    public void showVolume();

    public void setController(Controller controller);

    public Controller getController();
}
