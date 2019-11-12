package com.github.hellxz.security.captcha;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

/**
 * <p>png格式验证码</p>
 *
 * @author: wuhongjun
 * @version:1.0
 */
public class SpecCaptcha extends Captcha {
    public SpecCaptcha() {
    }

    public SpecCaptcha(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public SpecCaptcha(int width, int height, int len) {
        this(width, height);
        this.len = len;
    }

    public SpecCaptcha(int width, int height, int len, Font font) {
        this(width, height, len);
        this.font = font;
    }

    /**
     * 生成验证码
     *
     * @throws IOException IO异常
     */
    @Override
    public void out(OutputStream out) {
        graphicsImage(alphas(), out);
    }

    /**
     * 画随机码图
     *
     * @param strs 文本
     * @param out  输出流
     */
    private boolean graphicsImage(char[] strs, OutputStream out) {
        boolean ok = false;
        try {
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = (Graphics2D) bi.getGraphics();
            AlphaComposite ac3;
            int len = strs.length;
            g.setColor(Randoms.getRandColor(200, 250));
            g.fillRect(0, 0, width, height);
            // 随机画干扰的蛋蛋
            for (int i = 0; i < 15; i++) {
                g.setColor(Randoms.getRandColor(160, 200));
                g.drawOval(Randoms.num(width), Randoms.num(height), 5 + Randoms.num(10), 5 + Randoms.num(10));// 画蛋蛋，有蛋的生活才精彩
            }
            g.setFont(font);
            int h = height - ((height - font.getSize()) >> 1),
                    w = width / len,
                    size = w - font.getSize() + 1;
            /* 画字符串 */
            int degree = 0;
            for (int i = 0; i < len; i++) {
                degree = Randoms.num(-30, 30);
                ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);// 指定透明度
                g.setComposite(ac3);
                g.setColor(Randoms.getRandColor(160, 200));
                g.rotate(Math.toRadians(degree), (width - (len - i) * w) + (w - font.getSize()) + 1, 21);
                g.drawString(strs[i] + "", (width - (len - i) * w) + size, h - 4);
                g.rotate(-Math.toRadians(degree), (width - (len - i) * w) + size, 21);//旋转之后，必须旋转回来
                ac3 = null;
            }
            ImageIO.write(bi, "png", out);
            out.flush();
            ok = true;
        } catch (IOException e) {
            ok = false;
        } finally {
            Streams.close(out);
        }
        return ok;
    }
}