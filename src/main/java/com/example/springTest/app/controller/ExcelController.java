/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.app.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springTest.app.form.ExcelForm;
import com.example.springTest.app.view.ExcelView;
import com.example.springTest.domain.service.ExcelService;

@Controller
@RequestMapping("/excelTest")
public class ExcelController {

	@Autowired
	ExcelService excelService;

    @ModelAttribute("excelForm")
    public ExcelForm excelForm() {
        return new ExcelForm();
    }

    @RequestMapping("/check")
    public ModelAndView index(@ModelAttribute("excelForm") ExcelForm form , Model model){
		// 生成
		ModelAndView mv = new ModelAndView();
		// テンプレートを指定
		mv.setViewName("excelTest/excelTest");
		// 日時を取得、設定
		mv.addObject("now", new Date().toString());
		// modelに設定して画面に表示するようにする
		mv.addObject("form", form);
        return mv;
    }

    //TODO Excelをダウンロードする処理を追加する
	// POST用のパラメータを受け取る
	@RequestMapping(value = {"/check"}, method = {RequestMethod.POST})
	public String doCheck(
			RedirectAttributes attributes,@ModelAttribute("excelForm") @Validated ExcelForm form,BindingResult result) {

		if(result.hasErrors()) {
			return "excelTest/excelTest";
		}
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("data", form);
		attributes.addFlashAttribute("model",modelMap);
        return "redirect:/excelTest/doCheck";
	}

    //TODO Excelをダウンロードする処理を追加する
	// POST用のパラメータを受け取る
	@RequestMapping(value = {"/doCheck"}, method = {RequestMethod.GET})
	public ModelAndView doCheckAndDownload(
			@ModelAttribute("model")ModelMap modelMap) {

		ExcelForm form = (ExcelForm) modelMap.get("data");
		System.out.println("実行前ID:"+form.getTargetId());
		System.out.println("実行前oldJson:"+form.getOldJson());
		System.out.println("実行前newJson:"+form.getNewJson());
		//チェック処理を行う
		Map<String,String> resultMap = excelService.doValidate(form);
		String result = resultMap.get("result");

		String fileName = "【"+ result +"】" +form.getTargetId()+".xlsx";
		//結果でファイル名を設定する
        View view = new ExcelView(fileName, new UserExcel());

        Map<String, Object> params = new HashMap<>();
        params.put("result", result);
        params.put("id", form.getTargetId());
        params.put("oldJson", form.getOldJson());
        params.put("newJson", form.getNewJson());

        ModelAndView mv = new ModelAndView(view, params);

        return mv;
	}
}