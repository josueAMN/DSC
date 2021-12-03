package lab.lab.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabsApplication.class, args);
	}

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return String.format("Aquela aplicacao");
	}

}
