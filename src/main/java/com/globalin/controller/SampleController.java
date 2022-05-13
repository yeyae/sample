package com.globalin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalin.domain.SampleVO;
import com.globalin.domain.Ticket;

@RestController
@RequestMapping("/sample")
public class SampleController {

	private Logger log = LoggerFactory.getLogger(SampleController.class);

	/*
	 * RestController는 jsp와 달리 순수한 데이터를 반환해준다. 다양한 형식의 데이터를 전송할 수 있다. 주로 많이 사용하는 형태
	 * : 문자열, JSON, XML
	 */

	// 문자열을 반환하는 형태
	// Controller는 리턴타입이 String인 메소드 :
	// 리턴한 결과가 JSP 파일 이름이 되어있는데, RestController는 순수한 데이터를 준다.
	// produces 속성은 메소드가 생성하는 media type를 의미한다.(mime type)

	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {

		log.info("type : " + MediaType.TEXT_PLAIN_VALUE);

		return "안녕하세요";
	}

	// 객체 반환 json 이나 xml을 이용한다.
	@GetMapping(value = "/getSample", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SampleVO getSample() {

		return new SampleVO(2, "스티븐", "스트레인지");

	}

	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			SampleVO s = new SampleVO(i, i + "first", i + "last");
			list.add(s);
		}

		return list;
	}

	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("First", new SampleVO(11, "그루트", "주니어"));
		return map;
	}
//헤더 정보를 조작해서 헤더의 상태메시지를 같이 포함해서 전달하는 방법
	
	@GetMapping(value="/check", params= {"height" , "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		
		SampleVO s = new SampleVO(0, "" + height, "" + weight);
		
		//우리가 리턴해줄 ResponseEntity 객체
		ResponseEntity<SampleVO> result = null;
		
		//키가 180이하이면 BAD_GATEWAY
		if(height <= 180) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(s);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(s);
		}
		//키가 180보다 크면 OK
		return result;
	}
	
	//RestController에서 많이 사용하는 URL 경로에 파라미터를 포함하는 방법
	//?파라미터 = 값  : 쿼리스트링
	// /파라미터값/
	//이 요청은 요청 url에 파라미터 값이 포함되어 있다.
	//각 파라미터의 이름은 cat, pid 이다. (값이 cat, pid는 아님)
	@GetMapping("/product.{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat,
			@PathVariable("pid") Integer pid) {
		//String cat은 url에 {cat} 자리에 있는 값을 가져온다.
		//integer pid는 url에 {pid} 자리에 있는 값을 가져온다.
		//cat : category // pid : product id
		//PathVariable에는 기본자료형 사용 x
		return new String[] {"category : " + cat , "productid: " + pid};
	}
	
	@PostMapping("/ticket")
	public Ticket ticket(@RequestBody Ticket ticket) {
		
		log.info("ticket : " + ticket);
		
		return ticket;
		
	}
	
}
