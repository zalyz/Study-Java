package com.company;

import java.io.Serializable;
import java.time.LocalTime;

public class NoteBook implements Serializable {
    private String dayOfWeek;
    private LocalTime time;
    private String event;
    private String fullName;
    private double cost;

    public NoteBook(String dayOfWeek, LocalTime time, String event, String fullName, double cost) {
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.event = event;
        this.fullName = fullName;
        this.cost = cost;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public boolean equals(Object obj) {
       if(this == obj)
           return true;
       if(obj == null)
           return false;
       if(getClass() != obj.getClass())
           return false;
       NoteBook other = (NoteBook) obj;
       return dayOfWeek.equals(other.dayOfWeek) && fullName.equals(other.fullName)
               && event.equals(other.event) && cost == other.cost && time.equals(other.time);
    }

    @Override
    public String toString() {
        return "Day of week: " + this.dayOfWeek + "\nEvent: " + this.event + "\nFull name: "
                + this.fullName + "\nCost: " + this.cost + "\nВремя: " + time + "\n";
    }


}
