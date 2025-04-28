package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Engine {
    List<Character> val= new ArrayList<>();
    Code[] code = new Code[23];
    int size = 0;
    public Engine(int value) {
        val.add('й');
        val.add('ф');
        val.add('я');
        val.add('ц');
        val.add('ы');
        val.add('ч');
        val.add('у');
        val.add('в');
        val.add('с');
        val.add('к');
        val.add('а');
        val.add('м');
        val.add('е');
        val.add('п');
        val.add('и');
        val.add('н');
        val.add('р');
        val.add('т');
        val.add('г');
        val.add('о');
        val.add('ь');
        val.add('ш');
        val.add('л');
        val.add('б');
        val.add('щ');
        val.add('д');
        val.add('ю');
        val.add('з');
        val.add('ж');
        val.add('э');
        val.add('х');
        val.add('ъ');
        val.add('ё');
        val.add(' ');
        val.add('1');
        val.add('2');
        val.add('3');
        val.add('4');
        val.add('5');
        val.add('6');
        val.add('7');
        val.add('8');
        val.add('9');
        val.add('0');
        val.add(',');
        val.add('.');
        Random rand = new Random(value);

        Collections.shuffle(val, rand);

        for (int i = 0; i < val.size() - 1; i += 2) {

            code[size] = new Code(val.get(i), val.get(i + 1));
            size++;
        }
        code[16] = new Code(val.get(32), val.get(32));
        size++;

        System.out.println(val);
    }

    private class Code {
        char one;
        char two;
        private Code(char a, char b) {
            one = a;
            two = b;
        }

        private int isThere(char a) {
            if (one == a) {
                return 1;
            } else if (two == a){
                return 2;
            }
            return 0;
        }
    }

    public String encode(String word) {
        char[] words = word.toCharArray();
        StringBuilder builder = new StringBuilder();
        char a = '-';
        for (int i = 0; i < words.length; i++) {
            if ((a = mirror(words[i])) != 0) {
                builder.append(a);
            }
        }
        return builder.toString();
    }

    private boolean have(char s) {
        for (int i = 0; i < size; i++) {
            if (code[i].isThere(s) > 0) {
                return code[i].isThere(s) > 0;
            }
        }
        return false;
    }

    private char mirror(char a) {
        if (code[0] == null) {
            return '-';
        }
        System.out.println(code.length);
        for (int i = 0; i < size; i++) {
            System.out.println(i);
            if (code[i].isThere(a) == 1) {
                return code[i].two;
            } else if (code[i].isThere(a) == 2) {
                return code[i].one;
            }
        }
        char r = '-';
        return r;
    }
}
