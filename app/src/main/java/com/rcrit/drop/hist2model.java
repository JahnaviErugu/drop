package com.rcrit.drop;

public class hist2model {
    String name;
    String address;
    String time;
    String units;
    String bloodgroup;
    int profile;

    public hist2model(String name, String address, String time, String units, String bloodgroup, int profile) {
        this.name = name;
        this.address = address;
        this.time = time;
        this.units = units;
        this.bloodgroup = bloodgroup;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTime() {
        return time;
    }

    public String getUnits() {
        return units;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public int getProfile() {
        return profile;
    }
}
