/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultil;

import Entidades.Retail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Izidio Carvalho
 */
public class Salvar {

    static boolean arq = false;

    //metodo que salva o arquivo final
    public static void escrever(String texto) {
        arq = true;
        System.out.println("Salvando arquivo Retail.csv");
        File dir = new File("src/");
        File arq = new File(dir, "Retail.csv");

        try {

            //neste ponto criamos o arquivo fisicamente
            arq.createNewFile();

            //Devemos passar no construtor do FileWriter qual arquivo
            // vamos manipular.
            // Esse construtor aceita dois tipos de parametros,
            // File ou String.
            //O parametro true indica que reescrevemos no arquivo
            // sem apagar o que ja existe.
            // O false apagaria o conteúdo do arquivo e escreveria
            // o novo conteúdo.
            // Se não usar o 2 parâmetro, ele por padrão será false.
            //O mais importante, essa linha abre o fluxo do arquivo
            FileWriter fileWriter = new FileWriter(arq, false);

            //Agora vamos usar a classe PrintWriter para escrever
            //fisicamente no arquivo.
            //Precisamos passar o objeto FileReader em seu construtor
            PrintWriter printWriter = new PrintWriter(fileWriter);

            //Agora vamos escrever no arquivo com o metodo  println(),
            // que nos permite escrever linha a linha no arquivo
            printWriter.println(texto);

            //o metodo flush libera a escrita no arquivo
            printWriter.flush();

            //No final precisamos fechar o arquivo
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Arqivo " + arq + " salvo com sucesso em: " + dir);
    }

    //metodo que le a String
    public static String create_CSV() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Online_Retail.csv"));
        String line = "";
        String a = "";
        int i = 0;
        int n = 0;

        List lista = new ArrayList();
        System.out.println("Iniciando leitura do arquivo CSV");

        while ((line = br.readLine()) != null) {

            // "," ou ";" de acordo com o arquivo
            String[] row = line.split(";");
            lista.add(new Retail(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7]));
            a += row[0] + ";" + row[1] + ";" + row[2] + ";" + row[3] + ";" + row[4] + ";" + row[5] + ";" + row[6] + ";" + row[7];
            if (i == n) {
                System.out.println("Salvar.Create_CSV ->" + n);
                n += 1000;
            }
            if (i < 10000) {
                a += "\n";
            }
            if (i == 10000) {
                System.out.println("Aquivos lidos com Sucesso!");
                System.out.println("Quantidade: " + lista.size());
                return a;
            }
            i++;
        }
        System.out.println("Aquivos lidos com Sucesso!");
        System.out.println("Quantidade: " + lista.size());
        return a;
    }

    public static boolean get_status() {
        return arq;
    }
}
