package com.probert999.cinnamon.testhelper;

import com.probert999.cinnamon.model.CinemaInterface;
import com.probert999.cinnamon.model.SeatingPlanInterface;

public class CinemaStub implements CinemaInterface {

    private SeatingPlanStub seatingPlan;
    private String name;

    public CinemaStub(String name) {
        this.name = name;
        seatingPlan = new SeatingPlanStub('A', 2);
    }

    public String getName() {
        return name;
    }

    public SeatingPlanInterface getSeatingPlan() {
        return seatingPlan;
    }
}
