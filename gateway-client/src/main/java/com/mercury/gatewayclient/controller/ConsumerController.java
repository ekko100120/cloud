package com.mercury.gatewayclient.controller;


import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    public static final String SERVICE_NAME = "service-consumer";

    @Autowired(required = true)
    private LoadBalancerClient loadBalancerClient;

    @Autowired(required = true)
    private DiscoveryClient discoveryClient;


    @RequestMapping(value = "/services",method = RequestMethod.GET)
    public Object services(){
        return discoveryClient.getInstances(SERVICE_NAME);
    }

    @RequestMapping(value = "/discover",method = RequestMethod.GET)
    public Object discover(){
        ServiceInstance instance =  loadBalancerClient.choose(SERVICE_NAME);
        if (instance == null){
            return  "Null";
        }
        return  instance.getUri().toString();
    }


}
