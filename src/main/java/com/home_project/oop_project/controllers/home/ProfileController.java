package com.home_project.oop_project.controllers.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.home_project.oop_project.entity.User;
import com.home_project.oop_project.service.UserService;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private HomeController home0;

    @GetMapping(value={"/edit-profile","/edit-profile/"})
    public String editProfile(@ModelAttribute("user") User user, Model model) {
        if (home0.getUserDetail() != null) {
            model.addAttribute("usernameValidated", userService.getUserById(home0.getUserDetail().getId()));
            return "home/editProfile";
        } else
            return "redirect:/login";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute("user") User user, Model model) {

        // get User from database by id
        User existingUser = userService.getUserById(home0.getUserDetail().getId());
        existingUser.setId(home0.getUserDetail().getId());
        existingUser.setFullName(user.getFullName());
        // existingUser.setUserName(user.getUserName());
        // existingUser.setPassword(user.getPassword());
        existingUser.setDiaChi(user.getDiaChi());
        existingUser.setEmail(user.getEmail());
        existingUser.setSdt(user.getSdt());
        // save updated User object
        userService.updateUser(existingUser);
        return "redirect:/";
    }

    @GetMapping(value={"/edit-password","/edit-password/"})
    public String editPassword( Model model) {
        if (home0.getUserDetail() != null) {
            model.addAttribute("usernameValidated", userService.getUserById(home0.getUserDetail().getId()));
            return "home/editPassword";
        } else
            return "redirect:/login";
    }

    @PostMapping("/update-password")
    public String updatePassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @ModelAttribute("user") User user,
            Model model) {

                // get User from database by id
            User existingUser = userService.getUserById(home0.getUserDetail().getId());


        if (existingUser.getPassword().equals(oldPassword)) {
            existingUser.setId(home0.getUserDetail().getId());
            existingUser.setPassword(newPassword);

            // save updated User object
            userService.updateUser(existingUser);
            return "redirect:/";
        } else {
            model.addAttribute("message", "Nhập sai mật khẩu cũ. Vui lòng thử lại");
            return "home/editPassword";
        }
    }
}
