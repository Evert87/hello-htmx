package dev.danvega.hellohtmx._05;

import com.github.javafaker.Faker;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final Faker faker;
    private final List<Order> orderList;

    public OrderController(Faker faker) {
        this.faker = faker;
        this.orderList = createOrder(5);
    }

    @GetMapping(value = "", produces = MediaType.TEXT_HTML_VALUE)
    public String list(Model model) {
        model.addAttribute("orders", orderList);
//        model.addAttribute("newPerson", new Order());
        return "05/index";
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable String id, Model model){
        var order = orderList.stream().filter(ord -> id.equals(ord.id())).findFirst().orElseThrow(() -> new RuntimeException("404"));
        model.addAttribute("order", order);
        return "05/order-details :: orderDetails";
    }

    @PutMapping("/{id}")
    public String updateOrder(@PathVariable String id, @ModelAttribute Order updatedOrder){
        var order = orderList.stream().filter(ord -> id.equals(ord.id())).findFirst()
                .orElseThrow(() -> new RuntimeException("Geen order gevonden"));
        System.out.println("updatedOrder = " + updatedOrder);
        return "05/order-details :: orderDetails";
    }


    @GetMapping("/load")
    public String getRows(Model model) {
        model.addAttribute("orders", createOrder(3));
        return "03/contact-row :: contact-row";
    }

    @PostMapping("/users")
    public void updateRows(Model model, List<Order> orders) {
        System.out.println("model = " + model);
        System.out.println("contacts = " + orders);
    }

    private List<Order> createOrder(Integer count) {
        return IntStream.rangeClosed(1,count)
                .mapToObj(i -> new Order(
                        faker.name().firstName() + " " + faker.name().lastName(),
                        faker.internet().emailAddress(),
                        faker.internet().uuid(),
                        false
                )).toList();
    }

}
