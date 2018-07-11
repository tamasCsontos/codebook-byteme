package com.codecool.codebook.controller;

import com.codecool.codebook.Password;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@EnableWebSecurity
@Controller
public class UserController extends WebSecurityConfigurerAdapter {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    Password bcrypt;

    @GetMapping("/login")
    public String displayLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("email") String email, @RequestParam("password") String password, AuthenticationManagerBuilder auth) throws Exception {
        String hashedPassword = studentRepository.findByEmail(email).getPassword();
        if (bcrypt.checkPassword(password, hashedPassword)) {
            auth.inMemoryAuthentication()
                    .withUser(studentRepository.findByEmail(email).getName()).roles("USER");
            return "redirect:/";
        }
        return "login";
    }


    @GetMapping("/registration")
    public String displayRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String doRegistration(@RequestParam("name") String name,@RequestParam("email") String email, @RequestParam("password") String password) {

        String hashedPAssword = bcrypt.hashPassword(password);
        Student newStudent = new Student(name, email, hashedPAssword);
        studentRepository.save(newStudent);
        return "redirect:/";
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login", "/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/")
                .and()
                .logout().invalidateHttpSession(true).logoutSuccessUrl("/")
                .and()
                .csrf().disable();
    }






}
