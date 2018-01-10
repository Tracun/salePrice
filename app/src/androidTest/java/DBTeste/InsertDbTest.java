package DBTeste;

import android.content.Context;
import android.database.Cursor;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wb.tracun.costapp.DB.GerenciaBD;
import com.wb.tracun.costapp.model.Unidade;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Tracun on 07/12/2017.
 */
@RunWith(AndroidJUnit4.class)
public class InsertDbTest {

    private GerenciaBD gerenciaBD;
    private Unidade unidade;

    @Test
    public void insertUnidades(){
        unidade = new Unidade();
        unidade.setDescricao("Lt");

        Context appContext = InstrumentationRegistry.getTargetContext();

        gerenciaBD = new GerenciaBD(appContext);
        Assert.assertEquals(1, gerenciaBD.saveUnidade(unidade));
    }

//    @Test
//    public void dropUnidades(){
//        Context appContext = InstrumentationRegistry.getTargetContext();
//        gerenciaBD = new GerenciaBD(appContext);
//
//        gerenciaBD.deleteUnidades();
//    }

    @Test
    public void catchUnidadeById(){

        Context appContext = InstrumentationRegistry.getTargetContext();
        gerenciaBD = new GerenciaBD(appContext);

        Cursor cursor = gerenciaBD.buscaUnidades();

        cursor.moveToFirst();
//        cursor.getString(1);

        if(cursor != null){

            System.out.println(cursor.getString(1).toString());
            Assert.assertEquals("Kg", cursor.getString(1).toString());

        }
    }



}
