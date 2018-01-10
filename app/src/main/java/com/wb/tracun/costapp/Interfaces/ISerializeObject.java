package com.wb.tracun.costapp.Interfaces;

import java.io.File;

import com.wb.tracun.costapp.model.DespesaAdm;
import com.wb.tracun.costapp.model.Insumo;
import com.wb.tracun.costapp.model.Produto;
import com.wb.tracun.costapp.model.Rateio;
import com.wb.tracun.costapp.model.TempoFab;

/**
 * Created by u4239 on 29/11/2017.
 */

public interface ISerializeObject {

    Insumo WriteSerializeObject(Insumo insumo, String name, File dir);

    DespesaAdm WriteSerializeObject(DespesaAdm despesaAdm, String name, File dir);

    TempoFab WriteSerializeObject(TempoFab tempoFab, String name, File dir);

    Rateio WriteSerializeObject(Rateio rateio, String name, File dir);

    Produto WriteSerializeObject(Produto produto, String name, File dir);

    Insumo readSerializeObject(Insumo insumo, String name, File dir);

    DespesaAdm readSerializeObject(DespesaAdm despesaAdm, String name, File dir);

    TempoFab readSerializeObject(TempoFab tempoFab, String name, File dir);

    Rateio readSerializeObject(Rateio rateio, String name, File dir);

    Produto readSerializeObject(Produto produto, String name, File dir);
}
