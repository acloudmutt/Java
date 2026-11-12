package com.iotmonitor;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Device {

    private final StringProperty name;
    private final StringProperty ipAddress;
    private StringProperty status;

    public Device(String name, String ipAddress, String status) {
        this.name = new SimpleStringProperty(name);
        this.ipAddress = new SimpleStringProperty(ipAddress);
        this.status = new SimpleStringProperty(status);
    }

    public String getName() {
        return name.get();
    }

    public String getIpAddress() {
        return ipAddress.get();
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty ipAddressProperty() {
        return ipAddress;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatusProperty(String s) {
        this.status = new SimpleStringProperty(s);
    }
    
}
