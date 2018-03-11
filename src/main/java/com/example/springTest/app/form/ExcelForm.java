/**
 * @author super
 *
 */
package com.example.springTest.app.form;

import javax.validation.constraints.NotEmpty;

public class ExcelForm {

	@NotEmpty(message="Idを入力してください")
	private String targetId;
	@NotEmpty(message="oldJsonを入力してください")
	private String oldJson;
	@NotEmpty(message="newJsonを入力してください")
    private String newJson;

	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getOldJson() {
		return oldJson;
	}
	public void setOldJson(String oldJson) {
		this.oldJson = oldJson;
	}
	public String getNewJson() {
		return newJson;
	}
	public void setNewJson(String newJson) {
		this.newJson = newJson;
	}


}