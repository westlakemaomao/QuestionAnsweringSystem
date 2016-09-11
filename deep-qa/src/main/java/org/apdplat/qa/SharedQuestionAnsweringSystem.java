/**
 * 
 * APDPlat - Application Product Development Platform
 * Copyright (c) 2013, 杨尚川, yang-shangchuan@qq.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package org.apdplat.qa;

import org.apdplat.qa.datasource.BaiduDataSource;
import org.apdplat.qa.datasource.DataSource;
import org.apdplat.qa.datasource.FileDataSource;
import org.apdplat.qa.datasource.GoogleDataSource;
import org.apdplat.qa.files.FilesConfig;
import org.apdplat.qa.model.Question;
import org.apdplat.qa.system.CommonQuestionAnsweringSystem;
import org.apdplat.qa.system.QuestionAnsweringSystem;

/**
 * 使用指定或自定义数据源的共享问答系统 数据源需实现DataSource接口
 * 
 * @author
 */
public class SharedQuestionAnsweringSystem {
//	private static final QuestionAnsweringSystem QUESTION_ANSWERING_SYSTEM = new CommonQuestionAnsweringSystem();
	private static  QuestionAnsweringSystem QUESTION_ANSWERING_SYSTEM = new CommonQuestionAnsweringSystem();

	// static{
	// QUESTION_ANSWERING_SYSTEM.setDataSource(new BaiduDataSource());
	//
	//// QUESTION_ANSWERING_SYSTEM.setDataSource(new
	// FileDataSource(FilesConfig.locationNameMaterial));
	// //用户自定义问答候选文件
	//// QUESTION_ANSWERING_SYSTEM.setDataSource(new
	// FileDataSource(FilesConfig.userDefinedMaterial));
	// }
	public static QuestionAnsweringSystem getInstance() {
		return QUESTION_ANSWERING_SYSTEM;
	}

	public static QuestionAnsweringSystem getInstanceByDataSourceType(String type) {
		if (type.equals("userid")) {
			QUESTION_ANSWERING_SYSTEM.setDataSource(new FileDataSource(FilesConfig.userDefinedMaterial));
			return QUESTION_ANSWERING_SYSTEM;
		} else{
			QUESTION_ANSWERING_SYSTEM.setDataSource(new BaiduDataSource());
			return QUESTION_ANSWERING_SYSTEM;
		}

	}

	public static void main(String[] args) {
		DataSource dataSource = QUESTION_ANSWERING_SYSTEM.getDataSource();
		System.out.println(dataSource.toString());
		Question question = dataSource.getQuestion("亚洲耕地面积最大的国家是");
		System.out.println(question.getText());
		System.out.println(question.getQuestion());
	}
}
