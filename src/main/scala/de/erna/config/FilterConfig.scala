package de.erna.config

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.filter.HiddenHttpMethodFilter

@Component
class FilterConfig {
  @Bean
  def registration( filter: HiddenHttpMethodFilter ): FilterRegistrationBean = {
    val registrationBean = new FilterRegistrationBean( filter )
    registrationBean.setEnabled( false )
    registrationBean
  }
}
