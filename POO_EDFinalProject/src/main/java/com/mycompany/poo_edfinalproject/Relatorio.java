package com.mycompany.poo_edfinalproject;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Relatorio implements InterfaceRelatorio {

    private ArrayList<Transportadora> entregas;
    private Document relatorioPDF;
    private String pathRelatorio;
    private String nomeArquivo;

    public Relatorio() {
        this.relatorioPDF = new Document(PageSize.A4, 40, 30, 20, 20);

    }

    public void abrirArquivoPDF() throws FileNotFoundException {

        PdfWriter.getInstance(relatorioPDF, new FileOutputStream(this.pathRelatorio));
        this.relatorioPDF.open();
    }

    public void setEntregas(ArrayList<Transportadora> entregas) {
        this.entregas = entregas;
    }

    public void setNomeArquivo(String nomeArquivo) {
        nomeArquivo = nomeArquivo.replace(".csv", "");
        this.nomeArquivo = nomeArquivo;
        this.pathRelatorio = "relatorios/" + nomeArquivo + ".pdf";
    }

    @Override
    public void criarCabecalho() {

        Paragraph pararagrafoTitulo = new Paragraph();
        pararagrafoTitulo.setAlignment(Element.ALIGN_CENTER);
        pararagrafoTitulo.add(new Chunk("DS Soluções Logisticas", new Font(Font.COURIER, 28)));

        this.relatorioPDF.add(pararagrafoTitulo);
        pularLinha();
        pularLinha();

        Paragraph pararagrafoSubTitulo = new Paragraph();
        pararagrafoSubTitulo.setAlignment(Element.ALIGN_CENTER);
        pararagrafoSubTitulo.add(new Chunk("Relatorio de entregas: " ,
                new Font(Font.COURIER, 22)));

        this.relatorioPDF.add(pararagrafoSubTitulo);
        Paragraph nombreRelatorio = new Paragraph();
        nombreRelatorio.setAlignment(Element.ALIGN_CENTER);
        nombreRelatorio.add(new Chunk(nomeArquivo ,
                new Font(Font.COURIER, 22)));

        this.relatorioPDF.add(nombreRelatorio);
        pularLinha();
        pularLinha();
    }

    @Override
    public void criarCorpo() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String stamp = dateformat.format(timestamp);

        for (Transportadora entrega : entregas) {
            Paragraph ciudadDestino = new Paragraph();
            ciudadDestino.setAlignment(Element.ALIGN_LEFT);
            ciudadDestino.add(new Chunk("Cidade Destino: " + entrega.getEnderecoClienteDestino(), new Font(Font.COURIER, 14)));
            this.relatorioPDF.add(ciudadDestino);
            
            Paragraph destinatario = new Paragraph();
            destinatario.setAlignment(Element.ALIGN_LEFT);
            destinatario.add(new Chunk("Destinatario: " + entrega.getNomeClienteDestino(), new Font(Font.COURIER, 14)));
            this.relatorioPDF.add(destinatario);
            
            Paragraph remetente = new Paragraph();
            remetente.setAlignment(Element.ALIGN_LEFT);
            remetente.add(new Chunk("Remetente: " + entrega.getNomeRemetente(), new Font(Font.COURIER, 14)));
            this.relatorioPDF.add(remetente);
            
            Paragraph volumeCarga = new Paragraph();
            volumeCarga.setAlignment(Element.ALIGN_LEFT);
            volumeCarga.add(new Chunk("Volume da Carga: " + entrega.getEnderecoClienteDestino() + "Valor do Frete: " + entrega.getVolumeCarga() * 1.17 * entrega.getDistancaoCidadeDestino(),
                     new Font(Font.COURIER, 14)));
            this.relatorioPDF.add(volumeCarga);
            
            Paragraph horaEntrega = new Paragraph();
            horaEntrega.setAlignment(Element.ALIGN_LEFT);
            horaEntrega.add(new Chunk("Data e hora de Entrega: " + stamp, new Font(Font.COURIER, 14)));
            this.relatorioPDF.add(horaEntrega);
            pularLinha();
            
            Paragraph divisor = new Paragraph();
            divisor.setAlignment(Element.ALIGN_LEFT);
            divisor.add(new Chunk("---------------------------------------------", new Font(Font.COURIER, 14)));
            this.relatorioPDF.add(divisor);
            pularLinha();
        }
    }

    @Override
    public void fecharPDF() {
        if (this.relatorioPDF != null && this.relatorioPDF.isOpen()) {
            this.relatorioPDF.close();
        }
    }

    public void pularLinha() {
        this.relatorioPDF.add(new Paragraph(" "));
    }

}
