package edu.usac.ipc1.tarea3;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;



public class graficar {

    public String[] xdatos;
    public Double[] ydatos;
    public String encabezado_x;
    public String encabezado_y;
    private String textoDelArchivo;
    private JFreeChart grafico;



    public void leer(File archivo) {
        StringBuilder sb = new StringBuilder();
        if (archivo.exists() && archivo.canRead()) {
            BufferedReader bReader = null;
            try {
                bReader = Files.newBufferedReader(archivo.toPath(), StandardCharsets.UTF_8);
                String line;
                while ((line = bReader.readLine()) != null) {
                    sb.append(line+"\n");

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (bReader != null) {
                    try {
                        bReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        textoDelArchivo = sb.toString();
    }

    public void rellenar(){
        String lineas[] = textoDelArchivo.split("\n");
        xdatos = new String[lineas.length-1];
        ydatos = new Double[lineas.length-1];
        String titulos[] = lineas[0].split(",");
        encabezado_x = titulos[0];
        encabezado_y = titulos[1];
        for (int i = 1; i < lineas.length; i++) {
            String columnas[] = lineas[i].split(",");
            xdatos[i-1] = columnas[0];
            ydatos[i-1] = Double.parseDouble(columnas[1]);
        }

    }

    public ChartPanel graficar(String titulo){
        DefaultCategoryDataset cd = new DefaultCategoryDataset();
        for (int i = 0; i < xdatos.length; i++) {
            cd.addValue(ydatos[i], xdatos[i],encabezado_x);
        }
        grafico = ChartFactory.createBarChart(titulo, encabezado_x, encabezado_y, cd);
        ChartPanel graficoPanel = new ChartPanel(grafico);
        graficoPanel.setPreferredSize(new java.awt.Dimension(750,400));
        return graficoPanel;
    }

    public void exportar (String nombreArchivo){
        File bar = new File(nombreArchivo+".jpg");
        try {
            ChartUtils.saveChartAsJPEG(bar, grafico, 750, 400);
        } catch (Exception e){

        }
    }



}
