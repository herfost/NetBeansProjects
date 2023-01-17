package sampleapplication.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.ParseException;
import sampleapplication.domain.Volume;

public interface ICalculator {

    public Volume calculateVolume(String length, String height, String width) throws UnknownHostException, IOException, ClassNotFoundException, ParseException;
}
