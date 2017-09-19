package de.erna.upload

import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

@RestController
@RequestMapping(Array("/upload"))
class UploadController {
  @RequestMapping(method = Array(RequestMethod.GET))
  def hello(): String = {
    "Hello World!"
  }
}
