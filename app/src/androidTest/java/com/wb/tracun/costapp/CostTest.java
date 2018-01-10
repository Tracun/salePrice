package com.wb.tracun.costapp;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import com.wb.tracun.costapp.Calculations;
import com.wb.tracun.costapp.model.DespesaAdm;
import com.wb.tracun.costapp.model.Insumo;
import com.wb.tracun.costapp.model.Produto;
import com.wb.tracun.costapp.model.Rateio;
import com.wb.tracun.costapp.model.TempoFab;

/**
 * Created by Tracun on 05/12/2017.
 */

@RunWith(AndroidJUnit4.class)
public class CostTest {

    private Produto p;
    private DespesaAdm dAdm;
    private Insumo i;
    private Rateio r;
    private TempoFab tFab;

    void criaProduto(){
        p = new Produto();
        dAdm = new DespesaAdm();
        ArrayList<DespesaAdm> aAdm = new ArrayList<>();
        ArrayList<Insumo> aIns = new ArrayList<>();
        ArrayList<Rateio> aRat = new ArrayList<>();
        ArrayList<TempoFab> aTFab = new ArrayList<>();


        dAdm.setDescricao("Salarios");
        dAdm.setValor(Float.parseFloat("3500.00"));
        aAdm.add(dAdm);

        i = new Insumo("Farinha", "kg", 0, 2, Float.parseFloat("1.50"));
        aIns.add(i);
        i = new Insumo("Fermento", "kg", 0, (float)0.1, Float.parseFloat("3.00"));
        aIns.add(i);

        r = new Rateio("Oleo", 1, "LT", 1, 30, (float)5.00);
        aRat.add(r);
        r = new Rateio("Gas", 1, "BJ", 1, 500, (float)50.00);
        aRat.add(r);

        tFab = new TempoFab("Prep Massa", (float)0.25,(float)8.52);
        aTFab.add(tFab);

        p.setNome("Teste");
        p.setDespesaAdm(aAdm);
        p.setInsumos(aIns);
        p.setRateio(aRat);
        p.setTempoFab(aTFab);

        Calculations c = new Calculations();
        c.somaTotalDespesa(p.getDespesaAdm());
        c.somaTotalFabricacao(p.getTempoFab());
        c.somaTotalInsumos(p.getInsumos());
        c.somaValorRateio(p.getRateio());

        p.setCusto(c.calcularCusto());
    }

    @Test
    public void sumOfCost(){
        criaProduto();
        Assert.assertEquals(5.70, p.getCusto(), 0.01);
    }
}
