package com.example.mechanicalapp.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtils {
    public static String getPinYinAllChar(String zn_str, int caseType) {
        char[] strChar = zn_str.toCharArray();
        HanyuPinyinOutputFormat hanYuPinOutputFormat = new HanyuPinyinOutputFormat();
        // 输出设置，大小写，音标方式等
        if (1 == caseType) {
            hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        } else {
            hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        }
        hanYuPinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hanYuPinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

        StringBuffer pyStringBuffer = new StringBuffer();
        String[] strString = new String[strChar.length];
        try {
            for (int i = 0; i < strChar.length; i++) {
                if (Character.toString(strChar[i]).matches("[\\u4E00-\\u9FA5]+")) {//如果是汉字字符
                    strString = PinyinHelper.toHanyuPinyinStringArray(strChar[i], hanYuPinOutputFormat);
                    pyStringBuffer.append(strString[0]);//取出该汉字全拼的第一种读音并连接到字符串pyStringBuffer后
                } else {
                    //如果不是汉字字符，直接取出字符并连接到字符串pyStringBuffer后
                    pyStringBuffer.append(Character.toString(strChar[i]));
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return pyStringBuffer.toString().substring(0,1).toUpperCase();
    }

}
