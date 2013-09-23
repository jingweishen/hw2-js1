package edu.cmu.deiis.types;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import edu.cmu.deiis.types.Question;
public class QuestionAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas myJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    
    //get document text
    String docText = myJCas.getDocumentText();
    int pos = docText.indexOf("\r");   // the position of the first occurance of "\r"
    if (pos!=-1)
    {
      Question annotation = new Question (myJCas);
      annotation.setBegin(2);
      annotation.setEnd(pos-1);
      
      
    }
    
    
    
    
    
  }

}
