package com.example.spring_test.validation.validator;

import com.example.spring_test.validation.annotation.HW5Id;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.regex.Pattern;

public class HW5IdValidator implements ConstraintValidator<HW5Id, String> {
    static char[] characterArray = new char[26];//A-Z
    static int[] numberArray = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 32};//A-Z對應的數字
    static int[] stringToIntArray = new int[26];//放輸入的字串
    @Override
    public boolean isValid(String hw5id, ConstraintValidatorContext context) {

        try {
            for(int i = 0; i <= 25; i++){
                characterArray[i] = (char) (65 + i);//把英文字母放入字元陣列，強制轉型A->65
            }
            hw5id = hw5id.toUpperCase();
            int index = 0;
            char firstLetter = hw5id.charAt(0);
            for(int i = 1; i <= hw5id.length() - 1; i++){
                stringToIntArray[i] = (int)(hw5id.charAt(i)) - 48;//把身分證字號放入stringToIntArray[]，inputString.charAt(i)裡面的是字元1->49所以減48int 1
            }
            index = Arrays.binarySearch(characterArray,firstLetter);//輸入的第一個英文字母判斷她是在characterArray中的第幾個index
            int d0 = numberArray[index];//對應到的數字抓出來放入d0
            int x2 = (d0) % 10;//d0的個位數
            int x1 = (int)Math.floor((d0) / 10);//d0的十位數

            int result = x1 + (9 * x2) + (8 * stringToIntArray[1]) + (7 * stringToIntArray[2]) + (6 * stringToIntArray[3]) + (5 * stringToIntArray[4]) + (4 * stringToIntArray[5]) + (3 * stringToIntArray[6]) + (2 * stringToIntArray[7]) + (stringToIntArray[8]);
            int checkCode = 10 - (result % 10);
            boolean check;
            if(stringToIntArray[9] == checkCode){
                check = true;
            }else{
                check = false;
            }
            boolean isValid = check;
            return isValid;
        } catch(Exception e) {
            boolean isValid = false;
            return isValid;
        }
    }

}
