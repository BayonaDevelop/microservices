package com.bayonasoftware.batteryplus.microservices.services.commons

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties
@EntityScan("com.bayonasoftware.batteryplus.microservices.utils.model.entities")
@SpringBootApplication
class CommonsApplication

fun main(args: Array<String>) {
  runApplication<CommonsApplication>(*args)
}
