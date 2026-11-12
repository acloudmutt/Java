package com.iotmonitor;

public class SensorDevice {

    private String deviceId;
    private String name;
    private double temperature;
    private boolean connected;
    
    public void setDeviceId(String s) {
        deviceId = s;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceName(String n) {
        name = n;
    }

    public String getDeviceName() {
        return name;
    }

    public void setTemperature(double t) {
        temperature = t;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isConnected(){
        return connected;
    }

    @Override
    public String toString() {
        return "Device ID: " + deviceId +
               ", Device Name: " + name +
               ", Temperature (C): " + temperature +
               ", Connected: " + connected;
    }

    SensorDevice(String s, String n) {

        System.out.println("SensorDevice");

        deviceId = s;
        name = n;
        temperature = 0.0;
        connected = false;
    }
}
