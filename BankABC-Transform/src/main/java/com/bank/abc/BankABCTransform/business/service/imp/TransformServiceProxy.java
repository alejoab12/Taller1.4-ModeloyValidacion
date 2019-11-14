package com.bank.abc.BankABCTransform.business.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bank.abc.BankABCTransform.business.service.TransformService;
import com.bank.abc.BankABCTransform.rest.handler.exception.CustomerException;
import com.bank.abc.BankABCTransform.rest.model.TransformModel;
@Service("TransformServiceProxy")
public class TransformServiceProxy implements TransformService {
	@Autowired
	@Qualifier("TransformService")
	private TransformService transformService;
	@Override
	public String transform(TransformModel transformModel) {
		String result=null;
		try{
			result=transformService.transform(transformModel);
		}catch(Exception ex) {
			throw new CustomerException(500,ex.getMessage());
		}
		return result;
	}

}
