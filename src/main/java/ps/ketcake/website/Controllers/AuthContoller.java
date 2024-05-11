// package ps.ketcake.website.Controllers;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;

// import lombok.RequiredArgsConstructor;

// @Controller
// @RequiredArgsConstructor
// public class AuthContoller {

//     // Login form
//     @RequestMapping("/login")
//     public String login() {
//         return "login.html";
//     }

//     // Login form with error
//     @RequestMapping("/login-error")
//     public String loginError(Model model) {
//         model.addAttribute("loginError", true);
//         return "login.html";
//     }
// }