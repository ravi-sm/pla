package com.pla.sample.presentation;

import com.pla.sample.application.AgentCommand;
import com.pla.sample.application.SampleCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

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

    @RequestMapping(value = "/agent",method = RequestMethod.GET)
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
        System.out.println(sampleCommand.getMultipartFile().getSize());
        return "pla/sample/sample";
    }

}
