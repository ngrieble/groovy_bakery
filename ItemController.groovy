import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


//@Grab("spring-boot-actuator")
//@Grab("thymeleaf-spring4")
@Grab(group='org.springframework.boot', module='spring-boot-actuator', version='1.1.6.RELEASE')
@Grab(group='org.thymeleaf', module='thymeleaf-spring4', version='2.1.2.RELEASE')

@Controller
@RequestMapping("/")
class ItemController {

  @Autowired
  ItemRepository itemRepo

  @RequestMapping(method=RequestMethod.GET)
  String home(Map<String,Object> model) {
    List<Item> items = itemRepo.findAll()
    model.putAll([items: items])
    "home"
  }

  @RequestMapping(method=RequestMethod.POST)
  String submit(Item item) {
      itemRepo.save(item)
    "redirect:/"
  }
}