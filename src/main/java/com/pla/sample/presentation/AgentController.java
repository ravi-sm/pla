package com.pla.sample.presentation;

import com.pla.sample.application.AgentCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.interceptors.JSR303ViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Author: Nthdimenzion
 */

@Controller
@RequestMapping(value = "/agent")
public class AgentController {


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

    @RequestMapping(method = RequestMethod.GET)
    public String getAgent(Model model){
        model.addAttribute("agentCommand", new AgentCommand());
        return "pla/sample/agentCreation";
    }

}
