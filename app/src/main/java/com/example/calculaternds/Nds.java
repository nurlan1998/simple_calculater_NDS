package com.example.calculaternds;

import android.widget.RadioButton;

public class Nds {
    private float amount;
    private float nds;


    public Nds() {
    }


    public Nds(float amount, float nds) {
        this.amount = amount;
        this.nds = nds;
    }

    float ChargeNds(){
        return (amount * nds)/100;

    }

    float MarkNds(){
        return (amount * nds)/(100 + nds);
    }

}
