package com.happy.javautil;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Sides;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.Arrays;
import java.util.Optional;

public class PrintTest {
    public static void main(String[] args) throws Exception {
        //File file = new File("F:/image/image4.jpg");
        File file = new File("F:/image/使用“钉钉”为公司内部沟通工具的通知.pdf");
        //File file = new File("F:/image/xiaomi.docx");
        String printName = "FUJI XEROX DocuCentre SC2022";
        //oldPrint(file, printName);

       // printpdf(file, printName);
//        try {
//            printWord(file,printName);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public static void oldPrint(File file, String printName) {
        InputStream fileInputStream = null;
        try {
            /**打印的格式**/
            DocFlavor.INPUT_STREAM jpeg = DocFlavor.INPUT_STREAM.AUTOSENSE;
            /**打印的参数**/
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            //份数
            printRequestAttributeSet.add(new Copies(1));
            //单双面
            printRequestAttributeSet.add(Sides.ONE_SIDED);

            //获取本电脑获取的所有的打印机
            PrintService[] printServices = PrinterJob.lookupPrintServices();

            Optional<PrintService> printServiceOptional = Arrays.stream(printServices).filter(x -> x.getName().equals(printName)).findFirst();

            if (!printServiceOptional.isPresent()) {
                return;
            }

            fileInputStream = new FileInputStream(file);

            Doc doc = new SimpleDoc(fileInputStream, jpeg, null);

            DocPrintJob job = printServiceOptional.get().createPrintJob();
            job.print(doc, printRequestAttributeSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭打印的文件流
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void printWord(File file, String printName) throws FileNotFoundException {
        System.out.println("开始打印");
        ComThread.InitSTA();
        ActiveXComponent word = new ActiveXComponent("Word.Application");
        Dispatch doc = null;
        Dispatch.put(word, "Visible", new Variant(false));
        Dispatch docs = word.getProperty("Documents").toDispatch();
        doc = Dispatch.call(docs, "Open", "F:/image/xiaomi.docx").toDispatch();

        try {
            Dispatch.call(doc, "PrintOut");//打印
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("打印失败");
        } finally {
            try {
                if (doc != null) {
                    Dispatch.call(doc, "Close", new Variant(0));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            //释放资源
            ComThread.Release();
        }

    }

    public static void printPdf(File file, String printerName) throws Exception {
        PDDocument document = null;
        try {
            document = PDDocument.load(file);
            PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setJobName(file.getName());
            if (printerName != null) {
                // 查找并设置打印机
                //获得本台电脑连接的所有打印机
                PrintService[] printServices = PrinterJob.lookupPrintServices();

                Optional<PrintService> printServiceOptional = Arrays.stream(printServices).filter(x -> x.getName().equals(printerName)).findFirst();
                if (!printServiceOptional.isPresent()) {
                    return;
                }
                printJob.setPrintService(printServiceOptional.get());
            }
            //设置纸张及缩放
            PDFPrintable pdfPrintable = new PDFPrintable(document, Scaling.ACTUAL_SIZE);
            //设置多页打印
            Book book = new Book();
            PageFormat pageFormat = new PageFormat();
            //设置打印方向
            pageFormat.setOrientation(PageFormat.PORTRAIT);//纵向
            pageFormat.setPaper(getPaper());//设置纸张
            book.append(pdfPrintable, pageFormat, document.getNumberOfPages());
            printJob.setPageable(book);
            printJob.setCopies(1);//设置打印份数
            //添加打印属性
            HashPrintRequestAttributeSet pars = new HashPrintRequestAttributeSet();
            pars.add(Sides.DUPLEX); //设置单双页
            printJob.print(pars);
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static Paper getPaper() {
        Paper paper = new Paper();
        // 默认为A4纸张，对应像素宽和高分别为 595, 842
        int width = 595;
        int height = 842;
        // 设置边距，单位是像素，10mm边距，对应 28px
        int marginLeft = 10;
        int marginRight = 0;
        int marginTop = 10;
        int marginBottom = 0;
        paper.setSize(width, height);
        // 下面一行代码，解决了打印内容为空的问题
        paper.setImageableArea(marginLeft, marginRight, width - (marginLeft + marginRight), height - (marginTop + marginBottom));
        return paper;
    }
}
