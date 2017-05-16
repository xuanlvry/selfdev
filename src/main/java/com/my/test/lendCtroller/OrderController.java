package com.my.test.lendCtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 订单信息controller
 * Created by Chengfei.Sun on 2015/9/14.
 */
@Controller("orderController")
@RequestMapping("/orders")
public class OrderController {
    /***
     * POST
     * 借款
     * @param request 请求对象<br>
     *        amount[decimal]: 借款金额<br>
     *        debitCardId[int]: 关联借记卡Id<br>
     *        creditCardId[int]: 关联信用卡Id<br>
     *        refundDate[date]: 还款日期<br>
     *        isAgreeProtocol[boolean]: 是否同意协议<br>
     *        token[string]: 验证码<br>
     * @return
     *           : 借入失败<br>
     *           : 借入成功<br>
     *           : 信用卡已担保<br>
     *           : 信用卡额度不足<br>
     *           : 信用卡失效<br>
     *           : 借记卡失效<br>
     */
    @RequestMapping(value="/lend",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody String lend(HttpServletRequest request, HttpServletResponse response){
        return null;
    }

}
