/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 /* 27734の曖昧さ回避ページがある */
package extractfromleadsentence;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeMap;

/**
 *
 * @author kosuke
 */
public class ExtractAimai {
	public static void main(String args[]){			
	String line = "";
        String title="";
        int count = 0;
        boolean aimai_Flag = false;
        boolean delete_Flag = false;    //trueの場合はメモリに記録していかない。
        String contents = "";
        
        
        HashSet<String> words = new HashSet<String>();
	TreeMap<String, Integer> tm = new TreeMap<String, Integer>();//　noun_mecab_article_noninverse_index　wiki_rawtext_kakkoari　ketteiban_wiki_cabocha_rawtext_kakkoari
        try {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/kosuke/Desktop/jawikidump.xml"),"utf-8"));
		
                while((line = br.readLine()) != null){
                    if(line.contains("<title>")){
                        title = line.replaceFirst(".*<title>", "").replaceFirst("</title>.*", "");
                       // delete_Flag = true;
                    }
                    
                    if(line.contains("<text")){
                        delete_Flag = false;
                    }
                    
                    if(delete_Flag==false){
                        contents = contents + line+"\n";
                    }
                    
                    if(line.contains("{{aimai}}")){
                       aimai_Flag = true;
                       delete_Flag = true;
                       count++;
                    }
                    
                    if(line.contains("</page>")){
                        //ここでflagが立っていたかどうかで残すかどうかを判定する
                        if(aimai_Flag==true){
                            System.out.println(title);
                            System.out.println(contents);
                            //Extract(contents.replaceAll("\\{\\{aimai\\}\\}", ""));
                        }
                        
                        aimai_Flag = false;
                        delete_Flag = true;
                        title = "";
                        contents="";
                    }
		    if(count%1000==0) System.out.println(count);
                   

                }
                System.out.println("おわり"+count);
                
                System.out.println(count);
                
                br.close();
                
	} catch (FileNotFoundException e) {
	e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
	}
        

    }
}
