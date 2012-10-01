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
			    String sentence = line.replaceAll("画像:.*?.jpg", "").replaceAll("画像:.*?.png", "").replaceAll("画像:.*?.gif", "").replaceAll("（.*?）", "");
			    sentencenum++;
			    if(line.contains("<<<<")){
				sentencenum = 0;
				title = line.replaceAll("<<<<", "").replaceAll(">>>>", "");
			    }
			    if(sentencenum==1 && !line.contains("#REDIRECT") && !line.contains("#転送")){
				    System.out.println(title+"-------");
			        System.out.println(sentence +"\n");
				count++;
				Cabocha cabocha = new Cabocha("C://Program Files/CaboCha/bin/cabocha.exe");
					try{
					    Sentence stc = null;
					    stc = cabocha.execute(sentence.replaceAll(" ", "").replaceAll("　", ""));
					    int chunksize = stc.getChunks().size();
					    for(int i=0;i<chunksize;i++){
						    System.out.println(stc.getChunks().get(i).getBase().toString());
						/*for(int j=0;j<stc.getChunks().get(i).getTokens().size();j++){
						
						  System.out.print(stc.getChunks().get(i).getTokens().get(j).getSurface()+",");
						}*/
					    }

					    //System.out.println(pos.get(pos.size()-2)+"\n"+pos.get(pos.size()-1));
						System.out.println("\n");
					}catch (InterruptedException ex) {
					}catch (IOException e) {
						System.out.println("Error!");
					}
			    }
			    //if(count%1000==0) System.out.println(count);

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
