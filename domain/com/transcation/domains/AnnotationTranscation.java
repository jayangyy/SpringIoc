package com.transcation.domains;

import org.springframework.transaction.annotation.Transactional;

public class AnnotationTranscation {

	@Transactional(rollbackFor = Exception.class)
	public void TestTrans() {
		Integer id = 0;
		try {
			id++;
			System.out.print(id.toString());
			throw new RuntimeException("×¢ÊÍ");
		} catch (Exception ex) {
			System.out.println("id=" + id.toString());
		}

	}
}
