package com.wb.tracun.costapp.activity.fragments.NewProductFragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.wb.tracun.costapp.*;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.LegendModel;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

public class ProdutoCustoFragment extends Fragment {

    EditText txtCusto;
    Button btnCalcularCusto;
    BarChart mBarChart;
    PieChart mPieChart;

    static float mValorInsumos = 0;
    static float mValorTempoFab = 0;
    static float mValorDespesa = 0;
    static float mValorRateio = 0;

    public ProdutoCustoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_produto_custo, container, false);
        txtCusto = (EditText) view.findViewById(R.id.txtCusto);
        btnCalcularCusto = (Button) view.findViewById(R.id.btnCalcularCusto);

        txtCusto.setText("R$ " + calcularCustoProduto(view));

        plotPieChart(view);

        btnCalcularCusto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCusto.setText("R$ " + calcularCustoProduto(view));
                plotPieChart(view);
            }
        });

        return view;
    }

    public static float calcularCustoProduto(View view){

        mValorInsumos = ProdutoInsumoFragment.calcularCustosInsumos();
        mValorRateio = ProdutoRateioFragment.calcularCustosRateio();
        mValorDespesa = ProdutoDespesaFragment.calcularCustosDespesa();
        mValorTempoFab = ProdutoTempoFabFragment.calcularCustosTempoFab();

//        Toast.makeText(view.getContext(), "SOMA INSUMO; " + mValorInsumos, Toast.LENGTH_LONG).show();
//        Toast.makeText(view.getContext(), "SOMA RATEIO; " + mValorRateio, Toast.LENGTH_LONG).show();
//        Toast.makeText(view.getContext(), "SOMA DESPESA; " + mValorDespesa, Toast.LENGTH_LONG).show();
//        Toast.makeText(view.getContext(), "SOMA TEMPO FAB; " + mValorTempoFab, Toast.LENGTH_LONG).show();

        return  (mValorInsumos + mValorRateio + mValorTempoFab);
    }

    void plotPieChart(View view){

        mPieChart = (PieChart) view.findViewById(R.id.costPieGraph);

        mPieChart.setUseInnerValue(true);

        mPieChart.addPieSlice(new PieModel("Insumos", mValorInsumos, R.color.insumoColor));
        mPieChart.addPieSlice(new PieModel("Rateio", mValorRateio, R.color.rateioColor));
        mPieChart.addPieSlice(new PieModel("Temp Fab", mValorTempoFab, R.color.tempoFabColor));

        mPieChart.setLegendHeight(2f);

        mPieChart.startAnimation();

    }
}
