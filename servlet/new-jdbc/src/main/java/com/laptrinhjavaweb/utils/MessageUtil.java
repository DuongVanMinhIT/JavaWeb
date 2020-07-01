package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

import com.laptrinhjavaweb.controller.constant.SystemConstant;

public class MessageUtil {
	public static void showMessage(HttpServletRequest req) {
		if (req.getParameter(SystemConstant.Message) != null) {
			String messageResponse = "";
			String alert = "";
			String message = req.getParameter(SystemConstant.Message);
			if (message.equals(SystemConstant.MSIssert)) {
				messageResponse = SystemConstant.MSIssert;
				alert = SystemConstant.showMs;
			} else if (message.equals(SystemConstant.MSUpdate)) {
				messageResponse = SystemConstant.MSIssert;
				alert =  SystemConstant.showMs;
			} else if (message.equals(SystemConstant.MSDetele)) {
				messageResponse = SystemConstant.MSDetele;
				alert =  SystemConstant.showMs;
			} else if (message.equals(SystemConstant.MSError)) {
				messageResponse = SystemConstant.MSError;
				alert =  SystemConstant.MSError;
			}
			req.setAttribute("messageResponse", messageResponse);
			req.setAttribute("alert", alert);
		}
	}
}