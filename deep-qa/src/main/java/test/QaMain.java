/**
* @author hzyuyongmao
* @version 创建时间：2016年9月11日 下午4:46:19
* 类说明
*/
package test;

import java.util.ArrayList;
import java.util.List;

import org.apdplat.qa.SharedQuestionAnsweringSystem;
import org.apdplat.qa.model.CandidateAnswer;
import org.apdplat.qa.model.Question;

public class QaMain {
	
	public static List<CandidateAnswer> getQaQuestion(String questionStr) {

		Question question = SharedQuestionAnsweringSystem.getInstanceByDataSourceType("baidu")
				.answerQuestion(questionStr);
		List<CandidateAnswer> candidateAnswers = new ArrayList<CandidateAnswer>();
		if (question != null) {
			candidateAnswers = question.getAllCandidateAnswer();

		}
		return candidateAnswers;
	}
	
	public static void main(String[] args) {
		 List<CandidateAnswer>  list=	QaMain.getQaQuestion("老聃科技的创始人是谁");
		 for(CandidateAnswer ca:list){
			 System.out.println(ca.getAnswer());
		 }
		 
	}
}
