package com.probert999.cinnamon.testhelper;

import com.probert999.cinnamon.model.CinemaInterface;
import com.probert999.cinnamon.model.SeatingPlan;
import com.probert999.cinnamon.model.SeatingPlanInterface;

public class CinemaDummy implements CinemaInterface {

    private SeatingPlanDummy seatingPlan;
    private String name;

    public CinemaDummy(String name) {
        this.name = name;
        seatingPlan = new SeatingPlanDummy('A', 2);
    };

    public String getName() {
        return name;
    }

    public SeatingPlanInterface getSeatingPlan() {
        return seatingPlan;
    };
}
