package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.MyPageDTO;
import it.contrader.model.MyPage;

public class MyPageConverter implements Converter<MyPage, MyPageDTO> {
	public MyPageDTO toDTO(MyPage myPage) {
		MyPageDTO myPageDTO = new MyPageDTO(myPage.getId(), myPage.getMessage(), myPage.getChronology(), myPage.getDisputesReports());
		return myPageDTO;
		}


		public MyPage toEntity(MyPageDTO myPageDTO) {
		MyPage myPage = new MyPage(myPageDTO.getId(), myPageDTO.getMessage(), myPageDTO.getChronology(), myPageDTO.getDisputesReports());
		return myPage;
		}


		public List<MyPageDTO> toDTOList(List<MyPage> myPageList) {
		//Crea una lista vuota.
		List<MyPageDTO> myPageDTOList = new ArrayList<MyPageDTO>();

		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(MyPage myPage : myPageList) {
		//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
		//e lo aggiunge adda lista di DTO
		myPageDTOList.add(toDTO(myPage));
		}
		return myPageDTOList;
		}

}