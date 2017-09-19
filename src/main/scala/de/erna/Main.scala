package de.erna

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.{Banner, SpringApplication}

@SpringBootApplication
class Main

object Main extends App {
  val app = new SpringApplication(classOf[Main])
  app.setBannerMode(Banner.Mode.OFF)
  app.run(args: _*)
}
