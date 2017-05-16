package com.my.test.lendCtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息controller
 * Created by Chengfei.Sun on 2015/9/14.
 */
@Controller("UsersInfoController")
@RequestMapping("/usersInfo")
public class UsersInfoController {
    /***
     * 获取用户信用额度信息
     * @param request 请求对象 无<br>
     * @return
     *       totalLendAmount[decimal]: 总借款额度<br>
     *       usedLendAmount[decimal]: 已用借款额度<br>
     *       singleLendAmount[decimal]: 单笔借款额度<br>
     *       yield[decimal]: 费率<br>
     */
    @RequestMapping(value="/creditInfo", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String getCreditInfo(HttpServletRequest request,HttpServletResponse response) {
        return null;
    }

    /***
     * 获取用户信用卡列表
     * @param request 请求对象 无<br>
     * @return 数组<br>
     *         bankCardNo[string]: 银行卡号<br>
     *         bankName[string]: 银行名称<br>
     *         bankId[int]: 银行卡ID<br>
     *         isDefault[bool]: 是否是默认银行卡<br>
     * @throws Exception
     */
    @RequestMapping(value="/creditCards",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String creditCards(HttpServletRequest request,HttpServletResponse response) throws Exception {
        return null;
    }
}
