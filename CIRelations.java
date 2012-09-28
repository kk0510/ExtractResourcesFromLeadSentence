/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extractfromleadsentence;
import java.util.*;
import java.io.*;
import com.cignoir.cabocha.*;
import com.cignoir.enums.PosDiv;
import com.cignoir.node.*;
import java.math.RoundingMode;
/**
 *
 * @author kosuke
 */
public class CIRelations {
	public void ExtractCIRelations(){
		try {
		    String line = "";
		    String title ="";
		    int sentencenum = 0;
		    int count = 0;
		    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\kosuke\\Desktop\\wiki_rawtext_kakkoari.txt"),"utf-8"));
		    //File file = new File(outputFileName);
		    //FileWriter fw = new FileWriter(file, true); 
		    //fw.write(arfffile_template);            //@dataより手前を書き出す
		    //素性変換後のデータをarffファイルへ出力
		    while((line = br.readLine()) != null){
			    sentencenum++;
			    if(line.contains("<<<<")){
				sentencenum = 0;
				title = line.replaceAll("<<<<", "").replaceAll(">>>>", "");
			    }
			    if(sentencenum==1 && !line.contains("#REDIRECT")){
				    System.out.println(title+"-------");
			        System.out.println(line+"\n");
				count++;
			    }

		    }
		    br.close();
		    System.out.println(count);
		    //fw.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	
	
	
	
	
	}
}
