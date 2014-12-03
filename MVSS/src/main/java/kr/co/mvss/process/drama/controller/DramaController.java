package kr.co.mvss.process.drama.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.co.mvss.process.drama.service.DramaService;
import kr.co.mvss.util.CommonUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Drama에 관련된 컨트롤러
 * @author 조호영.
 * @since 2014.11.27
 * @version 0.1
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2014.11.27  조호영          최초 생성
 *
 * </pre>
 */

@Controller
@RequestMapping("/drama")
public class DramaController {
	
	private static final Logger logger = LoggerFactory.getLogger(DramaController.class);
	
	@Resource(name = "dramaService")
	private DramaService dramaService;
	
	/**
	 * Piece와 drama를 사용해서 Recomment와 날짜를 토대로 BroadCast 5개의 데이터를 가져온다.
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/selectBest8Drama", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody List<Map<String, Object>> selectBest5Drama(HttpServletRequest request) throws Exception {
		logger.info("Call Drama Best5Drama");
		Map<String, Object> params = CommonUtility.transDataMap(request);
		
		return dramaService.selectBest8Drama(params);
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(HttpServletRequest request) throws Exception {
		logger.info("Call Drama Best5Drama");
		Map<String, Object> params = CommonUtility.transDataMap(request);
		
		return "/drama/view";
	}
	
}
