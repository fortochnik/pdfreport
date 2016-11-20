package report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.ProductCount;
import dto.Statistic;
import dto.UserOrder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mipan on 20.11.2016.
 */
@ManagedBean
@SessionScoped
public class Report {
    private static final long serialVersionUID = 1L;
    public void generateReport() throws Exception {
        Statistic statistic = GetReport.getReport();

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        Date now = new Date();
        SimpleDateFormat ftshort = new SimpleDateFormat("yyyyMMdd_HHmmss");
        response.setHeader("Content-Disposition", "attachment;filename=" + "statistic" + "_" + ftshort.format(now) + ".pdf");

        OutputStream file = response.getOutputStream();

        Font fontHeader = new Font(Font.FontFamily.HELVETICA, 25);
        Font fontText = FontFactory.getFont("fonts/Tahoma.ttf", BaseFont.IDENTITY_H, true, 12);
        Font fontTextBold = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Document document = new Document();
        PdfWriter.getInstance(document, file);

        document.open();

        Paragraph paragraph;
        Phrase phrase;

        paragraph = new Paragraph("Statistics", fontHeader);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        paragraph = new Paragraph("");
        paragraph.setSpacingAfter(5f);
        document.add(paragraph);
        document.add(new Phrase("Cost per week: ", fontTextBold));
        document.add(new Phrase("$ " + statistic.getProceedsByWeek(), fontText));

        paragraph = new Paragraph("");
        paragraph.setSpacingAfter(5f);
        document.add(paragraph);
        document.add(new Phrase("Cost per month: ", fontTextBold));
        document.add(new Phrase("$ " + statistic.getProceedsByMonth(), fontText));

        paragraph = new Paragraph("Top products", fontHeader);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(4);
        float[] columnWidths = {1f, 1f, 3f, 1f};
        table.setWidths(columnWidths);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        table.addCell("#");
        table.addCell("id");
        table.addCell("Product");
        table.addCell("Count");

        int id = 0;
        for(ProductCount product : statistic.getTopTenProduct()){
            PdfPCell cell = new PdfPCell();
            cell.addElement(new Phrase(product.getName(), fontText));
            table.addCell(++id + "");
            table.addCell(product.getId() + "");
            table.addCell(cell);
            table.addCell(product.getCount()+"");
        }
        document.add(table);

        paragraph = new Paragraph("Top users", fontHeader);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        table = new PdfPTable(4);
        table.setWidths(columnWidths);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        table.addCell("#");
        table.addCell("id");
        table.addCell("User login");
        table.addCell("Orders Quantity");

        id = 0;
        for(UserOrder user : statistic.getTopTenUser()){
            table.addCell(++id + "");
            table.addCell(user.getId() + "");
            table.addCell(user.getLogin());
            table.addCell(user.getOrdersQuantity()+"");
        }
        document.add(table);

        document.close();
        file.close();
        FacesContext.getCurrentInstance().getResponseComplete();
    }
}
