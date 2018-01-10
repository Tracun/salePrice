package com.wb.tracun.costapp.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tracun on 30/11/2017.
 */

public class BDCore extends SQLiteOpenHelper{

    private static final String NOME_BD = "BDProduto.db";
    private static final int VERSAO_BD = 1;

    public BDCore(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    String createTableProduto = "create table Produtos(_idProduto integer primary key autoincrement, nome text not null);\n";
    String createTableInsumo = "create table Insumos(_idInsumo integer primary key autoincrement, nome text not null, idUnidade integer, valorUnit real not null, foreign key(idUnidade) REFERENCES Unidades(idUnidade));";
    String createTableRateio = "create table Rateio(_idRateio integer primary key autoincrement, descricao text not null, valorUnit real not null, quant real, idUnidade integer, foreign key(idUnidade) REFERENCES Unidades(idUnidade));\n";
    String createTableMaoDeObra = "create table MaoDeObra(_idMaoDeObra integer primary key autoincrement, descricao text not null, valorHora real not null);\n";
    String createTableUnidade = "create table Unidades(_idUnidade integer primary key autoincrement, descricao text not null);";
    String createTableDespesa = "create table Despesas(_idDespesa integer primary key autoincrement, descricao text not null, valorUnit real not null);\n";

    String createTableProdutoHasInsumo = "create table ProdutoHasInsumos(idProduto integer not null, idInsumo integer not null, quantInsumo real not null, foreign key(idProduto) REFERENCES Produtos(_idProduto), foreign key(idInsumo) REFERENCES Insumos(_idInsumo), PRIMARY KEY(idProduto, idInsumo));\n";
    String createTableProdutoHasDespesa = "create table ProdutoHasDespesas(idProduto integer not null, idDespesa integer not null, foreign key(idProduto) REFERENCES Produtos(_idProduto), foreign key(idDespesa) REFERENCES Despesas(_idDespesa), PRIMARY KEY(idProduto, idDespesa));\n";
    String createTableProdutoHasRateio = "create table ProdutoHasRateio(idProduto integer not null, idRateio integer not null, quantProduzida real not null, foreign key(idProduto) REFERENCES Produtos(_idProduto), foreign key(idRateio) REFERENCES Rateio(_idRateio), PRIMARY KEY(idProduto, idRateio));\n";
    String createTableProdutoHasMaoDeObra = "create table ProdutoHasMaoDeObra(idProduto integer not null, idMaoDeObra integer not null, tempoNecessario real not null, foreign key(idProduto) REFERENCES Produtos(idProduto), foreign key(idMaoDeObra) REFERENCES maoDeObra(_idMaoDeObra), PRIMARY KEY(idProduto, idMaoDeObra));";

    @Override
    public void onCreate(SQLiteDatabase db) {

        createTables(db);

        //integer primary key autoincrement, nome text not null, custo text not null, encargo text not null, comissao text not null, lucro text not null, outro text not null, imp1 text not null, imp2 text not null, custoIndireto text not null, precoFora text not null, precoDentro text not null, uriImg text
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        deleteTables(db);
        createTables(db);

    }

    void createTables(SQLiteDatabase db){
        db.execSQL(createTableUnidade);
        db.execSQL(createTableInsumo);
        db.execSQL(createTableRateio);
        db.execSQL(createTableMaoDeObra);
        db.execSQL(createTableDespesa);
        db.execSQL(createTableProdutoHasInsumo);
        db.execSQL(createTableProdutoHasRateio);
        db.execSQL(createTableProdutoHasMaoDeObra);
        db.execSQL(createTableProdutoHasDespesa);
        db.execSQL(createTableProduto);
    }

    void deleteTables(SQLiteDatabase db){
        db.execSQL("Drop Table IF EXISTS " + "Unidades");
        db.execSQL("Drop Table IF EXISTS " + "Insumos");
        db.execSQL("Drop Table IF EXISTS " + "Rateio");
        db.execSQL("Drop Table IF EXISTS " + "maoDeObra");
        db.execSQL("Drop Table IF EXISTS " + "Despesas");
        db.execSQL("Drop Table IF EXISTS " + "ProdutoHasInsumos");
        db.execSQL("Drop Table IF EXISTS " + "ProdutoHasDespesas");
        db.execSQL("Drop Table IF EXISTS " + "ProdutoHasRateio");
        db.execSQL("Drop Table IF EXISTS " + "ProdutoHasMaoDeObra");
        db.execSQL("Drop Table IF EXISTS " + "Produtos");

        createTables(db);
    }
}
