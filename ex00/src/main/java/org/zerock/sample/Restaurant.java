package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

@Component
@ToString
@AllArgsConstructor
public class Restaurant {

	//�ʵ�����
	@Autowired
	private Chef chef;
	
	/*
	 * Setter����
	 @Setter(onMethod_ = {@Autowired} )
	 private Chef chef;
	 */
	
	/*
	 ������ ����
	 @AllArgsConstructor�߰� ��
	 private Chef chef;
	 */
}
