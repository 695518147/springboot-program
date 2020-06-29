package com.zpy.springboottest.controller;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/test")
@Slf4j
public class TestController {

    @RequestMapping(value = "/pdf-download", method = GET)
    public void download(InputStream in) throws IOException {
        Map parameters = new HashMap();
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        FileOutputStream outputStream = null;
        File file = new File("report.pdf");
        String reportModelFile = "report2.jasper";

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportModelFile,
                    parameters);
            JRAbstractExporter exporter = new JRPdfExporter();
            //创建jasperPrint
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            //生成输出流
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outPut);
            //屏蔽copy功能
            exporter.setParameter(JRPdfExporterParameter.IS_ENCRYPTED, Boolean.TRUE);
            //加密
            exporter.setParameter(JRPdfExporterParameter.IS_128_BIT_KEY, Boolean.TRUE);
            exporter.exportReport();
            outputStream = new FileOutputStream(file);
            outputStream.write(outPut.toByteArray());
        } catch (JRException e) {
            log.error("{}",e);
        } catch (Exception e) {
            log.error("{}",e);
        } finally {
            try {
                outPut.flush();
                outPut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
