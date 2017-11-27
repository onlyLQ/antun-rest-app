package com.qing.bigdata.antun.web.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qing.bigdata.antun.domain.User;
import com.qing.bigdata.antun.service.UserService;
import com.qing.bigdata.antun.web.model.UserAdd;
import com.qing.bigdata.antun.web.model.UserUpdate;

@Component
public class UserValidation {
	@Autowired
	private UserService userService;
	//姓名验证
	private String name_pattern="[\\u4e00-\\u9fa5]{2,10}";
	/**
	 * 新增验证
	 * @param userAdd
	 * @return
	 */
	public String addUserValidation(UserAdd userAdd) {
		//姓名是否为空
		if(StringUtils.isBlank(userAdd.getName()))
			return "姓名为空";
		//正则表达式验证姓名格式
		if(!userAdd.getName().matches(name_pattern))			
			return "姓名不符合要求";
		
		//手机号是否为空
				if (StringUtils.isBlank(userAdd.getPhone()))
					return "手机号不可为空";
		//手机号格式
		if (userAdd.getPhone().length() != 11)
			return "请输入正确的手机号";
		
		//手机号去重
		User user=userService.findByPhone(userAdd.getPhone());
		if(user!=null)
			return "手机号重复";
		
		
		// 身份证验证
		if (StringUtils.isBlank(userAdd.getIdNo()))
			return "身份证号不可为空";
		if (userAdd.getIdNo().length() != 18)
			return "身份证号不符合要求";

		
		// 性别不能为空
		if (userAdd.getSex()==null)
			return "性别不可为空";
			
		if (userAdd.getSex() != 0 && userAdd.getSex() != 1)
			return "请输入0(女生) 或1(男生)";


		//如果没有错误返回,表示验证通过,返回null
		return null;
	}
	/**
	 * 修改验证
	 * @param userUpdate
	 * @return
	 */
	public String updateUserValidation(UserUpdate userUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
