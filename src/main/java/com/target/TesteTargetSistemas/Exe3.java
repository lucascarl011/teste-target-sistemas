package com.target.TesteTargetSistemas;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;

public class Exe3 {
    public static void main(String[] args) throws IOException {

        String jsonFile = "src/main/resources/faturamento_mensal.json";
        JSONArray faturamentoDiario = lerFaturamentoJSON(jsonFile);

        int menorFaturamento = Integer.MAX_VALUE;
        int maiorFaturamento = 0;
        double mediaMensal = calcularMediaFaturamento(faturamentoDiario);
        int diasAcimaMedia = 0;

        for (int i = 0; i < faturamentoDiario.length(); i++) {
            int valorDiario = faturamentoDiario.getInt(i);

            if (valorDiario > 0) {
                if (valorDiario < menorFaturamento) {
                    menorFaturamento = valorDiario;
                }

                if (valorDiario > maiorFaturamento) {
                    maiorFaturamento = valorDiario;
                }

                if (valorDiario > mediaMensal) {
                    diasAcimaMedia++;
                }
            }
        }

        System.out.println("Menor valor de faturamento: " + menorFaturamento);
        System.out.println("Maior valor de faturamento: " + maiorFaturamento);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaMedia);
    }

    private static JSONArray lerFaturamentoJSON(String jsonFile) throws IOException {
        FileReader reader = new FileReader(jsonFile);
        JSONObject jsonObject = new JSONObject(reader);
        return jsonObject.getJSONArray("faturamento_diario");
    }

    private static double calcularMediaFaturamento(JSONArray faturamentoDiario) {
        int somaFaturamento = 0;
        int diasComFaturamento = 0;

        for (int i = 0; i < faturamentoDiario.length(); i++) {
            int valorDiario = faturamentoDiario.getInt(i);
            if (valorDiario > 0) {
                somaFaturamento += valorDiario;
                diasComFaturamento++;
            }
        }

        if (diasComFaturamento > 0) {
            return (double) somaFaturamento / diasComFaturamento;
        } else {
            return 0;
        }
    }
}
