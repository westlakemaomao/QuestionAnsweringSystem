/**
* @author hzyuyongmao
* @version 创建时间：2016年6月15日 下午1:10:47
* 类说明
*/
package test;

import java.util.List;

import org.apdplat.qa.SharedQuestionAnsweringSystem;
import org.apdplat.qa.model.CandidateAnswer;
import org.apdplat.qa.model.Question;

public class QAtest {
	 public static void main(String args[]){
		  String questionStr = "中国面积有多大？";
		  Question question = SharedQuestionAnsweringSystem.getInstance().answerQuestion(questionStr);
		  if (question != null) {
		      List<CandidateAnswer> candidateAnswers = question.getAllCandidateAnswer();
		      int i=1;
		      for(CandidateAnswer candidateAnswer : candidateAnswers){
		          System.out.println((i++)+"、"+candidateAnswer.getAnswer()+":"+candidateAnswer.getScore());
		      }
		  }
	  }
}
