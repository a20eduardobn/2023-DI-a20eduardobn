/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.appinformes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author a20eduardobn
 */
public class AppInformes {

    public static void main(String[] args) throws JRException, SQLException {
        Connection conexion;
        String url = "jdbc:h2:/home/sanclemente.local/a20eduardobn/Documentos/Informes/baseDatos/northwind";
        conexion = DriverManager.getConnection(url);
        System.out.println("Escribe un precio:");
        Scanner sc = new Scanner(System.in);
        Map parametros = new HashMap();
        int precio = sc.nextInt();
        sc.close();
        parametros.put("price", precio);
        JasperPrint print = JasperFillManager.fillReport("src/main/resources/informes/precioProductos.jasper", parametros, conexion);
// exportar a PDF
        JasperExportManager.exportReportToPdfFile(print, "src/main/resources/informes/informePrecio.pdf");
        System.out.println("PDF creado ----------------");
    }
}
