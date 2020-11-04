package br.edu.uniso;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadFile {

    public static void main (String[] args){

        try{
            String PlanilhaVendedores = "Vendedores.xlsx";
            File file = new File(PlanilhaVendedores);
            FileInputStream fis = new FileInputStream(file);
            Workbook wb = null;

            if(PlanilhaVendedores.endsWith("xls")){
                wb = new HSSFWorkbook(fis);
            } else if (PlanilhaVendedores.endsWith("xlsx")){
                wb = new XSSFWorkbook(fis);
            }



            Sheet planilha1 = wb.getSheetAt(0);

            Iterator<Row> rows = planilha1.iterator();
            rows.next();
            while(rows.hasNext()){
                Row row = rows.next();

                Iterator<Cell> celulas = row.cellIterator();
                
                    Cell coluna1 = celulas.next();
                    String nome = coluna1.getStringCellValue();

                    Cell coluna2 = celulas.next();
                    int idade = (int)coluna2.getNumericCellValue();

                    Cell coluna3 = celulas.next();
                    String cpf = coluna3.getStringCellValue();

                    mysql.enfiandoNoBanco(nome,idade,cpf);
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
