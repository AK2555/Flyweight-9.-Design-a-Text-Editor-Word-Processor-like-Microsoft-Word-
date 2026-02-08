package org.example;

import org.example.flyweight.CharFlyweight;
import org.example.flyweight.CharFlyweightFactory;

import java.util.ArrayList;
import java.util.List;

public class Solution implements Q09TextEditorInterface{
    private Helper09 helper;

    private CharFlyweightFactory factory;
    private List<TextRow> rows;


    public Solution(){
        this.factory=new CharFlyweightFactory();
        this.rows=new ArrayList<>();
    }
    public void init(Helper09 helper) {
        this.helper=helper;
    }

    public void addCharacter(int row, int column, char ch,
                             String fontName, int fontSize, boolean isBold, boolean isItalic) {

            while(row>=rows.size()) rows.add(new TextRow());
            CharFlyweight flyweight = factory.createStyle(ch,fontName,fontSize,isBold,isItalic);
            rows.get(row).addCharacter(flyweight,column);
           }

    // return "k-tahoma-22-b-i" or "j-Arial Black-8-i"
    public String getStyle(int row, int col) {
        if(row<0 || row>=rows.size()) return "";
        CharFlyweight flyweight=rows.get(row).getFlyweight(col);
        return flyweight==null ? "": flyweight.getCharAndStyle();
    }

    // e.g."what are you waiting for"
    public String readLine(int row) {
        if(row<0 || row>= rows.size()) return "";
        List<CharFlyweight> flyweights=rows.get(row).readLine();
        char[] ch =new char[flyweights.size()];
        for(int i=0;i<flyweights.size();i++){
            ch[i]=flyweights.get(i).getCh();
        }
        return new String(ch);
    }

    // returns true if a character is deleted or false if no character
    public boolean deleteCharacter(int row, int col) {
       if(row<0 || row>= rows.size()) return false;
       return rows.get(row).deleteCharacter(col);
    }
}


  interface Q09TextEditorInterface{
  void init(Helper09 helper);
  void addCharacter(int row, int column, char ch, String fontName,
  int fontSize, boolean isBold, boolean isItalic);
  String getStyle(int row, int col);
  String readLine(int row);
  boolean deleteCharacter(int row, int col);
  }
  class Helper09{
  void print(String s){System.out.print(s);} void println(String s){print(s+"\n");}
  }
