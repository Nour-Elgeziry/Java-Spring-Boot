package com.recommendationSystem.recommendationSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.util.List;



@Controller
public class AppControler {

    @Autowired
    private UserService userService;
    @Autowired
    private UserSkillsService usService;   
    @Autowired
    private UserNeedsService unService;
    @Autowired
    private UserRecommendationService urService;  
    @Autowired 
    private ProgramsService pService;


    @RequestMapping("/")
    public String viewHomePage(Model model) {
        System.out.println("----------------------------------------------------------");
        
        List<User> users = userService.listAll(); //returns list of all registerd users
        List<UserRecommendation> userRecommendations = urService.listAll();
        
        model.addAttribute("users", users); // reference to users in index page using thyme leaf
        model.addAttribute("recommendations", userRecommendations); // reference to users in index page using thyme leaf
        
        System.out.println("Number of registered users : " + users.size());

        return "index"; // home page
    }

    // go to register new user page
    @RequestMapping("/register_user")
    public String ShowNewUserForm(Model model) {
        User user = new User();
        
        model.addAttribute("user", user);
        return "register_user"; // register_user form
    }

    //save new user to databse
    @RequestMapping(value = "/save_user", method = RequestMethod.POST) 
    public String saveUser(@ModelAttribute("user") User user){     
        userService.save(user); //save to User table        
        System.out.println("User saved to user table.");

        //saving skill1 
        UserSkills skill1 = user.addUserSkills1();
        usService.save(skill1);
        System.out.println("Saving Skill1 to the skills table.");

        //saving skill2
        UserSkills skill2 = user.addUserSkills2();
        usService.save(skill2);
        System.out.println("Saving skill2 to the skills table.");

        //saving skill3
        UserSkills skill3 = user.addUserSkills3();
        usService.save(skill3);
        System.out.println("Saving skill3 to the skills table.");
        
        //saving need
        UserNeeds need = user.addUserNeeds();
        unService.save(need);
        System.out.println("Saving need to the needs table.");

        //recommendation algorithim
        //1.get user skills:
        String userSkill1 = user.getSkill1();
        String userSkill2 = user.getSkill2();
        String userSkill3 = user.getSkill3();

        System.out.println("User Skill is :  ");
        System.out.println(userSkill1);
        System.out.println(userSkill2);
        System.out.println(userSkill3);
        //2. get user needs:
        String userNeed = user.getNeed();
        System.out.println("and the user need is : ");
        System.out.println(userNeed);

        //list recommendation of that user if any  (applied in updating info )    
        List<String> userRecommendedPrograms = urService.findRecommendedPrograms(user.getUserName());        
        
        //a. search programs table where userSkill(1-3) == programm's skills
        ///a)list all programs 
        List<Programs> availablePrograms = pService.listAll(); 
        ///b) loop through programs
        for(Programs program : availablePrograms) {
            System.out.println(program.getProgram());
            System.out.println(program.getRequiredSkill());
            System.out.println(program.getRequiredNeed());
            
            //c) if program.getSkill == userSkill1 or userSkill2 or userSkill3 or program.getRequiredNeed() == userNeed && program.getProgram() != userRecommendation.getprogram 
            if(program.getRequiredSkill().equals(userSkill1) || program.getRequiredSkill().equals(userSkill2) || program.getRequiredSkill().equals(userSkill3) || program.getRequiredNeed().equals(userNeed)){
                //check if no recommendations set yet(when a new user is regestring)
                if(userRecommendedPrograms.isEmpty() == true){
                    //d)add to user recommendation
                    UserRecommendation userRecommendation = user.addUserRecommendation(program.getProgram());
                    urService.save(userRecommendation);
                    System.out.println("Skills or need matched, Saving recommendation to the recommendations table.");

                    //user already registered and is editing skills and needs
                }else if(userRecommendedPrograms.isEmpty() == false) {
                    //check if program is not recommended already (when user updates information)
                    if(!userRecommendedPrograms.contains(program.getProgram())){
                        //d)add to user recommendation
                        UserRecommendation userRecommendation = user.addUserRecommendation(program.getProgram());
                        urService.save(userRecommendation);
                        System.out.println("Skills or need matched, Saving recommendation to the recommendations table.");
                    }else{System.out.println("Program already recommended");}                              
                }
               
            }
            else{System.out.println("No Suitable Programs");}
             
        }
        return "redirect:/"; //return to index page  
    }

    //to update a  user in the database
    @RequestMapping("/edit_user/{username}")
    public ModelAndView showEditUserPage(@PathVariable(name = "username") String username) {
        ModelAndView mav = new ModelAndView("edit_user"); // edit_user form
        User user  = userService.get(username);  
        mav.addObject("user", user);
        
        return mav;
    }

    //to delete a full-time user from the database
    @RequestMapping("/delete_user/{username}")
    public String deleteUser(@PathVariable(name = "username") String username) {
        userService.delete(username); //delete user from user table
        usService.deleteAll(username);
        unService.deleteAll(username);
        urService.deleteAll(username);
 
        System.out.println("delete  user. ");

        return "redirect:/"; //return to index page      
    }
    
}
