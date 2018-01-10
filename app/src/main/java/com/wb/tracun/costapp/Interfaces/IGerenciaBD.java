package com.wb.tracun.costapp.Interfaces;

import android.content.Context;
import android.database.Cursor;

import com.wb.tracun.costapp.model.DespesaAdm;
import com.wb.tracun.costapp.model.Insumo;
import com.wb.tracun.costapp.model.Produto;
import com.wb.tracun.costapp.model.Rateio;
import com.wb.tracun.costapp.model.TempoFab;
import com.wb.tracun.costapp.model.Unidade;

/**
 * Created by Tracun on 07/12/2017.
 */

public interface IGerenciaBD {

    int saveUnidade(Unidade unidade);
    int saveInsumo(Insumo insumo);
    int saveRateio(Rateio rateio);
    int saveDespesa(DespesaAdm despesaAdm);
    int saveTempoFab(TempoFab tempoFab);
    int saveProduto(Produto produto);

    Cursor buscaUnidadeById(int id);
    Cursor buscaInsumoById(int id);
    Cursor buscaInsumos();
    Cursor buscaRateio();
    Cursor buscaDespesas();
    Cursor buscaTempoFab();
    Cursor buscaUnidades();

    void salvaUnidadesPadroes(Context context);


//    String uptadeUnidade(Unidade unidade);
//    String uptadeInsumo(Insumo insumo);
//    String uptadeRateio(Rateio rateio);
//    String uptadeDespesa(DespesaAdm despesaAdm);
//    String uptadeTempoFab(TempoFab tempoFab);
//    String uptadeProduto(Produto produto);


}
