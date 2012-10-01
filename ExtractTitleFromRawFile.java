/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extractfromleadsentence;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author kosuke
 */
public class ExtractTitleFromRawFile {
	  public static void main(String args[]){
		try {
		String line = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\kosuke\\Desktop\\wiki_rawtext_kakkoari.txt"),"utf-8"));
		File file = new File("C:\\Users\\kosuke\\Desktop\\wiki_article_title.txt");
                FileWriter fw = new FileWriter(file, true); 
		//素性変換後のデータをarffファイルへ出力
		while((line = br.readLine()) != null){
		   if(line.contains("<<<<") && line.contains(">>>>")){
		      String title =  line.replaceAll("<<<<", "").replaceAll(">>>>", "");
	              
	              fw.write(title+"\r\n");            //@dataより手前を書き出す
		      System.out.println(title);
		   }
		}
		br.close();
		fw.close();
	    } catch (FileNotFoundException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	  }
}
