package com.rcrit.drop;

public class dataclass {
    private String name;
    private String location;
    private String bloodType;
    private int unitsRequired;
    private int profile;
    private String time;

    public dataclass(String name, String location, String bloodType, int unitsRequired, int profile, String time) {
        this.name = name;
        this.location = location;
        this.bloodType = bloodType;
        this.unitsRequired = unitsRequired;
        this.profile = profile;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getUnitsRequired() {
        return unitsRequired;
    }

    public int getProfile() {
        return profile;
    }

    public String getTime() {
        return time;
    }
}
