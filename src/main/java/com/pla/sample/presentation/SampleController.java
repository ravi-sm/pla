package com.pla.sample.presentation;

import com.pla.sample.application.AgentCommand;
import com.pla.sample.application.SampleCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.joda.money.Money;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.nthdimenzion.common.AppConstants;
import org.nthdimenzion.ddd.domain.User;
import org.nthdimenzion.presentation.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.nthdimenzion.common.AppConstants.DEFAULT_CURRENCY;
import static org.nthdimenzion.presentation.AppUtils.ToLocalDate;
import static org.nthdimenzion.presentation.AppUtils.ToMoney;
import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Author: Nthdimenzion
 */

@Controller
@RequestMapping(value = "/sample")
public class SampleController {


    @Autowired
    private CommandGateway commandGateway;

    @RequestMapping(value = "/saveAgent",method = RequestMethod.POST)
    public String saveAgent(@Valid AgentCommand agentCommand, BindingResult bindingResult){
        System.out.println("saveAgent");
        System.out.println(agentCommand);
        if (bindingResult.hasErrors()){
            return "/pla/sample/AgentCreation";
        }
        return "pla/sample/agentCreation";
    }

    @RequestMapping(value = "/agent",method = GET)
    public String getAgent(Model model){
        model.addAttribute("agentCommand", new AgentCommand());
        return "pla/sample/agentCreation";
    }

    @RequestMapping(produces = "text/html")
    public String sampleFormController(Model model) {
        System.out.println("Hello world");
        model.addAttribute("sampleCommand", new SampleCommand());
        return "/pla/sample/sample";
    }

    @RequestMapping(value = "/saveSample",method = RequestMethod.POST)
    public String saveAgent(@Valid SampleCommand sampleCommand, BindingResult bindingResult){
        System.out.println("SampleCommand");
        System.out.println(sampleCommand);
//        System.out.println(sampleCommand.getMultipartFile().getSize());
        return "pla/sample/sample";
    }

    @RequestMapping(value = "/getSampleJsonWithDateAndMoney", method = GET,produces = APPLICATION_JSON_VALUE, consumes = ALL_VALUE)
    @ResponseBody
    public Map getSampleJsonWithDateAndMoney() {
        Map result = new HashMap();
        result.put("date", LocalDate.now());
        result.put("money", Money.of(DEFAULT_CURRENCY, BigDecimal.TEN));
        return result;
    }

    @RequestMapping(value = "/saveSampleJsonWithDateAndMoney", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity saveSampleJsonWithDateAndMoney(@RequestBody Map input) {
        System.out.println(ToLocalDate(input.get("date").toString()));
        System.out.println(ToMoney(input.get("money").toString()));
        System.out.println(input);
        return ResponseEntity.ok().build();
    }


    public static List<User> users = new ArrayList<User>();

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String findUserForm(Model model) {
        model.addAttribute(new User());
        return "user/addUser";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public String addNewUser(@Valid User user, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "user/addUser";
        } else {
            if (user!=null){
                users.add(user);
                status.setComplete();
                return "redirect:/sample/user/userList";
            }
            return "user/addUser";
        }
    }

    @RequestMapping("/user/userList")
    public ModelAndView showUser() {
        ModelAndView mav = new ModelAndView("/user/userList");
        mav.addObject(users);
        return mav;
    }

}
