package springmvcsearch2;


  import org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
  
  @Controller public class SearchController {
  
  @RequestMapping("/first")
  public String home() {
  System.out.println("This is first controller in searchController.java"); 
  return "home";
  }
  
  @RequestMapping("/about")
  public String aboutUs() {
	  System.out.println("This is about page in searchcontroller");
	  return "info";
  }
  
  @RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {

		String url = "https://www.google.com/search?q=" + query;

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);

		return redirectView;
	}
  
  }
 