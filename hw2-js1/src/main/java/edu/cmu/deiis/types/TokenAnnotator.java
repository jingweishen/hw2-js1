package edu.cmu.deiis.types;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.Token;
public class TokenAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    String docText = aJCas.getDocumentText();   //get document text
 // use ".\\ \\?" to split the document into parts
    String tags = "[.\\ \\?]"; 
    String []results = docText.split(tags);
    for (int i=0;i<results.length;i++){
      System.out.println(results[i]);
    }
  }

}
