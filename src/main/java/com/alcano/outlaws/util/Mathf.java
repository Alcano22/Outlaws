package com.alcano.outlaws.util;

import java.text.DecimalFormat;

public final class Mathf {

    private Mathf() {}

    public static String floatToMoney(float money) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return df.format(money);
    }

}
