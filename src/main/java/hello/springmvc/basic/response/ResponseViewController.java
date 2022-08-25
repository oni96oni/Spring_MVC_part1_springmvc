package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello! 출력부분테스트");

        return mav;

    }

//    @ResponseBody
//    @RestController
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data" , "hello! 출력부분테스트");
        return "response/hello"; // Controller에서 String 반환하면 ViewResolver를 통해서 View를 찾아서 보여준다. 즉 뷰의 논리적 이름이 된다.

    }

//    권장 x
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data" , "hello! 출력부분테스트");

    }
    // 컨트롤러의 이름과 뷰의 논리적 이름이 같고 아무것도 반환안하면 이게 바로 논리적 뷰의 이름이 되어 버린다.
}
