package com.happy.javautil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageTest {

    public static void main(String[] args) {
        File file = new File("F:/image/pf.png");
        File file2 = new File("F:/image/kb.png");
        File file3 = new File("F:/image/bzs.png");
        try {
            InputStream inputStream = fileToInputStream(file);
            InputStream inputStream2 = fileToInputStream(file2);
            InputStream inputStream3 = fileToInputStream(file3);
            BufferedImage bufferedImage = modifyImage(inputStream, inputStream2);
            InputStream inputStream1 = bufferImagedToInputStream(bufferedImage);
            BufferedImage bufferedImage1 = modifyImage(inputStream1, inputStream3);
            writeImageLocal("F:/image/pt.png",bufferedImage1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static InputStream fileToInputStream(File file) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (Exception e) {
        }
        return inputStream;
    }

    public static BufferedImage streamToBufferedImage(InputStream inputStream) {
        BufferedImage read = null;
        try {
            read = ImageIO.read(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return read;
    }

    public static InputStream bufferImagedToInputStream(BufferedImage bufferedImage) {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            inputStream = new ByteArrayInputStream(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public static BufferedImage modifyImage(InputStream inpA, InputStream inpB) {
        BufferedImage bufferedImage = null;
        try {
            BufferedImage imageA = ImageIO.read(inpA);
            BufferedImage imageB = ImageIO.read(inpB);
            int heightA = imageA.getHeight();
            int widthA = imageA.getWidth();
            int widthB = imageB.getWidth();
            int heightB = imageB.getHeight();

            bufferedImage = new BufferedImage(widthA + widthB, heightB, BufferedImage.TYPE_INT_BGR);
            Graphics2D graphics = bufferedImage.createGraphics();
            graphics.drawImage(imageA, 0, 0, widthA, heightA, null);
            graphics.drawImage(imageB, widthA, 0, widthB, heightB, null);
            graphics.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    public static BufferedImage modifyImage(BufferedImage imageA, BufferedImage imageB) {
        BufferedImage bufferedImage = null;
        try {
            int heightA = imageA.getHeight();
            int widthA = imageA.getWidth();
            int widthB = imageB.getWidth();
            int heightB = imageB.getHeight();

            bufferedImage = new BufferedImage(widthA + widthB, heightB, BufferedImage.TYPE_INT_BGR);
            Graphics2D graphics = bufferedImage.createGraphics();
            graphics.drawImage(imageA, 0, 0, widthA, heightA, null);
            graphics.drawImage(imageB, widthA, 0, widthB, heightB, null);
            graphics.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    /**
     * 生成新图片到本地
     */
    public static void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "png", outputfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 图像旋转
     *
     * @param src
     * @param angel
     * @return
     */
    public static BufferedImage Rotate(Image src, double angel) {
        int src_width = src.getWidth(null);
        int src_height = src.getHeight(null);
        Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(
                src_width, src_height)), angel);

        BufferedImage res = null;
        res = new BufferedImage(rect_des.width, rect_des.height,
                BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g2 = res.createGraphics();
        // transform
        g2.translate((rect_des.width - src_width) / 2,
                (rect_des.height - src_height) / 2);
        g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);

        g2.drawImage(src, null, null);
        return res;
    }

    public static Rectangle CalcRotatedSize(Rectangle src, double angel) {
        // if angel is greater than 90 degree, we need to do some conversion
        if (angel >= 90) {
            if (angel / 90 % 2 == 1) {
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angel = angel % 90;
        }

        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angel_dalta_width = Math.atan((double) src.height / src.width);
        double angel_dalta_height = Math.atan((double) src.width / src.height);

        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_width));
        len_dalta_width = len_dalta_width > 0 ? len_dalta_width : -len_dalta_width;

        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_height));
        len_dalta_height = len_dalta_height > 0 ? len_dalta_height : -len_dalta_height;

        int des_width = src.width + len_dalta_width * 2;
        int des_height = src.height + len_dalta_height * 2;
        des_width = des_width > 0 ? des_width : -des_width;
        des_height = des_height > 0 ? des_height : -des_height;
        return new java.awt.Rectangle(new Dimension(des_width, des_height));
    }
}
