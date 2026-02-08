package org.example.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharFlyweightFactory {
    private Map<String,CharFlyweight> map=new HashMap<>();

   public CharFlyweight createStyle(char ch,String fontName,int fontSize,boolean isBold,boolean isItalic){
        StringBuilder sb=new StringBuilder();
        sb.append(ch).append('-').append(fontName).append('-').append(fontSize);
        if(isBold) sb.append('-').append('b');
        if(isItalic) sb.append('-').append('i');

        String key=sb.toString();
        if(!map.containsKey(key)){
            map.put(key,new CharFlyweight(ch,fontName,fontSize,isBold,isItalic));
        }
        return map.get(key);
    }
}
