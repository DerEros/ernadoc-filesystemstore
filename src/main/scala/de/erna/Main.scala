package de.erna

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Main

object Main extends App {
  System.out.println("Hello World!!")
  SpringApplication.run(classOf[Main], args: _*)
}
