package com.wb.tracun.costapp;

import com.wb.tracun.costapp.Interfaces.IConversorMoeda;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by Tracun on 05/12/2017.
 */

public class ConversorMoeda implements IConversorMoeda {
    @Override
    public float RealFormat(float valor) {
        DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(new Locale("pt", "BR")));
        return Float.parseFloat(df.format(valor));
    }
}

