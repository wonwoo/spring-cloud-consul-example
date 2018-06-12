package ml.wonwoo.springcloudconsulexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadBalancerController {

  private final LoadBalancerClient loadBalancerClient;

  @Value("${spring.application.name}")
  private String applicationName;

  public LoadBalancerController(LoadBalancerClient loadBalancerClient) {
    this.loadBalancerClient = loadBalancerClient;
  }

  @GetMapping("/")
  public ServiceInstance lb() {
    return loadBalancerClient.choose(applicationName);
  }
}
