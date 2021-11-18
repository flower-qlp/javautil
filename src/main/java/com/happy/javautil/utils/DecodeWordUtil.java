package com.happy.javautil.utils;

import com.alibaba.fastjson.JSON;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class DecodeWordUtil {


   public static void word(String wordPath){

   }

    public static void decodeWord(String wordPath, String imageUrl, String outFile) {

        String originalUrl = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(wordPath));
            //二维码
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

            Map<DecodeHintType, Object> hintTypeObjectMap = new HashMap<>();
            hintTypeObjectMap.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = null;
            result = new MultiFormatReader().decode(binaryBitmap, hintTypeObjectMap);

            originalUrl = result.getText();
            System.out.println("originalUrl=" + originalUrl);
            //解码
            ResultPoint[] resultPoints = result.getResultPoints();
            System.out.println("resultPoint=" + JSON.toJSONString(resultPoints));

            float point1x = resultPoints[0].getX();
            float point1y = resultPoints[0].getY();
            float point2x = resultPoints[1].getX();
            float point2y = resultPoints[1].getY();

            //替换二维码
            BufferedImage image = ImageIO.read(new File(imageUrl));

            //设置宽高
            final int w = (int) Math
                    .sqrt(Math.abs(point1x - point2x) * Math.abs(point1x - point2x) + Math.abs(point1y - point2y) * Math.abs(point1y - point2y))
                    + 12 * (7 - 1);
            final int h = w;

            Hashtable<EncodeHintType, Object> hintTypeObjectHashtable = new Hashtable<>();
            hintTypeObjectHashtable.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hintTypeObjectHashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hintTypeObjectHashtable.put(EncodeHintType.MARGIN, 1);

            Graphics2D graphics2D = bufferedImage.createGraphics();

            int x = Math.round(point1x);
            int y = Math.round(point2y);

            //绘制图片
            graphics2D.drawImage(image, x, y, w, h, null);
            //边框
            graphics2D.setStroke(new BasicStroke(2));
            //边框颜色
            graphics2D.setColor(Color.white);
            graphics2D.drawRect(x, y, w, h);
            bufferedImage.flush();
            graphics2D.dispose();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            File file = new File(outFile);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(imageInByte);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        decodeWord("F:\\20190122195336302.jpg","F:\\20190122195438274.jpg","F:\\123.jpg");
    }

}
