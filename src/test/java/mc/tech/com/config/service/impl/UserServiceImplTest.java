package mc.tech.com.config.service.impl;

//import mc.tech.com.config.entity.User;


//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Slf4j
//class UserServiceImplTest {
//    @Autowired
//    private UserServiceImpl Service;
//    User userDto,userDto1;
//
//
//    @BeforeEach
//    void BeforeEachTest()  {
//        userDto = new User("Dray",
//                "draybulambo@gmail.com","12345");
//        userDto1 = new User("Dray",
//                "farai@gmail.com","12345");
//
//       }
//
//     @Order(1)
//    @Test
//    void saveUser() {
//       Role role1=new Role("ROLE_ADMIN");
//         Role role2=new Role("ROLE_USER");
//        Service.saveRole(role2) ;
//         Service.saveRole(role1) ;
//        this.Service.saveUser(userDto);
//         this.Service.saveUser(userDto1);
//        this.Service.findAllUsers();
//
//
//
//    }
//    @Order(5)
//    @Test
//    void addRoletoUser() {
//        Service.addRoletoUser(userDto1.getEmail(),"ROLE_ADMIN");
//    }
//    @Order(3)
//    @Test
//    void name() {
//        this.Service.findByName("ROLE_ADMIN");
//    }
//    @Order(4)
//    @Test
//    void email() {
//       this.Service.findByEmail(userDto1.getEmail());
//    }
//}