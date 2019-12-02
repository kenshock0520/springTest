/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springTest.app.form.LoginForm;
import com.example.springTest.domain.service.TestService;

@Controller
public class LoginController {

	@Autowired
	TestService testService;

	@Value("${test.value}")
	String value;

	@RequestMapping(value = { "/login" }, method = { RequestMethod.GET })
	public ModelAndView index(@ModelAttribute LoginForm form) {

		// 生成
		ModelAndView mv = new ModelAndView();

		// テンプレートを指定
		mv.setViewName("login/login");

		// 日時を取得、設定
		mv.addObject("now", new Date().toString());

		// modelに設定して画面に表示するようにする
		mv.addObject("form", form);

		// 返却
		return mv;
	}

	// POST用のパラメータを受け取る
	@RequestMapping(value = { "/formPost" }, method = { RequestMethod.POST })
	public ModelAndView postTest1(@ModelAttribute LoginForm form) {

		// 生成
		ModelAndView mv = new ModelAndView();

		// テンプレートを指定
		mv.setViewName("top/top");

		// modelに設定して画面に表示するようにする
		mv.addObject("form", form);

		System.out.println("格納");
		mv.addObject("dataValue", value);

		// 返却
		return mv;
	}

	// GET用のパラメータを受け取る
	@RequestMapping(value = { "/formPost" }, method = { RequestMethod.GET })
	public ModelAndView getTest1(@ModelAttribute LoginForm form) {

		// 生成
		ModelAndView mv = new ModelAndView();

		// テンプレートを指定
		mv.setViewName("top/top");

		// modelに設定して画面に表示するようにする
		mv.addObject("form", form);

		System.out.println("格納");
//		mv.addObject("data", testService.getTests());
		mv.addObject("dataValue", value);

		// 返却
		return mv;
	}

}