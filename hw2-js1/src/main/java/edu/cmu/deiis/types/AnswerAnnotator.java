package edu.cmu.deiis.types;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import edu.cmu.deiis.types.Answer;
public class AnswerAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    //get document text
    String docText = aJCas.getDocumentText();
    
    // use ". \\ ?" to split the document into parts
    String tags = "[.\\?]";   
    String []results = docText.split(tags);
    
    for (int i =1;i< results.length;i++)
    {
      String ans = results[i].substring(3);
      System.out.println(ans);
    }
    int pos = results[0].length();
    
    for (int i=1;i<results.length;i++)
    {
      //create annotation
      Answer annotation = new Answer(aJCas);
     
      annotation.setBegin(pos+4);
      annotation.setEnd(pos+results[i].length());
      pos = pos + results[i].length();   // update the position 
      
    }
    System.out.println("successful launch of 'AnswerAnnotator' ");
    
  }

}
