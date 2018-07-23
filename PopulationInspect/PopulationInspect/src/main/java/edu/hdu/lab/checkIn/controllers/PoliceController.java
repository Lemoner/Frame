package edu.hdu.lab.checkIn.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hdu.lab.checkIn.dto.PoliceBasic;
import edu.hdu.lab.checkIn.mapper.BuildingMapper;
import edu.hdu.lab.checkIn.mapper.CommunityMapper;
import edu.hdu.lab.checkIn.mapper.InspectLogMapper;
import edu.hdu.lab.checkIn.mapper.PoliceMapper;
import edu.hdu.lab.checkIn.mapper.RoomMapper;
import edu.hdu.lab.checkIn.model.Building;
import edu.hdu.lab.checkIn.model.BuildingExample;
import edu.hdu.lab.checkIn.model.CommunityExample;
import edu.hdu.lab.checkIn.model.PoliceExample;
import edu.hdu.lab.checkIn.model.Task;
import edu.hdu.lab.checkIn.services.LoginService;
import edu.hdu.lab.checkIn.services.PoliceService;
import edu.hdu.lab.checkIn.utils.FormVerify;
import edu.hdu.lab.checkIn.utils.JsonUtils;

@Controller
@RequestMapping("/police")
public class PoliceController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PoliceService policeService;

	@Autowired
	private PoliceMapper policeMapper;

	@Autowired
	private CommunityMapper communityMapper;

	@Autowired
	private BuildingMapper buildingMapper;

	@Autowired
	private RoomMapper roomMapper;

	@Autowired
	private LoginService loginService;

	@Autowired
	private InspectLogMapper inspectLogMapper;
	/**
	 * LOGIN_STATUS
	 */

	public final static int LOGIN_STATUS_LOGIN_SUCCESS = 1;
	public final static int LOGIN_STATUS_WRONG_PASSWORD = 2;
	public final static int LOGIN_STATUS_POLI_NOT_FOUND = 3;

	public final static String LOGIN_STATUS_POLI_NOT_FOUND_STR = "No Such Police Exist,Please Check Your Police Code.";
	public final static String LOGIN_STATUS_WRONG_PASSWORD_STR = "Wrong Password.";
	public final static String LOGIN_STATUS_LOGIN_SUCCESS_STR = "Login Success .";

	/*
	 * TODO Add Login Page
	 */
	/**
	 * 璺敱锛� 鐧婚檰
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String policeLogin() {
		return "login";
	}

	/**
	 * 璀﹀憳鐧婚檰淇℃伅楠岃瘉锛�*锛�
	 * 
	 * @param poliCode
	 * @param poliPwd
	 * @param loginIp
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String authorizePolice(@RequestParam("poli_code") String poliCode,
			@RequestParam("poli_pwd") String poliPwd,
			@RequestParam("ip") String loginIp, HttpServletRequest request) {
		int loginStatusCode = -1;
		String loginStatusStr = "";
		
		Map<String, Object> resultMap = new HashMap<String, Object>(3);
		
		/**
		 * From Text Filter.
		 */
		poliCode = FormVerify.TextFilter(poliCode);
		poliPwd = FormVerify.TextFilter(poliPwd);
		loginIp = FormVerify.TextFilter(loginIp);

		PoliceBasic poliExpected = policeService.getPoliceByPoliCode(poliCode);

		if (poliExpected == null || poliExpected.getIsDeleted()) {
			loginStatusCode = LOGIN_STATUS_POLI_NOT_FOUND;
			loginStatusStr = LOGIN_STATUS_POLI_NOT_FOUND_STR;
		} else if (loginService.isPasswardMatch(poliPwd, poliExpected)) {
			loginStatusCode = LOGIN_STATUS_LOGIN_SUCCESS;
			loginStatusStr = LOGIN_STATUS_LOGIN_SUCCESS_STR;

			resultMap.put("police", poliExpected);
			policeService.updateLoginInfo(poliExpected.getPoliId(), loginIp,
					new Date());
		} else {
			loginStatusCode = LOGIN_STATUS_WRONG_PASSWORD;
			loginStatusStr = LOGIN_STATUS_WRONG_PASSWORD_STR;
		}

		resultMap.put("loginStatusCode", loginStatusCode);
		resultMap.put("loginStatusStr", loginStatusStr);

		return JsonUtils.createGson().toJson(resultMap);
	}

	/**
	 * 璀﹀憳鐨勮秴鏈熸湭宸℃璁板綍
	 * 
	 * @param poli_id
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/inspectlog/overdue", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getOverDueInspectLog(
			@RequestParam("poli_id") Integer poli_id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		resultMap.put("overdue_num",policeMapper.getOverData(poli_id));
		resultMap.put("quick_overdue_num",policeMapper.getQuickOverData(poli_id));
		
		System.out.println(policeMapper.getOverData(poli_id).toString()+"sssssssssssssssssssssssssssssssssssss");
		
		return JsonUtils.createGson().toJson(resultMap);
		
	}

	/**
	 * 涓�鑸鍛樼敓鎴愭爲锛�*锛�
	 * 
	 * @param poli_id
	 *            璀﹀憳ID
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/jurisdiction", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getCommunitybyPoliid(
			@RequestParam("poli_id") Integer poli_id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		// 鏍规嵁璀﹀憳id鑾峰彇Community
		CommunityExample communityexample = new CommunityExample();
		communityexample.createCriteria().andPoliIdEqualTo(poli_id);
		resultMap.put("community",
				communityMapper.selectByExample(communityexample));
		// 鏍规嵁璀﹀憳id鑾峰彇鐙珛building
		BuildingExample buildingexample = new BuildingExample();
		buildingexample.createCriteria().andPoliIdEqualTo(poli_id);
		resultMap.put("building",
				buildingMapper.selectByExample(buildingexample));
		return JsonUtils.createGson().toJson(resultMap);
	}

	/**
	 * 鏍规嵁Poliid杩斿洖缁熻淇℃伅
	 * 
	 * @param poli_id
	 *            璀﹀憳ID
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/jurisdiction/statistics", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getStatisInfoByPoliId(
			@RequestParam("poli_id") Integer poli_id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		// 鏍规嵁璀﹀憳id鑾峰彇building
		List<Building> selectByExample = policeMapper.getBuilbyPoliid(poli_id);

		resultMap.put("room_number", policeMapper.getRoomNumbyPoliid(poli_id));
		resultMap.put("over_due_room_number", policeMapper.getOverRoomNumByPoliId(poli_id));
		resultMap.put("focus_room_number", policeMapper.getImpoRoomNumbyPoliid(poli_id));
		resultMap.put("person_number", policeMapper.getPersonNumbyPoliid(poli_id));
		resultMap.put("focus_person_number", policeMapper.getImpoPersonNumbyPoliid(poli_id));
		// 璁＄畻寰楀埌绌烘埧鏁�
		resultMap.put("empty_room_number", policeMapper
				.getEmptyRoomNumbyPoliid(poli_id));
		// 鑾峰彇鎵�鏈夌殑灏忓尯
		// 6.鏍规嵁Poli_id鑾峰彇鎴块棿鍚勭鍒嗙被鏁�
		resultMap.put("room_classify_info",
				policeMapper.getRoomSortNumbyPoliid(poli_id));
		// 7.鏍规嵁Poli_id鑾峰彇鑷綇浜烘暟/绉熶綇浜烘暟/宸ヤ綔浜烘暟
		resultMap.put("person_classify_info",
				policeMapper.getPersSortNumbyPoliid(poli_id));
		// 9.鏍规嵁Poli_id妤煎畤鏁�
		resultMap.put("building_number", selectByExample.size());
		// 10.鏍规嵁Poli_id鑾峰彇瓒呮湡鏈贰妫�妤煎畤鏁�
		resultMap.put("over_due_building_number",
				policeMapper.getOverBuilNumbyPoliid(poli_id));
		// 11.鏍规嵁Poli_id鑾峰彇閲嶇偣鍏虫敞妤煎畤鏁�
		resultMap.put("focus_building_number",
				policeMapper.getImpoBuilNumbyPoliid(poli_id));
		// 12.鏍规嵁Poli_id鑾峰彇灏忓尯鏁�
		// 鏍规嵁璀﹀憳id鑾峰彇Community
		CommunityExample communityexample = new CommunityExample();
		communityexample.createCriteria().andPoliIdEqualTo(poli_id);
		resultMap.put("community_number",
				communityMapper.countByExample(communityexample));
		PoliceExample example = new PoliceExample();
		example.createCriteria().andPoliIdEqualTo(poli_id);
		resultMap.put("indebuliding_number",
				policeMapper.countByExample(example));
		// 13.鏍规嵁Poli_id鑾峰彇瓒呮湡鏈贰妫�灏忓尯鏁�
		resultMap.put("over_due_community_number",
				policeMapper.getOverCommNumbyPoliid(poli_id));
		// 14.鏍规嵁Poli_id鑾峰彇閲嶇偣鍏虫敞灏忓尯鏁帮紱
		resultMap.put("focus_community_number",
				policeMapper.getImpoCommNumbyPoliid(poli_id));
		// 15.鏍规嵁Poli_id鑾峰彇鎴块棿鍚勭鍒嗙被鏁�
		resultMap.put("room_subclassify_info",
						policeMapper.getRoomSubSortNumbyPoliid(poli_id));
		// 16.鏍规嵁Poli_id鑾峰彇閲嶇偣鍗曚綅
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("poli_id", poli_id);
		map.put("danger",1);
		resultMap.put("focus_drug_unit",
								policeMapper.countRoom(map));
		map.replace("danger", 2);
		resultMap.put("focus_boom_unit",
				policeMapper.countRoom(map));
		map.replace("danger", 3);
		resultMap.put("focus_toxic_unit",
				policeMapper.countRoom(map));
		map.replace("danger", 4);
		resultMap.put("focus_danger_unit",
				policeMapper.countRoom(map));
		
		return JsonUtils.createGson().toJson(resultMap);
	}

	/**
	 * 鏍规嵁璀﹀憳ID 璁惧畾寮�濮嬫椂闂村拰鎴鏃堕棿 鑾峰彇妫�鏌ヨ褰� TODO There is a bug to Fix
	 * 
	 * @param poil_id
	 * @param startTime
	 * @param endTime
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/inspectlog/filter/time", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getInsp(
			@RequestParam("poli_id") Integer poli_id,
			@RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startTime,
			@RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endTime,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			HttpServletRequest request) {
		int resultCode = 0;
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		Map<String, Object> map = new HashMap<String, Object>(2);
		endTime.setHours(23);
		endTime.setMinutes(59);
		endTime.setSeconds(59);
		map.put("poil_id", poli_id);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		if (page != null && size != null) {
			map.put("page", size * (page -1));
			map.put("size", size);
		}
		resultMap.put("inspect", inspectLogMapper.getInspbyTime(map));
		return JsonUtils.createGson().toJson(resultMap);
	}
	
	
//	鑾峰彇璀﹀憳鍒楄〃
	@ResponseBody
	@RequestMapping(value = "/Police_list",produces = "text/html;charset=UTF-8")
	public String Police_list() {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		resultMap.put("data",policeMapper.getPoliceList());
		return JsonUtils.createGson().toJson(resultMap);
	}

}
