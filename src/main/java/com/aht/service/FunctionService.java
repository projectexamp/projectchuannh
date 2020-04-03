package com.aht.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.model.Function;
import com.aht.repository.FunctionRepository;

@Service
public class FunctionService {
	@Autowired
	private FunctionRepository fRepository;

	public List<Function> getAll() {

		return fRepository.findAll();
	}

	public Function createFunction(Function fun) {
		Function myFun = new Function();
		myFun.setStatus(0);
		myFun.setFunctionName(fun.getFunctionName());
		myFun.setFunctionUrl(fun.getFunctionUrl());
		myFun.setDescription(fun.getDescription());
		myFun.setFunctionCode(fun.getFunctionCode());
		myFun.setFunctionOrder(fun.getFunctionOrder());

		return fRepository.save(myFun);
	}

	public Function updateFunction(Function fun) {
		Function myFun = fRepository.findById(fun.getId()).get();
//		myFun.setStatus(2);
		myFun.setFunctionOrder(fun.getFunctionOrder());
		myFun.setFunctionUrl(fun.getFunctionUrl());
		myFun.setFunctionName(fun.getFunctionName());
		myFun.setDescription(fun.getDescription());
		myFun.setFunctionCode(fun.getFunctionCode());
		return fRepository.save(myFun);

	}

	public boolean deleteFunction(int id) {
		fRepository.delete(fRepository.findById(id).get());
		return true;
	}

	public Function getById(int id) {
		Optional<Function> funs = fRepository.findById(id);
		if (funs.isPresent())
			return funs.get();
		return null;
	}

	public Function activeFunc(int id) {
		Function myFun = fRepository.findById(id).get();
		myFun.setStatus(0);
		return fRepository.save(myFun);
	}

	public Function disableFunc(int id) {
		Function myFun = fRepository.findById(id).get();
		myFun.setStatus(1);
		return fRepository.save(myFun);
	}

	public Function delFunc(int id) {
		Function myFun = fRepository.findById(id).get();
		myFun.setStatus(2);
		return fRepository.save(myFun);
	}
}
