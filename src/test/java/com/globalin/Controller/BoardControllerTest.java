package com.globalin.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//이 클래스를 스프링 환경에서 테스트 합니다.
@RunWith(SpringJUnit4ClassRunner.class)
//스프링 설정 파일의 위치를 정해줍니다.
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })

//컨트롤러를 위한 테스트 클래스(웹 설정을 사용합니다.)
@WebAppConfiguration
public class BoardControllerTest {

	private static Logger log = LoggerFactory.getLogger(BoardControllerTest.class);

	// 스프링의 웹 설정 불러오기
	// Servlet의 servlet-context를 사용하기 위해서 필요한 설정
	@Autowired
	private WebApplicationContext ctx;

	// MOCK UP 목업
	// 내용이 없고 껍데기만 비슷하게 만들어 놓은 것(프로토 타입 만들기)
	// MVC 패턴을 테스트하기 위해서 서버 없이 동작해 볼 수 있도록 해주는 클래스
	private MockMvc mockMvc;

	// 테스트 메소드 실행하기 전에 항상 먼저 실행되는 메소드를 처리 => @Before
	// 가짜 mvc를 만들어 주기 (기능만 테스트 할꺼다)
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

	}

	@Test
	public void testList() throws Exception {
		log.info(
     mockMvc.perform(MockMvcRequestBuilders.get("/board/list").param("pageNum", "2").param("amount", "10")).andReturn().getModelAndView().getModelMap().toString());
	}
	
//	@Test
//	public void testRegister() throws Exception{
//		String result ="";
//		result = mockMvc.perform(MockMvcRequestBuilders.post("/board/register").param("title", "MOCK TEST TITLE").param("content", "MOCK TEST CONTENT").param("writer", "MOCKUSER")).andReturn().getModelAndView().getViewName();
////viewName : 다음에 갈 뷰 이름 ( 사용자가 볼 페이지 경로)
//		log.info(result);
//	}
	
	@Test
	public void testGet() throws Exception{
		log.info(
			     mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "2")).andReturn().getModelAndView().getModelMap().toString());
				}
	
//	@Test
//	public void testModify() throws Exception{
//		String result = "";
//		result = mockMvc.perform(
//	MockMvcRequestBuilders.post("/board/modify").param("bno", "1").param("title", "수정된 테스트 제목").param("content", "수정된 테스트 내용").param("writer", "수정된 작성자")).andReturn().getModelAndView().getViewName(); //가짜 Mvc 실행
//	
//	log.info(result);
//	}
	
	
//	@Test
//	public void testRemove() throws Exception{
//		String result = "";
//		result = mockMvc.perform
//				(MockMvcRequestBuilders.post("/board/remove").param("bno", "2")).andReturn().getModelAndView().getViewName();
//		
//		log.info(result);
//	}
	}
