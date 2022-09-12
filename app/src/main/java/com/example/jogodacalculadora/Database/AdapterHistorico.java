package com.example.jogodacalculadora.Database;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jogodacalculadora.R;

import java.util.List;

public class AdapterHistorico extends RecyclerView.Adapter<AdapterHistorico.HistoricoViewHolder> {

    private final List<Historico> historicos;




    public AdapterHistorico(List<Historico> historico) {
        this.historicos = historico;
    }

    @NonNull
    @Override
    public HistoricoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.historico_item, parent, false);
        return new HistoricoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricoViewHolder holder, int position) {
        Historico historico = historicos.get(position);
        holder.bind(historico);
    }

    @Override
    public int getItemCount() {
        return historicos.size();
    }


    class HistoricoViewHolder extends RecyclerView.ViewHolder{

        TextView calculoView, respostaView;
        ImageView imagemAcerto;


        public HistoricoViewHolder(@NonNull View itemView) {
            super(itemView);
            calculoView = itemView.findViewById(R.id.calculoView);
            respostaView = itemView.findViewById(R.id.respostaView);
            imagemAcerto = itemView.findViewById(R.id.imagemAcerto);
        }

        public void bind(Historico historico){
            calculoView = itemView.findViewById(R.id.calculoView);
            respostaView = itemView.findViewById(R.id.respostaView);
            imagemAcerto = itemView.findViewById(R.id.imagemAcerto);

            calculoView.setText(historico.equacao);
            respostaView.setText(""+historico.respostaUtilizada);
            if(historico.acertou_Errou){
                imagemAcerto.setImageResource(R.drawable.acerto);
            }else{
                imagemAcerto.setImageResource(R.drawable.erro);
            }


        }
    }
}




