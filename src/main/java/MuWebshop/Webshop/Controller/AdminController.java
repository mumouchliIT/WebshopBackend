package MuWebshop.Webshop.Controller;

import MuWebshop.Webshop.Entity.AdminEntity;
import MuWebshop.Webshop.Service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public String add(@RequestBody AdminEntity admin){
        adminService.addAdmin(admin);
        return "New Admin is added";
    }

    @GetMapping("/getAll")
    public List<AdminEntity> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @PostMapping("/login")
    public boolean login(@RequestBody AdminEntity admin) {
        System.out.println("Email: " + admin.getEmail());
        System.out.println("Password: " + admin.getPassword());

        AdminEntity oauthUser = adminService.AdminEntity(admin.getEmail(), admin.getPassword());

        System.out.println(oauthUser);

        if (Objects.nonNull(oauthUser)) {
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {
        return "redirect:/login";
    }

}
