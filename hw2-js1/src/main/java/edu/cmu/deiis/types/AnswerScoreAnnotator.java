package edu.cmu.deiis.types;

import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.cas.FSIndex;
import edu.cmu.deiis.types.*;
public class AnswerScoreAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    //get document text
    String docText = aJCas.getDocumentText();
    // get annotation indexes
    FSIndex QuestionIndex = aJCas.getAnnotationIndex(Question.type);
    FSIndex AnswerIndex = aJCas.getAnnotationIndex(Answer.type);
    // read the "Question" annotation
    Question ques = (Question) QuestionIndex.iterator().next();
    //read the "Answer" annotation
    Iterator ansIte = AnswerIndex.iterator();
    int i =0;
    while (ansIte.hasNext()){
      //calculate the score 
      
      
      
      //create a new annotation
      Answer ans = (Answer) ansIte.next();
      AnswerScore annotation = new AnswerScore(aJCas);
      annotation.setBegin(ans.getBegin());
      annotation.setEnd(ans.getEnd());
      annotation.setAnswer(ans);
      annotation.setScore(0.1*i);
      annotation.addToIndexes();
      i++;
    }
    
    
  }

}
