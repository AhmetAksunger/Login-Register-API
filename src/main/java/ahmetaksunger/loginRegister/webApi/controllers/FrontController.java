package ahmetaksunger.loginRegister.webApi.controllers;


import ahmetaksunger.loginRegister.business.abstracts.LoginService;
import ahmetaksunger.loginRegister.business.abstracts.RegisterService;
import ahmetaksunger.loginRegister.business.abstracts.UserService;
import ahmetaksunger.loginRegister.business.requests.CreateUserRequest;
import ahmetaksunger.loginRegister.business.requests.LoginUserRequest;
import ahmetaksunger.loginRegister.business.requests.RegisterUserRequest;
import ahmetaksunger.loginRegister.business.requests.UpdateUserRequest;
import ahmetaksunger.loginRegister.business.responses.GetAllUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByFirstNameUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByIdUserResponse;
import ahmetaksunger.loginRegister.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()
public class FrontController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    @GetMapping("/list")
    public String listUsers(Model model){

        List<GetAllUserResponse> users = userService.getAll();

        model.addAttribute("users",users);

        return "/users/users-list.html";

    }

    @GetMapping("/search")
    public String searchByFirstName(@RequestParam("keyword") String keyword, Model model){

        List<GetAllUserResponse> users = userService.findByFirstNameOrLastName(keyword);

        model.addAttribute("users",users);

        return "/users/users-list.html";

    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") CreateUserRequest createUserRequest){

        userService.add(createUserRequest);

        return "redirect:/list";
    }

    @GetMapping("/addform")
    public String addForm(Model model){


        User user = new User();

        model.addAttribute("user",user);

        return "/users/user-add-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        userService.remove(id);

        return "redirect:/list";

    }


    @PostMapping("/update")
    public String update(@ModelAttribute("user")UpdateUserRequest updateUserRequest){

        userService.update(updateUserRequest);

        return "redirect:/list";
    }

    @GetMapping("/updateform")
    public String updateForm(@RequestParam("id")int id, Model model){

        GetByIdUserResponse user = userService.getById(id);

        model.addAttribute("user",user);

        return "/users/user-update-form";
    }

    @GetMapping("/loginform")
    public String loginForm(Model model){

        LoginUserRequest loginUserRequest = new LoginUserRequest();

        model.addAttribute("loginRequest",loginUserRequest);

        return "/login/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@ModelAttribute("loginRequest") LoginUserRequest loginUserRequest){

        return ResponseEntity.ok(loginService.login(loginUserRequest));
    }

    @GetMapping("/registerform")
    public String registerForm(Model model){


        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        model.addAttribute("registerRequest",registerUserRequest);

        return "/register/register";

    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> register(@ModelAttribute("reqisterRequest") RegisterUserRequest registerUserRequest){

        return ResponseEntity.ok(registerService.register(registerUserRequest));
    }


}
