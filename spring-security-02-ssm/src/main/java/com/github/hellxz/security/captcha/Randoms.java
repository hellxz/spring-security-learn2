package com.github.hellxz.security.captcha;

import java.awt.Color;
import java.util.Random;

public class Randoms
{
    private static final Random RANDOM = new Random();
    public static final char ALPHA[]={'0','1','2','3','4','5','6','7','8','9','A','C','D','E','F','G','H','J','K','M','P','Q','R','T','W','X','Y','a','c','d','e','f','h','j','k','m','n','p','r','t','w','x','y'};

    /**
     * 产生两个数之间的随机数
     * @param min 小数
     * @param max 比min大的数
     * @return int 随机数字
     */
    public static int num(int min, int max)
    {
        return min + RANDOM.nextInt(max - min);
    }

    /**
     * 产生0--num的随机数,不包括num
     * @param num 数字
     * @return int 随机数字
     */
    public static int num(int num)
    {
        return RANDOM.nextInt(num);
    }

    public static char alpha()
    {
        return ALPHA[num(0, ALPHA.length)];
    }
    
	/**
	 * 给定范围生成随机颜色
	 * 
	 * @param fc
	 * @param bc
	 * @return
	 */
	public static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(Math.abs(bc - fc));
		int g = fc + random.nextInt(Math.abs(bc - fc));
		int b = fc + random.nextInt(Math.abs(bc - fc));
		return new Color(r, g, b);
	}
}