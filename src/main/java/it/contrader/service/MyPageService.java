package it.contrader.service;

import it.contrader.converter.MyPageConverter;
import it.contrader.dao.MyPageDAO;
import it.contrader.dto.MyPageDTO;
import it.contrader.model.MyPage;



public class MyPageService  extends AbstractService<MyPage, MyPageDTO> {

	public MyPageService(){
		this.dao = new MyPageDAO();
		this.converter = new MyPageConverter();
	}
	
}
