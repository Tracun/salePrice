package com.wb.tracun.costapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wb.tracun.costapp.Interfaces.IGerenciaBD;
import com.wb.tracun.costapp.model.DespesaAdm;
import com.wb.tracun.costapp.model.Insumo;
import com.wb.tracun.costapp.model.Produto;
import com.wb.tracun.costapp.model.Rateio;
import com.wb.tracun.costapp.model.TempoFab;
import com.wb.tracun.costapp.model.Unidade;

import java.util.ArrayList;

/**
 * Created by Tracun on 07/12/2017.
 */

public class GerenciaBD implements IGerenciaBD {

    private SQLiteDatabase db;

    public GerenciaBD(Context context){
        BDCore auxBD = new BDCore(context);
        db = auxBD.getWritableDatabase();
    }

    @Override
    public int saveUnidade(Unidade unidade) {

        String msg;
        ContentValues valor = new ContentValues();

        valor.put("Descricao", unidade.getDescricao());

        try{
            long result = db.insert("Unidades", null, valor);

            if(result != -1) return 1;

            return -1;

        }catch (Exception e){
            System.out.println("Error: saveUnidade - " + e.getMessage());
            e.printStackTrace();
            return -1;

        }finally {
            db.close();
        }
    }

    @Override
    public int saveInsumo(Insumo insumo) {

        String msg;
        ContentValues valor = new ContentValues();

        valor.put("nome", insumo.getNome());
        valor.put("idUnidade", insumo.getPosicaoUnid());
        valor.put("valorUnit", insumo.getValorUnitario());

        try{
            long result = db.insert("Insumos", null, valor);

            if(result != -1) return 1;

            return -1;

        }catch (Exception e){
            System.out.println("Error: saveInsumo - " + e.getMessage());
            e.printStackTrace();
            return -1;

        }finally {
            db.close();
        }
    }

    @Override
    public int saveRateio(Rateio rateio) {

        String msg;
        ContentValues valor = new ContentValues();

        valor.put("descricao", rateio.getDescricao());
        valor.put("valorUnit", rateio.getValorUnitario());
        valor.put("idUnidade", rateio.getPosicaoUnid());

        try{
            long result = db.insert("Rateio", null, valor);

            if(result != -1) return 1;

            return -1;

        }catch (Exception e){
            System.out.println("Error: saveRateio - " + e.getMessage());
            e.printStackTrace();
            return -1;

        }finally {
            db.close();
        }
    }

    @Override
    public int saveDespesa(DespesaAdm despesaAdm) {

        String msg;
        ContentValues valor = new ContentValues();

        valor.put("descricao", despesaAdm.getDescricao());
        valor.put("valorUnit", despesaAdm.getValor());

        try{
            long result = db.insert("Despesas", null, valor);

            if(result != -1) return 1;

            return -1;

        }catch (Exception e){
            System.out.println("Error: saveDespesa - " + e.getMessage());
            e.printStackTrace();
            return -1;

        }finally {
            db.close();
        }
    }

    @Override
    public int saveTempoFab(TempoFab tempoFab) {
        String msg;
        ContentValues valor = new ContentValues();

        valor.put("descricao", tempoFab.getNome());
        valor.put("valorHora", tempoFab.getValorHora());

        try{
            long result = db.insert("MaoDeObra", null, valor);

            if(result != -1) return 1;

            return -1;

        }catch (Exception e){
            System.out.println("Error: saveMaoDeObra - " + e.getMessage());
            e.printStackTrace();
            return -1;

        }finally {
            db.close();
        }
    }

    @Override
    public int saveProduto(Produto produto) {
        return -1;
    }


    //Buscas


    @Override
    public Cursor buscaUnidadeById(int id) {
        Cursor cursor;

        String[] campos = {"_idUnidade", "descricao"};
        String where = "_idUnidade" + "=" + id;
        cursor = db.query("Unidades", campos, where, null,
                        null, null, null, null);

        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            return cursor;
        }

        db.close();

        return null;
    }

    @Override
    public Cursor buscaInsumoById(int id) {
        Cursor cursor;

        String[] campos = {"_idInsumo", "nome", "valorUnit", "idUnidade"};
        String where = "_idInsumo" + "=" + id;
        cursor = db.query("Insumos", campos, where, null,
                null, null, null, null);

        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            return cursor;
        }

        db.close();

        return null;
    }

    @Override
    public Cursor buscaInsumos() {
        Cursor cursor;

        String[] campos = {"_idInsumo", "nome", "valorUnit", "idUnidade"};
        cursor = db.query("Insumos", campos, null, null,
                null, null, null, null);

        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            return cursor;
        }

        db.close();

        return null;
    }

    @Override
    public Cursor buscaRateio() {
        Cursor cursor;

        String[] campos = {"_idRateio", "descricao", "valorUnit", "idUnidade"};
        cursor = db.query("Rateio", campos, null, null,
                null, null, null, null);

        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            return cursor;
        }

        db.close();

        return null;
    }

    @Override
    public Cursor buscaDespesas() {
        Cursor cursor;

        String[] campos = {"_idDespesa", "descricao", "valorUnit"};
        cursor = db.query("Despesas", campos, null, null,
                null, null, null, null);

        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            return cursor;
        }

        db.close();

        return null;
    }

    @Override
    public Cursor buscaTempoFab() {
        Cursor cursor;

        String[] campos = {"_idMaoDeObra", "Descricao", "valorHora"};
        cursor = db.query("MaoDeObra", campos, null, null,
                null, null, null, null);

        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            return cursor;
        }

        db.close();

        return null;
    }

    @Override
    public Cursor buscaUnidades() {
        Cursor cursor;

        String[] campos = {"*"};
        cursor = db.query("Unidades", campos, null, null,
                null, null, null, null);
        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            return cursor;
        }

        db.close();

        return null;
    }

    @Override
    public void salvaUnidadesPadroes(Context context){

        ArrayList<String> listUnid = new ArrayList();
        listUnid.add("Kg");
        listUnid.add("g");
        listUnid.add("ml");
        listUnid.add("Ton");
        listUnid.add("l");
        listUnid.add("Pç");
        listUnid.add("Unid");
        listUnid.add("Cj");

        for (int i = 0; i < listUnid.size(); i++) {
            Unidade uni = new Unidade();
            uni.setDescricao(listUnid.get(i));
            saveUnidade(uni);
        }
        db.close();
    }

}
