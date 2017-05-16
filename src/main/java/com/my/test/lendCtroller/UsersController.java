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
@Controller("usersController")
@RequestMapping("/users")
public class UsersController {
    /***
     * POST
     * 添加信用卡
     * @param request 请求对象<br>
     *        bankCardNo[string]: 银行卡号（15-19位）<br>
     *        bankName[string]: 银行名称<br>
     *        realName[string]: 真实姓名<br>
     *        cellphone[string]: 手机号<br>
     *        cvn2[string]: 安全码<br>
     *        expireDate[date]: 有效期<br>
     *        cityName[string]: 开户行所在城市名称<br>
     * @return
     * 	      resultCode: 返回代码<br>
     *        message: 返回消息<br>
     *        properties:  SDK签名报文<br>
     *        - - - retCode[String]: 返回码，0000 成功<br>
     *        - - - retMsg[String]: 结果描述<br>
     * resultCode<br>
     *        10030: 无法添加银行卡<br>
     *        10032: 银行卡数量超过上限<br>
     *        10018: 该银行卡已经被绑定<br>
     *        10020: 对不起，该卡今天绑定失败次数已超过5次，请您明天再试<br>
     * @throws Exception
     */
    @RequestMapping(value="/auth/addCreditCard",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody String addCreditCard(HttpServletRequest request,HttpServletResponse response) throws Exception {
        return null;
    }

    /***
     * 设置默认信用卡
     * @param request 请求对象<br>
     *        cardId[int]: 银行卡Id<br>
     * @return
     *        601: 数据库更新错误<br>
     *        10029: 银行卡信息错误<br>
     */
    @RequestMapping(value="/auth/setDefaultCreditCard",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody String setDefaultCreditCard(HttpServletRequest request,HttpServletResponse response) {
        return null;
    }
}
